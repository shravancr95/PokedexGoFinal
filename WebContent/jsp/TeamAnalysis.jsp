<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>Analysis of your team 

Team you entered is: <br>
<img src = 'images/<%=session.getAttribute("pkmn0id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn0t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn0t2")%>.png' /> <%= session.getAttribute("pkmn0") %><br>
<img src = 'images/<%=session.getAttribute("pkmn1id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn1t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn1t2")%>.png' /> <%= session.getAttribute("pkmn1") %><br>
<img src = 'images/<%=session.getAttribute("pkmn2id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn2t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn2t2")%>.png' /> <%= session.getAttribute("pkmn2") %><br>
<img src = 'images/<%=session.getAttribute("pkmn3id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn3t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn3t2")%>.png' /> <%= session.getAttribute("pkmn3") %><br>
<img src = 'images/<%=session.getAttribute("pkmn4id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn4t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn4t2")%>.png' /> <%= session.getAttribute("pkmn4") %><br>
<img src = 'images/<%=session.getAttribute("pkmn5id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("pkmn5t1")%>.png' /> <img src = 'images/<%=session.getAttribute("pkmn5t2")%>.png' /> <%= session.getAttribute("pkmn5") %><br>

These 6 Pokemon will beat you: <br>
<img src = 'images/<%=session.getAttribute("cpkmn0id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn0t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn0t2")%>.png' /> <%= session.getAttribute("cpkmn0") %><br>
<img src = 'images/<%=session.getAttribute("cpkmn1id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn1t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn1t2")%>.png' /> <%= session.getAttribute("cpkmn1") %><br>
<img src = 'images/<%=session.getAttribute("cpkmn2id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn2t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn2t2")%>.png' /> <%= session.getAttribute("cpkmn2") %><br>
<img src = 'images/<%=session.getAttribute("cpkmn3id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn3t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn3t2")%>.png' /> <%= session.getAttribute("cpkmn3") %><br>
<img src = 'images/<%=session.getAttribute("cpkmn4id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn4t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn4t2")%>.png' /> <%= session.getAttribute("cpkmn4") %><br>
<img src = 'images/<%=session.getAttribute("cpkmn5id")%> icon.png' /> <img src = 'images/<%=session.getAttribute("cpkmn5t1")%>.png' /> <img src = 'images/<%=session.getAttribute("cpkmn5t2")%>.png' /> <%= session.getAttribute("cpkmn5") %><br></center>

<form action="/PokedexGo/saveTeam" method="post">
	  <br>
	If you would like to save this team for later reference<br>
	Trainer Name:<input type='text' name="t_name" id="t_name"><br>
	Notes:<input type='text' name="note" id="note"><br>
    <input type="submit" name="option" value="save"><br>
</form>
</body>
</html>