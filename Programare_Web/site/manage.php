<!DOCTYPE HTML>
<?php
include_once 'repository.php';
$lista = new ListaUtilaje();
if($_POST["edit"] or $_POST["del"]){
	$choice=0;
	$j=0;
	for($j=0;$j<=$lista->lung();$j++)
		if(isset($_POST["r".$j]))
			$choice=$j;
	setcookie("ind", $choice, time()+36000);
}
?>
<html>
<title> Administrare </title>
<body bgcolor="black">
<font color="red" size=7>

<?
	//include 'repository.php';
	$lista = new ListaUtilaje();
	if($_POST["del"]){
		echo 'Stergere...</br>Esti sigur? ';
		echo '<form action="managescript.php" method="post">';
		echo '<input type="submit" value="Da" name="y">';
		echo '<input type="submit" value="Nu" name="n"></form>';	
	}
	if($_POST["add"]){
		echo 'Adauga utilaj';
		echo '<form action="managescript.php" method="post">';
		echo 'Nume: 	 <input type="text" size=30 value="" name="nume"><br>';
		echo 'Categorie: <select><option value="1" name="co1">Bascula</option><option value="2" name="co2">Excavator</option><option value="3" name="co3">Buldozer</option><option value="4" name="co4">Macara</option><option value="5" name="co1">Autoturism</option></select><br>';
		echo 'Descriere: <input type="text" size=50 value="" name="desc"><br>';
		echo 'Imagini:</br>';
		$l=0;
		$im=array();
		$im=$lista->getpoze($util->nume);
		echo '<table border="1">';
		foreach ($im as $value){
			  echo '<tr><td><img src="vehicule/'.$value.'"></td><td><input type="checkbox" name="c'.$l++.'" value=""></td></tr>';
		}
		echo '</table>';
		echo '<input type="submit" value="Adauga imagine" name="addimg">';
		echo '<input type="submit" value="Sterge imagine" name="delimg">';
		echo '</br><input type="submit" value="Ok" name="okadd">';
		echo '<input type="submit" value="Renunta" name="back"></form>';
		$_COOKIE["ind"]=$lista->lung();
	}
	if($_POST["edit"]){
			$choice=0;
			echo "Modifica utilaj";
			/*$j=0;
			for($j=0;$j<=$lista->lung();$j++)
				if(isset($_POST["r".$j]))
					$choice=$j;*/
			$util=new Utilaj("",0,"","","");
			$util=$lista->ret($_COOKIE["ind"]);
			$text=array("","","","","");
			array_splice($text, $util->categorie, 1, " selected='selected' ");
			echo '<form action="managescript.php" method="post">';
			echo 'Nume: 	 <input type="text" size=30 value="'.$util->nume.'" name="nume"><br>';
			echo 'Categorie: <select><option value="1"'.$text[0].' name="co1">Bascula</option><option value="2"'.$text[1].' name="co2">Excavator</option><option value="3"'.$text[2].' name="co3">Buldozer</option><option value="4"'.$text[3].' name="co4">Macara</option><option value="5"'.$text[4]. 'name="co5">Autoturism</option></select><br>';
		    echo 'Descriere: <input type="text" size=50 value="'.$util->descriere.'" name="desc"><br>';
			echo 'Imagini:';
			echo '<br>';
			$l=0;
			$im=array();
			$im=$lista->getpoze($util->nume);
			echo '<table border="1">';
			foreach ($im as $value){
				  echo '<tr><td><img src="vehicule/'.$value.'"></td><td><input type="checkbox" name="c'.$l++.'" value=""></td></tr>';
			}
			echo '</table>';
			echo '<input type="submit" value="Adauga imagine" name="addimg">';
			echo '<input type="submit" value="Sterge imagine" name="delimg">';
			echo '</br><input type="submit" value="Oke" name="back"></form>';
		}
	if($_POST["back"]){
		header('Location: index.php');
		setcookie("ind", "", time()-3600);
		setcookie("log", "", time()-3600);
	}

?>
</font>
</body>
</html>