<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<body>	
	<center>Submit your own idea of a moveset for <%= session.getAttribute("name") %></center>
	<form action='/PokedexGo/MovesetUpdateServlet' method="post">
		
		 <center><label for = "pkmn_name">Nature: <input type="text" name="nature" id="nature" ><br></center>
		<center><label for = "pkmn_name">Ability: <input type="text" name="ability" id="ability" ><br></center>
		<center><label for = "pkmn_name">HP EV:  <input type="text" name="hp_ev" id="hp_ev" ></center> 
		<center><label for = "pkmn_name">Atk EV: <input type="text" name="atk_ev" id="atk_ev" ></center>
		<center><label for = "pkmn_name">Def EV:  <input type="text" name="def_ev" id="def_ev" ></center>
		<center><label for = "pkmn_name">Sp. Attack EV: <input type="text" name="spatk_ev" id="spatk_ev" ><br></center>
		<center><label for = "pkmn_name">Sp. Def EV: <input type="text" name="spdef_ev" id="spdef_ev" ><br></center>
		<center><label for = "pkmn_name">Spd EV: <input type="text" name="spd_ev" id="spd_ev" ><br></center> 
 		<center><label for = "pkmn_name">Move1 </label> <input type="text" name="pkmn_m1" id="pkmn_m1" ><br></center>
 		<center><label for = "pkmn_name">Move2 </label> <input type="text" name="pkmn_m2" id="pkmn_m2" ><br></center>
 		<center><label for = "pkmn_name">Move3 </label> <input type="text" name="pkmn_m3" id="pkmn_m3" ><br></center>
 		<center><label for = "pkmn_name">Move4 </label> <input type="text" name="pkmn_m4" id="pkmn_m4" ><br></center>
 		<div id="pkmn_list"></div>
 		<input type='submit' value='Submit!' id="submit" >
	</form>
	<input type=button onClick="location.href='../html/menu.html'" value='back' id="back" >
	<img></img>
		
</body>
</body>
</html>