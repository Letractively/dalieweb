package selinas.bean;

import javax.servlet.http.HttpServletRequest;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Selinas;
import database.dateien.User;
import database.getDatabase.DataSetDokument;

/**
 * @author dv0101 am 29.12.2008 um 09:15:45
 *
 * selinas.java
 * 
 */

public class SelinasSession {

	public Selinas session;
	private String[] columHeader = {"Typ des Dokuments","","Titel","Beschreibung","Ersteller","",""};
    
    public SelinasSession(Selinas session){
    	this.session = session;
    }//Selinas
    
	/** @return Returns the columHeader.*/
	public String[] getColumHeader() {
		return columHeader;
	}
	
	/**
	* <b>Erzeuge ein Objekt vom Dokument aus Datenbanktabelle Dokument</b>
	* <br><b>chain:Key user.getKundenId, user.getStandortId, int dokumentNr, dokumentId</b>
	* <br><b>protected</b><br>
	* @param
	* <ul>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokument</li></ul>
     * @throws Exception
     * @throws NumberFormatException
	*/
	public static Dokument getDokumentOfDatabase(Database dbConn,User user,HttpServletRequest request) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,request.getParameter("dokumentTyp"),Integer.parseInt((String)request.getParameter("dokumentNr")),Integer.parseInt((String)request.getParameter("dokumentId")));
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	
}//class selinas


