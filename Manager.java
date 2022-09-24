import java.util.Scanner;
import java.util.ArrayList;

public class Manager extends Projetos{
    public static int LEN_MAX_USERS = 1000;
    public static int acc_projects=0;
    public static ArrayList<Projetos> projects;
    public static Scanner opt;
    public static User user_data;
    public Manager(User _user_data){
        super();
        user_data = _user_data;
    }

    public static User getLogin(){return user_data;}

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
        System.out.println("Digite 15 para undo.");
        System.out.println("Digite 16 para redo.");
        System.out.println("Digite 0 para sair do programa.");
    }
    public static int taskExist(String task){
        int idt = -1;
        for (int i=0; i<acc_projects; i++){
            if (projects.get(i).getID()!=-1 && projects.get(i).getTask().equals(task)==true){idt=i;break;}
        }
        return idt;
    }
    public static boolean projectExist(int id_proj){
        if (id_proj<acc_projects && projects.get(id_proj).getID()!=-1){return true;}
        return false;
    }
    public static int findProject(ArrayList<Projetos> projects, int choose_id){
        int find = -1;
        for (int i=0; i<projects.size(); i++){
            if (projects.get(choose_id).getID()==projects.get(i).getID()){
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
    public User[] editUsers(int max){
        User[] scan1 = new User[LEN_MAX_USERS];
        int acc = 0;
        for(acc=0; acc<max; acc++){
            System.out.print("Digite a(o) "+(acc+1)+"ª usuária(o): ");
            String name1 = "";
            name1 = opt.nextLine();
            
            System.out.print("Digite a(o) e-mail da(o) "+(acc+1)+"ª usuária(o): ");
            String email1 = "";
            email1 = opt.nextLine();

            System.out.print("Digite se a(o) "+(acc+1)+"ª usuária(o) é aluna(o), professora(or) ou pesquisadora(or): ");
            UserStatus type = UserStatus.valueOf(opt.nextLine().toUpperCase());

            scan1[acc] = new User(name1, email1, "123", type, 0.0, AllocatorStatus.DEFINITIVE);
            // acc+=1;
            // opt.nextLine();
            // System.out.println(scan1[acc]);
        };
        scan1[max] = new User("-1");
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

                System.out.print("Users:\n");
                int acc = 0;
                User[] users = projects.get(i).getUsers();
                while(users[acc].getName().equals("-1")!=true)
                {
                    System.out.print("   "+users[acc].getName()+"("+users[acc].getEmail()+", "+users[acc].getPayment()+", "+users[acc].getStatus()+", "+users[acc].getAllocStatus()+")");
                    acc++;
                    if (users[acc].getName().equals("-1")!=true){System.out.print(".");}
                    else{System.out.println(";");}
                }
                System.out.print("\nCoord.: ");
                System.out.println(projects.get(i).getCoord());

                System.out.print("Status: ");
                System.out.println(getStringState()+".");
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
            int option = Integer.parseInt(opt.nextLine());
            // opt.nextLine();
            if (option==1){
                // opt.nextLine();
                System.out.println("Escolhida a opção 1.");
                
                System.out.println("Digite a tarefa:");
                String scan0;
                scan0=opt.nextLine();
                // opt.nextLine();
                User[] scan1;
                System.out.println("Digite o número de usuárias(os): ");
                int max = Integer.parseInt(opt.nextLine());
                // opt.nextLine();
                scan1 = editUsers(max);

                System.out.println("Digite a(o) coordenadora(or):");
                String scan2 = opt.nextLine();
                // opt.nextLine();

                projects.add(new Projetos(acc_projects, scan0, scan1, scan2));
                // acc_projects++;

                projects.get(acc_projects-1).printAllInfos();
                acc_projects += 1;
            }
            else if (option==2){
                System.out.println("Escolhida a opção 2.");
                System.out.println("Digite o ID do projeto que deseja remover:");
                int choose_id = Integer.parseInt(opt.nextLine());
                int search = findProject(projects, choose_id);
                if (search!=-1){
                    projects.get(search).setID(-1);
                    projects.get(search).setTask("");
                    projects.get(search).setUsers(null);
                    projects.get(search).setCoord("");
                    System.out.println("Remoção concluída.");
                }
                if (search==-1){System.out.println("ID não encontrado.");}
            }
            else if (option==3){
                System.out.println("Escolhida a opção 3.");
                System.out.println("\n--RELATÓRIO DE PROJETOS NA INSTITUIÇÃO--");
                System.out.print("\n");
                for (int i=0; i<acc_projects; ++i){
                    if (projects.get(i)!=null){
                        if (projects.get(i).getID()!=-1){
                            // projects.get(i).printAllInfos();
                            printAllInfos();
                        }
                    }
                }
                System.out.print("\n");
            }
            else if (option==4){
                System.out.println("Escolhida a opção 4");
                System.out.print("Digite o ID do projeto que deseja editar: ");
                int id_choosed = opt.nextInt();
                int id_finded = findProject(projects, id_choosed);
                if (id_finded!=-1){
                    //Editar
                    System.out.println("Digite a nova tarefa do Projeto:");
                    String up_task;
                    opt.nextLine();
                    up_task = opt.nextLine();

                    System.out.println("Digite o novo número de usuárias(os) deste projeto:");
                    int max = Integer.parseInt(opt.nextLine());
                    // opt.nextLine();
                    System.out.println("Digite as(os) novas(os) usuárias(os) deste projeto:");
                    User[] up_users;
                    up_users = editUsers(max);

                    System.out.println("Digite a(o) nova(o) coordenadora(or) deste projeto:");
                    String up_coord = opt.nextLine();

                    projects.get(id_finded).updateProject(up_task, up_users, up_coord);
                }
            }
            else if (option==5){
                System.out.println("Escolhida a opção 5.");

                System.out.println("Digite uma(um) usuária(o) para associar:");
                // opt.nextLine();
                User user5 = new User(opt.nextLine());
                // System.out.println("USER:");System.out.println(user);
                System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
                int id5 = Integer.parseInt(opt.nextLine());
                // id5 = opt.nextInt();
                boolean search = false;
                search = projects.get(id5).userExist(user5);
                if (search==true){
                    System.out.println("Erro. Usuária(o) já esta no projeto ou ID do projeto não existe.");
                }
                else{
                    projects.get(id5).addUser(user5);
                    System.out.println("Usuária(o) "+user5.getName()+" foi associado.");
                }
            }
            else if (option==6){
                System.out.println("Escolhida a opção 6.");
                
                System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
                // int id6 = Integer.parseInt(opt.nextLine());
                int id6 = Integer.parseInt(opt.nextLine());
                // opt.nextLine();
                boolean search = projectExist(id6);
                if (search==true){
                    System.out.println("Digite a(o) usuária(o) a ser associada(o):");
                    User user_name = new User(opt.nextLine());
                    if (projects.get(id6).userExist(user_name)==false){
                        projects.get(id6).addUser(user_name);
                        System.out.println("Usuária(o) "+user_name.getName()+" foi associado.");
                    }    
                }
                else{System.out.println("Erro. Projeto não existe ou usuária(o) não existe.");}
            }
            else if (option==7){
                System.out.println("Escolhida a opção 7.");
                
                System.out.println("Digite uma atividade:");
                // opt.nextLine();
                String task = opt.nextLine();
                System.out.println("Digite uma(um) usuária(o) para associar:");
                User user7 = new User(opt.nextLine());
                int id7 = taskExist(task);
                if (id7!=-1 && projects.get(id7).userExist(user7)!=true){
                    projects.get(id7).addUser(user7);
                    System.out.println("Usuária(o) "+user7.getName()+" foi associada(o).");
                }
                else{System.out.println("Erro. Atividade não existe ou usuária(o) já esta associada(o).");}
            }
            else if (option==8){
                System.out.println("Escolhida a opção 8.");

                System.out.println("Digite uma(um) usuária(o) para ser associada(o):");
                // opt.nextLine();
                User user8 = new User(opt.nextLine().toUpperCase());
                System.out.println("Digite uma atividade para associar:");
                String task8 = opt.nextLine();
                int id8 = taskExist(task8);
                if (id8!=-1 && projects.get(id8).userExist(user8)==false){
                    projects.get(id8).addUser(user8);
                    System.out.println("Usuária(o) "+user8.getName()+" foi associada(o).");
                }
                else{System.out.println("Erro. Usuário já associado a atividade ou atividade não existe.");}
            }
            else if (option==9){
                System.out.println("Escolhida a opção 9.");

                System.out.println("Digite um ID de projeto para alterar o status:");
                // opt.nextLine();
                int id9 = Integer.parseInt(opt.nextLine());
                String coord = projects.get(id9).getCoord();
                boolean permission = projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PROFESSORA || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PROFESSOR || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PESQUISADORA || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PESQUISADOR;
                if (projectExist(id9)==true && projects.get(id9).getStatus()<3 && getLogin().getName().equals(projects.get(id9).getCoord()) && (permission==true)){
                    System.out.print("Coord. "+projects.get(id9).getCoord()+", confirma a alteração de status de \""+projects.get(id9).getStringState()+"\"");
                    projects.get(id9).setStatus(projects.get(id9).getStatus()+1);
                    System.out.println(" para \""+projects.get(id9).getStringState()+"\"?");
                    System.out.println("Digite 1 para confirmar ou outro número para não confirmar:");
                    int confirm = Integer.parseInt(opt.nextLine());
                    if (confirm==1){System.out.println("Alteração concluída");}
                    else if (projects.get(id9).getStatus()>0){
                        projects.get(id9).setStatus(projects.get(id9).getStatus()-1);
                        System.out.println("Alteração não concluída.");
                    }
                    else{
                        System.out.println("Alteração não concluída.");
                    }
                }
                else{System.out.println("Erro. Projeto não existe, já concluído ou você não possui permissão para isso.");}
            }
            else if (option==10){
                System.out.println("Escolhida a opção 10.");

                System.out.println("Digite um usuário:");
                // opt.nextLine();
                User user10 = new User(opt.nextLine());
                boolean finded = false;
                for (int i=0; i<acc_projects; i++){
                    if (projects.get(i).userExist(user10)==true){
                        projects.get(i).printAllInfos();
                        finded = true;
                    }
                }
                if (finded==false){System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==11){
                System.out.println("Escohida a opção 11.");

                System.out.println("Digite um ID de projeto para consultar:");
                // opt.nextLine();
                int id11 = Integer.parseInt(opt.nextLine());
                if (projectExist(id11)==true){
                    projects.get(id11).printAllInfos();
                }
                else{System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==12){
                System.out.println("Escolhida a opção 12.");

                System.out.println("Digite uma atividade para ser consultada:");
                // opt.nextLine();
                String task12 = opt.nextLine();
                boolean finded = false;
                for (int i=0; i<acc_projects; i++){
                    if (projects.get(i).getTask().equals(task12)==true){
                        projects.get(i).printAllInfos();
                        finded = true;
                    }
                }
                if (finded==false){System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==13){
                System.out.println("Escolhida a opção 13.");

                System.out.println("Digite a(o) usuária(o) que deseja intercambiar:");
                String user13 = opt.nextLine();
                // User user13Pointer = new User(user13);
                System.out.println("Digite o ID do projeto que vai receber a(o) intercambista:");
                int id13 = Integer.parseInt(opt.nextLine());
                boolean error = false;
                if (projectExist(id13)==true){
                    //System.out.println("HERE1");
                    // System.out.println("id:"+projects[id13].getUsers());
                    // System.out.println("userExist:"+projects[id13].userExist(user13Pointer));
                    int id13_1 = -1;
                    for (int i=0; i<acc_projects; i++){
                        User[] users13_2 = projects.get(i).getUsers();
                        int acc13 = 0;
                        while(users13_2[acc13].getName().equals("-1")!=true){
                            if (user13.equals(users13_2[acc13].getName())==true){id13_1=acc13;break;}
                            acc13++;
                        }
                        if(id13_1!=-1){break;}
                    }
                    if (id13_1!=-1){
                        // System.out.println("HERE2");
                        User user13_searched = projects.get(id13_1).getUserPointer(user13);
                        projects.get(id13_1).addUser(user13_searched, AllocatorStatus.INTERCAMBISTA);
                        System.out.println("Intercâmbio feito.");
                    }
                    else {error=true;}
                }
                if (error==true){
                    System.out.println("Erro. Projeto não existe ou usuário não existe.");
                }
            }
            else if (option==14){
                System.out.println("Escolhida a opção 14.");

                System.out.println("Digite um nome de usuária(o):");
                String user_name14 = opt.nextLine();
                System.out.println("Digite o valor da bolsa para esta(o) usuária(o):");
                double new_value14 = Double.parseDouble(opt.nextLine());
                boolean update14 = false;
                for (int i=0; i<acc_projects; i++){
                    User user_name14_2 = projects.get(i).getUserPointer(user_name14);
                    if (user_name14_2!=null){
                        user_name14_2.setPayment(new_value14);
                        update14 = true;
                    }
                }
                if (update14==true){
                    System.out.println("Valor alterado com sucesso.");
                }else{System.out.println("Erro. Usuário não existe.");}
            }
            else if (option==15){return -1;}
            else if (option==16){return 1;}
            else if (option==0){opt.close();return 0;}
            opt.close();
            // break; //Break the loop and send answer to do_while loop in Main
            // return 0;
        }
        // System.out.println("Finishing instance...");
        // opt.close();
        // return 1;
    }
    // public static void main(String[] args){return;}
}