package org.pokedexgo.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovesetUpdateServlet
 */
//@WebServlet("/MovesetUpdateServlet")
public class MovesetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovesetUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		
		String m1 ="", m2="",m3="",m4="",name="";
		//int hp = 0;
		int hp = 0,atk = 0, def = 0, spatk = 0, spdef = 0, spd = 0;
		//String hp = "",atk = "", def = "", spatk = "", spdef = "", spd = "";
		String nature = "";
		String ability = "";
		//Pokemon p = new Pokemon("name");
		name = (String) request.getSession().getAttribute("name");
		String temp = "";
			
		
		nature = request.getParameter("nature");
		ability = request.getParameter("ability");
		temp = request.getParameter("hp_ev");
		hp = Integer.parseInt((String)request.getParameter("hp_ev"));
		if(temp!= null){
			hp = Integer.parseInt(request.getParameter("hp_ev").trim());
		}
		temp = request.getParameter("atk_ev");
		if(temp!= null){
			atk = Integer.parseInt(temp.trim());
		}
		
		temp = request.getParameter("def_ev");
		if(temp!= null){
			def = Integer.parseInt(temp);
		}
		temp = request.getParameter("spatk_ev");
		if(temp!= null){
			spatk = Integer.parseInt(temp);
		}
		temp = request.getParameter("spdef_ev");
		if(temp!= null){
			spdef = Integer.parseInt(temp);
		}
		temp = request.getParameter("spd_ev");
		if(temp!= null){
			spd = Integer.parseInt(temp);
		}
		/*if(request.getParameter("atk_ev").trim().compareTo("") == 0){
			atk = Integer.parseInt(request.getParameter("hp_ev")) ;
		}
		if(request.getParameter("def_ev").trim().compareTo("") == 0){
			def = Integer.parseInt(request.getParameter("hp_ev")) ;
		}
		if(request.getParameter("spatk_ev").trim().compareTo("") == 0){
			spatk = Integer.parseInt(request.getParameter("hp_ev")) ;
		}
		if(request.getParameter("spdef_ev").trim().compareTo("") == 0){
			spdef = Integer.parseInt(request.getParameter("hp_ev")) ;
		}
		if(request.getParameter("spd_ev").trim().compareTo("") == 0){
			spd = Integer.parseInt(request.getParameter("hp_ev")) ;
		}*/
		
		m1 = request.getParameter("pkmn_m1");
		m2 = request.getParameter("pkmn_m2");
		m3 = request.getParameter("pkmn_m3");
		m4 = request.getParameter("pkmn_m4");
		//out.write(name + m1 + m2 + m3 + m4);
		DBManager dbm = new DBManager();
		DBManager.insertMovesets(name, m1, m2, m3, m4, hp, atk, def, spatk, spdef, spd, nature, ability);
		
		
		response.sendRedirect("jsp/PokemonInfo.jsp");
		
	}

}
