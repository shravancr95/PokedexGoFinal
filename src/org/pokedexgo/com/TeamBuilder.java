package org.pokedexgo.com;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.w3c.dom.css.Counter;
public class TeamBuilder {
	static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
	
	
	static Statement s = null;
	static Connection conn = null;
	static ResultSet rs = null;
	
	public static Pokemon instantiatePokemon(String name){
		//Pokemon p = new Pokemon(name.toLowerCase());
		//System.out.println((myTeam.get(myTeam.size()-1)).toString());
		return new Pokemon(name.toLowerCase());
	}
	
	
	public static Pokemon instantiatePokemon(int id){
		//myTeam.add(new Pokemon(id));
		//System.out.println((myTeam.get(myTeam.size()-1)).toString());
		return new Pokemon(id);
	}
	
	//create db
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
	
	
	//Getting frequency of each type in an array 
	public static HashMap<String,Integer> getTypeFrequency(ArrayList<Integer> arr){
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		/*h.put("fire", 0);
		h.put("flying", 0);
		h.put("water", 0);
		h.put("poison",0);
		h.put("normal",0);
		h.put("grass",0);
		h.put("fairy",0);
		h.put("water",0);*/
		String t1 = ""; String t2 = "";
		for(int i = 0; i < arr.size(); i++){
			try {
				rs = s.executeQuery("select name, type1, type2 from pokemon where id = " + arr.get(i) + ";");
				while(rs.next()){
					System.out.println(rs.getObject("name") + " " + rs.getObject("type1") + " " + rs.getObject("type2"));
					t1 = (String) rs.getObject("type1");
					t2 = (String) rs.getObject("type2");
					if(!h.containsKey(t1)){
						h.put(t1, 1);
					}
					else{
						h.put(t1, h.get(t1) + 1);
					}
					if(!h.containsKey(t2)){
						h.put(t2, 1);
					}
					else{
						h.put(t1, h.get(t2) + 1);
					}	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//HashMap sortByFrequency<String, Intger> = sortByValues
		Set set = h.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry mentry = (Map.Entry)it.next();
			System.out.println(mentry.getKey() + ": " + mentry.getValue());
		}
		return h;
	}
	
	/*Function that returns the weaknesses of each pokemon and stores it in a hashmap. 
	This map will then give us the types of pokemon we are looking for to take on
	the input team*/
	public static ArrayList<typeFreq> getWeaknessFrequency(ArrayList<Pokemon> arr){
		ArrayList<typeFreq> weaknessOccurence = new ArrayList<typeFreq>();
		ResultSet w = null;
		String weaknessType = "";
		String n = "";
		String t1 = "";
		String t2 = "";
		//First we will count up all the weaknesses of the team and tally which one is most frequent
		HashMap<String, Integer> weakness = new HashMap<String, Integer>();
		for(int i = 0; i < arr.size(); i++){
			t1 = "";
			t2 = "";
			n = "";
			//System.out.println(arr.get(i).name);
			try {
				System.out.println(arr.get(i));
				rs = s.executeQuery("select name, type1, type2 from pokemon where id = " + arr.get(i).getID() + ";");
				while(rs.next()){
					n = (String) rs.getObject("name");
					t1 = (String) rs.getObject("type1");
					t2 = (String) rs.getObject("type2");
					//myTeam.add(new Pokemon(n, t1, t2));
				
					if(t2.equals("NULL")){
						w = conn.createStatement().executeQuery("select s_attack_type from super_effective, pokemon where name = '" + n + "' and strong_against = '" + t1 +  "';");
						while(w.next()){
							weaknessType = ((String) w.getObject("s_attack_type")).replaceAll(" ", "");
							if(!weakness.containsKey(weaknessType)){
								weakness.put(weaknessType, 1);
							}
							else{
								weakness.put(weaknessType, weakness.get(weaknessType) + 1);
							}
						}
					}
					else{
						w = conn.createStatement().executeQuery("select attacker as weakness from"
																+" (select sum(damage) as s,attacker, defender from"
																+" (select attacker, defender, damage"
																+" from pokemon, type_matchup"
																+" where name = '" + n + "' and defender = type1 and damage <> 0"
																+" union "
																+" select attacker, defender, damage"
																+" from pokemon, type_matchup"
																+" where name = '" + n + "' and defender = type2 and damage <> 0)"
																+" group by attacker) where s >= 3;");
						while(w.next()){
							weaknessType = ((String) w.getObject("weakness")).toLowerCase().replaceAll(" ", "");
							if(!weakness.containsKey(weaknessType)){
								weakness.put(weaknessType, 1);
							}
							else{
								weakness.put(weaknessType, weakness.get(weaknessType) + 1);
							}
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Set set = weakness.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry mentry = (Map.Entry)it.next();
			//System.out.println(mentry.getKey() + ": " + mentry.getValue());
			weaknessOccurence.add(new typeFreq((int)mentry.getValue(), (String)mentry.getKey()));
		}
		return weaknessOccurence;
	}
	
	public static int randInt(int min, int max){
		return max;
		
	}
	
	public static ArrayList<Pokemon> counterTeam(ArrayList<typeFreq> arr, ArrayList<Pokemon> input){
		int random = 0;
		Random r = new Random();
		ArrayList<Pokemon> counter = new ArrayList<Pokemon>();
		ArrayList<Pokemon> temp = new ArrayList<Pokemon>();
		ArrayList<String> types = new ArrayList<String>();
		
		for(int i = 0; i < arr.size();i++){
			try {
				//System.out.println("i = " + i);
				//System.out.println("select name from pokemon where (type1 = '" + arr.get(i).getType() + "' or type2 = '"+ arr.get(i).getType() + "') and id = evo_id;");
				rs = s.executeQuery("select name from pokemon where (type1 = '" + arr.get(i).getType() + "' or type2 = '"+ arr.get(i).getType() + "') and id = evo_id;");
				while(rs.next()){
					//System.out.println((String)rs.getObject("name"));
					temp.add(new Pokemon((String)rs.getObject("name")));
				}
				//random = r.nextInt(temp.size());
				
				System.out.println("Size of temp is " + temp.size());
				if(temp.size()>0){
					random = r.nextInt(temp.size());
					counter.add(temp.get(random));
				}
				while(!temp.isEmpty()){
					temp.remove(0);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("number of counters: " + counter.size());
			
		}
		/*for(int k = 0; k < counter.size()-1; k++){
			random = r.nextInt(counter.size());
			counter.remove(random);
		}*/
		markPriorities(counter, arr);
		shuffle(counter);
		ArrayList<Pokemon> finalTeam = new ArrayList<Pokemon>();
		for(int i = counter.size()-1; i >= 0;i--){
			if(counter.get(i).isPriority()){
				finalTeam.add(counter.get(i));
				if(!types.contains(counter.get(i).type1)){
					types.add(counter.get(i).type1);
				}
				if(!counter.get(i).type2.equals("NULL")){
					if(!types.contains(counter.get(i).type2)){
						types.add(counter.get(i).type2);
					}
				}
				counter.remove(i);
			}
		}
		for(int i = counter.size()-1; i >= 0; i--){
			if(finalTeam.size() < 6){
				if(!types.contains(counter.get(i).type1)||!types.contains(counter.get(i).type2)){
					finalTeam.add(counter.get(i));
					for(int l = counter.size()-1; l >= counter.size(); l--){
						if(counter.get(l).equals(counter.get(i))&&i!=l){
							counter.remove(l);
						}
					}
						
					counter.remove(i);
				}
			}
		}
		
		while(finalTeam.size()<6){
			if(!finalTeam.contains(counter.get(0))){
				finalTeam.add(counter.get(0));
			}
			counter.remove(0);
			shuffle(counter);
		}

		return finalTeam;
	}
	
	public static boolean typeExists(Pokemon p, ArrayList<typeFreq> w){
		for(int i = 0; i < w.size();i++){
			if(p.type1.equals(w.get(i).getType())||p.type2.equals(w.get(i).getType())){
				return true;
			}
		}
		return false;
	}
	
	public static void markPriorities(ArrayList<Pokemon> pkmn, ArrayList<typeFreq> w){
		//HashMap<String, Integer> h = new HashMap<String,Integer>();
		//Find pokemon types who are more frequent and mark pokemon of those types as priority
		for(int i = 0; i < pkmn.size(); i++){
			for(int j = 0; j < w.size();j++){
				if(pkmn.get(i).type1.equals(w.get(j).getType())||pkmn.get(i).type2.equals(w.get(j).getType())){
					if(w.get(j).getFrequency() > 1){
						pkmn.get(i).setAsPriority();
						System.out.println((pkmn.get(i).print()));
						if(pkmn.get(i).type1.equals(w.get(j).getType()))
							System.out.println(" is a priority because it's " + pkmn.get(i).type1 + " and that type occurs " + w.get(j).getFrequency() + " as a weakness.");
						if(pkmn.get(i).type2.equals(w.get(j).getType()))
							System.out.println(" is a priority because it's " + pkmn.get(i).type2  + " and that type occurs " + w.get(j).getFrequency() + " as a weakness.");
					}
				}
			}
		}
	}
	
	public static void shuffle(ArrayList<Pokemon> arr){
		Random r = new Random();
		int rand = 0;
		Pokemon p;
		for(int i = 0; i < arr.size(); i++){
			rand = r.nextInt(arr.size());
			p = arr.get(rand);
			System.out.println(rand);
			arr.remove(rand);
			arr.add(p);
		}
		
	}
	
	//Sorting to see which types are more important to have a counter to 
	public static ArrayList<typeFreq> sortByValue(ArrayList<typeFreq> arr){
		int maxVal = Integer.MIN_VALUE;
		typeFreq max = null;
		int maxLoc = 0;
		typeFreq temp = null;
		for(int i = 0; i < arr.size(); i++){
			maxLoc = i;
			max = arr.get(i);
			for(int j = i+1; j < arr.size(); j++){
				if(arr.get(j).getFrequency() > max.getFrequency()){
					//maxVal = arr.get(j).getFrequency();
					maxLoc = j;
					max = arr.get(j);
				}
			}
			
			//System.out.println("Minimum type at " + i + " is " + min.getType() +  " at " + min.getFrequency() + " located at " + minLoc);
			temp = arr.get(maxLoc);
			arr.set(maxLoc, arr.get(i));
			arr.set(i, temp);
		}
		return arr;
	}
	
	static ArrayList<Pokemon> runTeamBuilder(ArrayList<Pokemon> arr){
		instantiateDB();
		System.out.println("db");
		ArrayList<typeFreq> freq = getWeaknessFrequency(arr);
		System.out.println("weakness");
		freq = sortByValue(freq);
		System.out.println("sort weakness");
		ArrayList<Pokemon> x = counterTeam(freq,arr);
		
		System.out.println("produce counter");
		return x;
	}
	
	
	public static void main(String[]args){
		
		ArrayList arr = new ArrayList<Pokemon>();
		/*arr.add(6);
		arr.add(73);
		arr.add(18);
		arr.add(45);
		arr.add(40);
		arr.add(62);*/
		//arr.add(9);
		//arr.add(55);
		//arr.add(80);
		//arr.add(131);
		//arr.add(9);
		instantiateDB();
		arr.add(instantiatePokemon("mewtwo"));
		arr.add(instantiatePokemon("mew"));
		arr.add(instantiatePokemon("articuno"));
		arr.add(instantiatePokemon("moltres"));
		arr.add(instantiatePokemon("zapdos"));
		arr.add(instantiatePokemon("dragonite"));
		
		ArrayList<Pokemon> x = runTeamBuilder(arr);
		System.out.println(x.size());
		for(int i = 0; i < x.size();i++){
			System.out.println(x.get(i).print());
		}
		
		/*ArrayList<typeFreq> freq = getWeaknessFrequency(arr);
		freq = sortByValue(freq);
		/*for(int i = 0; i < freq.size();i++){
			System.out.println(freq.get(i).getType() + ": " + freq.get(i).getFrequency());
		}*/
		//ArrayList<Pokemon> x = counterTeam(freq,arr);
		
		//markPriorities(x, freq);
		//int maxVal = (Collections.max(freq.values()));
		//String maxKey = freq.getKey(maxVal);
		//getWeakness(arr);
	}
	
}
