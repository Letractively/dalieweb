/*
* Created of DV0101 on 08.04.2010  12:47:42
*
* Filename	  SelinasModul.java
*/
package selinas;

import database.dateien.Typen;

/**
* Dieses Objekt dient zur Idendifikation, welche Module 
* <ul><li>Dokumentenverwaltung</li><li>Immobilienverwaltung</li></ul>
* gerade aktuell vom User bearbeitet werden.<br>
* <br><ul><li>erbet von Objekt <code>Typen</code></li>
* <li>Datenbasis: Datei:STASELMOD - Selinasmodul</li>
* <li>Zugiff über: DataSetTypen<code>.chainDatenTypSelinasModel</code></li></ul>
* <br>
* @version 	1.00 09.04.2010 um  08:53:17
* @author 		DV0101
* <br><br>
*/
public class SelinasModul extends Typen {
	/* SelinasModul: Objekt zur Idendifikation,
	 	welches Modul gerade in der SelinasSession aktiv ist.  */
	
	/** <b>Idendifikation</b> welches Modul, <br> 
	 		in der Session aktiv ist */
	public SelinasModul(Typen modulTyp) throws Exception{
		super(modulTyp);
	}//SelinasModul
	
	/** isDokumentAktiv: if true = Dokumentenverwaltung ist aktiv */
	public boolean isDokumentAktiv(){
		if(this.getTyp().equalsIgnoreCase("D"))
			return true;
		else
			return false;
	}//isDokument
	
	/** isImmobilieAktiv: if true = Immobilienverwaltung ist aktiv*/
	public boolean isImmobilieAktiv(){
		if(this.getTyp().equalsIgnoreCase("I"))
			return true;
		else
			return false;
	}//isImmobilieAktiv
	
}//class SelinasModul
