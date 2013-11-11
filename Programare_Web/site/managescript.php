<!DOCTYPE HTML>
<?php
include_once 'repository.php';
$lista = new ListaUtilaje();
setcookie("log", "DA", time()+36000);
?>
<html>
<title> Administrare </title>
<body bgcolor="black">
<font color="red" size=7>

<?php
	//include 'repository.php';
	$lista = new ListaUtilaje();
	if($_POST["y"])
		$lista->del($_COOKIE["ind"]);
		//echo $_COOKIE["ind"];
		//header('Location: admin.php');
	if($_POST["n"])
		header('Location: admin.php');
	if($_POST["back"])
		header('Location: admin.php');
	if($_POST["okadd"])	{
		$op=0;
		if($_POST["co1"])
			$op=1;
		if($_POST["co2"])
			$op=2;
		if($_POST["co3"])
			$op=3;
		if($_POST["co4"])
			$op=4;
		if($_POST["co5"])
			$op=5;
		$u=new Utilaj($_POST["nume"],$op,$_POST["desc"],"");
		$lista->add($u);
		header('Location: admin.php');
	}
	if($_POST["okadd"])	{
		$op=0;
		if($_POST["co1"])
			$op=1;
		if($_POST["co2"])
			$op=2;
		if($_POST["co3"])
			$op=3;
		if($_POST["co4"])
			$op=4;
		if($_POST["co5"])
			$op=5;
		$u=new Utilaj($_POST["nume"],$op,$_POST["desc"],"");
		$lista->mod($_COOKIE["ind"],$u);
		header('Location: admin.php');
	}
	
	
?>