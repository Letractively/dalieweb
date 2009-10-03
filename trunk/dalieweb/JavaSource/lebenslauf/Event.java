/*
 * Created of DV0101 on 12.06.2009 11:02:16
 *
 * Filename	  Event.java
 */
package lebenslauf;

/**
 * Class description goes here.
 *
 * @version 	1.00 12.06.2009 um 11:02:16
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Event {
    /* Ein Event gibt die Beschreibung eines Linkes vorwärts und rückwärts wieder */
    
    /** descripten of backward */
    private String backPage;//Kontakt
    /** descripten of forward */
    private String nextPage;//Beruf
    /** URL welche im Frame angezeigt werden soll */
    private String showPage;
    
    public Event(String backPage, String nextPage, String showPage){
        this.backPage = backPage;
        this.nextPage = nextPage;
        this.showPage = showPage;
    }//Event
    
    /** @return Returns the descripten of Link.<br><b>backPage</b> */
    public String getBackPage() {
        return backPage;//Kontakt
    }
    /** @return Returns the nextPage.<br><b>nextPage</b> */
    public String getNextPage() {
        return nextPage;//Beruf
    }
    /** @return Returns the showPage.<br><b>link of Page</b> */
    public String getShowPage() {
        return showPage;//lebenslauf/beruf.jsp
    }
}//class Event
