/*
 * Created of DV0101 on 09.02.2010 12:59:12
 *
 * Filename	  ImmobilienTyp.java
 */
package hausverwaltung.immobilien;


/**
 * Objekt that describes the attributes of immobilientyp.
 *
 * @version 	1.00 09.02.2010 um 12:59:12
 * @author 		DV0101
 * <br><br>
 */
public class ImmobilienTyp {

	private ImmobilienTyp typ;
	
	ImmobilienTyp(){
	}//ImmobilienTyp
	public ImmobilienTyp(Haus haus){
		this.typ = haus;
	}//ImmobilienTyp
	public ImmobilienTyp(Wohnung wohnung){
		this.typ = wohnung;
	}//ImmobilienTyp
	public ImmobilienTyp(Parkplatz parkplatz){
		this.typ = parkplatz;
	}//ImmobilienTyp
	
	public String toString(){
		if(this.typ instanceof Haus)
			return "Haus";
		if(this.typ instanceof Wohnung)
				return "Wohnung";
		if(this.typ instanceof Parkplatz)	
				return "Parkplatz";
		return "";		
	}//toString
	
	public boolean isHaus(){
		if(this.typ instanceof Haus)
				return true;
		return false;		
	}//boolean
	
	public boolean isWohnung(){
		if(this.typ instanceof Wohnung)
				return true;
		return false;		
	}//boolean
	
	public boolean isParkplatz(){
		if(this.typ instanceof Parkplatz)
				return true;
		return false;		
	}//boolean
	
}//class ImmobilienTyp
