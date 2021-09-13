
package ebogrs;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
        
    private String url="jdbc:mysql://localhost:3306/ebgs";
    private String user="root";
    private String pass="sanjay_812";
    private String dbdriver="com.mysql.jdbc.Driver";
    
    public Connection getConnection()
    {
        Connection con=null;
        try
        {
            con=DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e)
        {
        }
        return con;
    }
    public String insert(User user,Address addr){
        String result="Data entered successfully";
        try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
        String sql1="insert into userdetails values(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql1);
            ps.setString(1,user.getF_name());
            ps.setString(2,user.getM_name());
            ps.setString(3,user.getL_name());
            ps.setDate(4,getSQLDate(user.getDob()));
            ps.setString(5,user.getGender()); 
            ps.setString(6,user.getPh());
            ps.setString(7,user.getEmail());
            ps.setString(8,user.getConsumerno());
            ps.setString(9,user.getPassword());
        
            
            ps.executeUpdate();
          
        }
        catch(SQLException e){
        e.printStackTrace();
         result="Unsuccessfull";
        }
         String sql2="insert into user_addr values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql2);
            ps.setString(1,user.getConsumerno());
            ps.setString(2,addr.getDoor_no());
            ps.setString(3,addr.getStreet());
            ps.setString(4,addr.getCity());
            ps.setString(5,addr.getDistrict());
            ps.setString(6,addr.getState());
            ps.setString(7,addr.getPincode());
            ps.executeUpdate();
          
        }
        catch(SQLException e){
        e.printStackTrace();
         result="Unsuccessfull";
        }
       return result; 
    }
    
    public String insertgrievance(grievance g){
        String result=null;
        try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
        String sql4="insert into grievances values(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql4);
            ps.setString(1,g.getGid());
            ps.setString(2,g.getRegion_no());
            ps.setString(3,g.getSection_no());
            ps.setString(4,g.getWard_no());
            ps.setString(5,g.getHouse_no());
            ps.setString(6,g.getDesc());
            ps.setTimestamp(7,getSQLTime(g.getG_date()));
            ps.setString(8,g.getCategory());
            ps.setString(9,g.getStatus());
            
            ps.executeUpdate();
          result="success";
        }
        catch(SQLException e){
        e.printStackTrace();
        result = "failure";
       
        }
        return result;
    }
    public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
    
     public static Timestamp getSQLTime(LocalDateTime date) {
        return java.sql.Timestamp.valueOf(date);
    }
    public boolean validate(String consumerno, String password)
    {
       
          try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
         boolean status=true;
         String sql3="select consumerno,password from userdetails where consumerno=? and password=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql3);
            ps.setString(1,consumerno);
            ps.setString(2,password);
     
            ResultSet rs=ps.executeQuery();  
            status=rs.next();
          
        }
        catch(SQLException e){
        e.printStackTrace();
      
        }
       return status; 
  
    }
    public boolean staffvalidate(String mail, String password)
    {
       
          try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
         boolean status=true;
         String sql3="select email,password from staff where email=? and password=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql3);
            ps.setString(1,mail);
            ps.setString(2,password);
     
            ResultSet rs=ps.executeQuery();  
            status=rs.next();
          
        }
        catch(SQLException e){
        e.printStackTrace();
      
        }
       return status; 
  
    }
    public String getmail(String consumerno){
         try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
        String mail= null;
         String sql7="select email from userdetails where consumerno like ?";
        try{
            PreparedStatement ps=con.prepareStatement(sql7);
            ps.setString(1,"%"+consumerno);
            ResultSet rs=ps.executeQuery();  
            rs.next();
            mail=rs.getString(1);
          
        }
        catch(SQLException e){
        e.printStackTrace();
      
        }
        return mail;
    }
     public String getStaffmail(String ward_no){
         try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
        String mail= null;
         String sql7="select email from staff where Zone =?";
        try{
            PreparedStatement ps=con.prepareStatement(sql7);
            ps.setString(1,ward_no);
            ResultSet rs=ps.executeQuery();  
            rs.next();
            mail=rs.getString(1);
          
        }
        catch(SQLException e){
        e.printStackTrace();
      
        }
        return mail;
    }
     public String getZone(String password){
         try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
        String zone = null;
         String sql7="select Zone from staff where password=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql7);
            ps.setString(1,password);
            ResultSet rs=ps.executeQuery();  
            rs.next();
            zone=rs.getString(1);
          
        }
        catch(SQLException e){
        e.printStackTrace();
      
        }
        return zone;
    }
      public String UpdateStatus(String gid,String status){
          String res = "successfully updated";
         try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
   
         String sql7="UPDATE grievances SET status =? WHERE gid =?";
        try{
            PreparedStatement ps=con.prepareStatement(sql7);
            ps.setString(1,status);
            ps.setString(2,gid);
            int rs=ps.executeUpdate();  
            
        }
        catch(SQLException e){
        e.printStackTrace();
        res="failed";
      
      
    }
        return res;
}
       public String Deletegrievance(String gid){
          String res = "successfully deleted";
         try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con =getConnection();
   
         String sql7="delete from  grievances where gid =?";
        try{
            PreparedStatement ps=con.prepareStatement(sql7); 
            ps.setString(1,gid);
            int rs=ps.executeUpdate();  
            
        }
        catch(SQLException e){
        e.printStackTrace();
        res="failed";
      
      
    }
        return res;
}
}
    

