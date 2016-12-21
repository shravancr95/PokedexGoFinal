<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>

 $(function() {
	
   var pokemon = ["bulbasaur","ivysaur","venusaur","charmander","charmeleon","charizard","squirtle","wartortle","blastoise","caterpie","metapod","butterfree","weedle","kakuna","beedrill","pidgey","pidgeotto","pidgeot","rattata","raticate","spearow","fearow","ekans","arbok","pikachu","raichu","sandshrew","sandslash","nidoran♀","nidorina","nidoqueen","nidoran♂","nidorino","nidoking","clefairy","clefable","vulpix","ninetails","jigglypuff","wigglytuff","zubat","golbat","oddish","gloom","vileplume","paras","parasect","venonat","venomoth","diglett","dugtrio","meowth","persian","psyduck","golduck","mankey","primeape","growlithe","arcanine","poliwag","poliwhirl","poliwrath","abra","kadabra","alakazam","machop","machoke","machamp","bellsprout","weepinbell","victreebel","tentacool","tentacruel","geodude","graveler","golem","ponyta","rapidash","slowpoke","slowbro","magnemite","magneton"," farfetchd","doduo","dodrio","seel","dewgong","grimer","muk","shellder","cloyster","gastly","haunter","gengar","onix","drowzee","hypno","krabby","kingler","voltorb","electrode","exeggcute","exeggutor","cubone","marowak","hitmonlee","hitmonchan","lickitung","koffing","weezing","rhyhorn","rhydon","chansey","tangela","kangaskhan","horsea","seadra","goldeen","seaking","staryu","starmie","mr. mime","scyther","jynx","electabuzz","magmar","pinsir","tauros","magikarp","gyarados","lapras","ditto","eevee","vaporeon","jolteon","flareon","porygon","omanyte","omastar","kabuto","kabutops","aerodactyl","snorlax","articuno","zapdos","moltres","dratini","dragonair","dragonite","mewtwo","mew"];
	 
   $( "#pkmn_m1" ).autocomplete({
      source: pokemon
   });
   
   $( "#pkmn_m2" ).autocomplete({
	      source: pokemon
	   });
   $( "#pkmn_m3" ).autocomplete({
	      source: pokemon
	   });
	   
   $( "#pkmn_m4" ).autocomplete({
	      source: pokemon
	   });
   $( "#pkmn_m5" ).autocomplete({
	      source: pokemon
	   });
		   
   $( "#pkmn_m6" ).autocomplete({
	      source: pokemon
	   });
});
</script>
</head>
<body>
Select Your Team of 6 Pokemon
<form action='/PokedexGo/TeamCounterServlet' method="post">
		<center></center>
 		<center><label for = "pkmn_m1">Pokemon 1: </label> <input type="text" name="pkmn_m1" id="pkmn_m1" ><br></center>
 		<center><label for = "pkmn_m2">Pokemon 2: </label> <input type="text" name="pkmn_m2" id="pkmn_m2" ><br></center>
 		<center><label for = "pkmn_m3">Pokemon 3: </label> <input type="text" name="pkmn_m3" id="pkmn_m3" ><br></center>
 		<center><label for = "pkmn_m4">Pokemon 4: </label> <input type="text" name="pkmn_m4" id="pkmn_m4" ><br></center>
 		<center><label for = "pkmn_m5">Pokemon 5: </label> <input type="text" name="pkmn_m5" id="pkmn_m5" ><br></center>
 		<center><label for = "pkmn_m6">Pokemon 6: </label> <input type="text" name="pkmn_m6" id="pkmn_m6" ><br></center>
 		<div id="pkmn_list"></div>
 		<input type='submit' value='Run Analysis!' id="submit" >
</form>
</body>

</html>