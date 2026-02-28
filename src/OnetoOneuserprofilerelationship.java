class Profile{
    private String email;
    private String phone;
    Profile(String email, String phone){
        this.email=email;
        this.phone=phone;
    }
    public String getEmail(){
        return email;
    }

}
class User{
    String userId;
    String userName;
    Profile profile;
    User(String userId,String userName,Profile profile){
        this.userId=userId;
        this.userName=userName;
        this.profile=profile;
    }
    public Profile getProfile(){
        return profile;
    }
}
public class OnetoOneuserprofilerelationship {
    public static void main(String[] args) {
    Profile p=new Profile("harshitagah","12345");
    User u=new User("123","harshita",p);
        System.out.println("Email:"+p.getEmail());
        System.out.println("Profile:"+u.getProfile().getEmail());
    }
}
