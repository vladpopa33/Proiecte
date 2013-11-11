<!DOCTYPE HTML>
<html>
<title> Administrare </title>
<body bgcolor="black">
<font color="red" size=7>

<?php
include 'repository.php';
if(($_POST["user"]=="admin" and $_POST["pass"]=="andor") or $_COOKIE["log"]=="DA"){
	$lista = new ListaUtilaje();
	$dir="vehicule";
	$i=0;
	echo '<form action="manage.php" method="post">';
	echo '<table border="1">';
	/*
	if (is_dir($dir)) {
	    if ($dh = opendir($dir)) {
	        while (($file = readdir($dh)) !== false) {
	        	if (substr($file,8)==".JPG"){
		            echo "<tr><td>";
		            echo "filename: .".$file." ".$i;
		            echo "</td><td>";
		            echo '<img src="'.'vehicule/'.$file.'"/>';
		            echo '</td><td>';
					echo "<input type='radio' name='r".($i++)."'' value=''>";
		            echo '</td></tr>';
	        	}
	        }
	        closedir($dh);
	    }*/
	echo "<tr><td>Nume</td><td>Categorie</td><td>Descriere</td><td>Imagine</td></tr>";
	while($i<$lista->lung()){
					$lista->getpoze("Buldozer galben");
				    echo "<tr><td>";
		            echo $lista->ret($i)->nume;
		            echo "</td><td>";
		            $k=$lista->ret($i)->categorie;
		         	echo $Categ[$k];
		            echo "</td><td>";
		            echo $lista->ret($i)->descriere;
		            echo "</td><td>";
		            //thumb.php?src=/artimg/raul-300x202.jpg&h=125&w=125&zc=1
		            //echo '<img src="thumb.php?src=/Poze Utilaje/'.$lista->ret($i)->poza.'&h=125&w=125&zc=1"/>';
		            echo '<img src="'.'vehicule/'.$lista->ret($i)->poza.'"/>';
		            echo '</td><td>';
					echo "<input type='radio' name='r".($i++)."'' value=''>";
		            echo '</td></tr>';
	}
	$j=0;
	//for(j=0;j<i;j++)
	echo '</table>';
	echo '<input type="submit" value="Adauga" name="add">';
	echo '<input type="submit" value="Modifica" name="edit">';
	echo '<input type="submit" value="Sterge" name="del" >';
	echo '<input type="submit" value="Inapoi" name="back">';
	echo "</form>";

	}
else
	echo "Logare esuata! <br />";
?>
</font>
</body>
</html>
