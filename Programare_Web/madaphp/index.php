<html>
	<head>
		<title>Laborator 6 - PHP</title>
		<link href="Lab6-PHP.css" rel="stylesheet" type="text/css">
		<script src="Lab6-PHP.js" type="text/javascript"></script>
		<script src="jquery-1.10.2.min.js"></script>
	
		<meta charset="utf-8" />
	</head>

	<body>
    	<?php
    		if(isset($_GET['butonulmeu']))
    			$i=$_GET['butonulmeu'];
    		else
    			$i=1;


    		include 'Lab6-PHPcommand.php';
    		echo "<div id='poza'>".get_poze($i).'</div>';
    		echo "<div id='mesaj'>".get_comments($i).'</div>';
    		if($i>1)
    			echo '<div id="butonstg"><form action="Lab6-PHP.php">'.'<input type="hidden" name="butonulmeu" value="'.($i-1).'">'.'<input type="submit" value="Previous"></form></div>';
			if($i<8)
				echo '<div id="butondrt"><form action="Lab6-PHP.php">'.'<input type="hidden" name="butonulmeu" value="'.($i+1).'">'.'<input type="submit" value="Next"></form></div>';  

			echo '<div id="comenteaza">
					<form id="formulmeu" action="Lab6-PHPcommand.php" method="post">
						<table name="guessbook" bgcolor="#006400">
							<tr><td>Nume</td> <td><textarea name="nume" type="text" ></textarea></td></tr><br>
							<tr><td>Mesaj</td> <td><textarea name="mesaj" cols="18" rows="3"></textarea><br></tr>
							<tr><td> <div id="voting"></div>  </td></tr>
							
		
						
						</table>	
					</form>
				  </div>';	

			echo '<div id="voting"></div>';
			
			

    		echo '<form method="post" action="Lab6-PHPview.php"><input type="submit" value="baga()"></form>'		
    		
?>


		<div id="vot">
			<ul id="listadestele">
				<li id=1 onclick="vot(1)"><img class="v" src="star1.png" onmouseover="stea(1)" onmouseout="stea2(1)"/></li>
				<li id=2 onclick="vot(2)"><img class="v" src="star1.png" onmouseover="stea(2)" onmouseout="stea2(2)"/></li>
				<li id=3 onclick="vot(3)"><img class="v" src="star1.png" onmouseover="stea(3)" onmouseout="stea2(3)"/></li>
				<li id=4 onclick="vot(4)"><img class="v" src="star1.png" onmouseover="stea(4)" onmouseout="stea2(4)"/></li>
				<li id=5 onclick="vot(5)"><img class="v" src="star1.png" onmouseover="stea(5)" onmouseout="stea2(5)"/></li>
			</ul>
		</div> 
	</body>
</html>