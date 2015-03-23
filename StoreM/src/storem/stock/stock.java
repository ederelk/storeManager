/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * stock.java
 *
 * Created on 19 avr. 2012, 18:23:27
 */
package storem.stock;


import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import storem.databases.*;

/**
 *
 * @author Yaovi Elom Kwasi AKA REDE <ederelk@gmail.com>
 */
public class stock extends javax.swing.JPanel {
  
    public static String[] columns = {"Nom du Produit","Stock","Date et Heure de la Derniere Modiication"};
    String query = " SELECT product_name,left_in_stock,"
            + "DATE_FORMAT(date,'    %d/%m/%Y  %H:%i:%s') FROM stocks ORDER BY date DESC";
    String queryAfterUpdate = " SELECT product_name,left_in_stock,"
            + "DATE_FORMAT(date,'    %d/%m/%Y  %H:%i:%s') FROM stocks";
    public final static  Class[] columnsType = new Class[]{ java.lang.Object.class, java.math.BigInteger.class, java.util.Calendar.class,java.lang.Long.class};  
     //java.net.URL helpURL = stock.class.getResource("TextSamplerDemoHelp.html");
     static final String  HTML_OPEN_TAG = "<HTML style =\" background:#efeff0;\">"+
             " <head> </head> <body style = \"color:;background:#efeff0;font-family:  Verdana, Arial, Helvetica, sans-serif; "+
	     "font-size: 10px; \">"+"<h2><a href = \"\">Informations Détaillées</a></h2>";
     static final String  HTML_CLOSE_TAG = "</body></HTML>";
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
    /** Creates new form stock */
    public stock() {
        initComponents();
        tableModelfunc.setDBconnection();
        tableModelfunc.setDateLanguage("fr_FR");
        tableModelfunc.setTableModelToJtable(stockTable, columns, query, columnsType);
        
      /*  try {
            jEditorPane1.setPage(helpURL);
            
        } catch (IOException ex) {
            Logger.getLogger(stock.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //dateTime.setTimeZone(dateTime.getTimeZone());
        
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editStockDialog = new javax.swing.JDialog();
        edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        addToStock = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        oldValue = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newValue = new javax.swing.JLabel();
        detailStockDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        editProduct = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column)
            { return false; }
        };

        editStockDialog.setTitle("Stock");
        editStockDialog.setResizable(false);
        editStockDialog.setSize(334, 292);
        editStockDialog.setLocation((screenSize.width-editStockDialog.getWidth())/2, (screenSize.height-editStockDialog.getHeight())/2);

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/ui/ApplyGreen.png"))); // NOI18N
        edit.setText("Enregistrer");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel2.setText("Valeur à Ajouter au Stock :");

        addToStock.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                addToStockCaretUpdate(evt);
            }
        });
        addToStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToStockActionPerformed(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/ui/DiscardRed.png"))); // NOI18N
        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel3.setText("L'Ancien stock est:");

        oldValue.setFont(new java.awt.Font("Tahoma", 1, 14));
        oldValue.setText("  ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("+");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("=");

        jLabel6.setText("Nouveau Stock:");

        newValue.setFont(new java.awt.Font("Tahoma", 1, 14));
        newValue.setText("  ");

        javax.swing.GroupLayout editStockDialogLayout = new javax.swing.GroupLayout(editStockDialog.getContentPane());
        editStockDialog.getContentPane().setLayout(editStockDialogLayout);
        editStockDialogLayout.setHorizontalGroup(
            editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStockDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editStockDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToStock, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editStockDialogLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newValue, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(edit)))
                    .addGroup(editStockDialogLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editStockDialogLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
                            .addComponent(oldValue, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(editStockDialogLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cancel)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        editStockDialogLayout.setVerticalGroup(
            editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStockDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addToStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editStockDialogLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(newValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(editStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(edit))
                .addGap(33, 33, 33))
        );

        detailStockDialog.setTitle("Detailles du Produit en Stock");
        detailStockDialog.setSize(400, 700);
        detailStockDialog.setLocation((screenSize.width-detailStockDialog.getWidth())/2, (screenSize.height-detailStockDialog.getHeight())/2);

        jButton3.setText("Fermer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        detailStockDialog.getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jScrollPane2.setViewportView(jEditorPane1);

        detailStockDialog.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/icons/record_edit.png"))); // NOI18N
        editProduct.setText("Modifier Stock");
        editProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/icons/tiny_refresh.png"))); // NOI18N
        refresh.setText("Actualiser");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/ui/search_icon.png"))); // NOI18N
        jLabel1.setText("Rechercher:");

        search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchCaretUpdate(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storem/images/grt/structs/workbench.physical.Diagram.16x16.png"))); // NOI18N
        jButton4.setText("Informations Detaillées");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refresh)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProduct)
                    .addComponent(jButton4))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        stockTable.setAutoCreateRowSorter(true);
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(stockTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tableModelfunc.setTableModelToJtable(stockTable, columns, query, columnsType);        // TODO add your handling code here:
}//GEN-LAST:event_refreshActionPerformed

    private void searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchCaretUpdate

        
                       
        if(!search.getText().equals(""))
            tableModelfunc.searchStocks(search, stockTable, columns);
        else
            tableModelfunc.setTableModelToJtable(stockTable, columns, query, columnsType);
        // TODO add your handling code here:
}//GEN-LAST:event_searchCaretUpdate
public void setPaneContent(){
    String bodyDetails = tableModelfunc.getStockdetails(
            stockTable.getValueAt(stockTable.getSelectedRow(),
            tableModelfunc.getCorrectColumn(stockTable)).toString());
    jEditorPane1.setText(HTML_OPEN_TAG+bodyDetails+HTML_CLOSE_TAG);
}
    private void editProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductActionPerformed
try{ 
        tableModelfunc.loadSelectedStock( stockTable.getValueAt(stockTable.getSelectedRow(), tableModelfunc.getCorrectColumn(stockTable)).toString()
                ,editStockDialog,oldValue);
       // newValue.setText("0");
        addToStock.setText("");
        newValue.setText(Integer.toString(Integer.parseInt(oldValue.getText())+0));
           editStockDialog.setModal(true); 
        editStockDialog.setVisible(true);}catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "S'il vous plais , Veuillez SELECTIONNER le produit à modifier avant de cliquer sur Modifier Stock", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
}//GEN-LAST:event_editProductActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
try{
            String history = "" ;
            String sqlquery = "select history from stocks where product_name = '"+stockTable.getValueAt(stockTable.getSelectedRow(), tableModelfunc.getCorrectColumn(stockTable))+"'";
            history = tableModelfunc.updateHistory(sqlquery);
            String editQuery ="UPDATE stocks SET "+
               "history = CONCAT('"+(history == null ?"*******":history) +"','<h4 style = \" color: black;\">Nouvelle Modification :</h4>Le ','<a style = \" color : green;\" href= \"\">',DATE_FORMAT(CURRENT_TIMESTAMP(),'%W %d, %M %Y  à  %H:%i:%s'),'</a>',' Le Stock a été augmanté de "+"<em style =\"color : red;font-weight: bold; \";>"+
               (Integer.parseInt(addToStock.getText().trim())) +"</em> et devient "+
                "<em style =\"color : red;font-weight: bold; \";>"+(newValue.getText().trim())+"</em>') ,"+
                "left_in_stock = "+(newValue.getText().trim()) +","
                +"date =  NULL"+ " WHERE product_name ='"
                +stockTable.getValueAt(stockTable.getSelectedRow(), tableModelfunc.getCorrectColumn(stockTable))+"'";
                tableModelfunc.executeEditquery(editQuery);    
                editStockDialog.dispose();
                editStockDialog.setModal(false);
                tableModelfunc.setTableModelToJtable(stockTable, columns, query, columnsType);
                stockTable.setRowSelectionInterval(0,0);
                
                    }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(jEditorPane1, "S'il vous plaît,veuilez entrer UNIQUEMENT DES CHIFFRES dans cet espace ", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void addToStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToStockActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try{
        setPaneContent();
        detailStockDialog.setModal(true);
        detailStockDialog.setVisible(true);}catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "S'il vous plais , Veuillez SELECTIONNER le produit dont vous voulez afficher les informations avant de cliquer sur Informations Detaillées", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }


// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        editStockDialog.dispose();
        editStockDialog.setModal(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void addToStockCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_addToStockCaretUpdate

        int newVal;
        try{
        if(!addToStock.getText().equals("")){
        newVal = Integer.parseInt(oldValue.getText())+ Integer.parseInt(addToStock.getText());
        newValue.setText(Integer.toString(newVal));}else
            newValue.setText("");}catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(newValue, "S'il vous plaît,veuilez entrer UNIQUEMENT DES CHIFFRES dans cet espace","Attention", JOptionPane.INFORMATION_MESSAGE);
            }
                // TODO add your handling code here:
    }//GEN-LAST:event_addToStockCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jEditorPane1.print();// TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
       tableModelfunc.setTableModelToJtable(stockTable, columns, query, columnsType);
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        detailStockDialog.dispose();
        detailStockDialog.setModal(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addToStock;
    private javax.swing.JButton cancel;
    private javax.swing.JDialog detailStockDialog;
    private javax.swing.JButton edit;
    private javax.swing.JButton editProduct;
    private javax.swing.JDialog editStockDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newValue;
    private javax.swing.JLabel oldValue;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
