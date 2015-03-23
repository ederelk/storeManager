/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storem.databases;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Yaovi Elom Kwasi AKA REDE <ederelk@gmail.com>
 */
public class storemDB extends AbstractTableModel{
    // JDBC driver name and database URL                              
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    static final String DATABASE_URL = "jdbc:mysql://localhost/generic_store";
    static final String DATABASE_NAME = "generic_store";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    
    public static Connection connection;
    public static Statement statement;// query statement
    public static ResultSet resultSet;
    public static ResultSetMetaData metaData;
    public static String dbConnectedName;
    private static String username, password;
    public int numberOfRows;
    protected static boolean connected = false;
    
    public storemDB (){
        connectToDB(DATABASE_NAME, USERNAME, PASSWORD);
    }
     public  storemDB(String dbName, String username, String password){
        connectToDB(dbName, username, password);
        
         // create Statement to query database   
               
     }
    public static boolean connectToDB(String dbName, String username, String password){
        setDbConnectedName(dbName);
        storemDB.username = username;
        storemDB.password = password;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch(Exception e){
            System.err.println("Unable to find and load driver!");
            return false;
        }

        try{
            connection = DriverManager.getConnection(
                   DATABASE_URL,username, password);
        }catch(SQLException ex){
            System.out.println("Unable to connect to database!");
            displaySQLErrors(ex);
            return false;
        }

        try {
          // create Statement to query database   
         statement = connection.createStatement( 
           ResultSet.TYPE_SCROLL_INSENSITIVE,   
           ResultSet.CONCUR_READ_ONLY );  
        } catch(SQLException ex) {
            displaySQLErrors(ex);
            return false;
        }

        setConnected(true);
        return true;
    }
     public static void disconnectFromDB(){
        try
        {
            if(resultSet.isClosed() == false)
                resultSet.close();

            if(statement.isClosed() == false)
                statement.close();

            if(connection.isClosed() == false) {
                connection.close();
            }
        } catch(SQLException ex)
        {
            displaySQLErrors(ex);
        }
        setConnected(false);
    }


      public static void displaySQLErrors(SQLException e){
        System.out.println("SQLEXception: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("endorError: " + e.getErrorCode());

//        errorText.append("SQLEXception: " + e.getMessage() + "\n");
//        errorText.append("SQLState: " + e.getSQLState() + "\n");
//        errorText.append("endorError: " + e.getErrorCode() + "\n");

        JOptionPane.showMessageDialog(null,
                "SQLEXception: " + e.getMessage() +
                "\nSQLState: " + e.getSQLState() +
                "\nendorError: " + e.getErrorCode()
                );
    }  
      
      
    public static String getDbConnectedName() {
        return dbConnectedName;
    }

    public static void setDbConnectedName(String dbConnectedName) {
       storemDB.dbConnectedName = dbConnectedName;
    }

    /**
     * Get the value of connected
     *
     * @return the value of connected
     */
    public static boolean isConnected() {
        return connected;
    }

    /**
     * Set the value of connected
     *
     * @param connected new value of connected
     */
    public static void setConnected(boolean connected) {
        storemDB.connected = connected;
    }

    public static void reconnect(){
        if(!connected)
            connectToDB(dbConnectedName, username, password);

    }
    
      public Class getColumnClass( int column ) throws IllegalStateException
      {
         // ensure database connection is available                        
         if ( !connected )                                       
            throw new IllegalStateException( "Not Connected to Database" );
 
         // determine Java class of column
         try
         {
           String className = metaData.getColumnClassName( column + 1 );
 
            // return Class object that represents className
            return Class.forName( className );              
         } // end try
         catch ( Exception exception )
         {
         } // end catch
 
         return Object. class; // if problems occur above, assume type Object
      } // end method getColumnClass
 
      // get number of columns in ResultSet
      public int getColumnCount() throws IllegalStateException
      {
         // ensure database connection is available
         if ( !connected )

            throw new IllegalStateException( "Not Connected to Database" );
 
         // determine number of columns
         try
         {
            return metaData.getColumnCount();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();
         } // end catch
 
         return 0; // if problems occur above, return 0 for number of columns
      } // end method getColumnCount
 
      // get name of a particular column in ResultSet
      public String getColumnName( int column ) throws IllegalStateException
      {
         // ensure database connection is available
         if ( !connected )
           throw new IllegalStateException( "Not Connected to Database" );
 
        // determine column name
        try
        {
           return metaData.getColumnName( column + 1 );
        } // end try
        catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
       } // end catch
 
        return ""; // if problems, return empty string for column name
     } // end method getColumnName

     // return number of rows in ResultSet
     public int getRowCount() throws IllegalStateException
     {
        // ensure database connection is available
      if ( !connected )
         throw new IllegalStateException( "Not Connected to Database" );
        return numberOfRows;
     } // end method getRowCount
 
     // obtain value in particular row and column
    public Object getValueAt( int row, int column )
       throws IllegalStateException
   {
        // ensure database connection is available
        if ( !connected )
           throw new IllegalStateException( "Not Connected to Database" );

        // obtain a value at specified ResultSet row and column
        try
        {
         resultSet.absolute( row + 1 );
          return resultSet.getObject( column + 1 );
       } // end try
       catch ( SQLException sqlException )
        {
          sqlException.printStackTrace();
        } // end catch

return ""; // if problems, return empty string object
    } // end method getValueAt

     // set new database query string
     public void setQuery( String query )
        throws SQLException, IllegalStateException
    {
        // ensure database connection is available
        if ( !connected )
          throw new IllegalStateException( "Not Connected to Database" );
 
       // specify query and execute it
       resultSet = statement.executeQuery(query);
  
        // obtain meta data for ResultSet
       metaData = resultSet.getMetaData();
 
        // determine number of rows in ResultSet
        resultSet.last();                   // move to last row
        numberOfRows = resultSet.getRow();  // get row number
 
// notify JTable that model has changed
       fireTableStructureChanged();           
     } // end method setQuery
  

    
    
}
