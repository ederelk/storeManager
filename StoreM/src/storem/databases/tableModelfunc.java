/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storem.databases;

import com.sun.management.VMOption.Origin;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yaovi Elom Kwasi AKA REDE <ederelk@gmail.com>
 */
public class tableModelfunc extends DBconnect {
  
    public tableModelfunc (){
        connectToDB(DATABASE_NAME, USERNAME, PASSWORD);
        
    }
    
     public static void setDBconnection(){
        connectToDB(DATABASE_NAME, USERNAME, PASSWORD);
    }
    public static DefaultTableModel setDefaultTableModel(String[] orderTableColumns, final Class[] ColumnsType){
       int initialRow = 0;
        DefaultTableModel newDefaultTable = new DefaultTableModel(orderTableColumns, initialRow){
    Class[] types = ColumnsType;

            @Override
    public Class getColumnClass(int columnIndex) {
                
                  return types[columnIndex];
    }
}; 
        return newDefaultTable;
    }
    
    
     public static void  setTableModelToJtable(JTable tbRecords, String[] orderTableColumns,String query,final Class[] ColumnsType ){
   DefaultTableModel defaultTable =    setDefaultTableModel(orderTableColumns, ColumnsType);
            Object rowRecord[] = new Object[orderTableColumns.length];
             
        try {
            
            //(DATABASE_NAME, USERNAME, PASSWORD);
           
        reconnect();
             
            
            resultSet = statement.executeQuery(query);

           
            int count = 0;
          
            resultSet.beforeFirst();
                
               while (resultSet.next()) {
                    for(count=0;count<orderTableColumns.length;count++){
                   
                    rowRecord[count]=resultSet.getObject(count+1);
                    
                   // System.out.println(orderTableColumns);
                    }
                defaultTable.addRow(rowRecord);
                tbRecords.setModel(defaultTable);
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            displaySQLErrors(ex);
        }


       // btnDelete.setVisible(false);
       // btnEdit.setVisible(false);

//disconnectFromDB();

   }

     public static String getStockdetails(String product_name){
         String  details = null;
         String formatedDate = null;
         String  query = "SELECT * FROM stocks WHERE product_name= '"+product_name+"'";
         String  getDate = "SELECT product_name,DATE_FORMAT(date,'%W %d, %M %Y  à  %H:%i:%s') FROM stocks WHERE product_name= '"+product_name+"'";
         
        
           
       
        try {
            resultSet = statement.executeQuery(getDate);
            resultSet.next();
            formatedDate = resultSet.getString(2);
            resultSet = statement.executeQuery(query);
            resultSet.next();
            details = "&nbsp;<h3 style = \" color:#1A446C;\"> Nom du Produit </h3>";
            details += resultSet.getString("product_name")+"</p><p>&nbsp;";
            details += "<h3 style = \" color:#1A446C;\"> Stock </h3>";
            details += resultSet.getString("left_in_stock")+"</p><p>&nbsp;";
            details += "<h3 style = \" color:#1A446C;\"> Dernière Date de Modification </h3>";
            details += formatedDate+"</p><p>&nbsp;";
            details += "<h3 style = \" color:#1A446C;\"> Historique </h3>";
            details += resultSet.getString("history");
            return details; 
            
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return null;
        }
                 
         
        
     }
     public static boolean searchProducts( JTextField txtSearch,JTable tbRecords, String[] orderTableColumns,boolean mode){
         String searchQuery2 = "SELECT  product_name,sales_unit_price,sales_total_price FROM "
                        + "products WHERE product_name like '";

         String searchQuery1 =  "SELECT  product_name,sales_unit_price,purchased_unit_price,sales_total_price,purchased_total_price FROM "
                        + "products WHERE product_name like '";
         
        try {

           
            reconnect();
             
            resultSet = statement.executeQuery(
                    "select product_name from products "+
                    "where product_name like  '%" + txtSearch.getText().replace("\'", "\\'") + "%' order by product_name"
                    );

            resultSet.last();
            int rowCount = resultSet.getRow();

            if(rowCount == 0){
//                JOptionPane.showMessageDialog(null, "No Results found!");
             txtSearch.setForeground(Color.red);
               // txtSearch.setBackground(Color.red);
                return false;
            }
         txtSearch.setForeground(Color.BLACK);
          //  txtSearch.setBackground(Color.white);

            String[][] data = new String[rowCount][orderTableColumns.length];
            String[] namesToSearchFor = new String[rowCount];

            resultSet.beforeFirst();
            while(resultSet.next()){
                namesToSearchFor[resultSet.getRow() - 1] = resultSet.getString("product_name").replace("\'", "\\'");
                }

            for(int k = 0; k < namesToSearchFor.length; k++){
                resultSet = statement.executeQuery((mode?searchQuery1:searchQuery2)+namesToSearchFor[k] +"' order by product_name");
                resultSet.next();

                for(int j = 0; j < orderTableColumns.length; j++){
                    data[k][j] = resultSet.getString(j+1);
                }
            }

            tbRecords.setModel(new DefaultTableModel(data, orderTableColumns));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
        }

        //btnDelete.setVisible(false);
        //btnEdit.setVisible(false);


        return true;
   }
public static boolean executeQueryUpdate(String insertQuery){
    reconnect();
        try {
            statement.executeUpdate(insertQuery);
             System.err.println("Table insert succesfull");
       return true;
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            
            return false;
        }
}
public static boolean executeQueryInsert(String insertQuery){
    reconnect();
        try {
            statement.executeUpdate(insertQuery);
             System.err.println("Table insert succesfull");
       return true;
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1062){
                JOptionPane.showMessageDialog(null, "Ce produit exist deja dans l'inventaire!", "Attention",JOptionPane.ERROR_MESSAGE);
            }
          //  displaySQLErrors(ex);
            return false;
        }
}
public static boolean executeQuery(String Query){
    reconnect();
        try {
            resultSet = statement.executeQuery(Query);
             System.err.println("Successful!");
       return true;
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return false;
        }
}
public static boolean executeEditquery(String editQuery){
    reconnect();
        try {
            statement.execute(editQuery);
             System.err.println("Table edit succesfull");
       return true;
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return false;
        }
}
public static String updateHistory(String Query){
    reconnect();
   
           try {
            resultSet = statement.executeQuery(Query);
            resultSet.next();       
             System.err.println("History Read");
       return resultSet.getString("history");
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return null;
        }
}
public static String getPaidStatus(String query){
     reconnect();
   
           try {
            resultSet = statement.executeQuery(query);
            resultSet.next();       
             System.err.println("Paid status read");
       return resultSet.getString("paid_status");
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return "2";
        }
}
public static String getSum(String query){
     reconnect();
   
           try {
            resultSet = statement.executeQuery(query);
            resultSet.next();       
             System.err.println("sum");
       return (resultSet.getString(1)==null?"0":resultSet.getString(1));
        } catch (SQLException ex) {
            displaySQLErrors(ex);
            return "0";
        }
}
public static  void loadSelectedProduct(String product_name, JTextField name,JTextField uSalesPrice,JTextField tSalesprice,JTextField uPurchprice,JTextField tPurchprice){
    String loadQuery = "SELECT product_name,sales_unit_price,purchased_unit_price,sales_total_price,purchased_total_price FROM products WHERE product_name = '"
            +product_name+"'";
   
        try {
            
            resultSet = statement.executeQuery(loadQuery);
            resultSet.next();
            name.setText(resultSet.getString("product_name"));
            uSalesPrice.setText(resultSet.getString("sales_unit_price"));
            uPurchprice.setText(resultSet.getString("purchased_unit_price"));
            tSalesprice.setText(resultSet.getString("sales_total_price"));
            tPurchprice.setText(resultSet.getString("purchased_total_price"));   
            
            
            
        } catch (SQLException ex) {
           displaySQLErrors(ex);
            
        }
    
}
public static  void loadSelectedStock(String product_name,JDialog stockDialog,JLabel oldValue){
    String loadQuery = "SELECT product_name,left_in_stock FROM stocks WHERE product_name ='"
+product_name+"'";
        try {
            resultSet = statement.executeQuery(loadQuery);
            resultSet.next();
            oldValue.setText(resultSet.getString("left_in_stock"));
            stockDialog.setTitle(resultSet.getString("product_name"));
           
        } catch (SQLException ex) {
           displaySQLErrors(ex);
           System.out.print("loadstock");
            
        }
    
}
public static int getCorrectColumn(JTable myTable){
    int i;
    String firstColName = "Nom du Produit";
    
    for(i = 0;i<myTable.getColumnCount();i++){
        if(firstColName.equals(myTable.getColumnName(i) )){
            break;
        }
    }
    
    return i;
}
public static int getCorrectColumnClient(JTable myTable){
    int i;
    String firstColName = "Nom du Client";
    
    for(i = 0;i<myTable.getColumnCount();i++){
        if(firstColName.equals(myTable.getColumnName(i) )){
            break;
        }
    }
    
    return i;
}
public static int getCorrectColumnId(JTable myTable){
    int i;
    String firstColName = "Code de Transaction";
    
    for(i = 0;i<myTable.getColumnCount();i++){
        if(firstColName.equals(myTable.getColumnName(i) )){
            break;
        }
    }
    
    return i;
}
public static  void loadSelectedProductPrice(String product_name, JLabel mylabel){
    String loadQuery = "SELECT sales_unit_price FROM products WHERE product_name ='"
            +product_name+"'";
        try {
            resultSet = statement.executeQuery(loadQuery);
            resultSet.next();
            mylabel.setText(resultSet.getString("sales_unit_price"));
            
           
        } catch (SQLException ex) {
           displaySQLErrors(ex);
             System.out.print("loadprice");
        }
    
}
public static  boolean  checkProductDuplicate( String mylabel){
    String loadQuery = "SELECT product_name FROM products WHERE  product_name ='"
            +mylabel+"'";
    String original= "" ;
   
        try {
            resultSet = statement.executeQuery(loadQuery);
           if(resultSet.isBeforeFirst()){
              // System.out.println("No data"); 
               resultSet.next();
            original = resultSet.getString("product_name");
            
           }
           
        } catch (SQLException ex) {
           displaySQLErrors(ex);
            
        }
      
     if(original.equals(mylabel) ){
         return true;
               }else{
         return false;
     }
            
}
public static  void loadSelectedProductStock(String product_name, JLabel mylabel){
    String loadQuery = "SELECT left_in_stock FROM stocks WHERE product_name ='"
            +product_name+"'";
        try {
            resultSet = statement.executeQuery(loadQuery);
            resultSet.next();
            mylabel.setText(resultSet.getString("left_in_stock"));
            
           
        } catch (SQLException ex) {
           displaySQLErrors(ex);
            
        }
    
}
public static void loadCustomer(JComboBox customers){
     String loadQuery = "SELECT customer_name FROM customers";
     while(customers.getItemCount()!=1){
         customers.removeItemAt(customers.getItemCount()-1);
     }
          
               
        try {
            resultSet = statement.executeQuery(loadQuery);
            resultSet.beforeFirst();
            
            while(resultSet.next()){
                customers.addItem(resultSet.getObject("customer_name"));
            }
            
           
        } catch (SQLException ex) {
           displaySQLErrors(ex);
            
        }
}
public static void setDateLanguage(String language){
    String sql = "SET lc_time_names = '"+language+"'";
        try {
            reconnect();
            statement.execute(sql);
        } catch (SQLException ex) {
            displaySQLErrors(ex);
        }
}
public static boolean searchStocks( JTextField txtSearch,JTable tbRecords, String[] orderTableColumns){
        

        try {

           
            reconnect();
             
            resultSet = statement.executeQuery(
                    "select product_name from stocks "+
                    "where product_name like  '%" + txtSearch.getText().replace("\'", "\\'") + "%' order by product_name"
                    );

            resultSet.last();
            int rowCount = resultSet.getRow();

            if(rowCount == 0){
//                JOptionPane.showMessageDialog(null, "No Results found!");
             txtSearch.setForeground(Color.red);
               // txtSearch.setBackground(Color.red);
                return false;
            }
         txtSearch.setForeground(Color.BLACK);
          //  txtSearch.setBackground(Color.white);

            String[][] data = new String[rowCount][orderTableColumns.length];
            String[] namesToSearchFor = new String[rowCount];

            resultSet.beforeFirst();
            while(resultSet.next()){
                namesToSearchFor[resultSet.getRow() - 1] = resultSet.getString("product_name").replace("\'", "\\'");
                }

            for(int k = 0; k < namesToSearchFor.length; k++){
                resultSet = statement.executeQuery(
                        "SELECT  product_name,left_in_stock,DATE_FORMAT(date,'    %d/%m/%Y  %H:%i:%s') FROM "
                        + "stocks WHERE product_name like '"+namesToSearchFor[k] +"' order by product_name"
                        
                        );
                resultSet.next();

                for(int j = 0; j < orderTableColumns.length; j++){
                    data[k][j] = resultSet.getString(j+1);
                }
            }

            tbRecords.setModel(new DefaultTableModel(data, orderTableColumns));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
        }

        //btnDelete.setVisible(false);
        //btnEdit.setVisible(false);


        return true;
   }

public static boolean searchSales( JTextField txtSearch,JTable tbRecords, String[] orderTableColumns){
        

        try {

           
            reconnect();
             
            resultSet = statement.executeQuery(
                    "select id from sales "+
                    "where product_name like  '%" + txtSearch.getText().replace("\'", "\\'") + "%' order by product_name"
                    );

            resultSet.last();
            int rowCount = resultSet.getRow();

            if(rowCount == 0){
//                JOptionPane.showMessageDialog(null, "No Results found!");
             txtSearch.setForeground(Color.red);
               // txtSearch.setBackground(Color.red);
                return false;
            }
         txtSearch.setForeground(Color.BLACK);
          //  txtSearch.setBackground(Color.white);

            String[][] data = new String[rowCount][orderTableColumns.length];
            String[] namesToSearchFor = new String[rowCount];

            resultSet.beforeFirst();
            while(resultSet.next()){
                namesToSearchFor[resultSet.getRow() - 1] = resultSet.getString("id").replace("\'", "\\'");
                }

            for(int k = 0; k < namesToSearchFor.length; k++){
                resultSet = statement.executeQuery(
                        "SELECT product_name,quantity_sold,unit_price,total_price,DATE_FORMAT(date,'          %d/%m/%Y    %H:%i:%s'),customer_name FROM sales "
                        + " WHERE id ="+namesToSearchFor[k] +" order by date DESC"
                        
                        );
                resultSet.next();

                for(int j = 0; j < orderTableColumns.length; j++){
                    data[k][j] = resultSet.getString(j+1);
                }
            }

            tbRecords.setModel(new DefaultTableModel(data, orderTableColumns));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
        }

        //btnDelete.setVisible(false);
        //btnEdit.setVisible(false);


        return true;
   }

public static boolean searchStocksAvailable( JTextField txtSearch,JTable tbRecords, String[] orderTableColumns){
        

        try {

           
            reconnect();
             
            resultSet = statement.executeQuery(
                    "select product_name from stocks "+
                    "where left_in_stock > 0 and product_name like  '%" + txtSearch.getText().replace("\'", "\\'") + "%' order by product_name"
                    );

            resultSet.last();
            int rowCount = resultSet.getRow();

            if(rowCount == 0){
//                JOptionPane.showMessageDialog(null, "No Results found!");
             txtSearch.setForeground(Color.red);
               // txtSearch.setBackground(Color.red);
                return false;
            }
         txtSearch.setForeground(Color.BLACK);
          //  txtSearch.setBackground(Color.white);

            String[][] data = new String[rowCount][orderTableColumns.length];
            String[] namesToSearchFor = new String[rowCount];

            resultSet.beforeFirst();
            while(resultSet.next()){
                namesToSearchFor[resultSet.getRow() - 1] = resultSet.getString("product_name").replace("\'", "\\'");
                }

            for(int k = 0; k < namesToSearchFor.length; k++){
                resultSet = statement.executeQuery(
                        "SELECT  product_name,left_in_stock FROM "
                        + "stocks WHERE left_in_stock > 0 and  product_name like '"+namesToSearchFor[k] +"' order by product_name"
                        
                        );
                resultSet.next();

                for(int j = 0; j < orderTableColumns.length; j++){
                    data[k][j] = resultSet.getString(j+1);
                }
            }

            tbRecords.setModel(new DefaultTableModel(data, orderTableColumns));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
        }

        //btnDelete.setVisible(false);
        //btnEdit.setVisible(false);


        return true;
   }

 
public static boolean searchProductsInventory( JTextField txtSearch,JTable tbRecords, String[] orderTableColumns){
        

        try {

           
            reconnect();
             
            resultSet = statement.executeQuery(
                    "select product_name from products "+
                    "where product_name like  '%" + txtSearch.getText().replace("\'", "\\'") + "%' order by product_name"
                    );

            resultSet.last();
            int rowCount = resultSet.getRow();

            if(rowCount == 0){
//                JOptionPane.showMessageDialog(null, "No Results found!");
             txtSearch.setForeground(Color.red);
               // txtSearch.setBackground(Color.red);
                return false;
            }
         txtSearch.setForeground(Color.BLACK);
          //  txtSearch.setBackground(Color.white);

            String[][] data = new String[rowCount][orderTableColumns.length];
            String[] namesToSearchFor = new String[rowCount];

            resultSet.beforeFirst();
            while(resultSet.next()){
                namesToSearchFor[resultSet.getRow() - 1] = resultSet.getString("product_name").replace("\'", "\\'");
                }

            for(int k = 0; k < namesToSearchFor.length; k++){
                resultSet = statement.executeQuery(
                        "SELECT  product_name,id FROM "
                        + "products WHERE product_name like '"+namesToSearchFor[k] +"' order by product_name"
                        
                        );
                resultSet.next();

                for(int j = 0; j < orderTableColumns.length; j++){
                    data[k][j] = resultSet.getString(j+1);
                }
            }

            tbRecords.setModel(new DefaultTableModel(data, orderTableColumns));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
        }

        //btnDelete.setVisible(false);
        //btnEdit.setVisible(false);


        return true;
   }
 
 public static  String setPurchaseToCart(String product_name,JTable Cart,String[] orderTableColumns,DefaultTableModel defaultTable,JComboBox combo){
     
     String query = "SELECT product_name,sales_unit_price,sales_total_price FROM products WHERE product_name = '" +product_name+"'";
     
        try {
            resultSet = statement.executeQuery(query);
             
          Object rowRecord[] = new Object[orderTableColumns.length];
          
            resultSet.beforeFirst();
                
               while (resultSet.next()) {
                    
                   
                    rowRecord[0]=resultSet.getString(1);
                    rowRecord[1]= combo.getSelectedItem().toString();
                    if("Carton".equals(rowRecord[1])){
                    rowRecord[2]=resultSet.getString(3);
                    rowRecord[3]=resultSet.getString(3);}else{
                        rowRecord[2]=resultSet.getString(2);
                    rowRecord[3]=Integer.toString(Integer.parseInt(rowRecord[2].toString())*Integer.parseInt(rowRecord[1].toString()));
                     
                    
                    }
                    
                    
                   // System.out.println(orderTableColumns);
                   defaultTable.addRow(rowRecord);
                  
                Cart.setModel(defaultTable); 
           
                
               }   
                
            return rowRecord[3].toString();
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            displaySQLErrors(ex);
            return null;
        }
     
 }
 
 public static boolean  login(String username,String password){
     
     String query = "SELECT firstname_username,phone_number_password FROM employees";
     String cUsername = "";
     String cPassword = "";
        try {
            resultSet = statement.executeQuery(query);
            resultSet.beforeFirst();
            while(resultSet.next()){
                         
                if(username.equals(resultSet.getString("firstname_username")) && password.equals(resultSet.getString("phone_number_password"))){
                   cUsername = resultSet.getString("firstname_username");
                 cPassword = resultSet.getString("phone_number_password");
                    break;                
                }                
            }
            if(username.equals(cUsername) && password.equals(cPassword)){
                return true;
            }else
                return  false;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
           
            displaySQLErrors(ex);
            System.out.println(ex.getMessage());
            return false;
        }
     
 }

}
