import java.util.ArrayList;

public class Projetos {
    private String task;
    private ArrayList<User> users;
    protected String prof_or_research;
    private int id;
    private int state;
    private String description;
    private Time data_time;
    private ArrayList<Activitie> activities;
    private int acc_activities = 0;
    Projetos(){}
    Projetos(int _id, String _task, ArrayList<User> _users, String _prof_or_research, ArrayList<Activitie> _acts){
        this.task = _task;
        this.users = _users;
        this.prof_or_research = _prof_or_research;
        this.id = _id;
        this.state = 0;
        this.description="";
        this.data_time = new Time(28,7,1996,11,59,0,28,7,2100,11,59,0);
        this.activities = _acts;
        this.acc_activities = _acts.size();
    }
    Projetos(int _id, String _task, ArrayList<User> _users, String _prof_or_research, int _state){
        this.task = _task;
        this.users = _users;
        this.prof_or_research = _prof_or_research;
        this.id = _id;
        this.state = _state;
        this.description="";
        this.data_time = new Time(28,7,1996,11,59,0,28,7,2100,11,59,0);
        this.activities = null;
    }
    public void printLineSep(int n){for(int i=0; i<n; i++){System.out.print("-");}System.out.print("\n");}
    public void printAllInfos(){
        int spaces = 10;
        printLineSep(spaces);
        System.out.print("ID: ");
        System.out.println(this.id);
        System.out.print("Tarefa: ");
        System.out.println(this.task);

        System.out.print("Users:\n");
        int acc = 0;
        while(this.users.get(acc).getName().equals("-1")!=true)
        {
            System.out.print("   "+this.users.get(acc).getName());
            acc++;
            if (this.users.get(acc).getName().equals("-1")!=true){System.out.println(".");}
            else{System.out.println(";");}
        }
    }
    public void setID(int n){this.id=n;}
    public void setTask(String n){this.task=n;}
    public void setUsers(ArrayList<User> n){this.users=n;}
    public void setCoord(String n){this.prof_or_research=n;}
    public void setStatus(int n){this.state=n;}
    public void setDescription(String n){this.description=n;}
    public int getStatus(){return this.state;}
    public int getID(){return this.id;}
    public String getTask(){return this.task;}
    public String getCoord(){return this.prof_or_research;}
    public String getDescription()
    {if (this.description.equals("")==false){return this.description;}else{return "\nDescrição não informada.";}}
    public int getUser(String user_searched){
        int acc = 0;
        while(this.users.get(acc).getName().equals("-1")!=true){
            if (this.users.get(acc).getName().equals(user_searched)==true){
                return acc;
            }
            acc++;
        }
        return acc;
    }
    public User getUserPointer(String user){
        int acc = 0;
        while(this.users.get(acc).getName().equals("-1")!=true){
            if (this.users.get(acc).getName().equals(user)==true){
                return this.users.get(acc);
            }
            acc++;
        }
        return null;
    }
    public ArrayList<User> getUsers(){return this.users;}
    public ArrayList<Activitie> getActivities(){return this.activities;}
    public int getActivitieIndex(int index)
    {if (this.activities.get(index)!=null){return index;};return -1;}
    public int getActsLenght(){return this.acc_activities;}
    public int getLenghtUsers(){
        int acc=0;while(this.users.get(acc).getName().equals("-1")!=true){acc++;}return acc;
    }
    public String getStringState(){
        if(this.state==0){return "Em processo de criação";}
        else if (this.state==1){return "Iniciado";}
        else if(this.state==2){return "Em andamento";}
        return "Concluído";
    }
    public Time getData(){return this.data_time;}
    public boolean userExist(User user_name){
        int acc = 0;
        while ((this.users.get(acc).getName()).equals("-1")!=true){
            if ((this.users.get(acc).getName()).equals(user_name.getName())==true){return true;}
            acc++;
        }
        return false;
    }
    public void updateProject(String up_task, ArrayList<User> up_users, String up_coord){
        setTask(up_task);
        setUsers(up_users);
        setCoord(up_coord);
        System.out.println("Edição feita com sucesso.");
    }
    public void addUser(User user){
        int acc = 0;
        while(this.users.get(acc).getName().equals("-1")==false){acc+=1;}
        // acc+=1;
        this.users.add(user);
        acc++;
        String final_name = "-1";
        this.users.add(new User(final_name));
    }
    public void addUser(User user, AllocatorStatus as){
        int acc = 0;
        while((this.users.get(acc).getName()).equals("-1")==false){
            // System.out.println("userINUserExist:"+this.users[acc].getName());
            acc+=1;
        }
        // acc+=1;
        this.users.add(user);
        this.users.get(acc).setAllocStatus(as);
        acc++;
        String final_name = "-1";
        this.users.add(new User(final_name));//, "not_defined", "not_defined", null, 0.0, as);
    }
    public void addActivitie(String descri, String responsa){
        Activitie act = new Activitie(descri, responsa);
        this.activities.add(act);
        this.acc_activities++;
    }
    public Activitie popBackActivitie(int index){
        try{
            if (activities.get(index)!=null && acc_activities>0){
                //remova e retorne
                Activitie act = activities.get(index);
                this.activities.add(new Activitie());
                this.acc_activities--;
                return act;
            }
        } catch(IndexOutOfBoundsException | NullPointerException e){
            System.out.println("Índice não corresponde a nenhuma atividade. Erro: "+e);
        }
        return null;
    }
    static public void main(String[] args){
        return;
    }
}