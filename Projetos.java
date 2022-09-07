public class Projetos{
    public String task;
    public User[] users;
    public String prof_or_research;
    public int id;
    public int state;
    Projetos(int _id, String _task, User[] _users, String _prof_or_research){
        this.task = _task;
        this.users = _users;
        this.prof_or_research = _prof_or_research;
        this.id = _id;
        this.state = 0;
    }
    Projetos(int _id, String _task, User[] _users, String _prof_or_research, int _state){
        this.task = _task;
        this.users = _users;
        this.prof_or_research = _prof_or_research;
        this.id = _id;
        this.state = _state;
    }
    public void printLineSep(int n){for(int i=0; i<n; i++){System.out.print("-");}System.out.print("\n");}
    public void printAllInfos(){
        int spaces = 10;
        printLineSep(spaces);
        System.out.print("ID: ");
        System.out.println(this.id);
        System.out.print("Tarefa: ");
        System.out.println(this.task);

        System.out.print("Users: ");
        int acc = 0;
        while(this.users[acc].getName().equals("-1")!=true)
        {
            System.out.print(this.users[acc].getName()+"("+this.users[acc].getEmail()+", "+this.users[acc].getPayment()+", "+this.users[acc].getStatus()+")");
            acc++;
            if (this.users[acc].getName().equals("-1")!=true){System.out.print("; ");}
        }

        System.out.print("\nCoord.: ");
        System.out.println(this.prof_or_research);

        System.out.print("Status: ");
        System.out.println(getStringState()+".");
        printLineSep(spaces);
    }
    public void setID(int n){this.id=n;}
    public void setTask(String n){this.task=n;}
    public void setUsers(User[] n){this.users=n;}
    public void setCoord(String n){this.prof_or_research=n;}
    public void setStatus(int n){this.state=n;}
    public int getStatus(){return this.state;}
    public int getID(){return this.id;}
    public String getTask(){return this.task;}
    public String getCoord(){return this.prof_or_research;}
    public int getUser(String user_searched){
        int acc = 0;
        while(this.users[acc].getName().equals("-1")!=true){
            if (this.users[acc].getName().equals(user_searched)==true){
                return acc;
            }
            acc++;
        }
        return acc;
    }
    public User getUserPointer(String user){
        int acc = 0;
        while(this.users[acc].getName().equals("-1")!=true){
            if (this.users[acc].getName().equals(user)==true){
                return this.users[acc];
            }
            acc++;
        }
        return null;
    }
    public User[] getUsers(){return this.users;}
    public int getLenghtUsers(){
        int acc=0;while(this.users[acc].getName().equals("-1")!=true){acc++;}return acc;
    }
    public String getStringState(){
        if(this.state==0){return "Em processo de criação";}
        else if (this.state==1){return "Iniciado";}
        else if(this.state==2){return "Em andamento";}
        return "Concluído";
    }
    public boolean userExist(User user_name){
        int acc = 0;
        while (this.users[acc].getName().equals("-1")!=true){
            if (this.users[acc].getName().equals(user_name.getName())){return true;}
            acc++;
        }
        return false;
    }
    public void updateProject(String up_task, User[] up_users, String up_coord){
        setTask(up_task);
        setUsers(up_users);
        setCoord(up_coord);
        System.out.println("Edição feita com sucesso.");
    }
    public void addUser(User user){
        int acc = 0;
        while(this.users[acc].getName().equals("-1")==false){acc+=1;}
        // acc+=1;
        this.users[acc] = user;
        acc++;
        String final_name = "-1";
        this.users[acc] = new User(final_name);
    }
    static public void main(String[] args){
        return;
    }
}