<?php
	function get_user($n,$p){
		$con=mysqli_connect("127.0.0.1","root","","pw");
		if (mysqli_connect_errno($con)){
	            echo "Nu s-a conectat " . mysqli_connect_error();
	        }
	    $result=mysqli_query($con,"SELECT * FROM `members` WHERE 1");
	    $ok=0;

		while($row=mysqli_fetch_array($result)){
			if($n=$row['username'] && $m=$row['password'])
				$ok=1;
		}	
		mysqli_close($con);
		return $ok;
	}

	function add_programs(){
		$d=mysql_real_escape_string($_GET['data']);
		$o=mysql_real_escape_string($_GET['ora']);
		$du=mysql_real_escape_string($_GET['durata']);
		$de=mysql_real_escape_string($_GET['descriere']);
		$u=$_SESSION['logged'];
		$con=mysqli_connect("127.0.0.1","root","","pw");
		if (mysqli_connect_errno($con)){
	            echo "Nu s-a conectat " . mysqli_connect_error();
	        }
	    $result=mysqli_query($con,"INSERT INTO `calendar` VALUES ('$u','$d','$o','$du','$de')");
	    echo 'Programul tau a fost adaugat!';
	}

	function view_programs(){
		$con=mysqli_connect("127.0.0.1","root","","pw");
		$u=$_SESSION['logged'];

		$result=mysqli_query($con,"SELECT * FROM `calendar` WHERE user='$u'");
		$vector=array(); //vector cu JSON
		$i=1;
		while($row=mysqli_fetch_array($result)){
			$vector[]=$i.". "."~".$row['data']."~".$row['ora']."~".$row['durata']."~".$row['descriere']."~";
			$i++;
		}
		echo json_encode($vector);
	}

	function edit_programs(){
		$d=intval($_GET['ind1']);
		$s=intval($_GET['ind2']);
		$v=mysql_real_escape_string($_GET['v']);
		$u=$_SESSION['logged'];
		$da='';
		$o='';
		$con=mysqli_connect("127.0.0.1","root","","pw");
		if (mysqli_connect_errno($con)){
	            echo "Nu s-a conectat " . mysqli_connect_error();
	        }
	    $result=mysqli_query($con,"SELECT * FROM `calendar` WHERE user='$u'");
	    $i=0;
	    while($row=mysqli_fetch_array($result)){
	    	if($i==$d){
	    		$da=$row['data'];
	    		$o=$row['ora'];
	    	}
	    	$i++;
	    }
	    if($s==1)
	    	$string="UPDATE `calendar` SET durata='$v' WHERE user='$u' AND data='$da' AND ora='$o'";
	    if($s==2)
	    	$string="UPDATE `calendar` SET descriere='$v' WHERE user='$u' AND data='$da' AND ora='$o'";
	    $result=mysqli_query($con,$string);
	    echo "modificat";
	    /*
 			$du = $_REQUEST['durata'] ;
  			$de = $_REQUEST['descriere'] ;
	    */
  		//header( "refresh:3;url=vizualizare.php" );
	}

	function delete_programs(){
		$d=intval($_GET['ind']);
		$u=$_SESSION['logged'];
		$da='';
		$o='';
		$con=mysqli_connect("127.0.0.1","root","","pw");
		if (mysqli_connect_errno($con)){
	            echo "Nu s-a conectat " . mysqli_connect_error();
	        }
	    $result=mysqli_query($con,"SELECT * FROM `calendar` WHERE user='$u'");
	    $i=0;
	    while($row=mysqli_fetch_array($result)){
	    	if($i==$d){
	    		$da=$row['data']; //data curenta
	    		$o=$row['ora']; //ora curenta
	    	}
	    	$i++;
	    }
	    $string="DELETE FROM `calendar` WHERE user='$u' AND data='$da' AND ora='$o'";
	    $result=mysqli_query($con,$string);
	    echo "sters";
	    /*
 			$du = $_REQUEST['durata'] ;
  			$de = $_REQUEST['descriere'] ;
	    */
  		//header( "refresh:3;url=vizualizare.php" );
	}

	if(isset($_GET['do'])){ //efectiv il verifica daca ii setat din ajax
		session_start();
		if($_GET['do']=="26") //daca ii ok functia ii apelata cu ajax din php
			add_programs();
		if($_GET['do']=="10")
			view_programs();
		if($_GET['do']=="92")
			edit_programs();
		if($_GET['do']=="18")
			delete_programs();
	

	}		


?>
