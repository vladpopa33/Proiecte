<?php
session_start();
if($_SESSION['logged']=='yes'){
	echo '<html><head><title>Adauga curse</title></head><body><h4>Adauga cursa</h4>';
	echo '<form action="command.php" method="GET">Localitate plecare:<input type="text" name="lplec"><br>Localitate sosire:<input type="text" name="lsos"><br>Ora plecare:<input type="text" name="orap"><br>Ora sosire:<input type="text" name="oras"><input type="hidden" name="do" value="0"><br><input type="submit" value="Adauga"></form>';
	echo '</html>';
}
else{
	header( "refresh:3;url=index.html" );
	echo '<h2>EROARE! Nu sunteti autentificat!</h2>Veti fi redirectionati inapoi';
}
?>