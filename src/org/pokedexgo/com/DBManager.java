package org.pokedexgo.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
	static Statement s = null;
	static Connection conn = null;
	static ResultSet rs = null;
	static ArrayList<String> pokemon = new ArrayList<String>();
	public static void instantiateDB(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection("jdbc:sqlite:/Users/SCanchiRadhakrishna/Pokedex.db");
			s = conn.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static String toJSONArray(){
		instantiateDB();
		try {
			rs = s.executeQuery("select * from pokemon");
			while(rs.next()){
				pokemon.add((String) rs.getObject("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jsonArr = "[";
		
		for(int i = 0; i < pokemon.size();i++){
			if(i==pokemon.size()-1){
				jsonArr+="\"" + pokemon.get(i) + "\"]";
			}
			else{
				jsonArr+="\"" + pokemon.get(i) + "\",";
			}
				//jsonArr += "\" + pokemon.get(i) + "";
		}
		return jsonArr;	
	}
	
	public static Pokemon getPokemon(String n){
		//instantiateDB();
		Pokemon p = new Pokemon(n);
		return p;
		
	}
	
	public ArrayList<PokemonTeam> getSavedTeams(){
		instantiateDB();
		ArrayList<PokemonTeam> team = new ArrayList<PokemonTeam>();
		try {
			rs = s.executeQuery("select * from saved_teams;");
			//team.add(new PokemonTeam((String)rs.getObject("notes"),(String)rs.getObject("pkmn0"), (String)rs.getObject("pkmn1"), (String)rs.getObject("pkmn2"), (String)rs.getObject("pkmn3"), (String)rs.getObject("pkmn4"), (String)rs.getObject("pkmn5")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
	}
	
	public static void insertMovesets(String n, String m1, String m2, String m3, String m4, int hp, int atk, int def, int spatk, int spdef, int spd, String nature, String ability){
		String query = "INSERT into movesets VALUES(NULL, '" + n + "', NULL, '"+nature+"', '"+ability+"' , "+hp+", "+atk+", "+def+", "+spatk+", "+spdef+", "+spd+", '" + m1 +  "','" + m2 + "','" + m3 + "','" + m4 + "');";
		System.out.println(query);
		instantiateDB();
		try {
			s.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted new moveset");
	}
	
	public static void addNickname(String nickname, String pokemon_name, String reasoning){
		instantiateDB();
		int id  = 0;
		try {
			rs = s.executeQuery("select id from pokemon where name = '" + pokemon_name.toLowerCase() + "';" );
			while(rs.next()){
				id = (int) rs.getObject("id");
			}
			System.out.println("insert into nicknames VALUES(" + id + ", '" + pokemon_name + "', '" + nickname + "', '" + reasoning+ "');");
			s.executeUpdate("insert into nicknames VALUES(" + id + ", '" + pokemon_name + "', '" + nickname + "', '" + reasoning+ "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<nicknameInfo> getNicknames(String query){
		instantiateDB();
		ArrayList<nicknameInfo> arr = new ArrayList<nicknameInfo>();
		try {
			rs = s.executeQuery(query);
			while(rs.next()){
				arr.add(new nicknameInfo((String)rs.getObject("pokemon_nickname"), (String)rs.getObject("pokemon_name"), (String)rs.getObject("reasoning"), (int)rs.getObject("pokemon_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < arr.size();i++){
			arr.get(i).print();
		}
		return arr;
	}
	
	public static Pokemon selectPokemon(String name){
		return new Pokemon(name);
	}
	
	public static ArrayList<String> getCompSet(String name){
		ArrayList<String> compSet = new ArrayList<>();
		instantiateDB();
		String out = "";
		int id = 0;
		//String description = "";
		//String name = "";
		String nature = "";
		int ev_atk = 0, ev_def = 0, ev_hp = 0, ev_spdef = 0, ev_spatk = 0, ev_spd = 0;
		try {
			rs = s.executeQuery("select distinct * from movesets, natures, pokemon where pokemon.name = movesets.name and movesets.nature = natures.n_nature and pokemon.name = '"+name+"';");
			while(rs.next()){
				id = (int)rs.getObject("id");
				out = "";
				out+= "<img src = 'images/" + id + " icon.png' />";
				out+="<b>"+name.substring(0,1).toUpperCase()+ name.substring(1) +"</b><br>";
				out+=("ability: "+(String)rs.getObject("ability")+"<br>");
				ev_atk = (int) rs.getObject("atk_ev");
				ev_hp = (int) rs.getObject("hp_ev");
				ev_def = (int) rs.getObject("def_ev");
				ev_spatk = (int) rs.getObject("spatk_ev");
				ev_spd = (int) rs.getObject("spd_ev");
				ev_spdef = (int) rs.getObject("spdef_ev");
				if(ev_hp>0){
					out+=ev_hp+" HP/ ";
				}
				if(ev_atk>0){
					out+=ev_atk+" Atk/ ";
				}
				if(ev_def>0){
					out+=ev_hp+" Def/ ";
				}
				if(ev_spatk>0){
					out+=ev_spatk+" Sp.Atk/ ";
				}
				if(ev_spdef>0){
					out+=ev_spdef+" Sp.Def/ ";
				}
				if(ev_spd>0){
					out+=ev_spd+" Spd/ ";
				}
				out = out.substring(0,out.length()-2);
				out+="<br>";
				out+=((String)rs.getObject("n_nature")+"(+"+(String)rs.getObject("n_increase") + ", -" + (String)rs.getObject("n_decrease")+")<br>");
				out+=(rs.getObject("move1")+"<br>");
				out+=(rs.getObject("move2")+"<br>");
				out+=(rs.getObject("move3")+"<br>");
				out+=(rs.getObject("move4")+"<br>");
				//out+=")\n";
				
				compSet.add(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compSet;
	}
	/*public static ArrayList<String> getCompSet(String name){
		ArrayList<String> compSet = new ArrayList<>();
		instantiateDB();
		String out = "";
		int id = 0;
		//String description = "";
		//String name = "";
		String nature = "";
		int ev_atk = 0, ev_def = 0, ev_hp = 0, ev_spdef = 0, ev_spatk = 0, ev_spd = 0;
		try {
			rs = s.executeQuery("select * from movesets, natures, pokemon where pokemon.name = movesets.name and pokemon.name = '"+name+"';");
			while(rs.next()){
				id = (int)rs.getObject("id");
				out = "";
				out+= "<img src = 'images/" + id + " icon.png' />";
				out+="<b>"+name.substring(0,1).toUpperCase()+ name.substring(1) +"</b><br>";
				out+=("ability: "+(String)rs.getObject("ability")+"<br>");
				ev_atk = (int) rs.getObject("atk_ev");
				ev_hp = (int) rs.getObject("hp_ev");
				ev_def = (int) rs.getObject("def_ev");
				ev_spatk = (int) rs.getObject("spatk_ev");
				ev_spd = (int) rs.getObject("spd_ev");
				ev_spdef = (int) rs.getObject("spdef_ev");
				if(ev_hp>0){
					out+=ev_hp+" HP/ ";
				}
				if(ev_atk>0){
					out+=ev_atk+" Atk/ ";
				}
				if(ev_def>0){
					out+=ev_hp+" Def/ ";
				}
				if(ev_spatk>0){
					out+=ev_spatk+" Sp.Atk/ ";
				}
				if(ev_spdef>0){
					out+=ev_spdef+" Sp.Def/ ";
				}
				if(ev_spd>0){
					out+=ev_spd+" Spd/ ";
				}
				out = out.substring(0,out.length()-2);
				out+="<br>";
				out+=((String)rs.getObject("n_nature")+"(+"+(String)rs.getObject("n_increase") + ", -" + (String)rs.getObject("n_decrease")+")<br>");
				out+=(rs.getObject("move1")+"<br>");
				out+=(rs.getObject("move2")+"<br>");
				out+=(rs.getObject("move3")+"<br>");
				out+=(rs.getObject("move4")+"<br>");
				//out+=")\n";
				
				compSet.add(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compSet;
	}*/
	
	public static void saveTeam(String trainerName, String pkmn1, String pkmn2, String pkmn3, String pkmn4, String pkmn5, String pkmn6, String notes){
		instantiateDB();
		try {
			s.executeUpdate("insert into saved_teams VALUES(NULL,'" + pkmn1 + "', '" + pkmn2 + "', '" + pkmn3 + "', '"  + pkmn4 + "', '" + pkmn5 + "', '"  + pkmn6 + "', '" + trainerName+"')");
			//s.executeUpdate("update ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args){
		ArrayList<String> arr = getCompSet("charizard");
		for(int i = 0; i < arr.size();i++){
			System.out.println(arr.get(i));
		}
		//getNicknames("select * from nicknames where pokemon_name = 'gengar';");
		//instantiateDB();
		//toJSONArray();
		//insertMovesets("charizard", "fire blast", "wing attack", "flamethrower", "seismic toss");
		//System.out.println("\"" + pokemon.get(0) + "\"");
		//addNickname("Boo", "gengar", "He is a ghost");
	}
}
