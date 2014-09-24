import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here   

Bacteria [] society;

Virus [] invasion;
//get(x.y)
 public void setup()   
 {     //initialize bacteria variables here   
 	size(500,500);
 	
	society = new Bacteria[20];

 	for(int i = 0; i < society.length ; i++){
 		society[i]= new Bacteria();
 	}
 	invasion = new Virus[20];

 	for(int i = 0; i < society.length ; i++){
 		invasion[i] = new Virus();
 	}

 }   
 public void draw()   
 {    //move and show the bacteria   
 	background(0,0,0);
 	for(int i = 0; i <society.length;i++){
 		society[i].move();
 		/*for(int j = 0; j <society.length;j++){
 			if(get(society[j].myX,society[j].myY)==color(0,0,255)){
 				society[j].mySize1 = 60;
 				society[j].mySize2 = 30;

 			}
 		}*/
 		society[i].show();
 		}
 		
 	/*if(society[i].myX ==invasion[i].myX){
 			society[i].bacteriacolor1 = 0;
 			society[i].bacteriacolor2 = 0;
 			society[i].bacteriacolor3 = 0;*/

 	for(int i = 0; i < invasion.length; i++){
 		invasion[i].move();
 		
 		for(int j = 0; j <invasion.length;j++){
 		if(get(invasion[j].xposition,invasion[j].yposition)!=color(0)){
 			
 				invasion[j].viruscolor= color(0);
 				if(invasion[j].viruscolor==color(0)){
 					invasion[j].xposition = -500;
 					invasion[j].yposition = -500;
 					/*for(int k = 0; k <society.length;k++){
 						society[k].mySize1 = 50;
 						society[k].mySize2 = 30;
 						society[k].show();

 					}*/
 				}

 			}
 			
 		}
	invasion[i].show();
 	}




 }  
 class Bacteria    
 {  //lots of java! 

 	int myX,myY,bacteriacolor,mySize1,mySize2;

 	Bacteria(){
 		
 		bacteriacolor = color(0,250,0);
 		myX = (int)(Math.random()*401);
 		myY = (int)(Math.random()*401);
 		mySize1 = 45;
 		mySize2 = 15;
 	}    
 	public void move(){
 		int number = (int)(Math.random()*4);
 		if(number == 0){
 			myX--;
 		}if(number == 1){
 			myY--;
 		}if(number == 2){
 			myX++;
 		}if(number == 3){
 			myY++;

 		}
 		
 		 	  
 	} 
 	public void show(){

 		fill(bacteriacolor);
 		ellipse(myX,myY,mySize1,mySize1-20);
 		fill(255,0,0);
 		ellipse(myX,myY,mySize2,mySize2);
 	}    	
}class Virus
{
	int xposition,yposition,viruscolor;
	Virus(){
		xposition = (int)(Math.random()*401);
		yposition = (int)(Math.random()*401);
		viruscolor = color(0,0,255);
	}
	public void move(){
		int randnumber = (int)(Math.random()*4);
		if(randnumber==0){
			xposition--;
		}if(randnumber==1){
			yposition++;
		}if(randnumber==2){
			xposition++;
		}if(randnumber==3){
			yposition--;
		}
	}public void show(){
		fill(viruscolor);
		triangle(xposition,yposition, xposition+15, yposition-15,xposition-15,yposition-15);
		//fill(200,0,0);
		//ellipse(xposition,yposition-5,10,10);
	}
	}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
