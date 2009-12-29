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
    private String name;
    private String vorname;
    
    private String password;
    private String passwordchek;
    
    /** selinas020-Adressverwaltung */
    private String adressArt;
    /** selinas020-Adressverwaltung */
    private String strasse;
    /** selinas020-Adressverwaltung */
    private String nummer;
    /** selinas020-Adressverwaltung */
    private String plz;
    /** selinas020-Adressverwaltung */
    private String ort;
    /** selinas020-Adressverwaltung */
    private String telefon;
    /** selinas020-Adressverwaltung */
    private String fax;
    /** selinas020-Adressverwaltung */
    private String mail;

    private String dokumentNr;
    private String dokumentTyp;
    /** selinas003-Anzeige Dokumente */
    private String titel;
    /** selinas003-Anzeige Dokumente */
    private String descripten;
    /** selinas003-Anzeige Dokumente,<br>
     * selinas004-Dokument verwaltung */
    private String content;
    /** selinas003-Anzeige Dokumente,<br>
     * selinas004-Dokument verwaltung */
    private String gliederung;
    /** selinas004-Dokument verwaltung */
    private String archiv;
    /** selinas004-Dokument verwaltung */
    private String vorgabe;
    /** selinas020-Adressverwaltung */
    private String status;

    /** selinas020-Adressverwaltung */
    private String caption1;//Adressverwaltung
    /** selinas020-Adressverwaltung */
    private String caption2;//Detail
    /** selinas020-Adressverwaltung */
    private String caption3;//Verwaltung der Dokumenttypen
    private String caption4;
    private String caption5;
    
    private String caption6;//List of Dokuments
    private String caption7;
    private String caption8;
    private String caption9;
    private String caption10;
    
    /** Verarbeitung starten */
    private String button1;//Verarbeitung starten
    /** Beenden */
    private String button2;//Beenden
    /** << zurück */
    private String button3;//zurück
    /** Dokument bearbeiten */
    private String button4;
    /** vorwärts >> */
    private String button5;
    /** Dokument drucken */
    private String button6;
    /** Upload starten */
    private String button7;
    /** Dokument verarbeiten */
    private String button8;
    /** Dokument kopieren */
    private String button9;
    /** Dokument löschen */
    private String button10;
    /** Dokument anlegen */
    private String button11;
    /** Dokumenttyp löschen */
    private String button12;
    /** Dokumenttyp anlegen*/
    private String button13;
    
    private String link1;//Übersicht
    private String link1t;//Übersicht
    
    private String link2;//Auswahl nach DokumentTyp
    private String link2t;//Auswahl nach DokumentTyp
    
    private String link3;//Administration of Selinas
    private String link3t;//Administration of Selina
    
    private String link4;//Adressen
    private String link4t;//Adressen
    
    private String link5;//Dokumenttypen
    private String link5t;//Dokumenttypen
    
    private String link6;//Userverwaltung
    private String link6t;//Userverwaltung
    
    private String link7;
    private String link7t;
    
    private String link8;
    private String link8t;
    
    private String link9;
    private String link9t;
    
    private String link10;
    private String link10t;
    
    private String image1;//Ihr Standpunkt 
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private String image7;
    private String image8;
    private String image9;
    private String image10;
    
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
        this.name = columns.elementAt(8).toString();
        this.vorname = columns.elementAt(9).toString();
        
        this.password = columns.elementAt(10).toString();
        this.passwordchek = columns.elementAt(11).toString();
        
        this.adressArt = columns.elementAt(12).toString();
        this.strasse = columns.elementAt(13).toString(); 
        this.nummer = columns.elementAt(14).toString();
        this.plz = columns.elementAt(15).toString();
        this.ort = columns.elementAt(16).toString();
        this.telefon = columns.elementAt(17).toString();
        this.fax = columns.elementAt(18).toString();
        this.mail = columns.elementAt(19).toString();
        
        this.dokumentNr = columns.elementAt(20).toString();
        this.dokumentTyp = columns.elementAt(21).toString();
        this.titel = columns.elementAt(22).toString();
        this.descripten = columns.elementAt(23).toString();
        this.content = columns.elementAt(24).toString();
        this.gliederung = columns.elementAt(25).toString();
        this.archiv = columns.elementAt(26).toString();
        this.vorgabe = columns.elementAt(27).toString();
        this.status = columns.elementAt(28).toString();
        
        this.caption1 = columns.elementAt(29).toString();
        this.caption2 = columns.elementAt(30).toString();
        this.caption3 = columns.elementAt(31).toString();
        this.caption4 = columns.elementAt(32).toString();
        this.caption5 = columns.elementAt(33).toString();
        
        this.caption6 = columns.elementAt(34).toString();
        this.caption7 = columns.elementAt(35).toString();
        this.caption8 = columns.elementAt(36).toString();
        this.caption9 = columns.elementAt(37).toString();
        this.caption10 = columns.elementAt(38).toString();
        
        this.button1 = columns.elementAt(39).toString();
        this.button2 = columns.elementAt(40).toString();
        this.button3 = columns.elementAt(41).toString();
        this.button4 = columns.elementAt(42).toString();
        this.button5 = columns.elementAt(43).toString();
        this.button6 = columns.elementAt(44).toString();
        this.button7 = columns.elementAt(45).toString();
        this.button8 = columns.elementAt(46).toString();
        this.button9 = columns.elementAt(47).toString();
        this.button10 = columns.elementAt(48).toString();
        this.button11 = columns.elementAt(49).toString();
        this.button12 = columns.elementAt(50).toString();
        this.button13 = columns.elementAt(51).toString();
        
        this.link1 = columns.elementAt(52).toString();
        this.link1t = columns.elementAt(53).toString();
        this.link2 = columns.elementAt(54).toString();
        this.link2t = columns.elementAt(55).toString();
        this.link3 = columns.elementAt(56).toString();
        this.link3t = columns.elementAt(57).toString();
        this.link4 = columns.elementAt(58).toString();
        this.link4t = columns.elementAt(59).toString();
        this.link5 = columns.elementAt(60).toString();
        this.link5t = columns.elementAt(61).toString();
        this.link6 = columns.elementAt(62).toString();
        this.link6t = columns.elementAt(63).toString();
        this.link7 = columns.elementAt(64).toString();
        this.link7t = columns.elementAt(65).toString();
        this.link8 = columns.elementAt(66).toString();
        this.link8t = columns.elementAt(67).toString();
        this.link9 = columns.elementAt(68).toString();
        this.link9t = columns.elementAt(69).toString();
        this.link10 = columns.elementAt(70).toString();
        this.link10t = columns.elementAt(71).toString();
        
        this.image1 = columns.elementAt(72).toString();
        this.image2 = columns.elementAt(73).toString();
        this.image3 = columns.elementAt(74).toString();
        this.image4 = columns.elementAt(75).toString();
        this.image5 = columns.elementAt(76).toString();
        this.image6 = columns.elementAt(77).toString();
        this.image7 = columns.elementAt(78).toString();
        this.image8 = columns.elementAt(79).toString();
        this.image9 = columns.elementAt(80).toString();
        this.image10 = columns.elementAt(81).toString();
        
        this.createUse = columns.elementAt(82).toString();
        this.createDate = columns.elementAt(83).toString();
        this.changeUser = columns.elementAt(84).toString();
        this.changeDate = columns.elementAt(85).toString();     
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
	 * @return Returns the button11.
	 */
	public String getButton11() {
		return button11;
	}
	/**
	 * @param button11 The button11 to set.
	 */
	public void setButton11(String button11) {
		this.button11 = button11;
	}
	/**
	 * @return Returns the button12.
	 */
	public String getButton12() {
		return button12;
	}
	/**
	 * @param button12 The button12 to set.
	 */
	public void setButton12(String button12) {
		this.button12 = button12;
	}
	/**
	 * @return Returns the button13.
	 */
	public String getButton13() {
		return button13;
	}
	/**
	 * @param button13 The button13 to set.
	 */
	public void setButton13(String button13) {
		this.button13 = button13;
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
	 * @return Returns the caption10.
	 */
	public String getCaption10() {
		return caption10;
	}
	/**
	 * @param caption10 The caption10 to set.
	 */
	public void setCaption10(String caption10) {
		this.caption10 = caption10;
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
	 * @return Returns the caption6.
	 */
	public String getCaption6() {
		return caption6;
	}
	/**
	 * @param caption6 The caption6 to set.
	 */
	public void setCaption6(String caption6) {
		this.caption6 = caption6;
	}
	/**
	 * @return Returns the caption7.
	 */
	public String getCaption7() {
		return caption7;
	}
	/**
	 * @param caption7 The caption7 to set.
	 */
	public void setCaption7(String caption7) {
		this.caption7 = caption7;
	}
	/**
	 * @return Returns the caption8.
	 */
	public String getCaption8() {
		return caption8;
	}
	/**
	 * @param caption8 The caption8 to set.
	 */
	public void setCaption8(String caption8) {
		this.caption8 = caption8;
	}
	/**
	 * @return Returns the caption9.
	 */
	public String getCaption9() {
		return caption9;
	}
	/**
	 * @param caption9 The caption9 to set.
	 */
	public void setCaption9(String caption9) {
		this.caption9 = caption9;
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
	 * @return Returns the image1.
	 */
	public String getImage1() {
		return image1;
	}
	/**
	 * @param image1 The image1 to set.
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	/**
	 * @return Returns the image10.
	 */
	public String getImage10() {
		return image10;
	}
	/**
	 * @param image10 The image10 to set.
	 */
	public void setImage10(String image10) {
		this.image10 = image10;
	}
	/**
	 * @return Returns the image2.
	 */
	public String getImage2() {
		return image2;
	}
	/**
	 * @param image2 The image2 to set.
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	/**
	 * @return Returns the image3.
	 */
	public String getImage3() {
		return image3;
	}
	/**
	 * @param image3 The image3 to set.
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	/**
	 * @return Returns the image4.
	 */
	public String getImage4() {
		return image4;
	}
	/**
	 * @param image4 The image4 to set.
	 */
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	/**
	 * @return Returns the image5.
	 */
	public String getImage5() {
		return image5;
	}
	/**
	 * @param image5 The image5 to set.
	 */
	public void setImage5(String image5) {
		this.image5 = image5;
	}
	/**
	 * @return Returns the image6.
	 */
	public String getImage6() {
		return image6;
	}
	/**
	 * @param image6 The image6 to set.
	 */
	public void setImage6(String image6) {
		this.image6 = image6;
	}
	/**
	 * @return Returns the image7.
	 */
	public String getImage7() {
		return image7;
	}
	/**
	 * @param image7 The image7 to set.
	 */
	public void setImage7(String image7) {
		this.image7 = image7;
	}
	/**
	 * @return Returns the image8.
	 */
	public String getImage8() {
		return image8;
	}
	/**
	 * @param image8 The image8 to set.
	 */
	public void setImage8(String image8) {
		this.image8 = image8;
	}
	/**
	 * @return Returns the image9.
	 */
	public String getImage9() {
		return image9;
	}
	/**
	 * @param image9 The image9 to set.
	 */
	public void setImage9(String image9) {
		this.image9 = image9;
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
	 * @return Returns the link10t.
	 */
	public String getLink10t() {
		return link10t;
	}
	/**
	 * @param link10t The link10t to set.
	 */
	public void setLink10t(String link10t) {
		this.link10t = link10t;
	}
	/**
	 * @return Returns the link1t.
	 */
	public String getLink1t() {
		return link1t;
	}
	/**
	 * @param link1t The link1t to set.
	 */
	public void setLink1t(String link1t) {
		this.link1t = link1t;
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
	 * @return Returns the link2t.
	 */
	public String getLink2t() {
		return link2t;
	}
	/**
	 * @param link2t The link2t to set.
	 */
	public void setLink2t(String link2t) {
		this.link2t = link2t;
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
	 * @return Returns the link3t.
	 */
	public String getLink3t() {
		return link3t;
	}
	/**
	 * @param link3t The link3t to set.
	 */
	public void setLink3t(String link3t) {
		this.link3t = link3t;
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
	 * @return Returns the link4t.
	 */
	public String getLink4t() {
		return link4t;
	}
	/**
	 * @param link4t The link4t to set.
	 */
	public void setLink4t(String link4t) {
		this.link4t = link4t;
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
	 * @return Returns the link5t.
	 */
	public String getLink5t() {
		return link5t;
	}
	/**
	 * @param link5t The link5t to set.
	 */
	public void setLink5t(String link5t) {
		this.link5t = link5t;
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
	 * @return Returns the link6t.
	 */
	public String getLink6t() {
		return link6t;
	}
	/**
	 * @param link6t The link6t to set.
	 */
	public void setLink6t(String link6t) {
		this.link6t = link6t;
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
	 * @return Returns the link7t.
	 */
	public String getLink7t() {
		return link7t;
	}
	/**
	 * @param link7t The link7t to set.
	 */
	public void setLink7t(String link7t) {
		this.link7t = link7t;
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
	 * @return Returns the link8t.
	 */
	public String getLink8t() {
		return link8t;
	}
	/**
	 * @param link8t The link8t to set.
	 */
	public void setLink8t(String link8t) {
		this.link8t = link8t;
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
	 * @return Returns the link9t.
	 */
	public String getLink9t() {
		return link9t;
	}
	/**
	 * @param link9t The link9t to set.
	 */
	public void setLink9t(String link9t) {
		this.link9t = link9t;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	/**
	 * @return Returns the vorname.
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname The vorname to set.
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}//class Selinas
