<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><img src = 'images/<%=session.getAttribute("pkmn_id")%>.png' /><br></center>
<center><img src = 'images/<%=session.getAttribute("pkmn_type1")%>.png' /><img src = 'images/<%=session.getAttribute("pkmn_type2")%>.png' /><br></center>
<center><%= session.getAttribute("pkmn_name") %> <br></center>
<center><%= session.getAttribute("pkmn_id") %> <br></center>
<center><%= session.getAttribute("description") %> <br></center>
<center>Example Competitive sets </center>
<center><%= session.getAttribute("competitiveSets") %> </center>
<% session.setAttribute("name",session.getAttribute("pkmn_name")); %>
<center><button value='Suggest a moveset!'  type=button onClick="location.href='SuggestMoveset.jsp'">Suggest a moveset!</button>
	<center><button type="submit" id="nickname" value="Menu" onClick="location.href='../jsp/PokemonDataDisplay.jsp'" >
		Back
	</button></center>
	<button type="submit" id="nickname" value="Menu" onClick="location.href='../html/menu.html'" >
		Menu
	</button></center></center>

</body>
</html>