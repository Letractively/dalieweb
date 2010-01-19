package selinas.servlet;

import help.LoggerHelper;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.SelinasUser;
import selinas.bean.SelinasSession;
import database.Database;
import database.dateien.Adresse;
import database.dateien.Selectbox;
import database.dateien.SelectboxOptionen;
import database.dateien.Selinas;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetSelectOptionen;
import database.getDatabase.DataSetSelectbox;

public class LogOnSelinaInializeServlet extends HttpServlet implements Servlet {
	
	Database dbConn;

	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Database dbConn = (Database) session.getAttribute("Database");
	    String dokumentTyp = "DokumentTyp" + selinasuser.user.getKundenId() + selinasuser.user.getStandortId();
		
		try{
	 		/* Hier wird die Adresse zum User geprüft,
	 		 * wird keine gefunden, wird diese dann inizialisiert und angelegt.  */
			dbConn.getConnection();//DataBaseConnection open
			Adresse adresse = show.getAdressOfDatabase(dbConn,selinasuser.user);//SessionAttribut:AdressOfDatabase
		}catch (Exception e) {
	 		LoggerHelper.log(this.getClass().getName(),"Exception no User of Database:", e);
	 		Adresse adresseOfInitialize = new Adresse();
			adresseOfInitialize.setAdressId(selinasuser.user.getKundenId());
			adresseOfInitialize.setAdressArt("U");
			adresseOfInitialize.setUserId(selinasuser.user.getUserId());
			adresseOfInitialize.setStrasse(show.session.getStrasse());
			adresseOfInitialize.setFax(show.session.getFax());
			adresseOfInitialize.setLand(show.session.getLand());
			adresseOfInitialize.setMail(show.session.getMail());
			adresseOfInitialize.setNummer(show.session.getNummer());
			adresseOfInitialize.setOrt(show.session.getOrt());
			adresseOfInitialize.setPlz(show.session.getPlz());
			adresseOfInitialize.setTelefon(show.session.getTelefon());
			try {
				DataSetAdresse.insert(dbConn,selinasuser.user,adresseOfInitialize);
			} catch (Exception e1) {
				LoggerHelper.log(this.getClass().getName(),"exception of initialize-adress:", e1);
			}//catch
		}//catch
			
		try{
			/* Hier wird die Selectobx für DokumentTypen zum User geprüft,
			 * wird keine gefunden, wird diese dann inizialisiert und angelegt.  */
			dbConn.getConnection();//DataBaseConnection open
			Selectbox selectbox = DataSetSelectbox.chain(dbConn,selinasuser.user.getKundenId(),selinasuser.user.getStandortId(),
						dokumentTyp,"KA");//SessionAttribut:AdressOfDatabase
		}catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"exception no Selectbox on Database:", e);
			try {
				DataSetSelectbox.insert(dbConn,selinasuser.user,dokumentTyp,"KA");	
				SelectboxOptionen option = new SelectboxOptionen();
		        option.setOptionId("KA");
		        option.setOptionValue("KA");
		        option.setOptionDescription(show.session.getOptionDescripten());
		        DataSetSelectOptionen.insert(dbConn,selinasuser.user,dokumentTyp,"KA",option);
			} catch (Exception e1) {
				LoggerHelper.log(this.getClass().getName(),"exception of initialize-selectbox:", e1);
			}//catch
	 	}//catch
		
    }//perform
	
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    perForm(request,response);
	}//doPost
	
	public LogOnSelinaInializeServlet() {
		super();
	}//LogOnSelinaInializeServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check User is ready to work on selina ";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(),"Exception of destroy: ", e);
	    }//catch
	}//destroy
	
}//class LogOnSelinaInializeServlet