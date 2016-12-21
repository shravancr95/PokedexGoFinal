package org.pokedexgo.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saveTeam
 */
//@WebServlet("/saveTeam")
public class saveTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveTeam() {
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
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		String trainer = request.getParameter("t_name");
		String notes = request.getParameter("note");
		
		if(notes == null){
			notes = "";
		}
		
		if(trainer == null){
			trainer = "";
		}
		
		String pkmn1 = (String) request.getSession().getAttribute("pkmn0");
		String pkmn2 = (String) request.getSession().getAttribute("pkmn1");
		String pkmn3 = (String) request.getSession().getAttribute("pkmn2");
		String pkmn4 = (String) request.getSession().getAttribute("pkmn3");
		String pkmn5 = (String) request.getSession().getAttribute("pkmn4");
		String pkmn6 = (String) request.getSession().getAttribute("pkmn5");
		
		PrintWriter out = response.getWriter();
		db.saveTeam(trainer, pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, notes);
		response.sendRedirect("jsp/saveConfirm.jsp");
		//out.println(pkmn1 + ","+trainer +","+ notes);
		//doGet(request, response);
		
	}

}
