import java.util.Scanner;
import java.util.ArrayList;


public class Manager extends Projetos implements MainManager{
    public static int acc_projects=0;
    private static ArrayList<Projetos> projects;
    private static Scanner opt;
    public User user_data;
    public Manager(User _user_data){
        super();
        this.user_data = _user_data;
        // for (int i=0; i<LEN_MAX_USERS; i++){projects.get(i).setID(-1);}
    }

    public User getLogin(){return user_data;}

    public void subMenu1(){
        System.out.println("\n--GERENCIADOR DE PROJETOS--");
        System.out.println("Logada(o) como: "+getLogin().getName()+".");
        System.out.println("Digite 1 para criar um projeto.");
        System.out.println("Digite 2 para remover um projeto.");
        System.out.println("Digite 3 para exibir relatório dos projetos.");
        System.out.println("Digite 4 para editar um projeto a partir de um ID.");
        System.out.println("Digite 5 para associar uma(um) usuária(o) a algum projeto.");
        System.out.println("Digite 6 para associar um projeto a uma(um) usuária(o).");
        System.out.println("Digite 7 para associar uma atividade a uma(um) usuária(o).");
        System.out.println("Digite 8 para associar uma(um) usuária(o) a uma atividade.");
        System.out.println("Digite 9 para alterar o status de um projeto.");
        System.out.println("Digite 10 para consultar por usuária(o).");
        System.out.println("Digite 11 para consultar por ID de projeto.");
        System.out.println("Digite 12 para consultar por atividade.");
        System.out.println("Digite 13 para intercambiar uma(um) usuária(o) para um projeto.");
        System.out.println("Digite 14 para atribuir um valor de bolsa a uma(um) usuária(o).");
        System.out.println("Digite 15 para adicionar uma descrição a um projeto.");
        System.out.println("Digite 16 para definir data de inicio e término de um projeto.");
        // System.out.println("Digite 17 para adicionar uma atividade a um projeto.");
        System.out.println("Digite 0 para sair do programa.");
    }
    public static boolean projectExist(int id_proj){
        if (id_proj<acc_projects && projects.get(id_proj).getID()!=-1){return true;}
        return false;
    }
    public int findProject(ArrayList<Projetos> projects, int choose_id){
        int find = -1;
        for (int i=0; i<projects.size(); i++){
            int x = projects.get(choose_id).getID();
            boolean choosed = x==-1;
            // System.out.println("proj.get.getID: "+projects.get(choose_id).getID());
            
            if (choosed==false && projects.get(choose_id).getID()==projects.get(i).getID()){
                find = i;
                return projects.get(i).getID();
            }
            
        }
        if (find==-1){
            System.out.println("Não encontrado ID do projeto. Tente novamente.");
            return find;
        }
        return find;
    }
    public ArrayList<User> editUsers(int max){
        ArrayList<User> scan1 = new ArrayList<User>();
        int acc = 0;
        for(acc=0; acc<max; acc++){
            System.out.print("Digite a(o) "+(acc+1)+"ª usuária(o): ");
            String name1 = "";
            name1 = opt.nextLine();
            
            System.out.print("Digite a(o) e-mail da(o) "+(acc+1)+"ª usuária(o): ");
            String email1 = "";
            email1 = opt.nextLine();

            System.out.print("Digite se a(o) "+(acc+1)+"ª usuária(o) é graduanda(o), mestranda(o), doutoranda(o), técnica(o), desenvolvedora(or), testadora(or), analista, professora(or) ou pesquisadora(or): ");
            UserStatus type = UserStatus.valueOf(opt.nextLine().toUpperCase());

            scan1.add(new User(name1, email1, "123", type, 0.0, AllocatorStatus.DEFINITIVE));
            // acc+=1;
            // opt.nextLine();
            // System.out.println(scan1[acc]);
        };
        scan1.add(new User("-1"));
        return scan1;
    }
    @Override
    public void printAllInfos() {
        int spaces = 20;
        // TODO Auto-generated method stub
        // super.printAllInfos();
        for (int i=0; i<projects.size(); i++){
            if (projects.get(i).getID()!=-1){
                printLineSep(spaces);
                System.out.print("ID: ");
                System.out.println(projects.get(i).getID());
                System.out.print("Tarefa: ");
                System.out.println(projects.get(i).getTask());

                System.out.print("\nUsers:\n");
                int acc = 0;
                ArrayList<User> users = projects.get(i).getUsers();
                while(users.get(acc).getName().equals("-1")!=true)
                {
                    System.out.print("   "+users.get(acc).printInfoUser());
                    acc++;
                    if (users.get(acc).getName().equals("-1")!=true){System.out.println(",");}
                    else{System.out.println(";");}
                }
                System.out.print("\nCoord.: ");
                System.out.println(projects.get(i).getCoord());

                System.out.print("Status: ");
                System.out.println(getStringState()+".");

                System.out.print("Descrição: ");
                System.out.println(projects.get(i).getDescription());

                System.out.print("Data de inicio da(s) bolsa(s): ");
                System.out.println(projects.get(i).getData().getDataCreationString());
                System.out.print("Data de término da(s) bolsa(s): ");
                System.out.println(projects.get(i).getData().getDataTerminateString());
     
                System.out.println();
                projects.get(i).printActs();

                printLineSep(spaces);
            }
        }
    }
    public int Runner(int input_option){
        // int end = 0;
        projects = new ArrayList<Projetos>();
        opt = new Scanner(System.in);
        // subMenu1();
        // String input = "";
        // System.out.println("input:"+input);
        while (true){
            subMenu1();
            // input = opt.nextLine();
            // System.out.println("Pressione enter:");
            int option;
            try{option = Integer.parseInt(opt.nextLine());}
            catch (NumberFormatException e){
                System.out.println("Opção inválida. Erro"+e+" Tente novamente.");
                break;
            }
            // finally{option=-1;}
            // opt.nextLine();
            if (option==1){
                // opt.nextLine();
                
                CreateProjectManager cpm = new CreateProjectManager();
                cpm.runner(opt, projects);
            }
            else if (option==2){
                
                RemoveProjectManager rpm = new RemoveProjectManager();
                rpm.runner(opt, projects);
            }
            else if (option==3){
                System.out.println("Escolhida a opção 3.");
                System.out.println("\n--RELATÓRIO DE PROJETOS NA INSTITUIÇÃO--");
                System.out.print("\n");
                printAllInfos();
                System.out.print("\n");
            }
            else if (option==4){
                EditionProjectManager epm = new EditionProjectManager();
                epm.runner(opt, projects);
            }
            else if (option==5){
                AssociateUserAtProject auatpm = new AssociateUserAtProject();
                auatpm.runner(opt, projects);
            }
            else if (option==6){
                AssociateProjectAtUser apaum = new AssociateProjectAtUser();
                apaum.runner(opt, projects);
            }
            else if (option==7){
                AssociateActivitieAtUser aaaum = new AssociateActivitieAtUser();
                aaaum.runner(opt, projects);
            }
            else if (option==8){
                AssociateUserAtActivitie auaam = new AssociateUserAtActivitie();
                auaam.runner(opt, projects);
            }
            else if (option==9){
                ChangeStatus csm = new ChangeStatus();
                csm.runner(opt, projects);
            }
            else if (option==10){
                SearchUser sum = new SearchUser();
                sum.runner(opt, projects);
            }
            else if (option==11){
                SearchIDProject sidpm = new SearchIDProject();
                sidpm.runner(opt, projects);
            }
            else if (option==12){
                SearchActivitie sam = new SearchActivitie();
                sam.runner(opt, projects);
            }
            else if (option==13){
                InterchangeUser ium = new InterchangeUser();
                ium.runner(opt, projects);
            }
            else if (option==14){
                AttributeValue avm = new AttributeValue();
                avm.runner(opt, projects);
            }
            else if (option==15){
                AddDescription adm = new AddDescription();
                adm.runner(opt, projects);
            }
            else if (option==16){
                SetDateTime sdtm = new SetDateTime();
                sdtm.runner(opt, projects);
            }
            // else if (option==15){return -1;}
            // else if (option==16){return 1;}
            else if (option==0){opt.close();return 0;}
            // opt.close();
            // break; //Break the loop and send answer to do_while loop in Main
            // return 0;
        }
        // System.out.println("Finishing instance...");
        opt.close();
        return 1;
    }
    // public static void main(String[] args){return;}
}