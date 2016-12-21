package org.pokedexgo.com;
import java.sql.*;
	
public class Pokemon {
	int id;
	boolean priority = false;
	String description = "";
	String name = "";
	String type1 = "";
	String type2 = "";
	String ability1 = "";
	int b_atk = 0, b_def = 0, b_hp = 0, b_spdef = 0, b_spatk = 0, b_spd = 0;
	static Statement s = null;
	static Connection conn = null;
	static ResultSet rs = null;
	public void instantiateDB(){
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
	
	public Pokemon(int id, String name, String type1, String type2, int b_hp, int b_atk, int b_def, int b_spatk, int b_spdef, int b_spd){
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.b_hp = b_hp;
		this.b_spatk = b_spatk;
		this.b_spdef = b_spdef;
		this.b_spd = b_spd;
		this.b_atk = b_atk;
		this.b_def = b_def;
	}
	
	public String print(){
		if(type2.equals("NULL"))
			return (id + ": " + name + "\n" + type1 + "\n" + b_hp + "/" + b_atk + "/" + b_def + "/" + b_spatk + "/" + b_spdef + "/" + b_spd + "");
		else
			return (id + ": " + name + "\n" + type1+ "/" + type2 + "\n" + b_hp + "/" + b_atk + "/" + b_def + "/" + b_spatk + "/" + b_spdef + "/" + b_spd + "");
	}
	
	public Pokemon(String name){
		this.name = name;
		//this.type1 = type1;
		//this.type2 = type2;
		instantiateDB();
		try {
			//System.out.println("select id,type1, type2, base_hp, base_atk, base_def, base_spdef, base_spatk, base_spd from pokemon where name = '" + name + "';");
			rs = s.executeQuery("select id,type1, type2, base_hp, base_atk, base_def, base_spdef, base_spatk, base_spd, description, ability1 from pokemon where name = '" + name + "';");
			while(rs.next()){
				id = (int) rs.getObject("id");
				b_hp = (int) rs.getObject("base_hp");
				b_atk = (int) rs.getObject("base_atk");
				b_def = (int) rs.getObject("base_def");
				b_spatk = (int) rs.getObject("base_spatk");
				b_spdef = (int) rs.getObject("base_spdef");
				b_spd = (int) rs.getObject("base_spd");
				type1 = (String) rs.getObject("type1");
				type2 = (String) rs.getObject("type2");
				description = (String)rs.getString("description");
				ability1 = (String)rs.getObject("ability1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pokemon(int id){
		this.id = id;
		//this.type1 = type1;
		//this.type2 = type2;
		instantiateDB();
		try {
			rs = s.executeQuery("select name,type1, type2, base_hp, base_atk, base_def, base_spdef, base_spatk, base_spd from pokemon where id = " + id + ";");
			while(rs.next()){
				name = (String) rs.getObject("name");
				b_hp = (int) rs.getObject("base_hp");
				b_atk = (int) rs.getObject("base_atk");
				b_def = (int) rs.getObject("base_def");
				b_spatk = (int) rs.getObject("base_spatk");
				b_spdef = (int) rs.getObject("base_spdef");
				b_spd = (int) rs.getObject("base_spd");
				type1 = (String) rs.getObject("type1");
				type2 = (String) rs.getObject("type2");
				description = (String)rs.getString("description");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getID(){
		return id;
	}
	
	public void setAsPriority(){
		priority = true;
	}
	
	public boolean isPriority(){
		return priority;
	}
	
}
