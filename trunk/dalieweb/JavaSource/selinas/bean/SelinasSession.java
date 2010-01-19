package selinas.bean;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import selinas.SelinasUser;

import database.Database;
import database.dateien.Adresse;
import database.dateien.Dokument;
import database.dateien.Link;
import database.dateien.SelectboxOptionen;
import database.dateien.Selinas;
import database.dateien.Typ;
import database.dateien.User;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetLink;
import database.getDatabase.DataSetSelectOptionen;
import database.getDatabase.DataSetTyp;
import database.getDatabase.DataSetStatus;
import database.getDatabase.DataSetUser;

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
     * @throws 
    * @throws Exception
	*/
	public Adresse getAdressOfDatabase(Database dbConn,User user) throws Exception{
		/* Verwendung: AdressToRequestServlet-Aufruf der Adressverwaltung */
		/*             GoToSelinas020Servlet->Aufruf zur Adressverwaltung */
	    Adresse adresseOfDatabase = null;
		dbConn.getConnection();//DataBaseConnection open
		adresseOfDatabase = DataSetAdresse.chain(dbConn, user.getKundenId(),"U",user.getUserId());
		dbConn.close();//DataBaseConnection close
		return adresseOfDatabase;//Return AdressOfDatabase
	}//getAdressOfDatabase
	
	public Adresse getAdressOfDatabase(Database dbConn,HttpServletRequest request) throws Exception{
		/* Verwendung: AdressToRequestServlet -> get Adress from Database and Load to SessionAttribute */
	    Adresse adresseOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		adresseOfDatabase = DataSetAdresse.chain(dbConn,Integer.parseInt(request.getParameter("adressId")),request.getParameter("adressArt"),request.getParameter("userId"));
		dbConn.close();////DataBaseConnection close
		return adresseOfDatabase;//Return AdresseOfDatabase
	}//getDokumentTypOfDatabase
	
	public Adresse getAdressOfDatabase(Database dbConn,User user,User show){
		/* Verwendung: UserToRequestServlet-Aufruf der Userverarbeitung */
	    Adresse adresseOfDatabase = null;
		try {
			dbConn.getConnection();////DataBaseConnection open
			adresseOfDatabase = DataSetAdresse.chain(dbConn, user.getKundenId(),"U",show.getUserId());
			dbConn.close();////DataBaseConnection close
			return adresseOfDatabase;//Return AdressOfDatabase
		} catch (Exception e) {
			Adresse adresseOfInitialize = new Adresse();
			try {
				adresseOfInitialize.setAdressId(user.getKundenId());
				adresseOfInitialize.setAdressArt("U");
				adresseOfInitialize.setUserId(show.getUserId());
				adresseOfInitialize.setStrasse(session.getStrasse());
				adresseOfInitialize.setFax(session.getFax());
				adresseOfInitialize.setLand(session.getLand());
				adresseOfInitialize.setMail(session.getMail());
				adresseOfInitialize.setNummer(session.getNummer());
				adresseOfInitialize.setOrt(session.getOrt());
				adresseOfInitialize.setPlz(session.getPlz());
				adresseOfInitialize.setTelefon(session.getTelefon());
				dbConn.getConnection();//DataBaseConnection open
				DataSetAdresse.insert(dbConn,user,adresseOfInitialize);
				adresseOfInitialize = DataSetAdresse.chain(dbConn,user.getKundenId(),"U",show.getUserId());
				dbConn.close();//DatabaseConnection close;
			} catch (Exception e1) {
				System.out.println(this.getClass().getName()+".getAdressOfDatabase:" + e1);
			}//catch
				return adresseOfInitialize;//Return adresseOfInitialize
		}//catch
	}//getAdressOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Adresse aus HttpServletRequest</b>
	* <br> Adresse bearbeiten ohne Update of Database"
	* <br><b>chain:Key Adresse ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Adresse ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Adresse adresseOfRequest</li></ul>
    * @throws Exception
	*/
	public Adresse getAdressOfRequest(Adresse ofSession, HttpServletRequest request)throws Exception{
		/* Verwendung: UserToProcessServlet Aufruf der User/Adressverarbeitung */
		   Adresse adresseOfRequest = ofSession;
		   adresseOfRequest.setStrasse(collapseSpaces(request.getParameter(session.getStrasse())));
		   adresseOfRequest.setNummer(collapseSpaces(request.getParameter(session.getNummer())));
		   adresseOfRequest.setPlz(collapseSpaces(request.getParameter(session.getPlz())));
		   adresseOfRequest.setOrt(collapseSpaces(request.getParameter(session.getOrt())));
		   adresseOfRequest.setLand(collapseSpaces(request.getParameter(session.getLand())));
		   adresseOfRequest.setMail(collapseSpaces(request.getParameter(session.getMail())));
		   adresseOfRequest.setTelefon(collapseSpaces(request.getParameter(session.getTelefon())));
		   adresseOfRequest.setFax(collapseSpaces(request.getParameter(session.getFax())));
		   return adresseOfRequest;
	}//getAdressOfRequest  
	
	public Adresse getAdressOfUpdate(Database dbConn,User user,Adresse ofSession, HttpServletRequest request)throws Exception{
		/* Verwendung: AdressToProcessServlet Aufruf der Adressverarbeitung */
		Adresse adressOfUpdate = ofSession;
		adressOfUpdate.setAdressArt(request.getParameter("AdressTyp"));
		adressOfUpdate.setStrasse(collapseSpaces(request.getParameter(session.getStrasse())));
		adressOfUpdate.setNummer(collapseSpaces(request.getParameter(session.getNummer())));
		adressOfUpdate.setPlz(collapseSpaces(request.getParameter(session.getPlz())));
		adressOfUpdate.setOrt(collapseSpaces(request.getParameter(session.getOrt())));
		adressOfUpdate.setLand(collapseSpaces(request.getParameter(session.getLand())));
		adressOfUpdate.setTelefon(collapseSpaces(request.getParameter(session.getTelefon())));
		adressOfUpdate.setFax(collapseSpaces(request.getParameter(session.getFax())));
		adressOfUpdate.setMail(collapseSpaces(request.getParameter(session.getMail())));
		adressOfUpdate.setUserId(request.getParameter("userAdressId"));
		dbConn.getConnection();//DataBaseConnection open
		DataSetAdresse.update(dbConn, user, adressOfUpdate);
		adressOfUpdate = DataSetAdresse.chain(dbConn, user.getKundenId() ,adressOfUpdate.getAdressArt(),adressOfUpdate.getUserId()); 
		dbConn.close();//DataBaseConnection close
		return adressOfUpdate;
	}//getAdressOfUpdate 
	
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
	public Dokument getBackDokumentOfDatabase(Database dbConn,User user,Dokument dokument) throws Exception{
		/* Verwendung GoToSelinas003Servlet -> << backward  */
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.foundBackDokument(dbConn,user,dokument,"TNID");
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getNextDokumentOfDatabase
	
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
	public Dokument getBackDokumentOfDatabase1(Database dbConn,User user,Dokument dokument) throws Exception{
		/* Verwendung GoToSelinas003Servlet -> << backward  */
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
		/* Verwendung GoToSelinas003Servlet -> >> forward  */
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.foundNextDokument(dbConn,user,dokument,"TNI");
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getNextDokumentOfDatabase
	
	public Dokument getNextDokumentOfDatabase1(Database dbConn,User user,Dokument dokument) throws Exception{
		/* Verwendung GoToSelinas003Servlet -> >> altes forward  */
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		int nextDokumentId = DataSetDokument.getNextdokument(dbConn,user,dokument);
		dokument.setId(nextDokumentId);
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,dokument);
		dbConn.close();////DataBaseConnection close
		return dokumentOfDatabase;//Return DokumentOfDatabase
	}//getNextDokumentOfDatabase1
	
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
       dokumentOfInitialize.setTyp(request.getParameter("dokumentTyp"));
       dokumentOfInitialize.setNr(Integer.parseInt(request.getParameter("dokumentNr")));
       int nextDokumentId = DataSetDokument.getNextdokumentId(dbConn,user,dokumentOfInitialize);
       dokumentOfInitialize.setGliederung(dokumentOfInitialize.getNummer() + "." + nextDokumentId);//GliederungsVorschlag setzen
       dokumentOfInitialize.setStatus("P");//Status:privat
       dokumentOfInitialize.setTitel(session.getTitel());
       dokumentOfInitialize.setDescripten(session.getDescripten());
       dokumentOfInitialize.setContent(session.getContent());
       dokumentOfInitialize.setArchiv(session.getArchiv());
       dokumentOfInitialize.setSprachId("DE");
       dokumentOfInitialize.setVorgabe("123");
       DataSetDokument.insert(dbConn,user,dokumentOfInitialize);//Insert in Datenbank
       dokumentOfInitialize = DataSetDokument.chain(dbConn,user,dokumentOfInitialize.getTyp(),dokumentOfInitialize.getNummer(),nextDokumentId);
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
	   dokumentOfUpdate.setDescripten(collapseSpaces(request.getParameter(session.getDescripten())));
	   dokumentOfUpdate.setContent(collapseSpaces(request.getParameter(session.getContent())));
	   dokumentOfUpdate.setGliederung(collapseSpaces(request.getParameter(session.getGliederung())));
	   dokumentOfUpdate.setArchiv(collapseSpaces(request.getParameter(session.getArchiv())));
	   dokumentOfUpdate.setVorgabe(collapseSpaces(request.getParameter(session.getVorgabe())));
	   dokumentOfUpdate.setStatus(collapseSpaces(request.getParameter(session.getStatus())));
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
		   dokumentOfRequest.setDescripten(collapseSpaces(request.getParameter(session.getDescripten())));
		   dokumentOfRequest.setContent(collapseSpaces(request.getParameter(session.getContent())));
		   dokumentOfRequest.setGliederung(collapseSpaces(request.getParameter(session.getGliederung())));
		   dokumentOfRequest.setArchiv(collapseSpaces(request.getParameter(session.getArchiv())));
		   dokumentOfRequest.setVorgabe(collapseSpaces(request.getParameter(session.getVorgabe())));
		   dokumentOfRequest.setStatus(collapseSpaces(request.getParameter(session.getStatus())));
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
       dokumentOfCopy.setDescripten(session.getDescripten());
       dokumentOfCopy.setContent(session.getContent());
       dokumentOfCopy.setStatus("P");
       DataSetDokument.insert(dbConn,user,dokumentOfCopy);//Insert in Datenbank
       dokumentOfCopy = DataSetDokument.chain(dbConn,user,dokumentOfCopy.getTyp(),dokumentOfCopy.getNummer(),nextDokumentId);
       dbConn.close();
       return dokumentOfCopy;
    }//getDokumentOfCopy
	
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Link aus Datenbanktabelle link</b>
	* <br> link update"
	* <br><b>chain:Key User user,Dokument ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>Dokument ofSession</li>
	* <li>Link updateLink</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>Dokument dokumentOfUpdate</li></ul>
    * @throws Exception
	*/
	public void getDokumentLinkOfUpdate(Database dbConn,User user,Dokument ofSession,HttpServletRequest request)throws Exception{
		dbConn.getConnection();//DataBaseConnection open
		Link linkOfUpdate = DataSetLink.chain(dbConn,ofSession,Integer.parseInt(request.getParameter("ApplicationsId")));
		linkOfUpdate.setNotizOfLink(collapseSpaces(request.getParameter("memo")));
		DataSetLink.update(dbConn, user,ofSession,linkOfUpdate);
		dbConn.close();//DataBaseConnection close
	}//getDokumentLinkOfUpdate
	
	
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
		/* Verwendung: AdminOfSelina -> Aufruf Administration Selinas */
		/*             TypToProcessServlet -> Verarbeitung Dokumenttyp */			
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
	* <b>Erzeuge ein Objekt vom Typ Typ aus Datenbanktabelle Typ</b>
	* <br> Dokumenttyp anlegen"
	* <br><b>chain:Key id </b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>String language</li>
	* </ul>
	* @return
	* <ul><li>Typ typ</li></ul>
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
       String dokumentTyp = "DokumentTyp" + user.getKundenId() + user.getStandortId();
       DataSetSelectOptionen.insert(dbConn,user,dokumentTyp,"KA",option);
       dbConn.close();
       return  typOfInitialize;
    }//getTypOfInitialize
	
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
	   typOfUpdate.setDescription(collapseSpaces(request.getParameter(session.getDescripten())));
	   dbConn.getConnection();//DataBaseConnection open
	   DataSetTyp.update(dbConn, user, typOfUpdate);
	   typOfUpdate = DataSetTyp.chain(dbConn, user, typOfUpdate);
	   SelectboxOptionen option = new SelectboxOptionen();
       option.setOptionId("KA");
       option.setOptionValue(typOfUpdate.getTyp());
       option.setOptionDescription(typOfUpdate.getDescription());
       String dokumentTyp = "DokumentTyp" + user.getKundenId() + user.getStandortId();
       DataSetSelectOptionen.update(dbConn,user,dokumentTyp,"KA",option);
	   dbConn.close();//DataBaseConnection close
	   return typOfUpdate;
	}//getTypOfUpdate
	
	/**
	* <b>delete content on Databasetable: Dokumenttyp and selectboxoptionen</b>
	* <br> Dokumenttyp delete and Selectbox delete"
	* <br><b>chain:Key User user,Dokument ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>Typ ofSession</li>
	* </ul>
	* @return
	* <ul><li>nothing</li></ul>
    * @throws Exception
	*/
	public void getTypOfDelete(Database dbConn,User user,Typ ofSession)throws Exception {
		/* Verwendung: TypToProcessServlet - Verarbeitung/Verwaltung von Dokumenttypen */
	   Typ typOfDelete = ofSession;
	   dbConn.getConnection();//DataBaseConnection open
	   DataSetTyp.delete(dbConn,user.getKundenId(),user.getStandortId(),typOfDelete.getTyp());
	   String dokumentTyp = "DokumentTyp" + user.getKundenId() + user.getStandortId();
	   DataSetSelectOptionen.delete(dbConn,dokumentTyp,"KA","KA",typOfDelete.getTyp());
	   dbConn.close();//DataBaseConnection close
	}//getTypOfDelete
	
	/**
	* <b>Erzeuge ein Objekt vom Typ User aus Datenbanktabelle user</b>
	* <br><b>chain:Key request userId</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>User user</li></ul>
    * @throws Exception
	*/
	public User getUserOfDatabase(Database dbConn,HttpServletRequest request) throws Exception{
		/* Verwendung:  UserToRequestServlet -> Aufruf Userverwaltung*/
	    User userTypOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		userTypOfDatabase = DataSetUser.chain(dbConn,request.getParameter("user"));
		dbConn.close();////DataBaseConnection close
		return userTypOfDatabase;//Return DokumentTypOfDatabase
	}//getUserOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ User aus Datenbanktabelle user</b>
	* <br><b>chain:Key User userId</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* </ul>
	* @return
	* <ul><li>User user</li></ul>
    * @throws Exception
	*/
	public User getUserOfDatabase(Database dbConn,User user) throws Exception{
		/* Verwendung: GoToSelinas030Serlvet -> Anzeige Userverwaltung */
		User userOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		userOfDatabase = DataSetUser.chain(dbConn,user.getUserId());
		dbConn.close();////DataBaseConnection close
		return userOfDatabase;//Return UserTypOfDatabase
	}//getUserOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ User aus Datenbanktabelle user</b>
	* <br><b>chain:Key User userId</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* </ul>
	* @return
	* <ul><li>User user</li></ul>
    * @throws Exception
	*/
	public User getUserOfDatabase(Database dbConn,String userId) throws Exception{
		/* Verwendung: GoToSelinas020Serlvet -> Anzeige Adressverwaltung */
		User userOfDatabase = null;
		dbConn.getConnection();//DataBaseConnection open
		System.out.println(this.getClass().getName()+"Hier " + userId);
		userOfDatabase = DataSetUser.chain(dbConn,userId);
		dbConn.close();//DataBaseConnection close
		return userOfDatabase;//Return UserOfDatabase
	}//getUserOfDatabase
	
	/**
	* <b>Erzeuge ein Objekt vom Typ User aus HttpServletRequest</b>
	* <br> User bearbeiten ohne Update of Database"
	* <br><b>chain:Key User ofSession, HttpServletRequest request</b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>User ofSession</li>
	* <li>HttpServletRequest request</li>
	* </ul>
	* @return
	* <ul><li>User userOfRequest</li></ul>
    * @throws Exception
	*/
	public User getUserOfRequest(User ofSession, HttpServletRequest request)throws Exception{
		   User userOfRequest = ofSession;
		   userOfRequest.setPermitId(Integer.parseInt(request.getParameter("PermitId").toString()));
		   userOfRequest.setUserAutorisierungsId(Integer.parseInt(request.getParameter("AutorisierungId").toString()));
		   userOfRequest.setName(collapseSpaces(collapseSpaces(request.getParameter(session.getName()))));
		   userOfRequest.setVorname(collapseSpaces(collapseSpaces(request.getParameter(session.getVorname()))));
		   userOfRequest.setUserStatus(request.getParameter("Status"));
		   userOfRequest.setPassword(collapseSpaces(request.getParameter(session.getPassword())));
		   return userOfRequest;
	}//getUserOfRequest  
	
	/**
	* <b>Erzeuge ein Objekt vom Typ Typ aus Datenbanktabelle Typ</b>
	* <br> Dokumenttyp anlegen"
	* <br><b>chain:Key id </b>
	* <br><b>public</b><br>
	* @param
	* <ul>
	* <li>Database dbConn</li>
	* <li>User user</li>
	* <li>String language</li>
	* </ul>
	* @return
	* <ul><li>Typ typ</li></ul>
    * @throws Exception
	*/
	public User getUserOfInitialize(Database dbConn,User user,String language)throws Exception{
       User userOfInitialize = new User();
       dbConn.getConnection();//Aufbau Dankverbindung
       SelinasUser selinasuser = new SelinasUser(DataSetUser.determineLastUserId(dbConn,user));
       userOfInitialize.setName("Name");
       userOfInitialize.setVorname("Vorname");
       userOfInitialize.setPassword("selina");
       userOfInitialize.setKundenId(selinasuser.getKundenId());
       userOfInitialize.setPermitId(user.getPermitId());
       userOfInitialize.setSelinasId(1);
       userOfInitialize.setSelinasStandortId(1);
       userOfInitialize.setSprachId("");
       userOfInitialize.setStandortId(user.getStandortId());
       userOfInitialize.setUserAutorisierungsId(user.getUserAutorisierungsId());
       userOfInitialize.setUserId(selinasuser.getNewUserId());
       userOfInitialize.setUserStatus(DataSetStatus.chain(dbConn,"A",language).getStatusId());
       userOfInitialize.setCreateUserId(user.getUserId());
       DataSetUser.insert(dbConn,userOfInitialize);
       userOfInitialize = DataSetUser.chain(dbConn,selinasuser.getNewUserId());
       dbConn.close();
       return  userOfInitialize;
    }//getTypOfInitialize
	
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
	public User getUserOfUpdate(Database dbConn,User user,User ofSession,HttpServletRequest request)throws Exception{
	   User userOfUpdate = ofSession;
	   userOfUpdate.setPermitId(Integer.parseInt(request.getParameter("PermitId").toString()));
	   userOfUpdate.setUserAutorisierungsId(Integer.parseInt(request.getParameter("AutorisierungId").toString()));
	   userOfUpdate.setName(collapseSpaces(request.getParameter(session.getName())));
	   userOfUpdate.setVorname(collapseSpaces(request.getParameter(session.getVorname())));
	   userOfUpdate.setUserStatus(collapseSpaces(request.getParameter("Status")));
	   userOfUpdate.setPassword(collapseSpaces(request.getParameter(session.getPassword())));
	   dbConn.getConnection();//DataBaseConnection open
	   DataSetUser.update(dbConn, user, userOfUpdate);
	   userOfUpdate = DataSetUser.chain(dbConn,userOfUpdate.getUserId());
	   dbConn.close();//DataBaseConnection close
	   return userOfUpdate;
	}//getUserOfUpdate
	
	public User getUserOfDelete(Database dbConn,User user,User ofSession,String language)throws Exception{
		   User userOfUpdate = ofSession;
		   dbConn.getConnection();//DataBaseConnection open
		   userOfUpdate.setUserStatus(DataSetStatus.chain(dbConn,"I",language).getStatusId());
		   DataSetUser.update(dbConn, user, userOfUpdate);
		   userOfUpdate = DataSetUser.chain(dbConn,userOfUpdate.getUserId());
		   dbConn.close();//DataBaseConnection close
		   return userOfUpdate;
		}//getUserOfUpdate
	
	/**
	 * Remove/collapse character
	 *
	 * @param argStr string to remove multiple spaces from.
	 * @return String
	 */
	String collapseSpaces(String argStr) {
		if (argStr != null || argStr != "" ) {//with Input
			char last = argStr.charAt(0);
			StringBuffer argBuf = new StringBuffer();
			for (int cIdx = 0; cIdx < argStr.length(); cIdx++) {
				char ch = argStr.charAt(cIdx);
				if (ch == '\'' || ch == '\"') {
					}else{
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


