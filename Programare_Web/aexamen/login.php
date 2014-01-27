<?php
if(isset($_POST['myusername'])&&isset($_POST['mypassword']))
	if($_POST['myusername']!=""&&$_POST['mypassword']!=""){
		include 'command.php';
		$ok=get_user($_POST['myusername'],$_POST['mypassword']);
		if($ok==1){
			header( "refresh:3;url=main.php" );
			session_start();
			$_SESSION['logged']=$_POST['myusername'];
			echo "<h2>Autentificare efectuata cu succes!</h2>Bine ai venit <b>".$_POST['myusername']."</b><br>Veti fi redirectionati catre pagina principala";
		}
		else{
			header( "refresh:3;url=index.php" );
			//echo $users."-->".$_POST['user']."~".$_POST['pass'];
			echo '<h2>EROARE! User sau parola gresite!</h2>Introduceti din nou';
		}	
		}
	else{
		header( "refresh:3;url=index.php" );
		echo '<h2>EROARE! Dati si userul si parola!</h2>';
	}
else{
	header( "refresh:3;url=index.php" );
	echo '<h2>EROARE! Dati si userul si parola!</h2>';

}




?>