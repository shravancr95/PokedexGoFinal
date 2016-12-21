<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>

 $(function() {
	
   var pokemon = ["bulbasaur","ivysaur","venusaur","charmander","charmeleon","charizard","squirtle","wartortle","blastoise","caterpie","metapod","butterfree","weedle","kakuna","beedrill","pidgey","pidgeotto","pidgeot","rattata","raticate","spearow","fearow","ekans","arbok","pikachu","raichu","sandshrew","sandslash","nidoran♀","nidorina","nidoqueen","nidoran♂","nidorino","nidoking","clefairy","clefable","vulpix","ninetails","jigglypuff","wigglytuff","zubat","golbat","oddish","gloom","vileplume","paras","parasect","venonat","venomoth","diglett","dugtrio","meowth","persian","psyduck","golduck","mankey","primeape","growlithe","arcanine","poliwag","poliwhirl","poliwrath","abra","kadabra","alakazam","machop","machoke","machamp","bellsprout","weepinbell","victreebel","tentacool","tentacruel","geodude","graveler","golem","ponyta","rapidash","slowpoke","slowbro","magnemite","magneton"," farfetchd","doduo","dodrio","seel","dewgong","grimer","muk","shellder","cloyster","gastly","haunter","gengar","onix","drowzee","hypno","krabby","kingler","voltorb","electrode","exeggcute","exeggutor","cubone","marowak","hitmonlee","hitmonchan","lickitung","koffing","weezing","rhyhorn","rhydon","chansey","tangela","kangaskhan","horsea","seadra","goldeen","seaking","staryu","starmie","mr. mime","scyther","jynx","electabuzz","magmar","pinsir","tauros","magikarp","gyarados","lapras","ditto","eevee","vaporeon","jolteon","flareon","porygon","omanyte","omastar","kabuto","kabutops","aerodactyl","snorlax","articuno","zapdos","moltres","dratini","dragonair","dragonite","mewtwo","mew"];
	 
   $( "#pkmn_name" ).autocomplete({
      source: pokemon
   });
});
</script>
<title>Nickname Suggestion</title>
</head>
<body>
<center>
Suggest a Nickname for a Pokemon! 
<form action="/PokedexGo/NicknameServlet" method="post">
	<br>
	<label for = "pkmn_name">Pokemon:</label><input type='text' name="pkmn_name" id="pkmn_name"><br>
	Nickname:<input type='text' name="nickname" id="nickname"><br>
	Give a short explanation for the nickname: <input type='text' name="pkmn_name" id="nickname_explanation"><br>
	<button type="submit" name="option" value="suggest this nickname!" onClick="alertFunc()">Suggest this nickname</button><br>
	
</form>

<form action="/PokedexGo/FindNicknameServlet" method="post">
	    <br>
	Find Nicknames that others suggested for some Pokemon!<br>
	<label for = "pkmn_name">Pokemon:<input type='text' name="pkmn_name" id="pkmn_name"><br>
    <input type="submit" name="option" value="find nicknames!"><br>
</form>
</center>
</body>
</html>