/*
 * Created of DV0101 on 04.05.2009 08:37:11
 *
 * Filename	  SelinasUser.java
 */
package selinas;

import database.dateien.Status;
import database.dateien.User;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 08:37:11
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class SelinasUser {
    
    public User user;
    
    public SelinasUser(User user) {
        this.user = user;
    }//SelinasUser
    
    /**
     * <b>check Password to be valid</b>
     * <br><b>public</b><br>
     * @param
     * <ul>	<li>Sting password</li></ul>
     * @return
     * <ul><li>boolean</li></ul>
     */
    public boolean checkPassword(String password) {
        return this.user.getPassword().equals(password);
    }//checkPasswort
    /**
     * <b>check Status to be valid</b>
     * <br><b>public</b><br>
     * @param
     * <ul>	<li>Status userstatus</li></ul>
     * @return
     * <ul><li>boolean</li></ul>
     */
    public boolean checkStatus(Status userstatus) {
        return this.user.getUserStatus().equals(userstatus.getStatusId());
    }//checkPasswort
    /**
     * <b>to determine a new USERId for Selinas</b>
     * <br>
     * <p>example DV0101 -> DV0102 </p>
     * @param String userId
     * */
    public String getNewUserId(){
    	return this.user.getUserId().substring(0,4) + getUserCounter(this.user.getUserId());
    }//getNewUserId
    
    /**
     * <b>convert the UserId to KundenId</b>
     * 
     * @param String userId
     * */
    public int getKundenId(){
    	return Integer.parseInt(this.user.getUserId().substring(2,4));
    }//getNewUserId
    
    /** to determine the next count */
    private String getUserCounter(String count){
		int counter = (Integer.parseInt(count.substring(4,count.length())) + 1);
			if (counter < 10){
				return "0" + (new Integer(counter)).toString();
			}else {
				return (new Integer(counter)).toString();
			}//endif
	}//getUserCounter
    
}//SelinasUser
