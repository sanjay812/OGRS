package ebogrs;

import java.time.LocalDate;

public class User {
    String f_name,m_name,l_name,gender,ph,email,consumerno,password;
      LocalDate dob;
    public User(String f_name, String m_name, String l_name, LocalDate dob, String gender, String ph, String email, String consumerno, String password) {
        this.f_name = f_name;
        this.m_name = m_name;
        this.l_name = l_name;
        this.dob = dob;
        this.gender = gender;
        
        this.ph = ph;
        this.email = email;
        this.consumerno = consumerno;
        this.password = password;
      
        
    }
 


   

    
    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
 
     public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConsumerno() {
        return consumerno;
    }

    public void setConsumerno(String consumerno) {
        this.consumerno = consumerno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  
    
}
