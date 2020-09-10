<?php 
require "init.php";

     
$phone=$_POST["phone"];
$password=$_POST["password"];
 
 $sql="select * from login_info where phone='$phone' and password='$password'";

 $result = mysqli_query($con,$sql);

if(!mysqli_num_rows($result)>0)
{
$status = "failed";
echo json_encode(array("response"=>$status));
}

else
{
$row = mysqli_fetch_assoc($result);
$phone=$row['phone'];
$status = "ok";
echo json_encode(array("response"=>$status,"phone"=>$phone));



}
mysqli_close($con);

?>