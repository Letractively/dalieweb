/*
 * Created of DV0101 on 16.02.2010 15:26:51
 *
 * Filename	  CreateTableStaLanImo.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;


/**
 * Create Table:SELINAS om Database.
 *
 * @version 	1.00 16.02.2010 um 15:26:51
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableStaLanImo {

	public synchronized void createTableStaLanImo(Database dbConn){
		try {
			dbConn.executeUpdate(
					"CREATE TABLE "+dbConn.getDbSchema()+".stalanimo(" +
						"kundenId int NOT NULL COMMENT '0 Kunden Id'," +
						"standortId int NOT NULL COMMENT '1 Standort Id'," +
						"sprachId char(2) NOT NULL COMMENT '2 Sprach Id'," +

						"objektId char(50) NOT NULL COMMENT '3 Objektnummer'," +
						"immobilientyp char(50) NOT NULL COMMENT '4 Immobilientyp'," +
						"name char(50) NOT NULL COMMENT '5 Name des Eigentuemers'," +
						"vorname char(50) NOT NULL COMMENT '6 Vorname des Eigentuemers'," +
						"geburtstag char(50) NOT NULL COMMENT '7 Geburtstag des Eigentuemers '," +
						"besitzSeit char(50) NOT NULL COMMENT '8 Besitzer seit'," +
						
						"miete char(50) NOT NULL COMMENT '9 Miete'," +
						"baujahr char(50) NOT NULL COMMENT '10 Baujahr'," +
						"zustand char(50) NOT NULL COMMENT '11 zustand'," +
						"wohnungstyp char(50) NOT NULL COMMENT '12 Wohnungstyp'," +
						"zimmer char(50) NOT NULL COMMENT '13 Zimmer'," +
						"flaeche char(50) NOT NULL COMMENT '14 Flaeche'," +
						"heitzungstyp char(50) NOT NULL COMMENT '15 Heitzungstyp'," +
						
						"catpion1 char(100) NOT NULL COMMENT '16 Caption 1'," +
						"caption2 char(100) NOT NULL COMMENT '17 Caption 2'," +
						"caption3 char(100) NOT NULL COMMENT '18 Caption 3'," +
						"caption4 char(100) NOT NULL COMMENT '19 Caption 4'," +
						"caption5 char(100) NOT NULL COMMENT '20 Caption 5'," +
						"caption6 char(100) NOT NULL COMMENT '21 Caption 6'," +
						"caption7 char(100) NOT NULL COMMENT '22 Caption 7'," +
						"caption8 char(100) NOT NULL COMMENT '23 Caption 8'," +
						"caption9 char(100) NOT NULL COMMENT '24 Caption 9'," +
						"caption10 char(100) NOT NULL COMMENT '25 Caption 10'," +
						
						"button1 char(150) NOT NULL COMMENT '26 Button 1'," +
						"button2 char(150) NOT NULL COMMENT '27 Button 2'," +
						"button3 char(150) NOT NULL COMMENT '28 Button 3'," +
						"button4 char(150) NOT NULL COMMENT '29 Button 4'," +
						"button5 char(150) NOT NULL COMMENT '30 Button 5'," +
						"button6 char(150) NOT NULL COMMENT '31 Button 6'," +
						"button7 char(150) NOT NULL COMMENT '32 Button 7'," +
						"button8 char(150) NOT NULL COMMENT '33 Button 8'," +
						"button9 char(150) NOT NULL COMMENT '34 Button 9'," +
						"button10 char(150) NOT NULL COMMENT '35 Button 10'," +
						
						"link1 char(150) NOT NULL COMMENT '36 Link1'," +
						"link1t char(150) NOT NULL COMMENT '37 Link1t '," +
						"link2 char(150) NOT NULL COMMENT '38 Link2'," +
						"link2t char(150) NOT NULL COMMENT '39 Link2t'," +
						"link3 char(150) NOT NULL COMMENT '40 Link3'," +
						"link3t char(150) NOT NULL COMMENT '41 Link3t'," +
						"link4 char(150) NOT NULL COMMENT '42 Link4'," +
						"link4t char(150) NOT NULL COMMENT '43 Link4t'," +
						"link5 char(150) NOT NULL COMMENT '44 Link5'," +
						"link5t char(150) NOT NULL COMMENT '45 Link5t'," +
						"link6 char(150) NOT NULL COMMENT '46 Link6'," +
						"link6t char(150) NOT NULL COMMENT '47 Link6t'," +
						"link7 char(150) NOT NULL COMMENT '48 Link7'," +
						"link7t char(150) NOT NULL COMMENT '49 Link7t'," +
						"link8 char(150) NOT NULL COMMENT '50 Link8'," +
						"link8t char(150) NOT NULL COMMENT '51 Link8t'," +
						"link9 char(150) NOT NULL COMMENT '52 Link9'," +
						"link9t char(150) NOT NULL COMMENT '53 Link9t'," +
						"link10 char(150) NOT NULL COMMENT '54 Link10'," +
						"link10t char(150) NOT NULL COMMENT '55 Link10t'," +
						
						"image1 char(75) NOT NULL COMMENT '56 Image 1'," +
						"image1t char(75) NOT NULL COMMENT '57 Image 1t'," +
						"image2 char(75) NOT NULL COMMENT '58 Image 2'," +
						"image2t char(75) NOT NULL COMMENT '59 Image 2t'," +
						"image3 char(75) NOT NULL COMMENT '60 Image 3'," +
						"image3t char(75) NOT NULL COMMENT '61 Image 3t'," +
						"image4 char(75) NOT NULL COMMENT '62 Image 4'," +
						"image4t char(75) NOT NULL COMMENT '63 Image 4t'," +
						"image5 char(75) NOT NULL COMMENT '64 Image 5'," +
						"image5t char(75) NOT NULL COMMENT '65 Image 5t'," +
						"image6 char(75) NOT NULL COMMENT '66 Image6'," +
						"image6t char(75) NOT NULL COMMENT '67 Image 6t'," +
						"image7 char(75) NOT NULL COMMENT '68 Image7'," +
						"image7t char(75) NOT NULL COMMENT '69 Image 7t'," +
						"image8 char(75) NOT NULL COMMENT '70 Image8'," +
						"image8t char(75) NOT NULL COMMENT '71 Image 8t'," +
						"image9 char(75) NOT NULL COMMENT '72 Image9'," +
						"image9t char(75) NOT NULL COMMENT '73 Image 9t'," +
						"image10 char(75) NOT NULL COMMENT '74 Image10'," +
						"image10t char(75) NOT NULL COMMENT '75 Image 10t'," +
						
						"createUser char(30) NOT NULL COMMENT '76 Ersteller'," +
						"createDate char(30) NOT NULL COMMENT '77 erstellt am'," +
						"changeUser char(30) NOT NULL COMMENT '78 Verwaltet'," + 
						"changeDate char(30) NOT NULL COMMENT '79 verwaltet am'," + 
						
					"PRIMARY KEY (kundenId,standortId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Stammdatendatei: Übersetzung für Immobilienenverwaltung'");
		} catch (Exception e) {
			LoggerHelper.log("CreateTableSelinas1","Exception of createTable-SQL:", e);
			System.out.println(this.getClass().getName()+".createTableStaLanImo.:" + e);
		}//catch
	}//createTableSelinas1
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableStaLanImo selinas = new CreateTableStaLanImo();
    	
    	dbConn.getConnection();
    	selinas.createTableStaLanImo(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableStaLanImo
