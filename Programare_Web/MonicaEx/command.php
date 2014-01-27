<?php
session_start();
function get_sosiri(){
	$tables='<table><tr><th>Oras plecare</th><th>Ora sosire</th></tr>';
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $sosire=mysql_real_escape_string($_GET['sosire']);
    $result = mysqli_query($con,"SELECT * FROM `curse` WHERE orassosire='$sosire' ORDER BY orasosire DESC LIMIT 5");
    $i=0;
    while($row = mysqli_fetch_array($result)){
    		$i++;
            $tables=$tables."<tr><td>".$row['orasplecare']."</td><td>".$row['orasosire'].'</td></tr>';
            }
    mysqli_close($con);
    $tables=$tables."</table>";
    echo $tables;
}
function get_plecari(){
    $tables='<table><tr><th>Oras destinatie</th><th>Ora plecare</th></tr>';
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $plecare=mysql_real_escape_string($_GET['plecare']);
    $result = mysqli_query($con,"SELECT * FROM `curse` WHERE orasplecare='$plecare' ORDER BY oraplecare DESC LIMIT 5");
    $i=0;
    while($row = mysqli_fetch_array($result)){
            $i++;
            $tables=$tables."<tr><td>".$row['orassosire']."</td><td>".$row['oraplecare'].'</td></tr>';
            }
    mysqli_close($con);
    $tables=$tables."</table>";
    echo $tables;
}
function get_user($nume,$parola){
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"SELECT * FROM `users` WHERE 1");
    $ok=0;
    while($row = mysqli_fetch_array($result)){
    		if($row['username']==$nume&&$row['password']==$parola)
    			$ok=1;
            }
    mysqli_close($con);
    return $ok;
}
function add_cursa(){
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $plecare=$_GET['lplec'];
    $sosire=$_GET['lsos'];
    $oraplecare=$_GET['orap'];
    $orasosire=$_GET['oras'];
    //$continut=mysql_real_escape_string($continut);
    $result = mysqli_query($con,"INSERT INTO `curse`(orasplecare, orassosire, oraplecare, orasosire) VALUES ('$plecare','$sosire','$oraplecare','$orasosire')");
    mysqli_close($con);
    header( "refresh:3;url=main.php" );
    echo 'Adaugat cu succes!';
    return;
}

if(isset($_GET['do'])){
    if($_GET['do']=='0'&&$_SESSION['logged']!='yes')
            add_cursa();
    if($_GET['do']=='1')
            get_plecari();
    if($_GET['do']=='2')
        get_sosiri();
}



?>