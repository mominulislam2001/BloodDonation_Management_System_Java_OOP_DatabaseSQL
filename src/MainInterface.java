public interface MainInterface {
    
    
    public Boolean addUserToDatabase(User user);
    public Boolean loginUser(String username,String password);
    public Boolean addDonorToDatabase(Donor donor);
    public Boolean updateDonorInfoDatabase(Donor donor);
    public Boolean removeDonorFromDatabase(String donorId);


}
