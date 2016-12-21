package org.pokedexgo.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NicknameServlet
 */
//@WebServlet("/NicknameServlet")
public class NicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NicknameServlet() {
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
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String nickname = "";
		String pkmnName = "";
		String explanation = "";
		DBManager db = new DBManager();
		
	    // Invoke adding to db
		nickname = request.getParameter("nickname");
		pkmnName = request.getParameter("pkmn_name");
		explanation = request.getParameter("nickname_explanation");
		db.addNickname(nickname, pkmnName, explanation);
		request.getSession().setAttribute("pkmn_name", pkmnName);
		response.sendRedirect("jsp/NicknameSubmissionConfirmation.jsp");
		
		//out.println("<center>Your nickname has been submitted!</center><br>");
		//.action.out.println("<center><button type='submit' onClick=" + "\""+"location.href=" + "'../jsp/Nickname.jsp'"+ "\"" + "></center>");
		
	}

}
