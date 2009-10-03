/*
 * Created of DV0101 on 11.06.2009 09:43:28
 *
 * Filename	  navigation.java
 */
package lebenslauf;

import java.util.HashMap;

/**
 * Eigenschaften zur aktuellen Seite die aufgerufen wird. 
 *
 * @version 	1.00 11.06.2009 um 09:43:28
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Navigation {
    
    public String indicator;
    public HashMap allEvents = new HashMap();
    
    /** Navigation Eigenschaften zur akutellen Seite */
    public Navigation(String indicator) {
        this.indicator = indicator;
    }//Navigation
    
    public Event getForEvent() throws Exception {
        try {
            if(indicator.equalsIgnoreCase("S")) {//sontiges
                this.indicator = "K";
            	return(Event)allEvents.get("K");
            	}else if(indicator.equalsIgnoreCase("L")){//Lehrgang
            	    this.indicator = "S";
            	    return(Event)allEvents.get("S"); 
            	}else if(indicator.equalsIgnoreCase("P")){//Projekt
            	    this.indicator = "L";
            	    return(Event)allEvents.get("L");
            	}else if(indicator.equalsIgnoreCase("A")){//Ausbildung
            	    this.indicator = "P";
            	    return(Event)allEvents.get("P"); 
            	}else if(indicator.equalsIgnoreCase("B")){//Beruf
            	    this.indicator = "A";
            	    return(Event)allEvents.get("A"); 
            	}else if(indicator.equalsIgnoreCase("K")){//Kontakt
            	    this.indicator = "B";
            	    return(Event)allEvents.get("B"); 
            }//endif
        }catch(Exception e) {
            throw new Exception("kein gültiges Event gefunden");            
        }//catch
        return null;
    }//getBackEvent
    
    public Event getBackEvent() throws Exception {
        try {
            if(indicator.equalsIgnoreCase("S")) {//sontiges
                this.indicator = "L";
            	return(Event)allEvents.get("L");
            	}else if(indicator.equalsIgnoreCase("L")){//Lehrgang
            	    this.indicator = "P";
            	    return(Event)allEvents.get("P"); 
            	}else if(indicator.equalsIgnoreCase("P")){//Projekt
            	    this.indicator = "A";
            	    return(Event)allEvents.get("A");
            	}else if(indicator.equalsIgnoreCase("A")){//Ausbildung
            	    this.indicator = "B";
            	    return(Event)allEvents.get("B"); 
            	}else if(indicator.equalsIgnoreCase("B")){//Beruf
            	    this.indicator = "K";
            	    return(Event)allEvents.get("K"); 
            	}else if(indicator.equalsIgnoreCase("K")){//Personendaten
            	    this.indicator = "S";
            	    return(Event)allEvents.get("S"); 
            }//endif
        }catch(Exception e) {
            throw new Exception("kein gültiges Event gefunden");            
        }//catch
        return null;
    }//getBackEvent
    
    public Event getStartEvent() throws Exception {
        try {
             this.indicator = "B";
             return(Event)allEvents.get("B");
        }catch(Exception e) {
            throw new Exception("kein gültiges Event gefunden");            
        }//catch
    }//getBackEvent
    
}//class navigation
