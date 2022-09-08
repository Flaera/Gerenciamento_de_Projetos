public class User {
    private String name;
    private String email;
    private String password;
    private UserStatus type;
    private Double payment;
    private AllocatorStatus alloc_status;
    public User(String _name){
        this.name = _name;
        this.email = "not_defined";
        this.password = "123456";
        this.type = UserStatus.ALUNA;
        this.payment = 0.0;
        this.alloc_status = AllocatorStatus.DEFINITIVE;
    }
    public User(String _name, String _email, String _password){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = UserStatus.ALUNA;
        this.payment = 0.0;
        this.alloc_status = AllocatorStatus.DEFINITIVE;
    }
    public User(String _name, String _email, String _password, UserStatus _type, Double _payment, AllocatorStatus _alloc_status){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = _type;
        this.payment = _payment;
        this.alloc_status = _alloc_status;
    }
    public String getName(){return this.name;}
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public UserStatus getStatus(){return this.type;}
    public Double getPayment(){return this.payment;}
    public AllocatorStatus getAllocStatus(){return this.alloc_status;}
    public void setName(String name2){this.name = name2;}
    public void setEmail(String email2){this.email=email2;}
    public void setPassword(String pw){this.password=pw;}
    public void setStatus(UserStatus t){this.type=t;}
    public void setPayment(Double bag_or_payment){this.payment = bag_or_payment;}
    public void setAllocStatus(AllocatorStatus as){this.alloc_status=as;}
    public static void main(String[] args){
        return;
    }
}
