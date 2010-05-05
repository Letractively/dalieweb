package applet;

/**
 * @author DALiE am 10.02.2006 um 21:52:01
 *
 * Feld.java
 * 
 */
public class Feld {
	
	int x = 0;//Position des Feldes 
		int y = 0;//Position des Feldes 
		int radiusx = 0;
		int radiusy = 0;
		int gamer = 0;
		int k1 = 0;
		int k2 = 0;
		int k3 = 0;
		int k4 = 0;
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int q4 = 0;
	
		boolean besetzt = false;
 	
		Feld(int x, int y, int radiusx, int radiusy, int k1, int k2, int k3,int k4,int q1,int q2,int q3,int q4){
		this.x = x;
		this.y = y;
		this.radiusx = radiusx;
		this.radiusy = radiusy;
		this.k1 = k1;
		this.k2 = k2;
		this.k3 = k3;
		this.k4 = k4;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		}//Feld construktor

}//Feld
