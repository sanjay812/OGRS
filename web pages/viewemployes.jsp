<%@ page import="java.sql.*"%>
<%@ include file="adwelcome.html"%>
<html>
 <body bgcolor=lightyellow text=green>
  <table border=1 cellspacing=4 cellpadding=3 bordercolor=green align=center>
     <tr><th>eid</th><th>firstname</th><th>middlename</th><th>lastname</th><th>street</th><th>colony</th><th>area</th><th>salary</th><th>phonenumber</th><th>department id</th><th>date of join</th><th>totalworkingdays</th><th>working days</th><th>gender</th><th>designation</th><th>qualification</th></tr>
   <%
      try
        {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection con=DriverManager.getConnection("jdbc:odbc:madhu","system","manager");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select  e.eid,e.ename,e.emname,e.elname,e.eaddress.street,e.eaddress.colony,e.eaddress.area,e.esal,e.ephno,e.did,to_char(e.doj,'dd-mon-yy'),e.twd,e.wd,e.gender,e.designation,e.qualification from employ e");
       while(rs.next())
       {
    %>
      <tr><td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td><td><%=rs.getString(6)%></td><td><%=rs.getString(7)%></td><td><%=rs.getString(8)%></td><td><%=rs.getString(9)%></td><td><%=rs.getString(10)%></td><td><%=rs.getString(11)%></td><td><%=rs.getString(12)%></td><td><%=rs.getString(13)%></td><td><%=rs.getString(14)%></td><td><%=rs.getString(15)%></td><td><%=rs.getString(16)%></td></tr>
    <%
        }
     %>
        </table>
      <%
      }
      catch(Exception e)
      {
        out.println(e);
      }
    %>
 </body>
</html>     