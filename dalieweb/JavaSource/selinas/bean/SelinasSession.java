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
	
   
    public SelinasSession(Selinas session){
    	this.session = session;
    }//Selinas
    
	
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
	public Dokument getDokumentOfDatabase(Database dbConn,User user,HttpServletRequest request) throws Exception{
	    Dokument dokumentOfDatabase = null;
		dbConn.getConnection();////DataBaseConnection open
		dokumentOfDatabase = DataSetDokument.chain(dbConn, user,request.getParameter("dokumentTyp"),Integer.parseInt((String)request.getParameter("dokumentNr")),Integer.parseInt((String)request.getParameter("dokumentId")));
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


