
package ebogrs;
import java.time.LocalDateTime;
 import java.util.Random;
public class grievance {
    
    String gid,region_no,section_no,ward_no,house_no,desc,category,status;
    LocalDateTime g_date;
    public grievance(String region_no, String section_no, String ward_no, String house_no,LocalDateTime g_date, String desc,String category, String status) {
        this.region_no = region_no;
        this.section_no = section_no;
        this.ward_no = ward_no;
        this.house_no = house_no;
        this.g_date=g_date;
        this.desc = desc;
        this.category = category;
        this.status = status;
    }

    public LocalDateTime getG_date() {
        return g_date;
    }

    public void setG_date(LocalDateTime g_date) {
        this.g_date = g_date;
    }
    
    public String getGid() {
        Random random = new Random();
        StringBuilder sb  = new StringBuilder();
        
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRegion_no() {
        return region_no;
    }

    public void setRegion_no(String region_no) {
        this.region_no = region_no;
    }

    public String getSection_no() {
        return section_no;
    }

    public void setSection_no(String section_no) {
        this.section_no = section_no;
    }

    public String getWard_no() {
        return ward_no;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
     public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	
 
}

