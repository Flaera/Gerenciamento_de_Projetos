public class User {
    public String name;
    public int type;
    public User(String _name){
        this.name = _name;
        this.type = 0;
    }
    public User(String _name, int _type){
        this.name = _name;
        this.type = _type;
    }
    public String getName(){return this.name;}
    public int getType(){return this.type;}
    public void setName(String name2){this.name = name2;}
    public void setType(int t){this.type=t;}
    public static void main(String[] args){
        return;
    }
}
