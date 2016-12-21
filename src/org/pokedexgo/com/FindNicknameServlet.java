package org.pokedexgo.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNicknameServlet
 */
//@WebServlet("/FindNicknameServlet")
public class FindNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNicknameServlet() {
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
		PrintWriter out1 = response.getWriter();
		DBManager dbm = new DBManager();
		ArrayList <nicknameInfo> nn;
		if(request.getParameter("pkmn_name") == null || request.getParameter("pkmn_name").equals("")){
			nn = dbm.getNicknames("select * from nicknames;");
			
		}
		else{
			//nn = dbm.getNicknames("select * from nicknames where pokemon_name = '"+request.getParameter("pokemon_name")+"';");
			nn = dbm.getNicknames("select * from nicknames where pokemon_name = '"+"charizard"+"';");
			//out.println("There is a parameter");
		}
		String out = "";
		for(int i = 0; i < nn.size(); i++){
			out+="<tr>";
			out+="<td><img src = 'images/" + nn.get(i).id + " icon.png' /></td>";
			out+="<td>" + nn.get(i).pokemonName + "</td>";
			out+="<td>" + nn.get(i).nickname + "</td>";
			out+="<td>" + nn.get(i).reasoning + "</td>";
			out+="</tr>";
		}
		request.getSession().setAttribute("rows", out);
		response.sendRedirect("jsp/NicknameDisplay.jsp");
		//out.println(x);
		//nn = dbm.getNicknames("select * from nicknames;");
		/*for(int i =0 ; i < nn.size();i++){
			out.println(nn.get(i).print());
		}*/
	}

}
