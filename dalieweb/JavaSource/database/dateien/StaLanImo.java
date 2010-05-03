/*
 * Created of DV0101 on 16.02.2010 16:41:43
 *
 * Filename	  StaLanImo.java
 */
package database.dateien;

import java.util.Vector;

/**
 * Stammdatendatei: 
 *	 	Übersetzung für Immobilienenverwaltung.
 *
 * @version 	1.00 16.02.2010 um 16:41:43
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class StaLanImo {
	/* Stammdatendatei: 
	 	Übersetzung für Immobilienenverwaltung */

	/** objektId: Id der Immobilie  */
    private String objektId;//objektId
    /** immobilientyp: Typ der Immobilie  */
    private String immobilientyp;//Haus,Wohnung o. Parkplatz
    /** name: Name des Eigentuemers  */
    private String name;//name
    /** vorname: Vorname des Eigentuemers  */
    private String vorname;//vorname
    /** geburtstag: Geburtstag des Eigentuemer*/
    private String geburtstag;
    /**  besitztSeit: Eigentum seit  */
    private String besitztSeit;//besitztSeit
    /**  miete: Höhe der Miete in EUR  */
    private String miete;//miete
    /**  baujahr: Datum der Fertigstellung  */
    private String baujahr;//01.01.1971
    /**  zustand: Zustand der Wohnung  */
    private String zustand;//gepflegt,renovierungsbedürftig
    /**  wohnungstyp: Typ der Wohnung  */
    private String wohnungstyp;//Dachgeschoss, Etage
    /**  zimmer: Anzahl der Zimmer */
    private String zimmer;//4
    /**  flaeche: Wohnfläche in QM  */
    private String flaeche;//122qm
    /**  heitzungstyp: Typ der Heitzung  */
    private String heitzungstyp;//Ofen, Gasheitzung, Lüfter
    
    /**  caption1: caption1*/
    private String caption1;//caption
    /**  caption2: caption2*/
    private String caption2;//caption
    /**  caption3: caption3*/
    private String caption3;//caption
    /**  caption4: caption4*/
    private String caption4;//caption
    /**  caption5: caption5*/
    private String caption5;//caption
    /**  caption6: caption6*/
    private String caption6;//caption
    /**  caption7: caption7*/
    private String caption7;//caption
    /**  caption8: caption8*/
    private String caption8;//caption
    /**  caption9: caption9*/
    private String caption9;//caption
    /**  caption10: caption10*/
    private String caption10;//caption
    
    /**  button1: button1*/
    private String button1;//button
    /**  button2: button2*/
    private String button2;//button
    /**  button3: button3*/
    private String button3;//button
    /**  button4: button4*/
    private String button4;//button
    /**  button5: button5*/
    private String button5;//button
    /**  button6: button6*/
    private String button6;//button
    /**  button7: button7*/
    private String button7;//button
    /**  button8: button8*/
    private String button8;//button
    /**  button9: button9*/
    private String button9;//button
    /**  button10: button10*/
    private String button10;//button
    
    /**  link1: link1*/
    private String link1;//link
    /**  linkt1: linkt1*/
    private String link1t;//link
    /**  link2: link2*/
    private String link2;//link
    /**  linkt2: linkt2*/
    private String link2t;//link
    /**  link3: link3*/
    private String link3;//link
    /**  linkt3: linkt3*/
    private String link3t;//link
    /**  link4: link4*/
    private String link4;//link
    /**  linkt4: linkt4*/
    private String link4t;//link
    /**  link5: link5*/
    private String link5;//link
    /**  linkt5: linkt5*/
    private String link5t;//link
    /**  link6: link6*/
    private String link6;//link
    /**  linkt6: linkt6*/
    private String link6t;//link
    /**  link7: link7*/
    private String link7;//link
    /**  linkt7: linkt7*/
    private String link7t;//link
    /**  link8: link8*/
    private String link8;//link
    /**  linkt8: linkt8*/
    private String link8t;//link
    /**  link9: link9*/
    private String link9;//link
    /**  linkt9: linkt9*/
    private String link9t;//link
    /**  link10: link10*/
    private String link10;//link
    /**  linkt10: linkt10*/
    private String link10t;//link
    
    /**  image1: image1*/
    private String image1;//image
    /**  imaget1: imaget1*/
    private String image1t;//image
    /**  image2: image2*/
    private String image2;//image
    /**  image2t: image2t*/
    private String image2t;//image
    /**  image3: image3*/
    private String image3;//image
    /**  image3t: image3t*/
    private String image3t;//image
    /**  image4: image4*/
    private String image4;//image
    /**  image4t: image4t*/
    private String image4t;//image
    /**  image5: image5*/
    private String image5;//image
    /**  image5t: image5t*/
    private String image5t;//image
    /**  image6: image6*/
    private String image6;//image
    /**  image6t: image6t*/
    private String image6t;//image
    /**  image7: image7*/
    private String image7;//image
    /**  image7t: image7t*/
    private String image7t;//image
    /**  image8: image8*/
    private String image8;//image
    /**  image8t: image8t*/
    private String image8t;//image
    /**  image9: image9*/
    private String image9;//image
    /**  image9t: image9t*/
    private String image9t;//image
    /**  image10: image10*/
    private String image10;//image
    /**  imaget10: image10t*/
    private String image10t;//image
    
    private String createUse;
    private String createDate;
    private String changeUser;
    private String changeDate;
    
    /** Stammdatendatei: 
 		Übersetzung für Immobilienenverwaltung */
    public StaLanImo(){
    }//StaLanImo
    public StaLanImo(Vector columns){
    	this.objektId = columns.elementAt(3).toString();
    	this.immobilientyp = columns.elementAt(4).toString();
    	this.name = columns.elementAt(5).toString();
    	this.vorname = columns.elementAt(6).toString();
    	this.geburtstag = columns.elementAt(7).toString();
    	this.besitztSeit = columns.elementAt(8).toString();
    	this.miete = columns.elementAt(9).toString();
    	this.baujahr = columns.elementAt(10).toString();
    	this.zustand = columns.elementAt(11).toString();
    	this.wohnungstyp = columns.elementAt(12).toString();
    	this.zimmer = columns.elementAt(13).toString();
    	this.flaeche = columns.elementAt(14).toString();
    	this.heitzungstyp = columns.elementAt(15).toString();
    	this.caption1 = columns.elementAt(16).toString();
		this.caption2 = columns.elementAt(17).toString();
		this.caption3 = columns.elementAt(18).toString();
		this.caption4 = columns.elementAt(19).toString();
		this.caption5 = columns.elementAt(20).toString();
		this.caption6 = columns.elementAt(21).toString();
		this.caption7 = columns.elementAt(22).toString();
		this.caption8 = columns.elementAt(23).toString();
		this.caption9 = columns.elementAt(24).toString();
		this.caption10 = columns.elementAt(25).toString();
		this.button1 = columns.elementAt(26).toString();
		this.button2 = columns.elementAt(27).toString();
		this.button3 = columns.elementAt(28).toString();
		this.button4 = columns.elementAt(29).toString();
		this.button5 = columns.elementAt(30).toString();
		this.button6 = columns.elementAt(31).toString();
		this.button7 = columns.elementAt(32).toString();
		this.button8 = columns.elementAt(33).toString();
		this.button9 = columns.elementAt(34).toString();
		this.button10 = columns.elementAt(35).toString();
		this.link1 = columns.elementAt(36).toString();
		this.link1t = columns.elementAt(37).toString();
		this.link2 = columns.elementAt(38).toString();
		this.link2t = columns.elementAt(39).toString();
		this.link3 = columns.elementAt(40).toString();
		this.link3t = columns.elementAt(41).toString();
		this.link4 = columns.elementAt(42).toString();
		this.link4t = columns.elementAt(43).toString();
		this.link5 = columns.elementAt(44).toString();
		this.link5t = columns.elementAt(45).toString();
		this.link6 = columns.elementAt(46).toString();
		this.link6t = columns.elementAt(47).toString();
		this.link7 = columns.elementAt(48).toString();
		this.link7t = columns.elementAt(49).toString();
		this.link8 = columns.elementAt(50).toString();
		this.link8t = columns.elementAt(51).toString();
		this.link9 = columns.elementAt(52).toString();
		this.link9t = columns.elementAt(53).toString();
		this.link10 = columns.elementAt(54).toString();
		this.link10t = columns.elementAt(55).toString();
		
		this.image1 = columns.elementAt(56).toString();
		this.image1t = columns.elementAt(57).toString();
		this.image2 = columns.elementAt(58).toString();
		this.image2t = columns.elementAt(59).toString();
		this.image3 = columns.elementAt(60).toString();
		this.image3t = columns.elementAt(61).toString();
		this.image4 = columns.elementAt(62).toString();
		this.image4t = columns.elementAt(63).toString();
		this.image5 = columns.elementAt(64).toString();
		this.image5t = columns.elementAt(65).toString();
		this.image6 = columns.elementAt(66).toString();
		this.image6t = columns.elementAt(67).toString();
		this.image7 = columns.elementAt(68).toString();
		this.image7t = columns.elementAt(69).toString();
		this.image8 = columns.elementAt(70).toString();
		this.image8t = columns.elementAt(71).toString();
		this.image9 = columns.elementAt(72).toString();
		this.image9t = columns.elementAt(73).toString();
		this.image10 = columns.elementAt(74).toString();
		this.image10t = columns.elementAt(75).toString();
		
		this.createUse = columns.elementAt(76).toString();
	    this.createDate = columns.elementAt(77).toString();
	    this.changeUser = columns.elementAt(78).toString();
	    this.changeDate = columns.elementAt(79).toString();
    }//StaLanImo
    
    
    
    
	/**
	 * @return Returns the baujahr.
	 */
	public String getBaujahr() {
		return baujahr;
	}
	/**
	 * @param baujahr The baujahr to set.
	 */
	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}
	/**
	 * @return Returns the besitztSeit.
	 */
	public String getBesitztSeit() {
		return besitztSeit;
	}
	/**
	 * @param besitztSeit The besitztSeit to set.
	 */
	public void setBesitztSeit(String besitztSeit) {
		this.besitztSeit = besitztSeit;
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
	 * @return Returns the flaeche.
	 */
	public String getFlaeche() {
		return flaeche;
	}
	/**
	 * @param flaeche The flaeche to set.
	 */
	public void setFlaeche(String flaeche) {
		this.flaeche = flaeche;
	}
	/**
	 * @return Returns the geburtstag.
	 */
	public String getGeburtstag() {
		return geburtstag;
	}
	/**
	 * @param geburtstag The geburtstag to set.
	 */
	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}
	/**
	 * @return Returns the heitzungstyp.
	 */
	public String getHeitzungstyp() {
		return heitzungstyp;
	}
	/**
	 * @param heitzungstyp The heitzungstyp to set.
	 */
	public void setHeitzungstyp(String heitzungstyp) {
		this.heitzungstyp = heitzungstyp;
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
	 * @return Returns the image10t.
	 */
	public String getImage10t() {
		return image10t;
	}
	/**
	 * @param image10t The image10t to set.
	 */
	public void setImage10t(String image10t) {
		this.image10t = image10t;
	}
	/**
	 * @return Returns the image1t.
	 */
	public String getImage1t() {
		return image1t;
	}
	/**
	 * @param image1t The image1t to set.
	 */
	public void setImage1t(String image1t) {
		this.image1t = image1t;
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
	 * @return Returns the image2t.
	 */
	public String getImage2t() {
		return image2t;
	}
	/**
	 * @param image2t The image2t to set.
	 */
	public void setImage2t(String image2t) {
		this.image2t = image2t;
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
	 * @return Returns the image3t.
	 */
	public String getImage3t() {
		return image3t;
	}
	/**
	 * @param image3t The image3t to set.
	 */
	public void setImage3t(String image3t) {
		this.image3t = image3t;
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
	 * @return Returns the image4t.
	 */
	public String getImage4t() {
		return image4t;
	}
	/**
	 * @param image4t The image4t to set.
	 */
	public void setImage4t(String image4t) {
		this.image4t = image4t;
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
	 * @return Returns the image5t.
	 */
	public String getImage5t() {
		return image5t;
	}
	/**
	 * @param image5t The image5t to set.
	 */
	public void setImage5t(String image5t) {
		this.image5t = image5t;
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
	 * @return Returns the image6t.
	 */
	public String getImage6t() {
		return image6t;
	}
	/**
	 * @param image6t The image6t to set.
	 */
	public void setImage6t(String image6t) {
		this.image6t = image6t;
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
	 * @return Returns the image7t.
	 */
	public String getImage7t() {
		return image7t;
	}
	/**
	 * @param image7t The image7t to set.
	 */
	public void setImage7t(String image7t) {
		this.image7t = image7t;
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
	 * @return Returns the image8t.
	 */
	public String getImage8t() {
		return image8t;
	}
	/**
	 * @param image8t The image8t to set.
	 */
	public void setImage8t(String image8t) {
		this.image8t = image8t;
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
	 * @return Returns the image9t.
	 */
	public String getImage9t() {
		return image9t;
	}
	/**
	 * @param image9t The image9t to set.
	 */
	public void setImage9t(String image9t) {
		this.image9t = image9t;
	}
	/**
	 * @return Returns the immobilientyp.
	 */
	public String getImmobilientyp() {
		return immobilientyp;
	}
	/**
	 * @param immobilientyp The immobilientyp to set.
	 */
	public void setImmobilientyp(String immobilientyp) {
		this.immobilientyp = immobilientyp;
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
	 * @return Returns the miete.
	 */
	public String getMiete() {
		return miete;
	}
	/**
	 * @param miete The miete to set.
	 */
	public void setMiete(String miete) {
		this.miete = miete;
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
	 * @return Returns the objektId.
	 */
	public String getObjektId() {
		return objektId;
	}
	/**
	 * @param objektId The objektId to set.
	 */
	public void setObjektId(String objektId) {
		this.objektId = objektId;
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
	/**
	 * @return Returns the wohnungstyp.
	 */
	public String getWohnungstyp() {
		return wohnungstyp;
	}
	/**
	 * @param wohnungstyp The wohnungstyp to set.
	 */
	public void setWohnungstyp(String wohnungstyp) {
		this.wohnungstyp = wohnungstyp;
	}
	/**
	 * @return Returns the zimmer.
	 */
	public String getZimmer() {
		return zimmer;
	}
	/**
	 * @param zimmer The zimmer to set.
	 */
	public void setZimmer(String zimmer) {
		this.zimmer = zimmer;
	}
	/**
	 * @return Returns the zustand.
	 */
	public String getZustand() {
		return zustand;
	}
	/**
	 * @param zustand The zustand to set.
	 */
	public void setZustand(String zustand) {
		this.zustand = zustand;
	}
}//class StaLanImo
