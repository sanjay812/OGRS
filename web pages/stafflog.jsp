<%@ include file="index.html"%>
<html>
     <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Login</title>
	<style>
	body{
	 background:#eee;
	 }
	.wrapper{
	margin:80px 100px;
	
	}
	.form-login{
	width:380px;
	background-color:#fff;
	padding: 15px 40px 35px;
	border: 1px solid #e5e5e5;
	}
	.checkbox
	{
	margin-bottom:30px;
	}
	.form-login input[type="text"], .form-login input[type="password"] ,.btn
	{
		margin-bottom: 20px;
	}
	</style>
  </head>
  <body>
  <div class="wrapper">
	<form class=" form-login" action="StaffLogin" method="post">
	<h3 class="text-center">STAFF LOGIN </h3>
         <div>
		<center><p id="message"></p></center>
         </div>
	<input type= "text" class="form-control" name="mail" placeholder="Enter mail">
	<input type="password" class="form-control" name="pass" placeholder="Enter password">
	<label>	<input type="checkbox">Remember me</label>
	<button type="submit" class="form-control btn btn-primary text-center" name="login">LOGIN</button>
	<a href="Register_consumer.jsp" style="font-size:15px">New user</a>
        <a href="#" style="font-size:15px" >Forgot Password</a>
	</form>	
</div>
  </body>
</html>