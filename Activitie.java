import java.util.ArrayList;

public class Activitie extends Time{
    private String description;
    private String responsable;
    private ArrayList<User> workers = new ArrayList<User>();
    private int acc_workers = 0;
    public Activitie(){
        super(28,7,1996,11,59,0,28,7,2100,11,59,0);
        this.description = "-1";
        this.responsable = "-1";
        // this.workers.add(new User("-1"));
        // this.acc_workers++;
    }
    public Activitie(String _description, String _responsable){
        super(28,7,1996,11,59,0,28,7,2100,11,59,0);
        this.description = _description;
        this.responsable = _responsable;
        // this.workers.add(new User("-1"));
        // this.acc_workers++;
    }
    public String getDescription(){return this.description;}
    public String getResponsable(){return this.responsable;}
    public ArrayList<User> getUsersAct(){return this.workers;}
    public int getSize(){return this.acc_workers;}
    public void setDescription(String n){this.description=n;}
    public void setResponsable(String n){this.responsable=n;}
    public void setUsersAct(ArrayList<User> n){this.workers = n;}
    public void addUserAtTask(User n){
        // System.out.println("HERE1");
        this.workers.add(n);
        // System.out.println("HERE2");
        this.acc_workers++;
        // getUsersAct().add(new User("-1"));
    }
    public String printWorkers(){
        String result = "";
        for (int i=0; i<getSize(); ++i){
            result = result+"        "+getUsersAct().get(i).printInfoUser()+"\n";
        }
        return result;
    }
}
