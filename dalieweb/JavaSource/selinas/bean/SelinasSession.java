package selinas.bean;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import database.Database;
import database.dateien.Adresse;
import database.dateien.Dokument;
import database.dateien.SelectboxOptionen;
import database.dateien.Selinas;
import database.dateien.Typ;
import database.dateien.User;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetSelectOptionen;
import database.getDatabase.DataSetTyp;

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
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br><b>chain:Key user.getKundenId, user.getStandortId, request int dokumentNr, request dokumentId</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
	public Dokument getDokumentOfDatabase(Database dbConn,User user,HttpServletRequest request) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,request.getParameter("dokumentTyp"),Integer.parseInt((String)request.getParameter("dokumentNr")),Integer.parseInt((String)request.getParameter("dokumentId")));
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br><b>chain:Key User user, Dokument dokumemt</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>Dokument dokument</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
	public Dokument getDokumentOfDatabase(Database dbConn,User user,Dokument dokument) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,dokument);
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Button Dokument "zurück"
	* <br><b>chain:Key User user, Dokument dokumemt</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>Dokument dokument</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
	public Dokument getBackDokumentOfDatabase(Database dbConn,User user,Dokument dokument) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		int nextDokumentId = DataSetDokument.getBackdokument(dbConn,user,dokument);
		dokument.setId(nextDokumentId);
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,dokument);
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Button Dokument "vorwärts"
	* <br><b>chain:Key User user, Dokument dokumemt</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>Dokument dokument</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
	public Dokument getNextDokumentOfDatabase(Database dbConn,User user,Dokument dokument) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		int nextDokumentId = DataSetDokument.getNextdokument(dbConn,user,dokument);
		dokument.setId(nextDokumentId);
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,dokument);
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getDokument
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Dokument anlegen"
	* <br><b>chain:Key User user, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
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
    }//getDokumentOfInitialize
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Dokument update"
	* <br><b>chain:Key User user,Dokument ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>Dokument ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfUpdate</li></ul>
    * @throws Exception
	*/
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
	}//getDokumentOfUpdate
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus HttpServletRequest</b>
	* <br> Dokument bearbeiten ohne Update of Database"
	* <br><b>chain:Key Dokument ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Dokument ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfRequest</li></ul>
    * @throws Exception
	*/
	public Dokument getDokumentOfRequest(Dokument ofSession, HttpServletRequest request)throws Exception{
		   Dokument dokumentOfRequest = ofSession;
		   dokumentOfRequest.setTitel(collapseSpaces(request.getParameter(session.getTitel())));
		   dokumentOfRequest.setDescripten(request.getParameter(session.getDescripten()));
		   dokumentOfRequest.setContent(collapseSpaces(request.getParameter(session.getContent())));
		   dokumentOfRequest.setGliederung(request.getParameter(session.getGliederung()));
		   dokumentOfRequest.setArchiv(request.getParameter(session.getArchiv()));
		   dokumentOfRequest.setVorgabe(request.getParameter(session.getVorgabe()));
		   dokumentOfRequest.setStatus(request.getParameter(session.getStatus()));
		   return dokumentOfRequest;
	}//getDokumentOfRequest  
	
	/**
	* <b>dupliziere ein Objekt vom Typ Dokument aus einem Objekt Dokument</b>
	* <b> Dokument kopieren
	* <br><b>chain:Key User user, Dokument ofSession</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>Dokument ofSession</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfCopy</li></ul>
    * @throws Exception
	*/
	public Dokument getDokumentOfCopy(Database dbConn,User user,Dokument ofSession)throws Exception{
       Dokument dokumentOfCopy = new Dokument();
       dokumentOfCopy = ofSession;
       dbConn.getConnection();//Aufbau Dankverbindung
       int nextDokumentId = DataSetDokument.getNextdokumentId(dbConn,user,dokumentOfCopy);
       dokumentOfCopy.setGliederung(dokumentOfCopy.getNummer() + "." + nextDokumentId);//GliederungsVorschlag setzen
       dokumentOfCopy.setStatus("A");
       DataSetDokument.insert(dbConn,user,dokumentOfCopy);//Insert in Datenbank
       dokumentOfCopy = DataSetDokument.chain(dbConn,user,dokumentOfCopy.getDokumentTyp(),dokumentOfCopy.getNummer(),nextDokumentId);
       dbConn.close();
       return dokumentOfCopy;
    }//getDokumentOfCopy
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokumenttyp aus Datenbanktabelle Dokumenttyp</b>
	* <br><b>chain:Key request kundenId, request standortId, request dokumenttyp</b>
	* <br><b>protected</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Typ dokumenttyp</li></ul>
    * @throws Exception
	*/
	public Typ getDokumentTypOfDatabase(Database dbConn,HttpServletRequest request) throws Exception{
	    Typ dokumentTypOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentTypOfDatabase = DataSetTyp.chain(dbConn,Integer.parseInt(request.getParameter("kundenId")),Integer.parseInt(request.getParameter("standortId")),request.getParameter("dokumentTyp"));
		dbConn.close();////DataBaseConnection close
		return dokumentTypOfDatabase;//Return DokumentTypOfDatabase
	}//getDokumentTypOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokumenttyp aus Datenbanktabelle Dokumenttyp</b>
	* <br><b>chain:Key User kundenId, User standortId, request dokumenttyp</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Typ dokumenttyp</li></ul>
    * @throws Exception
	*/
	public Typ getDokumentTypOfDatabase(Database dbConn,User user,HttpServletRequest request) throws Exception{
	    Typ dokumentTypOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentTypOfDatabase = DataSetTyp.chain(dbConn,user.getKundenId(),user.getStandortId(),request.getParameter("typ"));
		dbConn.close();////DataBaseConnection close
		return dokumentTypOfDatabase;//Return DokumentTypOfDatabase
	}//getDokumentTypOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokumenttyp aus Datenbanktabelle Dokumenttyp</b>
	* <br> Hier wird nach dem ersten gültigen Satz gesucht ->
	* <br> sollte hier keiner gefunden werden, wird ein leeres Objekt erzeugt.
	* <br> Verwendung:GoTo025Servlet 
	* <br><b>chain: User kundenId, standortId, sprachKey</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>String language</li>
	* </ul>
	* @return
	* <ul><li>Typ dokumenttyp</li></ul>
    * @throws Exception
	*/
	public Typ getTypOfDatabase(Database dbConn,User user) throws Exception{
	    Vector allDokumentTypOfDatabase;
	    Typ dokumentTypOfDatabase = new Typ();
		dbConn.getConnection();////DataBaseConnection open
		allDokumentTypOfDatabase = DataSetTyp.reade(dbConn,user);
		dbConn.close();////DataBaseConnection close
		if(allDokumentTypOfDatabase.size() > 0)//Typ in Datenbank gefunden
			dokumentTypOfDatabase = (Typ)allDokumentTypOfDatabase.elementAt(0);
		return dokumentTypOfDatabase;//Return DokumentTypOfDatabase
	}//getDokument
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Typ aus HttpServletRequest</b>
	* <br> Tyü bearbeiten ohne Update of Database"
	* <br><b>chain:Key Typ ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Typ ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Typ typOfRequest</li></ul>
    * @throws Exception
	*/
	public Typ getTypOfRequest(Typ ofSession, HttpServletRequest request)throws Exception{
		   Typ typOfRequest = ofSession;
		   //typOfRequest.setTyp(collapseSpaces(request.getParameter(session.getDokumentTyp())));
		   typOfRequest.setDescription(collapseSpaces(request.getParameter(session.getDescripten())));
		   return typOfRequest;
	}//getTypOfRequest  
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Dokument anlegen"
	* <br><b>chain:Key User user, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfDatabase</li></ul>
    * @throws Exception
	*/
	public Typ getTypOfInitialize(Database dbConn,User user,String language)throws Exception{
       Typ typOfInitialize = new Typ();
       dbConn.getConnection();//Aufbau Dankverbindung
       typOfInitialize.setTyp(DataSetTyp.createRandomString());
       typOfInitialize.setDescription(typOfInitialize.getTyp());
       DataSetTyp.insert(dbConn,user,typOfInitialize);//Insert in Datenbank
       typOfInitialize = DataSetTyp.chain(dbConn,user,typOfInitialize);
       SelectboxOptionen option = new SelectboxOptionen();
       option.setOptionId("KA");
       option.setOptionValue(typOfInitialize.getTyp());
       option.setOptionDescription(typOfInitialize.getDescription());
       DataSetSelectOptionen.insert(dbConn,user,"DokumentTyp",language,option);
       dbConn.close();
       return  typOfInitialize;
    }//getDokumentOfInitialize
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Dokument aus Datenbanktabelle Dokument</b>
	* <br> Dokument update"
	* <br><b>chain:Key User user,Dokument ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>Dokument ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfUpdate</li></ul>
    * @throws Exception
	*/
	public Typ getTypOfUpdate(Database dbConn,User user,Typ ofSession,HttpServletRequest request,String language)throws Exception{
	   Typ typOfUpdate = ofSession;
	   //typOfUpdate.setTyp(collapseSpaces(request.getParameter(session.getDokumentTyp())));
	   typOfUpdate.setDescription(request.getParameter(session.getDescripten()));
	   dbConn.getConnection();//DataBaseConnection open
	   DataSetTyp.update(dbConn, user, typOfUpdate);
	   typOfUpdate = DataSetTyp.chain(dbConn, user, typOfUpdate);
	   SelectboxOptionen option = new SelectboxOptionen();
       option.setOptionId("KA");
       option.setOptionValue(typOfUpdate.getTyp());
       option.setOptionDescription(typOfUpdate.getDescription());
       DataSetSelectOptionen.update(dbConn,user,"DokumentTyp",language,option);
	   dbConn.close();//DataBaseConnection close
	   return typOfUpdate;
	}//getDokumentOfUpdate
	
	/**
	 * Remove/collapse character
	 *
	 * @param argStr string to remove multiple spaces from.
	 * @return String
	 */
	String collapseSpaces(String argStr) {
		if (argStr != null) {//with Input
			char last = argStr.charAt(0);
			StringBuffer argBuf = new StringBuffer();
			for (int cIdx = 0; cIdx < argStr.length(); cIdx++) {
				char ch = argStr.charAt(cIdx);
				if (ch != '\'') {
					argBuf.append(ch);
					last = ch;
				}//endif
			}//for
			return argBuf.toString();
		} else {//without Input
			return "";
		}//endif
	}//collapseSpaces
}//class selinas


