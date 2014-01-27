<?php
if(isset($_POST['user'])&&isset($_POST['pass']))
	if($_POST['user']!=""&&$_POST['pass']!=""){
		include 'command.php';
		$ok=get_user($_POST['user'],$_POST['pass']);
		if($ok==1){
			header( "refresh:3;url=main.php" );
			session_start();
			$_SESSION['logged']='yes';
			echo "<h2>Autentificare efectuata cu succes!</h2>Bine ai venit <b>".$_POST['user']."</b><br>Veti fi redirectionati catre pagina principala";
		}
		else{
			header( "refresh:3;url=index.html" );
			//echo $users."-->".$_POST['user']."~".$_POST['pass'];
			echo '<h2>EROARE! User sau parola gresite!</h2>Veti fi redirectionati inapoi';
		}	
		}
	else{
		header( "refresh:3;url=index.html" );
		echo '<h2>EROARE! Dati si userul si parola!</h2>Veti fi redirectionati inapoi';
	}
else{
	header( "refresh:3;url=index.html" );
	echo '<h2>EROARE! Dati si userul si parola!</h2>Veti fi redirectionati inapoi';

}




?>