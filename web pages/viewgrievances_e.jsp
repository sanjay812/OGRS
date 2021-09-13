
<%@page import="com.mysql.jdbc.exceptions.MySQLSyntaxErrorException"%>
<%@ page import="java.sql.*"%>
<%@ include file="staffwelcome.jsp"%>
<html>
    <head>
     <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
   function myFunction() {
       disableBtn();
  var x = document.getElementById("box");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function disableBtn() {
    document.getElementById("myBtn").disabled = true;
}
</script>
    </head>
<body bgcolor=lightyellow text=green>
    <div class="container">
  <table class="table">
      <tr>
          <th>gid</th>
          <th>date</th>
          <th>Status</th>
      </tr>
    
 <%--    <tr class = "table-primary">      
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <<td> <button type="submit" class="btn btn-danger" name="grievance">Update status</button></td>
   </tr>
   <tr class = "table-primary">      
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td> <button type="submit" class="btn btn-danger" name="grievance">Update status</button></td>
   </tr>

<tr class = "table-primary">      
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td> <button type="submit" class="btn btn-danger" name="grievance">Update status</button></td>
   </tr>

<tr class = "table-primary">      
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td> <button type="submit" class="btn btn-danger" name="grievance">Update status</button></td>
   </tr>

<tr class = "table-primary">      
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td> <button type="submit" class="btn btn-danger" name="grievance">Update Status</button></td>
   </tr> --%>
 <%
     try
     {
     
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebgs","root","sanjay_812");
    String zone =(String)session.getAttribute("zone");
     Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("select gid,date,house_no,problem from grievances where ward_no='"+zone+"'order by date desc"); 
 
 
   %>
  <%
   while(rs.next())
   {
            
     %>      
    
     <tr class = "table-primary">      
       <td><%=rs.getString(1)%></td>
       <td><%=rs.getTimestamp(2)%></td>
       <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
       <td><button type="submit" class="btn btn-warning" id="myBtn" onclick="myFunction();this.disabled = true;">Update Status</button></td>
 
  
    <div id="box" style="display:none" class="wrapper">
            <form class="form-signin" action="UpdateStatus" method="POST">   
	<div class="form-row">
  <div class="form-group col-md-6">
    <label for="rno">GID</label>
    <input type="text" class="form-control" name="gid" >
  </div>
    
    <div class="form-group col-md-6">
      <label for="hno">House No</label>
      <input type="text" class="form-control" name="house_no">
    </div>
	</div>
	
 
<div class="form-group shadow-textarea">
  <label for="exampleFormControlTextarea6">Status</label>
  <textarea class=" form-control z-depth-1" id="exampleFormControlTextarea6" rows="2" name="status" placeholder="Write something here..." required></textarea>
</div>


     

        
	    <button type="submit" class="form-control btn btn-success" >UPDATE</button>
          </form>
	 </div> 
   </tr>
 
<%
   }
%> 
 <%
  
}
  
  catch(MySQLSyntaxErrorException e)
  {
   System.out.println(e);
  }
 %>

  </table>

 </div>
</body>
</html>
  
