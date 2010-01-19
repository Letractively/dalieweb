/*
 * Created of DV0101 on 04.01.2010 19:48:22
 *
 * Filename	  CreateDataSelectOptionen.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 04.01.2010 um 19:48:22
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableSelectOptionen {
	
	public synchronized void createTableSelectoptionen(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".selectoptionen( " +
					"selectbox char(15) NOT NULL COMMENT '0 Selectbox Name'," +
					"sprachId char(2) NOT NULL COMMENT '1 Sprach Id',"+
					"optionId char(2) NOT NULL COMMENT '2 Option Id',"+
					"optionValue char(2) NOT NULL COMMENT '3 Option Value',"+
					"optionDescripten char(30) NOT NULL COMMENT '4 Options Descripten',"+

					"createUser char(10) NOT NULL COMMENT '5 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '6 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '7 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '8 Aenderungs Datum'," + 
					" KEY (selectbox) " +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Selectoptionen '");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableSelectoptionen:", e);
			System.out.println(this.getClass().getName() + "createTableSelectoptionen:" + e);
		}//catch
	}//createTableSelectoptionen
	
}//class CreateTableSelectOptionen
