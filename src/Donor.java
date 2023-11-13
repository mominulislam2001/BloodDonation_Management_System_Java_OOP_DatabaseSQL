public class Donor extends Individual{
  
    public String donorId;
    public String fatherName;
    public String motherName;
    public String DOB;
    public String mobileNo;
    public String gender;
    public String bloodGroup;
    public String city;
    public String address;

    public Donor(String userName,String email,String donorId, String fatherName, String motherName, String DOB, String mobileNo, String gender, String bloodGroup, String city, String address) {
       
        super(userName,email);
     
        this.donorId = donorId;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.DOB = DOB;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.city = city;
        this.address = address;
   
    
    }
    
    
   
}
