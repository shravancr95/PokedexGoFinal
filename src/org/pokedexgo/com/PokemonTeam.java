package org.pokedexgo.com;

public class PokemonTeam {
	Pokemon p0 = null;
	Pokemon p1,p2,p3,p4,p5;
	String note  = "";
	public PokemonTeam(String n,  String n_p0, String n_p1, String n_p2, String n_p3, String n_p4, String n_p5){
		this.note = n;
		this.p0 = new Pokemon(n_p0);
		p1 = new Pokemon(n_p1);
		p2 = new Pokemon(n_p2);
		p3 = new Pokemon(n_p3);
		p4 = new Pokemon(n_p4);
		p5 = new Pokemon(n_p5);
	}
	
}
