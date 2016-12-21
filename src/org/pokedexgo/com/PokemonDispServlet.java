package org.pokedexgo.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PokemonDispServlet
 */
//@WebServlet("/PokemonDispServlet")
public class PokemonDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn = null;
	static Statement s = null;
	ResultSet rs = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokemonDispServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		/*try {
			Class.forName("org.sqlite.JDBC.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/Users/SCanchiRadhakrishna/Pokedex.db");
			if(s==null){System.out.println("yo conn null here");}
			s = conn.createStatement();
			if(s==null){System.out.println("yo s  null here");}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Successful set up");*/
		//response.sendRedirect("PokemonInfo.jsp");
		String name = request.getParameter("pkmn_name");
		String description = "", type1 = "", type2 = "", ability1 = "", ability2 = "";
		int id = 0;
		/*try {
			s = conn.createStatement();
			if(s==null){System.out.println("S is null");}
			rs = s.executeQuery("SELECT * from pokemon where name = '" + name + "';");
			while(rs.next()){
				description = (String) rs.getObject("description");
				type1 = (String) rs.getObject("type1");
				type2 = (String) rs.getObject("type2");
				id = (int) rs.getObject("id");
				System.out.println(description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}*/
		DBManager dbm = new DBManager();
		//dbm.instantiateDB();
		Pokemon p = DBManager.getPokemon(name);
		ArrayList<String> competitiveSets = dbm.getCompSet(name);
		String allCompSets = "";
		out.println(allCompSets);
		for(int i = 0; i < competitiveSets.size();i++){
			//allCompSets = allCompSets + "<img src ='images/<%=session.getAttribute('pkmn_id')%>.png' /> ";
			allCompSets += competitiveSets.get(i) + "\n" ;
		}
		
		//out.println(allCompSets);
		
		request.getSession().setAttribute("pkmn_name", p.name.substring(0, 1).toUpperCase()+p.name.substring(1));
		//request.getSession().setAttribute("pkmn_description", description);
		request.getSession().setAttribute("pkmn_type", p.type1);
		if(!type2.equals("NULL")){
			request.getSession().setAttribute("pkmn_type1", p.type1);
			request.getSession().setAttribute("pkmn_type2", p.type2);
		}
		else{
			request.getSession().setAttribute("pkmn_type1", p.type1);
			request.getSession().setAttribute("pkmn_type2", "none");
		}
		
		
		request.getSession().setAttribute("description", p.description);
		request.getSession().setAttribute("pkmn_id", p.id);
		request.getSession().setAttribute("competitiveSets", allCompSets);
		//out.println(allCompSets);
		response.sendRedirect("jsp/PokemonInfo.jsp");
		
		//
		//getServletContext().getRequestDispatcher("jsp/PokemonInfo.jsp").forward(request, response);
		//response.sendRedirect("MyFirstJSP.jsp?fname="+firstname+"&lname="+request.getParameter("lname")+"");
	}

	
}

