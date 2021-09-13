
<html>
<head>
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
	<title>Consumer Registration</title>
	<style>
	H1{
	color:#808080;
	text-align:center;
	}
	#f1{
	background-color:#F5F5F5;
	padding:10px;
	margin:5px 80px;
	
	}
	</style>
        <script type="text/javascript">
    function check() {
        var password = document.getElementById("newpsw").value;
        var confirmPassword = document.getElementById("confpsw").value;
        if (password !== confirmPassword) {
            document.getElementById('message').innerHTML = "Passwords do not match";
            
        }
        else
            document.getElementById('message').innerHTML = "Passwords match";
 
     
    }
</script>
	</head>
	<body>
<form action="Registration" method ="POST">
	<div class="form-row" style="padding-left:450px">
	<H1> REGISTRATION FORM</H1>
  </div>
	<fieldset id="f1">
	<legend>Personal Details</legend> 
	<div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">First Name</label>
      <input type="text" class="form-control" name="f_name" value="<c:out value='${user.f_name}' />" placeholder="Enter first name">
    </div>
	 <div class="form-group col-md-4">
      <label for="inputEmail4">Middle Name</label>
      <input type="text" class="form-control" name="m_name" value="<c:out value='${user.m_name}' />" placeholder="Enter first name">
    </div>
	 <div class="form-group col-md-4">
      <label for="inputEmail4">Last Name</label>
      <input type="text" class="form-control" name="l_name" value="<c:out value='${user.l_name}' />" placeholder="Enter first name">
    </div>
   
	 <div class="form-group col-md-4">
      <label for="dob">Date of Birth</label>
     <input type="date" class="form-control" name="dob" value="<c:out value='${user.dob}' />" id="dob">
  </div>
	 <div class="form-group col-md-4">
     <label for="gender">Gender</label>
     <select class="form-control" name="gender" id="gender">
	  <option value="none" selected disabled hidden> 
          Select an Option 
      </option> 
	 <option value="Male">Male</option>
	 <option value="Female">Female</option>
	 <option value="Others">Others</option>
	
	 </select>
  </div>
   <div class="form-group col-md-4">
      <label for="phone">Phone Number</label>
      <input type="text" class="form-control" name="phone" value="<c:out value='${user.ph}' />"  placeholder="phone number">
    </div>
	</div>
	</fieldset>
	<fieldset id="f1">
	<legend>Address Details</legend>
	<div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Address 1</label>
    <input type="text" class="form-control" name="inputAddress1" value="<c:out value='${addr.add1}' />"  placeholder="Door no">
  </div>
  
  <div class="form-group col-md-6">
    <label for="inputAddress">Address 2</label>
    <input type="text" class="form-control" name="inputAddress2" value="<c:out value='${addr.add2}' />"  placeholder="Street">
  </div>
    <div class="form-group col-md-4">
      <label for="inputCity">City</label>
     <select name="inputCity" class="form-control">
        <option value="none" selected disabled hidden> 
          Select an Option 
      </option> 
	 <option value="Sivakasi">Sivakasi</option>
	 <option value="Madurai">Madurai</option>
	 <option value="Tiruppur">Tiruppur</option>
      </select>
    </div>
            <div class="form-group col-md-4">
      <label for="inputDis">District</label>
     <select name="inputDis" class="form-control">
        <option value="none" selected disabled hidden> 
          Select an Option 
      </option> 
	 <option value="Sivakasi">Sivakasi</option>
	 <option value="Madurai">Madurai</option>
	 <option value="Tiruppur">Tiruppur</option>
      </select>
    </div>
    <div class="form-group col-md-3">
      <label for="inputState">State</label>
      <select name="inputState" class="form-control">
        <option value="none" selected disabled hidden> 
          Select an Option 
      </option> 
	 <option value="Sivakasi">Sivakasi</option>
	 <option value="Madurai">Madurai</option>
	 <option value="Tiruppur">Tiruppur</option>
      </select>
    </div>
    <div class="form-group col-md-3">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" value="<c:out value='${addr.pin}' />" name="inputZip">
    </div>
	</div>
  </fieldset>
    <fieldset id="f1">
        <legend>
            Credentials
        </legend>
          <div class="form-row">
              <p id="alert"></p>
          </div>
	   <div class="form-row">
     <label class="col-sm-3 col-form-label"  for="l1">E-mail</label>
     <input type="email" class="form-control col-sm-6"  name="email" id="l1" value="<c:out value='${user.email}' />" placeholder="Enter mail" >
   </div>
    <div class="form-row">
     <label class="col-sm-3 col-form-label"  for="cno">Consumerno</label>
     <input type="text" class="form-control col-sm-6" name="consumerno" id="cno" value="<c:out value='${user.consumerno}' />" placeholder="Enter consumer no" >
   </div>
  <div class="form-row">
     <label class="col-sm-3 col-form-label"  for="newpsw">New password</label>
     <input type="password" class="form-control col-sm-6" name="password" id="newpsw" value="<c:out value='${user.pass}' />"  placeholder="enter your new password">
  </div>
  <div class="form-row">
     <label class="col-sm-3 col-form-label"  for="confpsw">Confirm password</label>
     <input type="password" class="form-control col-sm-6" name="confpassword" id="confpsw"placeholder="enter your new password" onkeyup='check();'>
  </div>
    <div>
		<center><p id="message"></p></center>
   </div>
   </fieldset>
  <div class="form-row" style="margin-left:80px;margin-right:80px;">
  <button type="submit" class="form-control btn btn-success" style="text-align:center">Submit</button>
  </div>
</form>
</body>
</html>