<!DOCTYPE HTML>
<html>
<title> LogIn </title>
<head>
</head>
<body bgcolor="black">
<div>
<?php
echo '<font color="red" size=7>';
echo '<form action="admin.php" method="post">';
echo 'Utilizator: <input type="text" value="" name="user"><br>';
echo 'Parola: <input type="password" value="password" size=15 name="pass"><br>';
echo '<input type="submit" value="Ok"></form></font>';
echo '<footer><p>'.date("d/m/Y").' - '.date("H:m:s").'</footer></p>';
?>
</form>
</font>
</body>
</html>
