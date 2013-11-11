<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">	
<style type="text/css">
div#celula {
padding: 10px;
margin-left: 0px;
width: 690px;
min-height: 150px;
color:red;
margin-top: 0px;
border-radius: 10px;

}
div#detalii {
padding: 10px;
margin-left: 0px;
width: 250px;
height:480px;
color:red;
font-size: 32px;
margin-top: 30px;
border-radius: 10px;
}
div#poza {
padding: 10px;
margin-left: 275px;
width: 400px;
height: 330px;
margin-top: -480px;
border-radius: 10px;
}

div#descr {
padding: 30px;
margin-left: 30px;
width: 700px;
background-color: rgba(0,0,0,0.5);
margin-top: 20px;
border-radius: 10px;


}
#slider {
	margin: 0px auto;
	width: 400px;
	top: 0px;
	height: 300px;
	position: relative;
	overflow: hidden;
	box-shadow: 0px 0px 40px rgba(0,0,0,0.4);
	background: #434343;
}

#slider [id^='image']:target img {
	top: 0;  
	left: 0;
}

#slider [id^='image']:target a {
	background: #fff;
	border: 3px solid #333;
	width: 10px;
	height: 10px;
}

#slider [id^="image"] img {
	position: absolute;
	top: -300px;
	border: 0;
	-moz-transition: top 0.5s ease-in;
	-ms-transition: top 0.5s ease-in;
	-webkit-transition: top 0.5s ease-in;
	-o-transition: top 0.5s ease-in;
}

.slider-nav {
	background: #333;
	width: 16px;
	z-index: 9999;
	height: 16px;


	box-shadow: inset 0px 2px 10px rgba(0,0,0,0.3), 0px 0px 20px rgba(255,255,255,0.4);
	border-radius: 32px;
	position: absolute;

	bottom: 0px;

}
</style>

</head>
<body>

		<?php
		/*
				<div id="submeniu">
		<ul>
			<li><a href="display.php?tip=1" class="submeniub">Bascule</a></li><li><a href="display.php?tip=2" class="submeniub">Excavatoare</a></li><li><a href="display.php?tip=3" class="submeniub">Buldozere</a></li>	<li><a href="display.php?tip=4" class="submeniub">Cilindru/a></li>
		</ul>
		</div>
		*/
		include 'repository.php';
		$lista = new ListaUtilaje();
		$i=0;
		$l=0;
		$lista->getpoze("");
		for($i=0;$i<$lista->lung();$i++){
			if(isset($_GET["tip"]) and $_GET["tip"]!=$lista->ret($i)->categorie)
				echo "";
			else{
				echo '<div id="celula"><div id="detalii">'."Nume: ".$lista->ret($i)->nume."<br>";
				echo "Categorie: ".$Categ[$lista->ret($i)->categorie]."<br>";
				echo 'Descriere:<br>'.$lista->ret($i)->descriere;
				$img=array();
				$img=$lista->getpoze($lista->ret($i)->nume);
				echo '</div><div id="poza">';
				echo '<div id="slider">';
				$j=$l;
				foreach ($img as $value){
					$j++;
					echo '<div id="image-'.$j.'"><a href=""><img src="vehiculefront/'.$value.'.JPG" alt="" /></a>
				<a class="slider-nav" href="#image-'.$j.'"></a></div>';
				}
				echo "</div></div><br></div>";
				$l=$l+20;

			}
		}
		?>



</body>
</html>
		

