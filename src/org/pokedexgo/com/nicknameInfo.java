package org.pokedexgo.com;

public class nicknameInfo {
	String nickname="", pokemonName="", reasoning="";
	int id = 0;
	public nicknameInfo(String nn, String pn, String r, int id){
		nickname = nn;
		reasoning = r;
		this.id = id;
		pokemonName = pn;
	}
	
	public String print(){
		//System.out.println(id + " " + pokemonName + " " + nickname + " " + reasoning );
		return id + " " + pokemonName + " " + nickname + " " + reasoning ;
	}
}
