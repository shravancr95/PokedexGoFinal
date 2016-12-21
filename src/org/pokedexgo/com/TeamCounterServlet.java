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
 * Servlet implementation class TeamCounterServlet
 */
//@WebServlet("/TeamCounterServlet")
public class TeamCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamCounterServlet() {
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
		ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
			myTeam.add(new Pokemon(request.getParameter("pkmn_m1")));
			myTeam.add(new Pokemon(request.getParameter("pkmn_m2")));
			myTeam.add(new Pokemon(request.getParameter("pkmn_m3")));
			myTeam.add(new Pokemon(request.getParameter("pkmn_m4")));
			myTeam.add(new Pokemon(request.getParameter("pkmn_m5")));
			myTeam.add(new Pokemon(request.getParameter("pkmn_m6")));
		
			
		
		TeamBuilder tb = new TeamBuilder();
		ArrayList<Pokemon> counter = tb.runTeamBuilder(myTeam);
		
		/*out.println("This " + counter.size() + " pokemon wrecks you: ");
		for(int i = 0; i < 6;i++){
			out.println(counter.get(i).print());
		}*/
		
			
		//Pass on my team to the next page
		request.getSession().setAttribute("pkmn0", myTeam.get(0).name);
		request.getSession().setAttribute("pkmn1", myTeam.get(1).name);
		request.getSession().setAttribute("pkmn2", myTeam.get(2).name);
		request.getSession().setAttribute("pkmn3", myTeam.get(3).name);
		request.getSession().setAttribute("pkmn4", myTeam.get(4).name);
		request.getSession().setAttribute("pkmn5", myTeam.get(5).name);
		
		request.getSession().setAttribute("pkmn0t1", myTeam.get(0).type1);
		request.getSession().setAttribute("pkmn1t1", myTeam.get(1).type1);
		request.getSession().setAttribute("pkmn2t1", myTeam.get(2).type1);
		request.getSession().setAttribute("pkmn3t1", myTeam.get(3).type1);
		request.getSession().setAttribute("pkmn4t1", myTeam.get(4).type1);
		request.getSession().setAttribute("pkmn5t1", myTeam.get(5).type1);
		request.getSession().setAttribute("pkmn0t2", myTeam.get(0).type2);
		request.getSession().setAttribute("pkmn1t2", myTeam.get(1).type2);
		request.getSession().setAttribute("pkmn2t2", myTeam.get(2).type2);
		request.getSession().setAttribute("pkmn3t2", myTeam.get(3).type2);
		request.getSession().setAttribute("pkmn4t2", myTeam.get(4).type2);
		request.getSession().setAttribute("pkmn5t2", myTeam.get(5).type2);
		
		request.getSession().setAttribute("pkmn0", myTeam.get(0).name);
		request.getSession().setAttribute("pkmn1", myTeam.get(1).name);
		request.getSession().setAttribute("pkmn2", myTeam.get(2).name);
		request.getSession().setAttribute("pkmn3", myTeam.get(3).name);
		request.getSession().setAttribute("pkmn4", myTeam.get(4).name);
		request.getSession().setAttribute("pkmn5", myTeam.get(5).name);
		
		
		
		request.getSession().setAttribute("pkmn0id", myTeam.get(0).id);
		request.getSession().setAttribute("pkmn1id", myTeam.get(1).id);
		request.getSession().setAttribute("pkmn2id", myTeam.get(2).id);
		request.getSession().setAttribute("pkmn3id", myTeam.get(3).id);
		request.getSession().setAttribute("pkmn4id", myTeam.get(4).id);
		request.getSession().setAttribute("pkmn5id", myTeam.get(5).id);
		
		request.getSession().setAttribute("cpkmn0", counter.get(0).name);
		request.getSession().setAttribute("cpkmn1", counter.get(1).name);
		request.getSession().setAttribute("cpkmn2", counter.get(2).name);
		request.getSession().setAttribute("cpkmn3", counter.get(3).name);
		request.getSession().setAttribute("cpkmn4", counter.get(4).name);
		request.getSession().setAttribute("cpkmn5", counter.get(5).name);
		
		request.getSession().setAttribute("cpkmn0id", counter.get(0).id);
		request.getSession().setAttribute("cpkmn1id", counter.get(1).id);
		request.getSession().setAttribute("cpkmn2id", counter.get(2).id);
		request.getSession().setAttribute("cpkmn3id", counter.get(3).id);
		request.getSession().setAttribute("cpkmn4id", counter.get(4).id);
		request.getSession().setAttribute("cpkmn5id", counter.get(5).id);
		
		request.getSession().setAttribute("cpkmn0t1", counter.get(0).type1);
		request.getSession().setAttribute("cpkmn1t1", counter.get(1).type1);
		request.getSession().setAttribute("cpkmn2t1", counter.get(2).type1);
		request.getSession().setAttribute("cpkmn3t1", counter.get(3).type1);
		request.getSession().setAttribute("cpkmn4t1", counter.get(4).type1);
		request.getSession().setAttribute("cpkmn5t1", counter.get(5).type1);
		request.getSession().setAttribute("cpkmn0t2", counter.get(0).type2);
		request.getSession().setAttribute("cpkmn1t2", counter.get(1).type2);
		request.getSession().setAttribute("cpkmn2t2", counter.get(2).type2);
		request.getSession().setAttribute("cpkmn3t2", counter.get(3).type2);
		request.getSession().setAttribute("cpkmn4t2", counter.get(4).type2);
		request.getSession().setAttribute("cpkmn5t2", counter.get(5).type2);
		
		
		
		//pass on counter team to the next page
		response.sendRedirect("jsp/TeamAnalysis.jsp");
		
		
	}

}
