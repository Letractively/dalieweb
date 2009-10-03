/*
 * Created of DV0101 on 01.05.2009 18:58:52
 *
 * Filename	  Selinas.java
 */
package database.dateien;

import java.util.Vector;


/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 18:58:52
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Selinas {
    
    private String hinweis1;
    private String hinweis2;
    private String hinweis3;
    private String hinweis4;

    private String userId;
    private String password;
    private String passwordchek;

    private String adressArt;
    private String strasse;
    private String nummer;
    private String plz;
    private String ort;
    private String telefon;
    private String fax;
    private String mail;

    private String dokumentNr;
    private String dokumentTyp;
    private String titel;
    private String descripten;
    private String content;
    private String gliederung;
    private String archiv;
    private String vorgabe;
    private String status;

    private String caption1;//List of Dokuments
    private String caption2;
    private String caption3;
    private String caption4;
    private String caption5;
    
    private String button1;
    private String button2;
    private String button3;
    private String button4;
    private String button5;
    private String button6;
    private String button7;
    private String button8;
    private String button9;
    private String button10;
    
    private String link1;
    private String link2;
    private String link3;
    private String link4;
    private String link5;
    private String link6;
    private String link7;
    private String link8;
    private String link9;
    private String link10;
    
    private String createUse;
    private String createDate;
    private String changeUser;
    private String changeDate;

    
    public Selinas(){
    }//Selinas
    public Selinas(Vector columns){
        this.hinweis1 = columns.elementAt(3).toString();
        this.hinweis2 = columns.elementAt(4).toString();
        this.hinweis3 = columns.elementAt(5).toString();
        this.hinweis4 = columns.elementAt(6).toString();
        
        this.userId = columns.elementAt(7).toString();
        this.password = columns.elementAt(8).toString();
        this.passwordchek = columns.elementAt(9).toString();
        
        this.adressArt = columns.elementAt(10).toString();
        this.strasse = columns.elementAt(11).toString(); 
        this.nummer = columns.elementAt(12).toString();
        this.plz = columns.elementAt(13).toString();
        this.ort = columns.elementAt(14).toString();
        this.telefon = columns.elementAt(15).toString();
        this.fax = columns.elementAt(16).toString();
        this.mail = columns.elementAt(17).toString();
        
        this.dokumentNr = columns.elementAt(18).toString();
        this.dokumentTyp = columns.elementAt(19).toString();
        this.titel = columns.elementAt(20).toString();
        this.descripten = columns.elementAt(21).toString();
        this.content = columns.elementAt(22).toString();
        this.gliederung = columns.elementAt(23).toString();
        this.archiv = columns.elementAt(24).toString();
        this.vorgabe = columns.elementAt(25).toString();
        this.status = columns.elementAt(26).toString();
        
        this.caption1 = columns.elementAt(27).toString();
        this.caption2 = columns.elementAt(28).toString();
        this.caption3 = columns.elementAt(29).toString();
        this.caption4 = columns.elementAt(30).toString();
        this.caption5 = columns.elementAt(31).toString();
        
        this.button1 = columns.elementAt(32).toString();
        this.button2 = columns.elementAt(33).toString();
        this.button3 = columns.elementAt(34).toString();
        this.button4 = columns.elementAt(35).toString();
        this.button5 = columns.elementAt(36).toString();
        this.button6 = columns.elementAt(37).toString();
        this.button7 = columns.elementAt(38).toString();
        this.button8 = columns.elementAt(39).toString();
        this.button9 = columns.elementAt(40).toString();
        this.button10 = columns.elementAt(41).toString();
        
        this.link1 = columns.elementAt(42).toString();
        this.link2 = columns.elementAt(43).toString();
        this.link3 = columns.elementAt(44).toString();
        this.link4 = columns.elementAt(45).toString();
        this.link5 = columns.elementAt(46).toString();
        this.link6 = columns.elementAt(47).toString();
        this.link7 = columns.elementAt(48).toString();
        this.link8 = columns.elementAt(49).toString();
        this.link9 = columns.elementAt(50).toString();
        this.link10 = columns.elementAt(51).toString();
        
        this.createUse = columns.elementAt(52).toString();
        this.createDate = columns.elementAt(53).toString();
        this.changeUser = columns.elementAt(54).toString();
        this.changeDate = columns.elementAt(55).toString();     
    }//Selinas
    
    /**
     * @return Returns the adressArt.
     */
    public String getAdressArt() {
        return adressArt;
    }
    /**
     * @param adressArt The adressArt to set.
     */
    public void setAdressArt(String adressArt) {
        this.adressArt = adressArt;
    }
    /**
     * @return Returns the archiv.
     */
    public String getArchiv() {
        return archiv;
    }
    /**
     * @param archiv The archiv to set.
     */
    public void setArchiv(String archiv) {
        this.archiv = archiv;
    }
    /**
     * @return Returns the button1.
     */
    public String getButton1() {
        return button1;
    }
    /**
     * @param button1 The button1 to set.
     */
    public void setButton1(String button1) {
        this.button1 = button1;
    }
    /**
     * @return Returns the button10.
     */
    public String getButton10() {
        return button10;
    }
    /**
     * @param button10 The button10 to set.
     */
    public void setButton10(String button10) {
        this.button10 = button10;
    }
    /**
     * @return Returns the button2.
     */
    public String getButton2() {
        return button2;
    }
    /**
     * @param button2 The button2 to set.
     */
    public void setButton2(String button2) {
        this.button2 = button2;
    }
    /**
     * @return Returns the button3.
     */
    public String getButton3() {
        return button3;
    }
    /**
     * @param button3 The button3 to set.
     */
    public void setButton3(String button3) {
        this.button3 = button3;
    }
    /**
     * @return Returns the button4.
     */
    public String getButton4() {
        return button4;
    }
    /**
     * @param button4 The button4 to set.
     */
    public void setButton4(String button4) {
        this.button4 = button4;
    }
    /**
     * @return Returns the button5.
     */
    public String getButton5() {
        return button5;
    }
    /**
     * @param button5 The button5 to set.
     */
    public void setButton5(String button5) {
        this.button5 = button5;
    }
    /**
     * @return Returns the button6.
     */
    public String getButton6() {
        return button6;
    }
    /**
     * @param button6 The button6 to set.
     */
    public void setButton6(String button6) {
        this.button6 = button6;
    }
    /**
     * @return Returns the button7.
     */
    public String getButton7() {
        return button7;
    }
    /**
     * @param button7 The button7 to set.
     */
    public void setButton7(String button7) {
        this.button7 = button7;
    }
    /**
     * @return Returns the button8.
     */
    public String getButton8() {
        return button8;
    }
    /**
     * @param button8 The button8 to set.
     */
    public void setButton8(String button8) {
        this.button8 = button8;
    }
    /**
     * @return Returns the button9.
     */
    public String getButton9() {
        return button9;
    }
    /**
     * @param button9 The button9 to set.
     */
    public void setButton9(String button9) {
        this.button9 = button9;
    }
    /**
     * @return Returns the caption1.
     */
    public String getCaption1() {
        return caption1;
    }
    /**
     * @param caption1 The caption1 to set.
     */
    public void setCaption1(String caption1) {
        this.caption1 = caption1;
    }
    /**
     * @return Returns the caption2.
     */
    public String getCaption2() {
        return caption2;
    }
    /**
     * @param caption2 The caption2 to set.
     */
    public void setCaption2(String caption2) {
        this.caption2 = caption2;
    }
    /**
     * @return Returns the caption3.
     */
    public String getCaption3() {
        return caption3;
    }
    /**
     * @param caption3 The caption3 to set.
     */
    public void setCaption3(String caption3) {
        this.caption3 = caption3;
    }
    /**
     * @return Returns the caption4.
     */
    public String getCaption4() {
        return caption4;
    }
    /**
     * @param caption4 The caption4 to set.
     */
    public void setCaption4(String caption4) {
        this.caption4 = caption4;
    }
    /**
     * @return Returns the caption5.
     */
    public String getCaption5() {
        return caption5;
    }
    /**
     * @param caption5 The caption5 to set.
     */
    public void setCaption5(String caption5) {
        this.caption5 = caption5;
    }
    /**
     * @return Returns the changeDate.
     */
    public String getChangeDate() {
        return changeDate;
    }
    /**
     * @param changeDate The changeDate to set.
     */
    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
    /**
     * @return Returns the changeUser.
     */
    public String getChangeUser() {
        return changeUser;
    }
    /**
     * @param changeUser The changeUser to set.
     */
    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }
    /**
     * @return Returns the content.
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return Returns the createDate.
     */
    public String getCreateDate() {
        return createDate;
    }
    /**
     * @param createDate The createDate to set.
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    /**
     * @return Returns the createUse.
     */
    public String getCreateUse() {
        return createUse;
    }
    /**
     * @param createUse The createUse to set.
     */
    public void setCreateUse(String createUse) {
        this.createUse = createUse;
    }
    /**
     * @return Returns the descripten.
     */
    public String getDescripten() {
        return descripten;
    }
    /**
     * @param descripten The descripten to set.
     */
    public void setDescripten(String descripten) {
        this.descripten = descripten;
    }
    /**
     * @return Returns the dokumentNr.
     */
    public String getDokumentNr() {
        return dokumentNr;
    }
    /**
     * @param dokumentNr The dokumentNr to set.
     */
    public void setDokumentNr(String dokumentNr) {
        this.dokumentNr = dokumentNr;
    }
    /**
     * @return Returns the dokumentTyp.
     */
    public String getDokumentTyp() {
        return dokumentTyp;
    }
    /**
     * @param dokumentTyp The dokumentTyp to set.
     */
    public void setDokumentTyp(String dokumentTyp) {
        this.dokumentTyp = dokumentTyp;
    }
    /**
     * @return Returns the fax.
     */
    public String getFax() {
        return fax;
    }
    /**
     * @param fax The fax to set.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * @return Returns the gliederung.
     */
    public String getGliederung() {
        return gliederung;
    }
    /**
     * @param gliederung The gliederung to set.
     */
    public void setGliederung(String gliederung) {
        this.gliederung = gliederung;
    }
    /**
     * @return Returns the hinweis1.
     */
    public String getHinweis1() {
        return hinweis1;
    }
    /**
     * @param hinweis1 The hinweis1 to set.
     */
    public void setHinweis1(String hinweis1) {
        this.hinweis1 = hinweis1;
    }
    /**
     * @return Returns the hinweis2.
     */
    public String getHinweis2() {
        return hinweis2;
    }
    /**
     * @param hinweis2 The hinweis2 to set.
     */
    public void setHinweis2(String hinweis2) {
        this.hinweis2 = hinweis2;
    }
    /**
     * @return Returns the hinweis3.
     */
    public String getHinweis3() {
        return hinweis3;
    }
    /**
     * @param hinweis3 The hinweis3 to set.
     */
    public void setHinweis3(String hinweis3) {
        this.hinweis3 = hinweis3;
    }
    /**
     * @return Returns the hinweis4.
     */
    public String getHinweis4() {
        return hinweis4;
    }
    /**
     * @param hinweis4 The hinweis4 to set.
     */
    public void setHinweis4(String hinweis4) {
        this.hinweis4 = hinweis4;
    }
    /**
     * @return Returns the link1.
     */
    public String getLink1() {
        return link1;
    }
    /**
     * @param link1 The link1 to set.
     */
    public void setLink1(String link1) {
        this.link1 = link1;
    }
    /**
     * @return Returns the link10.
     */
    public String getLink10() {
        return link10;
    }
    /**
     * @param link10 The link10 to set.
     */
    public void setLink10(String link10) {
        this.link10 = link10;
    }
    /**
     * @return Returns the link2.
     */
    public String getLink2() {
        return link2;
    }
    /**
     * @param link2 The link2 to set.
     */
    public void setLink2(String link2) {
        this.link2 = link2;
    }
    /**
     * @return Returns the link3.
     */
    public String getLink3() {
        return link3;
    }
    /**
     * @param link3 The link3 to set.
     */
    public void setLink3(String link3) {
        this.link3 = link3;
    }
    /**
     * @return Returns the link4.
     */
    public String getLink4() {
        return link4;
    }
    /**
     * @param link4 The link4 to set.
     */
    public void setLink4(String link4) {
        this.link4 = link4;
    }
    /**
     * @return Returns the link5.
     */
    public String getLink5() {
        return link5;
    }
    /**
     * @param link5 The link5 to set.
     */
    public void setLink5(String link5) {
        this.link5 = link5;
    }
    /**
     * @return Returns the link6.
     */
    public String getLink6() {
        return link6;
    }
    /**
     * @param link6 The link6 to set.
     */
    public void setLink6(String link6) {
        this.link6 = link6;
    }
    /**
     * @return Returns the link7.
     */
    public String getLink7() {
        return link7;
    }
    /**
     * @param link7 The link7 to set.
     */
    public void setLink7(String link7) {
        this.link7 = link7;
    }
    /**
     * @return Returns the link8.
     */
    public String getLink8() {
        return link8;
    }
    /**
     * @param link8 The link8 to set.
     */
    public void setLink8(String link8) {
        this.link8 = link8;
    }
    /**
     * @return Returns the link9.
     */
    public String getLink9() {
        return link9;
    }
    /**
     * @param link9 The link9 to set.
     */
    public void setLink9(String link9) {
        this.link9 = link9;
    }
    /**
     * @return Returns the mail.
     */
    public String getMail() {
        return mail;
    }
    /**
     * @param mail The mail to set.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
     * @return Returns the nummer.
     */
    public String getNummer() {
        return nummer;
    }
    /**
     * @param nummer The nummer to set.
     */
    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
    /**
     * @return Returns the ort.
     */
    public String getOrt() {
        return ort;
    }
    /**
     * @param ort The ort to set.
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return Returns the passwordchek.
     */
    public String getPasswordchek() {
        return passwordchek;
    }
    /**
     * @param passwordchek The passwordchek to set.
     */
    public void setPasswordchek(String passwordchek) {
        this.passwordchek = passwordchek;
    }
    /**
     * @return Returns the plz.
     */
    public String getPlz() {
        return plz;
    }
    /**
     * @param plz The plz to set.
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }
    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return Returns the strasse.
     */
    public String getStrasse() {
        return strasse;
    }
    /**
     * @param strasse The strasse to set.
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    /**
     * @return Returns the telefon.
     */
    public String getTelefon() {
        return telefon;
    }
    /**
     * @param telefon The telefon to set.
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    /**
     * @return Returns the titel.
     */
    public String getTitel() {
        return titel;
    }
    /**
     * @param titel The titel to set.
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }
    /**
     * @return Returns the userId.
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @param userId The userId to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * @return Returns the vorgabe.
     */
    public String getVorgabe() {
        return vorgabe;
    }
    /**
     * @param vorgabe The vorgabe to set.
     */
    public void setVorgabe(String vorgabe) {
        this.vorgabe = vorgabe;
    }

}//class Selinas
