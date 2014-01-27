<?php 
$tabela=array("Astra Giurgiu",
	"Steaua Bucuresti",
	"Petrolul Ploiesti",
	"Pandurii Tg Jiu",
	"Ceahlaul Piatra Neamt",
	"Dinamo Bucuresti",
	"FC Vaslui",
	"Gaz Metan Medias",
	"CFR Cluj",
	"ACS Poli Timisoara",
	"FC Botosani",
	"Corcondia Chiajna",
	"Sageata Navodari",
	"FC Brasov",
	"Otelul Galati",
	"U Cluj",
	"Viitorul Voluntari",
	"Corona Brasov");
function getdata(){
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"DELETE FROM campionat WHERE echipa=''");
    $result = mysqli_query($con,"SELECT * FROM campionat WHERE 1");
    $i=1;
    $data="<tr id='"."0"."'><th>Echipa</th><th>Meciuri jucate</th><th>Castigate</th><th>Egale</th><th>Pierderi</th><th>Goluri marcate</th><th>Goluri primite</th><th>Punctaj</th></tr>";
    while($row = mysqli_fetch_array($result)){
    	//if($i==$_GET['linie'])     
    		$data = $data."<tr id=".$i.">"."<td>".$row['echipa']."</td>"."<td>".$row['jucate']."</td>"."<td>".$row['castigate']."</td>"."<td>".$row['egale']."</td>"."<td>".$row['pierderi']."</td>"."<td>".$row['marcate']."</td>"."<td>".$row['primite']."</td>"."<td>".$row['punctaj']."</td>"."</tr>";
    	$i++;
    }
    echo $data;
    mysqli_close($con);
}
function setdata(){
	$con=mysqli_connect("127.0.0.1","root","mclarenf1","pw");
	if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
    $result = mysqli_query($con,"DELETE FROM campionat WHERE 1=1");
    $data=$_GET['continut'];
    $ars=array();
	$ars=explode("`", $data);
	for($i=0;$i<count($ars);$i++){
		$ar=array();
		error_log($ars[$i]);
		$ar=explode("^", $ars[$i]);
		$result = mysqli_query($con,"INSERT INTO campionat(echipa,jucate,castigate,egale,pierderi,marcate,primite,punctaj) VALUES ('$ar[0]','$ar[1]','$ar[2]','$ar[3]','$ar[4]','$ar[5]','$ar[6]','$ar[7]')");
		error_log($ar[0]);
	}
    echo "merge";
    mysqli_close($con);

}

$tabela2=array("<td>Astra Giurgiu</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Steaua Bucuresti</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>3</td>",
	"<td>Petrolul Ploiesti</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Pandurii Tg Jiu</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Ceahlaul Piatra Neamt</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Dinamo Bucuresti</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>FC Vaslui</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Gaz Metan Medias</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>CFR Cluj</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>ACS Poli Timisoara</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>FC Botosani</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Corcondia Chiajna</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Sageata Navodari</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>FC Brasov</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Otelul Galati</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>U Cluj</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Viitorul Voluntari</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>",
	"<td>Corona Brasov</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>");
//error_log($_GET['linie']);
//echo $tabela;
if(isset($_GET['do'])){
	if($_GET['do']==1)
		getdata();
		/*if(isset($_GET['linie']))*/
			//echo $_GET['linie']."+".$tabela[$_GET['linie']-1];
	else{
		if($_GET['do']==2)
			setdata();
	}
}
else
	echo "Nu merge<br>";
//setdata();
?>
