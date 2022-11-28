public class User extends People{
    private String name;
    private String email;
    private String password;
    private UserStatus type;
    private Double payment;
    private AllocatorStatus alloc_status;
    private Time payment_duration;
    public User(String _name){
        this.name = _name;
        this.email = "not_defined";
        this.password = "123456";
        this.type = UserStatus.GRADUANDA;
        this.payment = 0.0;
        this.alloc_status = AllocatorStatus.DEFINITIVE;
        this.payment_duration = new Time(28,7,1996,11,59,0,28,7,2500,11,59,0);
    }
    public User(String _name, String _email, String _password){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = UserStatus.GRADUANDA;
        this.payment = 0.0;
        this.alloc_status = AllocatorStatus.DEFINITIVE;
        this.payment_duration = new Time(28,7,1996,11,59,0,28,7,2500,11,59,0);
    }
    public User(String _name, String _email, String _password, UserStatus _type, Double _payment, AllocatorStatus _alloc_status){
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.type = _type;
        this.payment = _payment;
        this.alloc_status = _alloc_status;
        this.payment_duration = new Time(28,7,1996,11,59,0,28,7,2500,11,59,0);
    }
    public String getName(){return this.name;}
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public UserStatus getStatus(){return this.type;}
    public Double getPayment(){return this.payment;}
    public AllocatorStatus getAllocStatus(){return this.alloc_status;}
    public Time getTimePaymentDuration(){return this.payment_duration;}
    public void setName(String name2){this.name = name2;}
    public void setEmail(String email2){this.email=email2;}
    public void setPassword(String pw){this.password=pw;}
    public void setStatus(UserStatus t){this.type=t;}
    public void setPayment(Double bag_or_payment){this.payment = bag_or_payment;}
    public void setAllocStatus(AllocatorStatus as){this.alloc_status=as;}
    public void setTimePaymentDuration(Time n){this.payment_duration=n;}
    public String printInfoUser(){
        return getName()+" "+"("+getEmail()+", "+getPayment()+", "+getStatus()+", "+getAllocStatus()+")";
    }
    public static void main(String[] args){
        return;
    }
}
