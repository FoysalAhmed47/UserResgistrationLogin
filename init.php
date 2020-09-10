<?php
$host = "localhost";
$user_name = "foysal";
$user_password = "123456";
$db_name = "userdb";

$con = mysqli_connect($host,$user_name,$user_password,$db_name);

if($con)
echo "Connection success...";
else
echo "Connection Failed...";

?>