<?php
session_start();
if($_SESSION['logged']=='yes'){
	?>
	<head><title>Meniu principal</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
	<script>
	var menucont = new Array();
	function menuopt(il){
		document.getElementById("main").innerHTML=menucont[il];
	}
	function preview(){
		var el = document.getElementById("preview");
		el.style.display = (el.style.display != 'none' ? 'none' : '' );
		var elem=document.getElementsByTagName("td");
		var cont="<ul>";
		console.log(elem.length);
		var elems=document.getElementsByTagName("textarea");
		for(var i=0;i<elems.length;i++)
			menucont[i]=elems[i].value;
		document.getElementById("preview").innerHTML="<div id='meniu'></div><div id='main'>&nbsp</div>";
		for(var i=0;i<elem.length;i++)
			if(i%3==0){
				cont=cont+"<li class='menu_item' id="+(i/3)+" onclick='menuopt("+(i/3)+")'>"+elem[i].innerHTML+"</li>";
			}
		cont=cont+"</ul>";
		document.getElementById("meniu").innerHTML=cont;
	}
	function functie(op){
		x=document.getElementById("formular");
		c=document.getElementById("continut").innerHTML;
		if(op==1){
			x.innerHTML="<div id='continut'></div><input type='hidden' name='do' value=1>Nume optiune <input type='text' name='opt'><br>Continut optiune <textarea name='cont'></textarea><br><input type='submit' value='Adauga optiune'>";
		}
		if(op==2){
			x.innerHTML="<div id='continut'></div><input type='hidden' name='do' value=2><input type='submit' value='Sterge optiune'>";
		}
		if(op==3){
			x.innerHTML="<div id='continut'></div><input type='hidden' name='do' value=3>Nume nou<input type='text' name='opt'><br><input type='submit' value='Schimba nume'>";
		}
		if(op==4){
			x.innerHTML="<div id='continut'></div><input type='hidden' name='do' value=4>Continut optiune <textarea name='cont'></textarea><br><input type='submit' value='Schimba continutul'>";
		}
		document.getElementById("continut").innerHTML=c;
	}
	</script>
	<?php
	include 'command.php';
	echo '<form><input type="radio" name="opt" onclick="functie(1)">Adauga optiune<input type="radio" name="opt" onclick="functie(2)">Sterge optiune<input type="radio" name="opt" onclick="functie(3)">Schimba nume<input type="radio" name="opt" onclick="functie(4)">Schimba continut</form><br>
	<form id="formular" method="GET" action="command.php"><div id="continut">'.get_continut().'</div></form><form action="logout.php" method="POST"><input type="submit" value="Log out"></form><input type="button" value="Preview" onclick="preview()"><div id="preview" style="display: none;"></div></body>';

}
else{
	header( "refresh:3;url=index.html" );
	echo '<h2>EROARE! Nu sunteti autentificat!</h2>Veti fi redirectionati inapoi';
}
?>