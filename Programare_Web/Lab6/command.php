<?php
session_start();
function get_continut(){
	$tables='<table><tr><th>Nume</th><th>Continut</th></tr>';
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"SELECT * FROM `continut` WHERE 1");
    $i=0;
    while($row = mysqli_fetch_array($result)){
    		$i++;
            $tables=$tables."<tr><td>".$row['nume']."</td><td><textarea>".$row['continut'].'</textarea></td><td><input type="checkbox" name="cb" value="'.$i.'"></td></tr>';
            }
    mysqli_close($con);
    $tables=$tables."</table>";
    return $tables;
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
function add_option($nume,$continut){
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $nume=mysql_real_escape_string($nume);
    //$continut=mysql_real_escape_string($continut);
    $result = mysqli_query($con,"INSERT INTO `continut`(nume,continut) VALUES ('$nume','$continut')");
    mysqli_close($con);
    header( "refresh:3;url=main.php" );
    echo 'Adaugat cu succes!';
    return;
}
function delete_option($nume){
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $nume=intval(mysql_real_escape_string($nume));
    $result = mysqli_query($con,"SELECT * FROM `continut` WHERE 1");
    $i=0;
    $desters=null;
    while($row = mysqli_fetch_array($result)){
        $i++;
        if($i==$nume)
            $desters=$row['id'];
    }
   /* if($desters==null){

    }*/
    $result = mysqli_query($con,"DELETE FROM `continut` WHERE id='$desters'");
    mysqli_close($con);
    header( "refresh:3;url=main.php" );
    echo 'Sters cu succes!';
    return;
}
function change_name($opt,$name){
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $opt=intval(mysql_real_escape_string($opt));
    $name=mysql_real_escape_string($name);
    $result = mysqli_query($con,"SELECT * FROM `continut` WHERE 1");
    $i=0;
    $desters=null;
    while($row = mysqli_fetch_array($result)){
        $i++;
        if($i==$opt)
            $desters=$row['id'];
    }
   /* if($desters==null){

    }*/
    $result = mysqli_query($con,"UPDATE `continut` SET nume='$name' WHERE id='$desters'");
    mysqli_close($con);
    header( "refresh:3;url=main.php" );
    echo 'Nume schimbat cu succes!';
    return;
}
function change_content($opt,$name){
    $con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
    if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $opt=intval(mysql_real_escape_string($opt));
    //$name=mysql_real_escape_string($name);
    $result = mysqli_query($con,"SELECT * FROM `continut` WHERE 1");
    $i=0;
    $desters=null;
    while($row = mysqli_fetch_array($result)){
        $i++;
        if($i==$opt)
            $desters=$row['id'];
    }
   /* if($desters==null){

    }*/
    $result = mysqli_query($con,"UPDATE `continut` SET continut='$name' WHERE id='$desters'");
    mysqli_close($con);
    header( "refresh:3;url=main.php" );
    echo 'Continut schimbat cu succes!';
    return;
}
if(isset($_GET['do'])){
    if($_GET['do']=='1'){
        if(isset($_GET['opt'])&&isset($_GET['cont']))
            add_option($_GET['opt'],$_GET['cont']);
        else{
            header( "refresh:3;url=main.php" );
            echo '<h2>EROARE! Dati numele optiunii si continutul</h2>Veti fi redirectionati inapoi';
        }
    }
    else{
        if($_SESSION['logged']!='yes'){
            header( "refresh:3;url=index.html" );
            echo '<h2>EROARE! Nu sunteti autentificat!</h2>Veti fi redirectionati inapoi';
        }
        else{
            if($_GET['do']=='2'){
                if(isset($_GET['cb']))
                    delete_option($_GET['cb']);
                
                else{
                    header( "refresh:3;url=main.php" );
                    echo '<h2>EROARE! Alegeti optiunea care vreti sa fie stearsa</h2>Veti fi redirectionati inapoi';
                }
            }
            if($_GET['do']=='3'){
                if(isset($_GET['cb'])&&isset($_GET['opt']))
                    change_name($_GET['cb'],$_GET['opt']);
                else{
                    header( "refresh:3;url=main.php" );
                    echo '<h2>EROARE! Alegeti optiunea care vreti sa fie modificata si dati noul nume</h2>Veti fi redirectionati inapoi';
                }
            }
            if($_GET['do']=='4'){
                if(isset($_GET['cb'])&&isset($_GET['cont']))
                    change_content($_GET['cb'],$_GET['cont']);
                else{
                    header( "refresh:3;url=main.php" );
                    echo '<h2>EROARE! Alegeti optiunea care vreti sa fie modificata si dati noul continut</h2>Veti fi redirectionati inapoi';
                }
            }
        }
    }
}



?>