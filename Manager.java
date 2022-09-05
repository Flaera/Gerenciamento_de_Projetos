import java.util.Scanner;

public class Manager{
    static public int LEN_MAX_USERS = 1000;
    static public int acc_projects=0;
    static public Projetos[] projects;
    public static Scanner opt;

    public static void menu(){
        System.out.println("\n--GERENCIADOR DE PROJETOS--");
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
        System.out.println("Digite 0 para sair do programa.");
    }
    public static int taskExist(String task){
        int idt = -1;
        for (int i=0; i<acc_projects; i++){
            if (projects[i].getID()!=-1 && projects[i].getTask().equals(task)==true){idt=i;break;}
        }
        return idt;
    }
    public static boolean projectExist(int id_proj){
        if (id_proj<acc_projects && projects[id_proj].getID()!=-1){return true;}
        return false;
    }
    public static int findProject(Projetos[] projects, int choose_id, int n){
        int find = -1;
        for (int i=0; i<n; i++){
            if (projects[choose_id].getID()==projects[i].getID()){
                find = i;
                return projects[i].getID();
            }
        }
        if (find==-1){
            System.out.println("Não encontrado ID do projeto. Tente novamente.");
            return find;
        }
        return find;
    }
    public static void main(String[] args){
        projects = new Projetos[LEN_MAX_USERS];
        opt = new Scanner(System.in);
        while (true){
            menu();
            int option = opt.nextInt();
            if (option==1){
                opt.nextLine();
                System.out.println("Escolhida a opção 1.");
                
                System.out.println("Digite a tarefa:");
                String scan0 = opt.nextLine();
                // opt.nextLine();
                
                int acc = 0;
                User[] scan1 = new User[LEN_MAX_USERS];
                System.out.println("Digite o número de usuários: ");
                int max = opt.nextInt();
                opt.nextLine();
                while(acc<max){
                    System.out.print("Digite a(o) "+(acc+1)+"ª usuária(o): ");
                    scan1[acc].setName(opt.nextLine());
                    // opt.nextLine();
                    acc+=1;
                    // opt.nextLine();
                    // System.out.println(scan1[acc]);
                };
                scan1[max].setName("-1");

                System.out.println("Digite a(o) coordenadora(or):");
                String scan2 = opt.nextLine();
                // opt.nextLine();

                projects[acc_projects] = new Projetos(acc_projects, scan0, scan1, scan2);

                projects[acc_projects].printAllInfos();
                acc_projects += 1;
            }
            else if (option==2){
                System.out.println("Escolhida a opção 2.");
                System.out.println("Digite o ID do projeto que deseja remover:");
                int choose_id = opt.nextInt();
                int search = findProject(projects, choose_id, acc_projects);
                if (search!=-1){
                    projects[search].setID(-1);
                    projects[search].setTask(null);
                    projects[search].setUsers(null);
                    projects[search].setCoord(null);
                    System.out.println("Remoção concluída.");
                }
            }
            else if (option==3){
                System.out.println("Escolhida a opção 3.");
                System.out.println("\n--RELATÓRIO DE PROJETOS NA INSTITUIÇÃO--");
                System.out.print("\n");
                for (int i=0; i<acc_projects; ++i){
                    if (projects[i].getID()!=-1==true){
                        projects[i].printAllInfos();
                    }
                }
                System.out.print("\n");
            }
            else if (option==4){
                System.out.println("Escolhida a opção 4");
                System.out.print("Digite o ID do projeto que deseja editar: ");
                int id_choosed = opt.nextInt();
                int id_finded = findProject(projects, id_choosed, acc_projects);
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
                    User[] up_users = new User[LEN_MAX_USERS];
                    int acc = 0;
                    while(acc<max){
                        up_users[acc].setName(opt.nextLine());
                        acc++;
                    }
                    up_users[max].setName("-1");

                    System.out.println("Digite a(o) nova(o) coordenadora(or) deste projeto:");
                    String up_coord = opt.nextLine();

                    projects[id_finded].updateProject(up_task, up_users, up_coord);
                }
            }
            else if (option==5){
                System.out.println("Escolhida a opção 5.");

                System.out.println("Digite uma(um) usuária(o) para associar:");
                opt.nextLine();
                User user = new User(opt.nextLine());
                // System.out.println("USER:");System.out.println(user);
                System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
                int id = Integer.parseInt(opt.nextLine());
                boolean search = false;
                search = projects[id].userExist(user);
                if (search==true){
                    System.out.println("Erro. Usuária(o) já esta no projeto ou ID do projeto não existe.");
                }
                else{
                    projects[id].addUser(user);
                    System.out.println("Usuário "+user+" foi associado.");
                }
            }
            else if (option==6){
                System.out.println("Escolhida a opção 6.");
                
                System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
                // int id6 = Integer.parseInt(opt.nextLine());
                int id6 = opt.nextInt();
                opt.nextLine();
                boolean search = projectExist(id6);
                if (search==true){
                    System.out.println("Digite a(o) usuária(o) a ser associada(o):");
                    User user_name = new User(opt.nextLine());
                    if (projects[id6].userExist(user_name)==false){
                        projects[id6].addUser(user_name);
                        System.out.println("Usuário "+user_name+" foi associado.");
                    }    
                }
                else{System.out.println("Erro. Projeto não existe ou usuária(o) não existe.");}
            }
            else if (option==7){
                System.out.println("Escolhida a opção 7.");
                
                System.out.println("Digite uma atividade:");
                opt.nextLine();
                String task = opt.nextLine();
                System.out.println("Digite uma(um) usuária(o) para associar:");
                String user7 = opt.nextLine();
                int id7 = taskExist(task);
                if (id7!=-1 && projects[id7].userExist(user7)!=true){
                    projects[id7].addUser(user7);
                    System.out.println("Usuário "+user7+" foi associada(o).");
                }
                else{System.out.println("Erro. Atividade não existe ou usuária(o) já esta associada(o).");}
            }
            else if (option==8){
                System.out.println("Escolhida a opção 8.");

                System.out.println("Digite uma(um) usuária(o) para ser associada(o):");
                opt.nextLine();
                String user8 = opt.nextLine();
                System.out.println("Digite uma atividade para associar:");
                String task8 = opt.nextLine();
                int id8 = taskExist(task8);
                if (id8!=-1 && projects[id8].userExist(user8)==false){
                    projects[id8].addUser(user8);
                    System.out.println("Usuário "+user8+" foi associada(o).");
                }
                else{System.out.println("Erro. Usuário já associado a atividade ou atividade não existe.");}
            }
            else if (option==9){
                System.out.println("Escolhida a opção 9.");

                System.out.println("Digite um ID de projeto para alterar o status:");
                opt.nextLine();
                int id9 = Integer.parseInt(opt.nextLine());
                if (projectExist(id9)==true && projects[id9].getStatus()<3){
                    System.out.print("Coord. "+projects[id9].getCoord()+", confirma a alteração de status de \""+projects[id9].getStringState()+"\"");
                    projects[id9].setStatus(projects[id9].getStatus()+1);
                    System.out.println(" para \""+projects[id9].getStringState()+"\"?");
                    System.out.println("Digite 1 para confirmar ou outro número para não confirmar:");
                    int confirm = Integer.parseInt(opt.nextLine());
                    if (confirm==1){System.out.println("Alteração concluída");}
                    else if (projects[id9].getStatus()>0){
                        projects[id9].setStatus(projects[id9].getStatus()-1);
                        System.out.println("Alteração não concluída.");
                    }
                    else{
                        System.out.println("Alteração não concluída.");
                    }
                }
                else{System.out.println("Erro. Projeto não existe ou projeto já concluído.");}
            }
            else if (option==10){
                System.out.println("Escolhida a opção 10.");

                System.out.println("Digite um usuário:");
                opt.nextLine();
                String user = opt.nextLine();
                boolean finded = false;
                for (int i=0; i<acc_projects; i++){
                    if (projects[i].userExist(user)==true){
                        projects[i].printAllInfos();
                        finded = true;
                    }
                }
                if (finded==false){System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==11){
                System.out.println("Escohida a opção 11.");

                System.out.println("Digite um ID de projeto para consultar:");
                opt.nextLine();
                int id11 = Integer.parseInt(opt.nextLine());
                if (projectExist(id11)==true){
                    projects[id11].printAllInfos();
                }
                else{System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==12){
                System.out.println("Escolhido a opção 12.");

                System.out.println("Digite uma atividade para ser consultada:");
                opt.nextLine();
                String task12 = opt.nextLine();
                boolean finded = false;
                for (int i=0; i<acc_projects; i++){
                    if (projects[i].getTask().equals(task12)==true){
                        projects[i].printAllInfos();
                        finded = true;
                    }
                }
                if (finded==false){System.out.println("Erro. Nenhum resultado encontrado.");}
            }
            else if (option==0){opt.close();return;}
        }
    }
}