/*
 * Created on 09.02.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package inserat.typ;

import hausverwaltung.immobilien.Parkplatz;
import hausverwaltung.immobilien.Wohnung;
import database.dateien.Typ;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InseratTyp {
	
	
	/** typOfInserat: K=aufen/M=ieten */
	private Typ typOfInserat;
    private InseratTyp inseratTyp;
	
    InseratTyp(){
    }//InseratTyp
	InseratTyp(Wohnung wohnung){
		this.inseratTyp = new InseratTypWohnung(wohnung);
	}//InseratTyp
	InseratTyp(Parkplatz parkplatz){
		this.inseratTyp = new InseratTypParkplatz(parkplatz);
	}//InseratTyp
	
}//class InseratTyp
