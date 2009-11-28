package selinas.bean;

import javax.servlet.http.HttpServletRequest;

import database.Database;
import database.dateien.Adresse;
import database.dateien.Dokument;
import database.dateien.Selinas;
import database.dateien.User;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetDokument;

/**
 * @author dv0101 am 29.12.2008 um 09:15:45
 *
 * selinas.java
 * 
 */
public class SelinasSession {

	
	public Selinas session;
	
   
    public SelinasSession(Selinas session){
    	this.session = session;
    }//Selinas
    
    /**
	* <b>Erzeuge ein Objekt vom Adresse aus Datenbanktabelle Adressen</b>
	* <br><b>chain:Key user.getKundenId, "U"ser Adresse</b>
	* <br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* </ul>
	* @return
	* <ul><li>Adresse adresse</li></ul>
    * @throws Exception
	*/
	public Adresse getAdressOfDatabase(Database dbConn,User user) throws Exception{
	    Adresse adresseOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		adresseOfDatabase = DataSetAdresse.chain(dbConn, user.getKundenId(),"U");
		dbConn.close();////DataBaseConnection close
		return adresseOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	
	public Adresse getAdressOfUpdate(Database dbConn,User user,Adresse ofSession, HttpServletRequest request)throws Exception{
		Adresse adressOfUpdate = ofSession;
		adressOfUpdate.setAdressArt(request.getParameter("AdressTyp"));
		adressOfUpdate.setStrasse(request.getParameter(session.getStrasse()));
		adressOfUpdate.setNummer(request.getParameter(session.getNummer()));
		adressOfUpdate.setPlz(request.getParameter(session.getPlz()));
		adressOfUpdate.setOrt(request.getParameter(session.getOrt()));
		adressOfUpdate.setTelefon(request.getParameter(session.getTelefon()));
		adressOfUpdate.setFax(request.getParameter(session.getFax()));
		adressOfUpdate.setMail(request.getParameter(session.getMail()));
		dbConn.getConnection();//DataBaseConnection open
		DataSetAdresse.update(dbConn, user, adressOfUpdate);
		adressOfUpdate = DataSetAdresse.chain(dbConn, user.getKundenId() ,adressOfUpdate.getAdressArt()); 
		dbConn.close();//DataBaseConnection close
		return adressOfUpdate;
	}//getDokument  
	
	
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
	*/
	public Dokument getDokumentOfDatabase(Database dbConn,User user,HttpServletRequest request) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,request.getParameter("dokumentTyp"),Integer.parseInt((String)request.getParameter("dokumentNr")),Integer.parseInt((String)request.getParameter("dokumentId")));
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	
	public Dokument getDokumentOfDatabase(Database dbConn,User user,Dokument dokument) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,dokument);
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	
	public Dokument getDokumentOfInitialize(Database dbConn,User user,HttpServletRequest request)throws Exception{
       Dokument dokumentOfInitialize = new Dokument();
       dbConn.getConnection();//Aufbau Dankverbindung
       dokumentOfInitialize.setDokumentTyp(request.getParameter("dokumentTyp"));
       dokumentOfInitialize.setDokumentNr(Integer.parseInt(request.getParameter("dokumentNr")));
       int nextDokumentId = DataSetDokument.getNextdokumentId(dbConn,user,dokumentOfInitialize);
       dokumentOfInitialize.setGliederung(dokumentOfInitialize.getNummer() + "." + nextDokumentId);//GliederungsVorschlag setzen
       dokumentOfInitialize.setStatus("A");
       dokumentOfInitialize.setTitel(session.getTitel());
       dokumentOfInitialize.setDescripten(session.getDescripten());
       dokumentOfInitialize.setContent(session.getContent());
       dokumentOfInitialize.setArchiv(session.getArchiv());
       dokumentOfInitialize.setSprachId("DE");
       dokumentOfInitialize.setVorgabe("123");
       DataSetDokument.insert(dbConn,user,dokumentOfInitialize);//Insert in Datenbank
       dokumentOfInitialize = DataSetDokument.chain(dbConn,user,dokumentOfInitialize.getDokumentTyp(),dokumentOfInitialize.getNummer(),nextDokumentId);
       dbConn.close();
       return  dokumentOfInitialize;
    }//getDokument
	
	public Dokument getDokumentOfUpdate(Database dbConn,User user,Dokument ofSession, HttpServletRequest request)throws Exception{
	   Dokument dokumentOfUpdate = ofSession;
	   dokumentOfUpdate.setTitel(collapseSpaces(request.getParameter(session.getTitel())));
	   dokumentOfUpdate.setDescripten(request.getParameter(session.getDescripten()));
	   dokumentOfUpdate.setContent(collapseSpaces(request.getParameter(session.getContent())));
	   dokumentOfUpdate.setGliederung(request.getParameter(session.getGliederung()));
	   dokumentOfUpdate.setArchiv(request.getParameter(session.getArchiv()));
	   dokumentOfUpdate.setVorgabe(request.getParameter(session.getVorgabe()));
	   dokumentOfUpdate.setStatus(request.getParameter(session.getStatus()));
	   dbConn.getConnection();//DataBaseConnection open
	   DataSetDokument.update(dbConn, user, dokumentOfUpdate);
	   dokumentOfUpdate = DataSetDokument.chain(dbConn, user, dokumentOfUpdate);
	   dbConn.close();//DataBaseConnection close
	   return dokumentOfUpdate;
	}//getDokument  
	
	/**
	 * Remove/collapse multiple spaces.
	 *
	 * @param argStr string to remove multiple spaces from.
	 * @return String
	 */
	String collapseSpaces(String argStr){
		char last = argStr.charAt(0);
	    StringBuffer argBuf = new StringBuffer();
	    for (int cIdx = 0 ; cIdx < argStr.length(); cIdx++){
	    	char ch = argStr.charAt(cIdx);
	        	if (ch != '\''){
	              argBuf.append(ch);
	              last = ch;
	          }//endif
	    }//for
	    return argBuf.toString();
	}//collapseSpaces
	
}//class selinas


