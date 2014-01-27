<?php 
function get_poze($n){
	$poze='<h5>';
	$con=mysqli_connect("127.0.0.1","root","","pw");
	if (mysqli_connect_errno($con)){
                echo "Nu s-a conectat " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"SELECT * FROM `poze` WHERE 1");
    $i=1;
    while($row = mysqli_fetch_array($result)){
			if($i==$n)
				$poze=$poze.$row['poza'].'</h5><br/><img src="'.$row['poza'].'">'.'<br/><br/>Nr. voturi pt. aceasta poza: '.$row['voturi'];
			 $i++;
            }
    mysqli_close($con);
    //$poze=$poze."</poze>";
    return $poze;
}

function get_comments($n){
	$comm='';
	$nume='';
	$con=mysqli_connect("127.0.0.1","root","","pw");
	if (mysqli_connect_errno($con)){
                echo "Nu s-a conectat: " . mysqli_connect_error();
            }
	$result = mysqli_query($con,"SELECT * FROM `poze` WHERE 1");
    $i=1;
    while($row = mysqli_fetch_array($result)){
			if($i==$n)
				$nume=$row['poza'];;
			 $i++;
            }

	$string="SELECT * FROM `comentarii` WHERE poza='".$nume."'";
    $result1 = mysqli_query($con,$string);
    while($row = mysqli_fetch_array($result1)){
				$comm=$comm.'<h6>'.$row['user'].' a spus la '.$row['data'].':&nbsp; &nbsp; &nbsp;'.$row['comentariu'];
            }
    mysqli_close($con);
    
    return $comm;
}



?>