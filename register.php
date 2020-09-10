<?php
require "init.php";

	  $first_name=$_POST['first_name'];
      $last_name=$_POST['last_name'];
      $email=$_POST['email'];
      $phone=$_POST['phone'];
      $password=$_POST['password'];

$sql = "select * from login_info where phone = '$phone'";
$result = mysqli_query($con,$sql);

if(mysqli_num_rows($result)>0)
{
	$status = "Phone must be unique";
}


$sql = "insert into login_info(first_name,last_name,email,phone,password) values ('$first_name','$last_name','$email','$phone','$password');";

 if($con->query($sql) === TRUE)
 {
   $status = "ok";
 }
 else
{
   $status = "error";
 }



echo json_encode(array("response"=>$status));

mysqli_close($con);

?>