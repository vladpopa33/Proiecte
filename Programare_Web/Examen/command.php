<?php
function get_names(){
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"SELECT id,nume FROM `produse` ORDER BY nume");
   	$ar=array();
   	$ar[]="^get_names^";
    while($row = mysqli_fetch_array($result)){
    		$ar[]=$row['id'];
    		$ar[]=$row['nume'];
            }
    mysqli_close($con);
   	echo json_encode($ar);
}
function get_details(){
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $id=mysql_real_escape_string($_GET['id']);
    $result = mysqli_query($con,"SELECT * FROM `produse` WHERE id='$id'");
   	$ar=array();
   	$ar[]="^get_details^";
   	$ar[]=$id;
    while($row = mysqli_fetch_array($result)){
    		$ar[]=$row['descriere'];
    		$ar[]=$row['pret'];
    		$ar[]=$row['imagine'];
            }
    mysqli_close($con);
   	echo json_encode($ar);
}
if(isset($_GET['do'])){
	if($_GET['do']==1)
		get_names();
	if($_GET['do']==2)
		get_details();
}