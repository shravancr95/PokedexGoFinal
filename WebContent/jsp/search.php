<?php
class MyDB extends SQLite3
{
	function __construct()
	{
		$this->open('/Users/SCanchiRadhakrishna/Pokedex.db');
	}
}
$db = new MyDB();
if(!$db){
	echo $db->lastErrorMsg();
} else {
	echo "Opened database successfully\n";
}
$output = '';
if(isset($_POST['query'])){
$query = "SELECT * from pokemon where name like '%".$_POST["query"]."%'";
	//$query = "SELECT * from pokemon where name like '%char%'";
$sql =<<<EOF
      $query;
EOF;

   $ret = $db->query($sql);
	$output.='<ul class="list-unstyled">';
   while($row = $ret->fetchArray(SQLITE3_ASSOC) ){
      echo "name = ". $row['name'] . "\n";
      $output.='<li>'. $row['name'].'</li>';
   }
   $output.='</ul class="list-unstyled">';
   echo $output;
   //echo "Operation done successfully\n";
}
   $db->close();

?>