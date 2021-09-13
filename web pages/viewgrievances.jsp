<%@page import="com.mysql.jdbc.exceptions.MySQLSyntaxErrorException"%>
<%@page import="com.mysql.jdbc.exceptions.MySQLSyntaxErrorException"%>
<%@ page import="java.sql.*"%>
<%@ include file="userwelcome.jsp"%>
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
<script>  
    function myFunction() {
  var x = document.getElementById("box");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script>
    </head>
<body bgcolor=lightyellow text=green>
    <div class="container">
  <table class="table">
      <tr>
          <th>gid</th>
          <th>hno</th>
          <th>sday</th>
          <th>problem</th>
          <th>category</th>
          <th>status</th>
      </tr>
      <%
     try
     {
     
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebgs","root","sanjay_812");
    String consumerno=(String) session.getAttribute("consumerno");
     String h_no = consumerno.substring(8);
     Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("select gid,house_no,date,problem,category,status from grievances where house_no='"+h_no+"'order by date desc"); 
 
 
   %>
  <%
   while(rs.next())
   {
       
    %>
     <tr class = "table-primary">      
       <td><%=rs.getString(1)%></td>
       <td><%=rs.getString(2)%></td>
       <td><%=rs.getTimestamp(3)%></td>
       <td><%=rs.getString(4)%></td>
       <td><%=rs.getString(5)%></td>
       <td style="color:red"><%=rs.getString(6)%></td>
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
  <button type="submit" class="btn btn-warning" id="myBtn" onclick="myFunction()">Delete greivances</button>
  <div id="box" style="display:none" class="wrapper">
            <form class="form-signin" action="Deletegrievance" method="POST">   
	<div class="form-row">
  <div class="form-group col-md-6">
    <label for="rno">GID</label>
    <input type="text" class="form-control" name="gid" >
  </div>      
	    <button type="submit" class="form-control btn btn-success" >OK</button>
          </form>
	 </div> 
</div>
</body>
</html>
  
