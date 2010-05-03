/*
 * Created of DV0101 on 16.02.2010 16:11:32
 *
 * Filename	  CreateDataStaLanImo.java
 */
package database.crtDatabase;

import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 16.02.2010 um 16:11:32
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataStaLanImo {
	/* Um sicher zustellen, dass immer korrekte Einträge für Selinas vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen */
	
	public synchronized void deleteStaLanImo(Database dbConn,int kundenId, int standortId, String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".stalanimo " +
					"where kundenId = " + kundenId +
					" and standortId = " + standortId +
	    	        " and sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteSelinas:" + e);
		}//catch
	}//deleteSelinas

	public synchronized void insertStaLanImoDE(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".stalanimo " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'DE'," +//sparchId
				"'Objekt-Id'," +//objektId
				"'Immobilientyp'," +//immobilientyp
				"'name'," +//name
				"'vorname'," +//vorname
				"'geburtstag'," +//geburtstag
				"'Eigentümer seit'," +//besitzSeit
				"'Miete'," +//miete
				"'Baujahr'," +//baujahr
				"'Beschreibung des Zustandes'," +//zustand
				"'Typ der Wohnung'," +//wohnungstyp
				"'Zimmeranzahl'," +//zimmmer
				"'Fläche in qm'," +//fläche
				"'Typ der Heitzung'," +//heitzungstyp
				"'caption 1'," +//caption1
				"'caption 2'," +//caption2
				"'caption 3'," +//caption3
				"'caption 4'," +//caption4
				"'caption 5'," +//caption5
				"'caption 6'," +//caption6
				"'caption 7'," +//caption7
				"'caption 8'," +//caption8
				"'caption 9'," +//caption9
				"'caption 10'," +//caption10
				"'<span style=\"text-decoration:underline\">s</span>uchen'," +//button1
				"'<span style=\"text-decoration:underline\">a</span>nlegen'," +//button2
				"'button 3'," +//button3
				"'button 4'," +//button4
				"'button 5'," +//button5
				"'button 6'," +//button6
				"'button 7'," +//button7
				"'button 8'," +//button8
				"'button 9'," +//button9
				"'button 10'," +//button10
				"'link1'," +//link1
				"'linkt1'," +//linkt1
				"'link2'," +//link2
				"'linkt2'," +//linkt2
				"'link3'," +//link3
				"'linkt3'," +//linkt3
				"'link4'," +//link4
				"'linkt4'," +//linkt4
				"'link5'," +//link5
				"'linkt5'," +//linkt5
				"'link6'," +//link6
				"'linkt6'," +//linkt6
				"'link7'," +//link7
				"'linkt7'," +//linkt7
				"'link8'," +//link8
				"'linkt8'," +//linkt8
				"'link9'," +//link9
				"'linkt9'," +//linkt9
				"'link10'," +//link10
				"'linkt10'," +//linkt10
				"'image1'," +//image1
				"'imaget1'," +//imaget1
				"'image2'," +//image2
				"'imaget2'," +//imaget2
				"'image3'," +//image3
				"'imaget3'," +//imaget3
				"'image4'," +//image4
				"'imaget4'," +//imaget4
				"'image5'," +//image5
				"'imaget5'," +//imaget5
				"'image6'," +//image6
				"'imaget6'," +//imaget6
				"'image7'," +//image7
				"'imaget7'," +//imaget7
				"'image8'," +//image8
				"'imaget8'," +//imaget8
				"'image9'," +//image9
				"'imaget9'," +//imaget9
				"'image10'," +//image10
				"'imaget10'," +//imaget10
				"'erstellt von:'," + "'erstellt am:'," + 
				"'geändert von'," + "'geändert am')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertStaLanImoDE:" + e);
		}//catch
	}//insertSelinasDE
	
	public synchronized void insertStaLanImoEN(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".stalanimo " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'EN'," +//sprachId
				"'Object-Id'," +//objektId
				"'Property of immobilie'," +//immobilientyp
				"'name'," +//name
				"'first name'," +//vorname
				"'birthday'," +//geburtstag
				"'Since of owner'," +//besitzSeit
				"'rent'," +//miete
				"'Vintage'," +//baujahr
				"'description of the state'," +//zustand
				"'Type of accommodation'," +//wohnungstyp
				"'Number of rooms'," +//zimmmer
				"'Area in sqm'," +//fläche
				"'Type of air blowers'," +//heitzungstyp
				"'caption 1'," +//caption1
				"'caption 2'," +//caption2
				"'caption 3'," +//caption3
				"'caption 4'," +//caption4
				"'caption 5'," +//caption5
				"'caption 6'," +//caption6
				"'caption 7'," +//caption7
				"'caption 8'," +//caption8
				"'caption 9'," +//caption9
				"'caption 10'," +//caption10
				"'<span style=\"text-decoration:underline\">s</span>earch'," +//button1
				"'to<span style=\"text-decoration:underline\">a</span>pply'," +//button2
				"'button 3'," +//button3
				"'button 4'," +//button4
				"'button 5'," +//button5
				"'button 6'," +//button6
				"'button 7'," +//button7
				"'button 8'," +//button8
				"'button 9'," +//button9
				"'button 10'," +//button10
				"'link1'," +//link1
				"'linkt1'," +//linkt1
				"'link2'," +//link2
				"'linkt2'," +//linkt2
				"'link3'," +//link3
				"'linkt3'," +//linkt3
				"'link4'," +//link4
				"'linkt4'," +//linkt4
				"'link5'," +//link5
				"'linkt5'," +//linkt5
				"'link6'," +//link6
				"'linkt6'," +//linkt6
				"'link7'," +//link7
				"'linkt7'," +//linkt7
				"'link8'," +//link8
				"'linkt8'," +//linkt8
				"'link9'," +//link9
				"'linkt9'," +//linkt9
				"'link10'," +//link10
				"'linkt10'," +//linkt10
				"'image1'," +//image1
				"'imaget1'," +//imaget1
				"'image2'," +//image2
				"'imaget2'," +//imaget2
				"'image3'," +//image3
				"'imaget3'," +//imaget3
				"'image4'," +//image4
				"'imaget4'," +//imaget4
				"'image5'," +//image5
				"'imaget5'," +//imaget5
				"'image6'," +//image6
				"'imaget6'," +//imaget6
				"'image7'," +//image7
				"'imaget7'," +//imaget7
				"'image8'," +//image8
				"'imaget8'," +//imaget8
				"'image9'," +//image9
				"'imaget9'," +//imaget9
				"'image10'," +//image10
				"'imaget10'," +//imaget10
				"'created by:'," + "'created on:'," + 
				"'edited by'," + "'changed')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertStaLanImoEN:" + e);
		}//catch
	}//insertSelinasEN
	
	 public static void main(String args[]) throws Exception{
	 	Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
	 	CreateDataStaLanImo selinas = new CreateDataStaLanImo();
    	
    	dbConn.getConnection();
    	selinas.deleteStaLanImo(dbConn,1,1,"DE");
    	selinas.deleteStaLanImo(dbConn,1,1,"EN");
    	selinas.insertStaLanImoDE(dbConn);
    	selinas.insertStaLanImoEN(dbConn);
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateDataStaLanImo
