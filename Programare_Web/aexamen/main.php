<?php
	session_start();

	if(isset($_SESSION['logged'])){ //ca util sa nu vada fara sa fie logat
		echo '<html>
		<head>
			<title>Alege</title>
		</head>
		<body>
			<a href="programare.php">Programare</a><br>
			<a href="vizualizare.php">Vizualizeaza</a><br>
			<a href="modificare.php">Modifica</a><br>
			<a href="stergere.php">Sterge</a><br>

		</body>
		</html>';
	}
	else
		echo 'Fraiere nu esti logat!';

?>