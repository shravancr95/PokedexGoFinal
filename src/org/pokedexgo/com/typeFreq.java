package org.pokedexgo.com;

public class typeFreq {
	int num = 0; 
	String type = "";
	
	public typeFreq(int n, String t){
		num = n;
		type = t;
	}
	
	public String getType(){return type;}
	public int getFrequency(){return num;}
}
