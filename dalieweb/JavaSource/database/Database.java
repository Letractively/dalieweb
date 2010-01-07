/*
 * Created of DV0101 on 01.05.2009 15:25:47
 *
 * Filename	  Database.java
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Definition of Database connection
 *
 * @version 	1.00 01.05.2009 um 15:25:47
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 */
public class Database {

    private Connection dbConnection;
	/** Atribute of TableColumn */
	private Hashtable columnTypes = new Hashtable();
	/** Name on TableColumn */
	private Vector columnNames = new Vector();
	/** Witch Database do you connect*/
	private String dbType;
	/** IP-Adress of Net */
	private String dbHost;
	/** Name of DatabaseSchema */
	private String dbSchema;
	/** USER if you wish to connect */
	private String user;
	/** Password of USER */
	private String password;
	
	public Database(String dbType, String dbHost, String dbSchema, String user, String password){	
		this.dbType = dbType;
		this.dbHost = dbHost;
		this.dbSchema = dbSchema;
		this.user = user;
		this.password = password;
	}//construktor Database	

	/** Get Driver for JDBC-Connection*/
	public void getConnection() throws Exception{
		try{
			if (dbType.equals("mySql")){  
				Class.forName("com.mysql.jdbc.Driver");
				if (dbHost.length() == 0){
					dbHost = "localhost";
				}//endif
				dbConnection = DriverManager.getConnection("jdbc:mysql://"+dbHost+"/"+dbSchema,user,password);
			}//endif
			}catch (Exception ex){
				throw new Exception ("dbs connect " + ex.toString());
			}//try
	}//getConnection
	
	public Vector executeQuery(String sqlStatement) throws Exception{
		Vector result = executeQueryProcess(sqlStatement);
			if (result == null){
				System.out.println("reconnect");
				getConnection();
				result = executeQueryProcess(sqlStatement);
			}//endif    
			return result;    	
	}//executeQuery	
	/** SQL for Data Query Language select */
	public Vector executeQueryProcess(String sqlStatement) throws Exception{
		Statement statement = null;
		try{
				statement = dbConnection.createStatement();
			}catch (Exception ex){
				throw new Exception ("dbs query 1 " + ex.toString());
			}//try

		ResultSet resultSet = null;
		ResultSetMetaData metaData = null; 
	
		try{
				resultSet = statement.executeQuery(sqlStatement);
				metaData = resultSet.getMetaData();
			}catch (SQLException ex){
				throw new Exception ("dbs query 2 " + ex.toString());
			}//try

		Vector rows = new Vector();
		try{
			while (resultSet.next() == true){
				Vector columns = new Vector();
				for (int i = 0; i < metaData.getColumnCount(); i++){
					columns.addElement((resultSet.getObject(i+1)));
				}//for
				rows.addElement(columns);
				}//while
				columnNames.clear();
				columnTypes.clear();
				for (int i = 0; i < metaData.getColumnCount(); i++){
				columnNames.addElement(metaData.getColumnName(i+1));
				columnTypes.put(metaData.getColumnName(i+1),metaData.getColumnTypeName(i+1));			
				}//for
				resultSet.close();
				statement.close();
				return rows;
			}catch (SQLException ex){
				throw new Exception ("dbs query 3 " + ex.toString());
			}//try
	}//executeQuery


	/** SQL Data Manipulation Language create,insert,delete,update */
	public boolean executeUpdate(String sqlStatement) throws Exception{
		boolean result = executeUpdateProcess(sqlStatement);
		if (!result){
			System.out.println("reconnect");
			getConnection();
			result = executeUpdateProcess(sqlStatement);
		}//endif    
		return result;    	
	}//executeUpdate	

	public boolean executeUpdateProcess(String sqlStatement) throws Exception {
		Statement statement = null;
		try{
			statement = dbConnection.createStatement();
		}catch (SQLException ex){
			throw new Exception ("dbs update 1 " + ex.toString());
		}//try	
		try{
			statement.executeUpdate(sqlStatement);
			statement.close();
			return true;
		}catch (SQLException ex){
			throw new Exception ("dbs update 2 " + ex.toString());
		}//try
	}//executeUpdateProcess

	/**
	 * Databaseconnect close
	 * @throws Exception
	 */
	public void close() throws Exception{
		try{
			dbConnection.close();
		}catch (SQLException ex){
			throw new Exception ("dbs close  " + ex.toString());
		}//try
	}//close
	/**
	 * all Atribute of TableColumn
	 * @return Hashtable of columnTypes
	 */
	public Hashtable getColumnTypes(){
		return(columnTypes);
	}//getColumnTypes
	
	/**
	 * all Name on TableColumn
	 * @return Vector of columnNames
	 */
	public Vector getColumnNames(){
		return(columnNames);
	}//getColumnNames
	
	public String getDbSchema() {
		return dbSchema;
	}//getDbSchema
    
}//class Database
