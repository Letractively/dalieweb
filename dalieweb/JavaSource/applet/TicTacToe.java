package applet;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * @author DALiE am 10.02.2006 um 21:54:06
 *
 * TicTacToe.java
 * 
 */
public class TicTacToe extends Applet implements MouseListener {
	
	static Feld[][] feld = new Feld [3][3];
	int spieler = 1;
	int breite;
	int hoehe;
	boolean status = true;
			
		public void init(){
			addMouseListener(this);
				
			//Parameter einlesen
			 try {
			   breite = Integer.parseInt(getParameter("breite"));
			 } catch (NumberFormatException e) {
			   breite = 200;
			 }
			 try {
				hoehe = Integer.parseInt(getParameter("hoehe"));
				} catch (NumberFormatException e) {
				hoehe = 200;
				}

			//erst einmal Spielfeldinizalisieren
			for(int x = 0;x < feld.length;x++)
				for(int y = 0;y < feld.length;y++)
					feld[x][y] = null;
		
			feld[0][0] = new Feld(41,41,60,60,40,40,80,80,80,40,40,80); 
			feld[1][0] = new Feld(81,41,100,60,80,40,120,80,120,40,80,80);
			feld[2][0] = new Feld(121,41,140,60,120,40,160,80,160,40,120,80);
			feld[0][1] = new Feld(41,81,60,100,40,80,80,120,80,80,40,120);
			feld[1][1] = new Feld(81,81,100,100,80,80,120,120,120,80,80,120);    
			feld[2][1] = new Feld(121,81,140,100,120,80,160,120,160,80,120,120);
			feld[0][2] = new Feld(41,121,60,140,40,120,80,160,80,120,40,160);
			feld[1][2] = new Feld(81,121,100,140,80,120,120,160,120,120,80,160);
			feld[2][2] = new Feld(121,121,140,140,120,120,160,160,160,120,120,160);		
		
			    
		}//init
	
		public void start(){
																						
		}//start
	
		public void destroy() {
			removeMouseListener(this);
		}//destroy
	
		public void paint(Graphics g){
		
			g.drawRect(1,1,breite,hoehe);
			//SpielFeld zeichnen
			g.setColor(Color.blue);
			for(int x = 39;x <= 159;x+=40)
			g.drawLine(x,39,x,159);
			for(int y = 39;y <= 159;y+=40)
			g.drawLine(39,y,159,y);
			//nochmal
			for(int x = 40;x <= 160;x+=40)
			g.drawLine(x,40,x,160);
			for(int y = 40;y <= 160;y+=40)
			g.drawLine(40,y,160,y);
		
		
		}//paint
	
		private void checksieg(){
			int produkt=1;
			for(byte x=0;x<feld.length;x++)
			for(byte y=0;y<feld[0].length;y++)
				produkt *= feld[x][y].gamer;	
				if(produkt > 0){
				showStatus("Unentschieden");
				status = false;
				}else 
				{
			//check von links,oben nach rechts,unten
			if(feld[0][0].gamer == spieler && feld[1][1].gamer == spieler && feld[2][2].gamer == spieler){
				showStatus("Spieler " + spieler + " hat gewonnen, Glückwunsch!!!");
				status = false;
				}//endif
			//check von links,unten nacht rechts,oben		
			if(feld[2][0].gamer == spieler && feld[1][1].gamer == spieler && feld[0][2].gamer == spieler){
				showStatus("Spieler " + spieler + " hat gewonnen!!! Glückwunsch");
				status = false;
				}//endif
			//check wagerecht
			for(int x = 0;x < feld.length;x++){
				if(feld[x][0].gamer == spieler && feld[x][1].gamer == spieler && feld[x][2].gamer == spieler){
				showStatus("Spieler " + spieler + " hat gewonnen !!! Glückwunsch !!!");
				status = false;
				}//endif
			}//for
			//check senkrecht
			for(int x = 0;x < feld.length;x++){
				if(feld[0][x].gamer == spieler && feld[1][x].gamer == spieler && feld[2][x].gamer == spieler){
				showStatus("Spieler " + spieler + " hat gewonnen Glückwunsch !!!");
				status = false;
				}//endif		
			}//for
			}//endif 
		}//checksieg
		private void nextspieler(){
			if(spieler == 2){
				spieler--;
			}else{
				spieler++;
			}//endif
		}//nextspieler
		public void mousePressed(MouseEvent event){
		}
		public void mouseReleased(MouseEvent event){	
		}	
		public void mouseClicked(MouseEvent event){
			Graphics g = getGraphics();
			int x = event.getX()/40-1;
			int y = event.getY()/40-1;
			if(!feld[x][y].besetzt && status){
				if(spieler == 2){
				g.setColor(Color.red);	
				for(int radius = 17;radius <= 18; radius++)//Kreis malen
				g.drawOval(feld[x][y].radiusx - radius, feld[x][y].radiusy - radius, radius + radius, radius + radius );
				}else{
				g.setColor(Color.blue);//Kreuz malen
				g.drawLine(feld[x][y].k1,feld[x][y].k2,feld[x][y].k3,feld[x][y].k4);
				g.drawLine(feld[x][y].q1,feld[x][y].q2,feld[x][y].q3,feld[x][y].q4);
				}//endif spieler
				feld[x][y].besetzt = true;
				feld[x][y].gamer = spieler;
				checksieg();
				nextspieler();	
			}//endif
		}//mouseClicked
		public void mouseEntered(MouseEvent event){
		
		}
		public void mouseExited(MouseEvent event){
		}
		public String getAppletInfo(){
			return "TicTacToe Ver. 1.0 (C) 2006 Uwe Dalies";
		}

}
