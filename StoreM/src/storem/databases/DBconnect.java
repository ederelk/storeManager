/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storem.databases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yaovi Elom Kwasi AKA REDE <ederelk@gmail.com>
 */
public class DBconnect  {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    static final String DATABASE_URL = "jdbc:mysql://localhost/generic_store";
    static final String DATABASE_NAME = "generic_store";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    public static String dbConnectedName;
    private static String username, password;
    public static  ResultSetMetaData metaData;
    public static Connection connection;
    public static Statement statement;// query statement
    public static ResultSet resultSet;
    
    protected static boolean connected = false;
    
    public DBconnect(){
        connectToDB(DATABASE_NAME, USERNAME, PASSWORD);
    }
    public DBconnect(String dbName, String username, String password){
        connectToDB(dbName, username, password);
       
     }
    public static boolean connectToDB(String dbName, String username, String password){
        setDbConnectedName(dbName);
        DBconnect.username = username;
        DBconnect.password = password;
        
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
       DBconnect.dbConnectedName = dbConnectedName;
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
        DBconnect.connected = connected;
    }

    public static void reconnect(){
        if(!connected)
            connectToDB(DATABASE_NAME, USERNAME, PASSWORD);

    }

  
}
