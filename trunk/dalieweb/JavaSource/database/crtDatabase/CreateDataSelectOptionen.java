/*
 * Created of DV0101 on 04.01.2010 19:28:53
 *
 * Filename	  CreateDataSelectOptionen.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 04.01.2010 um 19:28:53
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataSelectOptionen {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Selectboxen vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen */
	
	static Database dbConn;
	
	public static synchronized void deleteSelectboxId(Database dbConn,String selectbox,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selectbox " +
	        		"where kundenId = 1" +
					" and standortId = 1" +
					" and selectbox = '"+selectbox+"'" +
	    	        " and sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
	}//insertSelectboxPermitId
	public static synchronized void insertSelectboxId(Database dbConn,String selectbox,String sprachId){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectbox " +
					"values(1,1," +
					"'"+selectbox+"','"+sprachId+"'," + 
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
	}//insertSelectboxPermitId
	
	public static synchronized void deleteSelectoptionenId(Database dbConn,String nameOfSelectbox,String sprachId,int id) throws Exception {
    	dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selectoptionen " +
        		"where selectbox = '"+nameOfSelectbox+"'" +
    	        " and sprachId = '"+sprachId+"'"+
    			" and optionId = '"+id+"'");
    }//delete
	public static synchronized void deleteSelectoptionenId(Database dbConn,String nameOfSelectbox,String sprachId,String id) throws Exception {
    	dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selectoptionen " +
        		"where selectbox = '"+nameOfSelectbox+"'" +
    	        " and sprachId = '"+sprachId+"'"+
    			" and optionId = '"+id+"'");
    }//delete
	
    public static synchronized void insertSelectoptionenPermitId(Database dbConn,String nameOfSelectbox,String sprachId,int id){
    	String des = "";
    	for(int i = 1; i <= 5;i++){
    		if(i == 1 && sprachId == "DE")
    			des = " - ansehen ";
    		if(i == 2 && sprachId == "DE")
        	 	des = " - drucken ";
    		if(i == 3 && sprachId == "DE")
        	 	des = " - bearbeiten";
    		if(i == 4 && sprachId == "DE")
        	 	des = " - löschen ";
    		if(i == 5 && sprachId == "DE")
        	 	des = " - administrieren ";
    		
    		if(i == 1 && sprachId == "EN")
    			des = "- to view as " ;
    		if(i == 2 && sprachId == "EN")
    			des = "- to print as ";
    		if(i == 3 && sprachId == "EN")
    			des = "- to handle as ";
    		if(i == 4 && sprachId == "EN")
    			des = "- to delete as ";
    		if(i == 4 && sprachId == "EN")
    			des = "- to adminstration as ";
    		
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+id+"','"+i+"'," + 
					"'"+i + des+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	}//for
    }//insert
	
    public static synchronized void insertSelectoptionenAutorisierungId(Database dbConn,String nameOfSelectbox,String sprachId,int id,String des){
    	for(int i = 1; i <= 10;i++){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+id+"','"+i+"'," + 
					"'"+i + des+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	}//for
    }//insert
   
    public static synchronized void insertSelectoptionenStatusId(Database dbConn,String nameOfSelectbox,String sprachId,String optionId){
    	String optionValue = "";
    	String optionDescripten = "";
    	for(int i = 0; i <= 10;i++){
    		if(i == 0 && sprachId == "DE"){
    			optionValue = "P";
    			optionDescripten = " privat ";
    		}
    		if(i > 0 && sprachId == "DE"){
    			optionValue = (new Integer(i).toString());
    			optionDescripten = optionValue +"-Sicherheitsklasse ";
    		}
    		if(i == 0 && sprachId == "EN"){
    			optionValue = "P";
    			optionDescripten = " private ";
    		}
    		if(i > 0 && sprachId == "EN"){
        		optionValue = (new Integer(i)).toString();
        		optionDescripten = optionValue + "-Authorization ";
    		}
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	}//for
    }//insert
    
    public static synchronized void insertSelectoptionenUserStatusId(Database dbConn,String nameOfSelectbox,String sprachId,String optionId){
    	String optionValue = "";
    	String optionDescripten = "";
    	for(int i = 1; i <= 2;i++){
    		if(i == 1 && sprachId == "DE"){
    			optionValue = "A";
    			optionDescripten = " aktiv ";
    		}
    		if(i == 2 && sprachId == "DE"){
        		optionValue = "I";
        		optionDescripten = " inaktiv ";
    		}
    		if(i == 1 && sprachId == "EN"){
    			optionValue = "A";
    			optionDescripten = " actual ";
    		}
    		if(i == 2 && sprachId == "EN"){
        		optionValue = "I";
        		optionDescripten = " inactive ";
    		}
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	}//for
    }//insert
    
    public static synchronized void insertSelectoptionenAdressTyp(Database dbConn,String nameOfSelectbox,String sprachId,String optionId){
    	String optionValue = "";
    	String optionDescripten = "";
    	
    	if(sprachId == "DE"){
    		optionValue = "U";
    		optionDescripten = " Useradresse ";
    	}
    	if(sprachId == "EN"){
    		optionValue = "U";
    		optionDescripten = " Adress of User ";
    	}
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	
    }//insert
    
    public static synchronized void insertSelectoptionenSpeech(Database dbConn,String nameOfSelectbox,String sprachId,String optionId){
    	String optionValue = "";
    	String optionDescripten = "";
    	for(int i = 1; i <= 2;i++){
    		if(i == 1 && sprachId == "DE"){
    			optionValue = "DE";
    			optionDescripten = " deutsch ";
    		}
    		if(i == 2 && sprachId == "DE"){
        		optionValue = "EN";
        		optionDescripten = " englisch ";
    		}
    		if(i == 1 && sprachId == "EN"){
    			optionValue = "DE";
    			optionDescripten = " german ";
    		}
    		if(i == 2 && sprachId == "EN"){
        		optionValue = "EN";
        		optionDescripten = " english ";
    		}
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	}//for
    }//insert
    
    public static synchronized void insertSelectoptionenDokumentTyp(Database dbConn,String nameOfSelectbox,String sprachId,String optionId){
    	String optionValue = "KA";
    	String optionDescripten = "[Bitte auswählen] ";
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	
    }//insertSelectoptionenDokumentTyp
    
    public static synchronized void insertSelectoptionenImmobilienTyp(Database dbConn,String nameOfSelectbox,String sprachId,String optionId,String optionValue,String optionDescripten){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
					"values('"+nameOfSelectbox+"','" +sprachId+"','"+optionId+"','"+optionValue+"'," + 
					"'"+optionDescripten+"',"+
					"'DV0101'," + "now()," + 
					"'DV0101'," + "now())");
		} catch (Exception e) {
			LoggerHelper.log("CreateDataSelectOptionen", "Exception of insert-SQL", e);
		}//catch
    	
    }//insertSelectoptionenDokumentTyp
    
    public static void main(String args[]) throws Exception{
    	dbConn = new Database("mySql","localhost","selina","web4857","selina2009"); 
    	
    	dbConn.getConnection();
    	deleteSelectboxId(dbConn,"PermitId","DE");
    	insertSelectboxId(dbConn,"PermitId","DE");
    	for(int id = 1;id <= 5;id++){
    		deleteSelectoptionenId(dbConn,"PermitId","DE",id);
    		insertSelectoptionenPermitId(dbConn,"PermitId","DE",id);
    		
    	}//for
    	deleteSelectboxId(dbConn,"PermitId","EN");
    	insertSelectboxId(dbConn,"PermitId","EN");
    	for(int id = 1;id <= 5;id++){
    		deleteSelectoptionenId(dbConn,"PermitId","EN",id);
    		insertSelectoptionenPermitId(dbConn,"PermitId","EN",id);		
    	}//for
    	
    	deleteSelectboxId(dbConn,"AutorisierungId","DE");
    	insertSelectboxId(dbConn,"AutorisierungId","DE");
    	for(int id = 1;id <= 10;id++){
    		deleteSelectoptionenId(dbConn,"AutorisierungId","DE",id);
    		insertSelectoptionenAutorisierungId(dbConn,"AutorisierungId","DE",id," - Sicherheitsklasse");
    	}//for
    	deleteSelectboxId(dbConn,"AutorisierungId","EN");
    	insertSelectboxId(dbConn,"AutorisierungId","EN");
    	for(int id = 1;id <= 10;id++){
    		deleteSelectoptionenId(dbConn,"AutorisierungId","EN",id);
    		insertSelectoptionenAutorisierungId(dbConn,"AutorisierungId","EN",id,"- Authorization");
    	}//for
    	
    	deleteSelectboxId(dbConn,"Status","DE");
    	insertSelectboxId(dbConn,"Status","DE");
    	
    	deleteSelectoptionenId(dbConn,"Status","DE","P");
    		insertSelectoptionenStatusId(dbConn,"Status","DE","P");
    	
    		for(int id = 1;id <= 10;id++){
        		deleteSelectoptionenId(dbConn,"Status","DE",id);
        		insertSelectoptionenStatusId(dbConn,"Status","DE",(new Integer(id).toString()));
        	}//for
    		
    	deleteSelectboxId(dbConn,"Status","EN");
    	insertSelectboxId(dbConn,"Status","EN");
    	
    	deleteSelectoptionenId(dbConn,"Status","EN","P");
    		insertSelectoptionenStatusId(dbConn,"Status","EN","P");
    		
    		for(int id = 1;id <= 10;id++){
        		deleteSelectoptionenId(dbConn,"Status","EN",id);
        		insertSelectoptionenStatusId(dbConn,"Status","EN",(new Integer(id).toString()));
        	}//for
    	
    	deleteSelectboxId(dbConn,"AdressTyp","DE");
        insertSelectboxId(dbConn,"AdressTyp","DE");
        deleteSelectoptionenId(dbConn,"AdressTyp","DE","U");
        	insertSelectoptionenAdressTyp(dbConn,"AdressTyp","DE","U");
        	
        deleteSelectboxId(dbConn,"AdressTyp","EN");
        insertSelectboxId(dbConn,"AdressTyp","EN");
        deleteSelectoptionenId(dbConn,"AdressTyp","EN","U");
        	insertSelectoptionenAdressTyp(dbConn,"AdressTyp","EN","U");
        	
        	
        deleteSelectboxId(dbConn,"Speech","DE");
        insertSelectboxId(dbConn,"Speech","DE");
        deleteSelectoptionenId(dbConn,"Speech","DE","DE");
        	insertSelectoptionenSpeech(dbConn,"Speech","DE","DE");
        	
        	
        deleteSelectboxId(dbConn,"Speech","EN");
        insertSelectboxId(dbConn,"Speech","EN");	
        deleteSelectoptionenId(dbConn,"Speech","EN","EN");
        	insertSelectoptionenSpeech(dbConn,"Speech","EN","EN");
        
        //deleteSelectboxId(dbConn,"DokumentTyp","KA");
        //insertSelectboxId(dbConn,"DokumentTyp","KA");
        	//deleteSelectoptionenId(dbConn,"DokumentTyp","KA","KA");
        	//deleteSelectoptionenId(dbConn,"DokumentTyp","KA","KA");
        	//insertSelectoptionenDokumentTyp(dbConn,"DokumentTyp","KA","KA");
        
        /** Selectbox für UserStatus DE */
        deleteSelectboxId(dbConn,"Status","DE");
        insertSelectboxId(dbConn,"Status","DE");
        	
        /** Selectbox-optionen für UserStatus DE */
        deleteSelectoptionenId(dbConn,"Status","DE","A");
        deleteSelectoptionenId(dbConn,"Status","DE","I");
        	insertSelectoptionenUserStatusId(dbConn,"Status","DE","A");
        	insertSelectoptionenUserStatusId(dbConn,"Status","DE","I");
        	
       	/** Selectbox für UserStatus EN */
       	deleteSelectboxId(dbConn,"Status","EN");
       	insertSelectboxId(dbConn,"Status","EN");
        
       	/** Selectbox-optionen UserStauts EN */
       	deleteSelectoptionenId(dbConn,"Status","EN","A");
       	deleteSelectoptionenId(dbConn,"Status","EN","I");
       		insertSelectoptionenUserStatusId(dbConn,"Status","EN","A");
       		insertSelectoptionenUserStatusId(dbConn,"Status","EN","I");	
    	
       	/** Selectbox für ImmobilienTyp DE */
        deleteSelectboxId(dbConn,"TypDerImmobilie","DE");
        insertSelectboxId(dbConn,"TypDerImmobilie","DE");
            	
        /** Selectbox-optionen für ImmobilieTyp DE */
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","DE","W");
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","DE","H");
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","DE","P");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","W","W","Wohnung");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","W","H","Haus");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","W","P","Parkplatz");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","H","W","Wohnung");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","H","H","Haus");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","H","P","Parkplatz");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","P","W","Wohnung");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","P","H","Haus");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","DE","P","P","Parkplatz");	
           
        /** Selectbox für UserStatus EN */
        deleteSelectboxId(dbConn,"TypDerImmobilie","EN");
        insertSelectboxId(dbConn,"TypDerImmobilie","EN");
            
        /** Selectbox-optionen UserStauts EN */
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","EN","W");
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","EN","H");
        deleteSelectoptionenId(dbConn,"TypDerImmobilie","EN","P");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","W","W","Apartment");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","W","H","House");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","W","P","Parking places");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","H","W","Apartment");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","H","H","House");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","H","P","Parking places");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","P","W","Apartment");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","P","H","House");
        	insertSelectoptionenImmobilienTyp(dbConn,"TypDerImmobilie","EN","P","P","Parking places");			
       	dbConn.close();
    	System.out.println("Fertig");
    }//main
    
}//class CreateDataSelectOptionen
