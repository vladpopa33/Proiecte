<!DOCTYPE HTML>
<html>
<?php
// Create connection

$Categ = array("","","Excavator","Buldozer","Cilindru","Autoturism");
class Utilaj{
	public $nume;
	public $descriere;
	public $categorie;
	public $poza;
	public function __construct($nume,$categorie,$descriere,$poza){
		$this->nume=$nume;
		$this->categorie=$categorie;
		$this->descriere=$descriere;
		$this->poza=$poza;
	}

}
class ListaUtilaje{
  	  private $ut=array();
      public function __construct(){
            $con=mysqli_connect("127.0.0.1","root","mclarenf1","andorutilaje");

            // Check connection
            if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
           	
            $result = mysqli_query($con,"SELECT * FROM utilaje");
            while($row = mysqli_fetch_array($result)){
                //echo $row['nume'] . " " . $row['descriere']." ".$row['categorie']." "."<img src='vehicule/".$row['poza']."'>";
                #echo "<br>";
                $utilaj = new Utilaj($row['nume'],$row['categorie'],$row['descriere'],$row['poza']);
                $this->ut[]=$utilaj;
                //echo sizeof($this->ut);
                //echo "<br>";
            }
            mysqli_close($con);
            $i=0;
            $j=0;
            $file=fopen("mystyle.css","w");
            for($i=0;$i<sizeof($this->ut);$i++){
              fwrite($file,'#image-'.($j+1).' .slider-nav {
                right: 15px;
              }
              #image-'.($j+2).' .slider-nav {
                right: 30px;
              }

              #image-'.($j+3).' .slider-nav {
                right: 45px;
              }

              #image-'.($j+4).' .slider-nav {
                right: 60px;
              }
              #image-'.($j+5).' .slider-nav {
                right: 75px;
              }
              #image-'.($j+6).' .slider-nav {
                right: 90px;
              }
              #image-'.($j+7).' .slider-nav {
                right: 105px;
              }
              #image-'.($j+8).' .slider-nav {
                right: 120px;
              }
              #image-'.($j+9).' .slider-nav {
                right: 135px;
              }
              #image-'.($j+10).' .slider-nav {
                right: 150px;
              }
              #image-'.($j+11).' .slider-nav {
                right: 165px;
              }
              #image-'.($j+12).' .slider-nav {
                right: 180px;
              }
              #image-'.($j+13).' .slider-nav {
                right: 195px;
              }
              #image-'.($j+14).' .slider-nav {
                right: 210px;
              }
              #image-'.($j+15).' .slider-nav {
                right: 225px;
              }
              
              ');
              $j=$j+20;
              }
            fclose($file);
      }
      public function add($utilaj){
            $con=mysqli_connect("127.0.0.1","root","mclarenf1","andorutilaje");

            // Check connection
            if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
            $utilaj->nume=mysql_real_escape_string($utilaj->nume);
            $utilaj->descriere=mysql_real_escape_string($utilaj->descriere);
            //$utilaj->categorie=mysql_real_escape_string($utilaj->categorie);
            $utilaj->poza=mysql_real_escape_string($utilaj->poza);
            //mysqli_query($con,mysql_real_escape_string("INSERT INTO utilaje (nume, descriere, categorie, poza) VALUES ('$utilaj->nume', '$utilaj->descriere','$utilaj->categorie','$utilaj->poza')"));
            mysqli_query($con,"INSERT INTO utilaje (nume, descriere, categorie, poza) VALUES ('$utilaj->nume', '$utilaj->descriere','$utilaj->categorie','$utilaj->poza')");
            
            mysqli_close($con);
            $this->ut[]=$utilaj;
      }
      public function del($n){
            $con=mysqli_connect("127.0.0.1","root","mclarenf1","andorutilaje");
              // Check connection
            if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
            echo $this->ut[$n]->nume;
            mysqli_query($con,"DELETE FROM utilaje WHERE nume='$this->ut[$n]->nume'");
            mysqli_close($con);
          	array_splice($this->ut, $n, 1);
      }
      public function ret($n){
      	    return $this->ut[$n];
      }
      public function mod($n,$utilaj){
            $con=mysqli_connect("127.0.0.1","root","mclarenf1","andorutilaje");

              // Check connection
            if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
            $utilaj->nume=mysql_real_escape_string($utilaj->nume);
            $utilaj->descriere=mysql_real_escape_string($utilaj->descriere);
            //$utilaj->categorie=mysql_real_escape_string($utilaj->categorie);
            $utilaj->poza=mysql_real_escape_string($utilaj->poza);
            mysqli_query($con,"UPDATE utilaje SET descriere='$utilaj->descriere' WHERE nume='$this->ut[$n]->nume'");
            mysqli_query($con,"UPDATE utilaje SET categorie='$utilaj->categorie' WHERE nume='$this->ut[$n]->nume'");
            mysqli_query($con,"UPDATE utilaje SET poza='$utilaj->poza' WHERE nume='$this->ut[$n]->nume'");
            mysqli_query($con,"UPDATE utilaje SET nume='$utilaj->nume' WHERE nume='$this->ut[$n]->nume'");
            mysqli_close($con);
          	array_splice($this->ut, $n, 1, $utilaj);
          	}
      public function lung(){
          return sizeof($this->ut);
      }
      public function getpoze($nume){
            $con=mysqli_connect("127.0.0.1","root","mclarenf1","andorutilaje");
            // Check connection
            $poze=array();
            if (mysqli_connect_errno($con)){
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            }
            //$nume=mysql_real_escape_string($nume);
            $result = mysqli_query($con,"SELECT * FROM imagini");
            //$result = mysqli_query($con,"SELECT * FROM imagini WHERE nume='$nume'");
            //$file = fopen("test.txt","w");
            //fwrite($file,"bubu");
            //if($result!=FALSE)
            //echo $nume."-";
            while($row = mysqli_fetch_array($result)){
                    if($row["nume"]==$nume){
                      $poze[]=$row["imagine"];
                      //echo $nume."-".$row["imagine"]."<br>";
                    }
                    
                    //fwrite($file,$poze);
              }
            //fclose($file);
            return $poze;
      }
	}



?>
</html>
