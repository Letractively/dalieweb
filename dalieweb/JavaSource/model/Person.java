package model;
/**
 * @author u.dalies am 25.09.2007 um 19:16:19
 * <br>
 * <b>Person</b> abstract <br><br>
 * private String vorname<br>
 * private String name<br>
 * private Date geburtstag<br>
 * 
 */
abstract public class Person{
    
    private String vorname = "";//z.B Hans
    private String name = "";// Mustermann
    private String geburtstag;//31.12.0001
    
    /**
     * @return Returns the geburtstag "31.12.0001".
     */
    public String getGeburtstag() {
        return geburtstag;
    }
    /**
     * @param geburtstag The geburtstag "31.12.0001" to set.
     */
    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }
    /**
     * @return Returns the name "Musterman".
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name "Mustermann" to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the vorname "z.B Hans".
     */
    public String getVorname() {
        return vorname;
    }
    /**
     * @param vorname The vorname "z.B Hans" to set.
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}//class Person
