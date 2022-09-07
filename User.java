public class User {
    private String name;
    private String email;
    private String password;
    private UserStatus type;
    private Double payment;
    public User(String _name){
        this.name = _name;
        this.email = "not_defined";
        this.password = "123456";
        this.type = UserStatus.ALUNA;
        this.payment = 0.0;
    }
    public User(String _name, String _email, String _password){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = UserStatus.ALUNA;
        this.payment = 0.0;
    }
    public User(String _name, String _email, String _password, UserStatus _type, Double _payment){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = _type;
        this.payment = _payment;
    }
    public String getName(){return this.name;}
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public UserStatus getStatus(){return this.type;}
    public Double getPayment(){return this.payment;}
    public void setName(String name2){this.name = name2;}
    public void setEmail(String email2){this.email=email2;}
    public void setPassword(String pw){this.password=pw;}
    public void setStatus(UserStatus t){this.type=t;}
    public void setPayment(Double bag_or_payment){this.payment = bag_or_payment;}
    public static void main(String[] args){
        return;
    }
}
