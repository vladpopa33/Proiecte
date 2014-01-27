<?php
function baga(){
    $con=mysqli_connect("127.0.0.1","root","","pw");
    if (mysqli_connect_errno()){
        echo "Nu s-a conectat: " . mysqli_connect_error();
    }
    $sql="INSERT INTO comentarii(user, comentariu) VALUES ('$_POST[user]','$_POST[comentariu])";

    if (!mysqli_query($con,$sql)){
        die('Error: ' . mysqli_error($con));
    }
    $result=$result. '$_POST[user]'.' a spus '.'$_POST[comentariu]';
    mysqli_close($con);
    return $result;
}

baga();
?>

