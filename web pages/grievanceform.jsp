
<%@ include file="userwelcome.jsp"%>
<html lang="en">
  <head>
   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%   
     String consumerno=(String) session.getAttribute("consumerno");
     String region_no = consumerno.substring(0,2);
     String section_no = consumerno.substring(2,5);
     String ward_no = consumerno.substring(5,8);
     String house_no = consumerno.substring(8);
     
%>
   

    <title>Greivanceform</title>
	<style>
	
	H1{
	text-align:center;
	}
	
	
	label 
	{
		font-size:18px;
		font-family:bold;
		color:black;
		}
	.wrapper{
	
	margin:20px 80px 10px;
	padding:10px 300px 10px;
	}
	.form-signin{
	width:700px;
	background-color:#eee;
	padding: 15px 40px 35px;
	border: 1px solid #e5e5e5;
	}
	.form-signin input[type="text"],.form-signin input[type="date"],.form-signin input[type="email"],.form-signin input[type="password"],select,.form-signin input[type="number"]
	{
		margin-bottom: 20px;
	}
        .form-textbox 
        {
        
        width: 400px;
        font-size: 14px;
        }
	</style>
</head>
	<body style="background-color:#e10e10e10;">
	<div class="wrapper">
          <form class="form-signin" action="Grievancesubmit" method="POST">   
	<H1>GREIVANCE FORM</H1>
	<div class="form-row">
  <div class="form-group col-md-6">
    <label for="rno">Region No</label>
    <input type="text" class="form-control" name="rno" value="<%=region_no%>">
  </div>
  <div class="form-group col-md-6">
    <label for="sno">Section No</label>
    <input type="text" class="form-control" name="sno" value="<%=section_no%>">
  </div>
  <div class="form-group col-md-6">
    <label for="wno">Ward No</label>
    <input type="text" class="form-control" name="wno" value="<%=ward_no%>">
  </div>
    
    <div class="form-group col-md-6">
      <label for="hno">House No</label>
      <input type="text" class="form-control" name="hno" value="<%=house_no%>">
    </div>
	</div>
	
 
<div class="form-group shadow-textarea">
  <label for="exampleFormControlTextarea6">Description</label>
  <textarea class=" form-control z-depth-1" id="exampleFormControlTextarea6" rows="2" name="desc" placeholder="Write something here..." required></textarea>
</div>
<div class="form-row">
 <label class="col-sm-3 col-form-label">Category</label>
  <div class="form-check-inline">
  <label class="form-check-label">
      <input type="radio" class="form-check-input" name="category" value="Normal" required>Normal
  </label>
</div>
<div class="form-check-inline">
  <label class="form-check-label">
      <input type="radio" class="form-check-input" name="category" value="Emergency" required>Emergency
  </label>
</div>
        </div>


     

        
	    <button type="submit" class="form-control btn btn-success" name="grievance">SUBMIT</button>
          </form>
	 </div>
	
	</body>
	</html>


