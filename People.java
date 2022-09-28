public abstract class People {
    public abstract String getName();
    public abstract String getEmail();
    public abstract String getPassword();
    public abstract UserStatus getStatus();
    public abstract Double getPayment();
    public abstract AllocatorStatus getAllocStatus();
    public abstract void setName(String name2);
    public abstract void setEmail(String email2);
    public abstract void setPassword(String pw);
    public abstract void setStatus(UserStatus t);
    public abstract void setPayment(Double bag_or_payment);
    public abstract void setAllocStatus(AllocatorStatus as);
}
