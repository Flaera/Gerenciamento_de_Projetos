import java.util.Scanner;

public class Manager{
    public static int LEN_MAX_USERS = 1000;
    public static int acc_projects=0;
    public static Projetos[] projects;
    public static Scanner opt;
    public static User user_data;
    public Manager(User _user_data){
        user_data = _user_data;
    }

    public static User getLogin(){return user_data;}

    public static void subMenu1(){
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
    public int Runner(){
        projects = new Projetos[LEN_MAX_USERS];
        opt = new Scanner(System.in);
        while (true){
            subMenu1();
            // System.out.println("Pressione enter:");
            // opt.nextLine();
            int option = Integer.parseInt(opt.nextLine());
            // opt.nextLine();
            if (option==1){
                // opt.nextLine();
                System.out.println("Escolhida a opção 1.");
                
                System.out.println("Digite a tarefa:");
                String scan0 = opt.nextLine();
                // opt.nextLine();
                User[] scan1;
                System.out.println("Digite o número de usuárias(os): ");
                int max = Integer.parseInt(opt.nextLine());
                // opt.nextLine();
                scan1 = editUsers(max);

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
                int choose_id = Integer.parseInt(opt.nextLine());
                int search = findProject(projects, choose_id, acc_projects);
                if (search!=-1){
                    projects[search].setID(-1);
                    projects[search].setTask("");
                    projects[search].setUsers(null);
                    projects[search].setCoord("");
                    System.out.println("Remoção concluída.");
                }
                if (search==-1){System.out.println("ID não encontrado.");}
            }
            else if (option==3){
                System.out.println("Escolhida a opção 3.");
                System.out.println("\n--RELATÓRIO DE PROJETOS NA INSTITUIÇÃO--");
                System.out.print("\n");
                for (int i=0; i<acc_projects; ++i){
                    if (projects[i]!=null){
                        if (projects[i].getID()!=-1){
                            projects[i].printAllInfos();
                        }
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
                    User[] up_users;
                    up_users = editUsers(max);

                    System.out.println("Digite a(o) nova(o) coordenadora(or) deste projeto:");
                    String up_coord = opt.nextLine();

                    projects[id_finded].updateProject(up_task, up_users, up_coord);
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
                search = projects[id5].userExist(user5);
                if (search==true){
                    System.out.println("Erro. Usuária(o) já esta no projeto ou ID do projeto não existe.");
                }
                else{
                    projects[id5].addUser(user5);
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
                    if (projects[id6].userExist(user_name)==false){
                        projects[id6].addUser(user_name);
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
                if (id7!=-1 && projects[id7].userExist(user7)!=true){
                    projects[id7].addUser(user7);
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
                if (id8!=-1 && projects[id8].userExist(user8)==false){
                    projects[id8].addUser(user8);
                    System.out.println("Usuária(o) "+user8.getName()+" foi associada(o).");
                }
                else{System.out.println("Erro. Usuário já associado a atividade ou atividade não existe.");}
            }
            else if (option==9){
                System.out.println("Escolhida a opção 9.");

                System.out.println("Digite um ID de projeto para alterar o status:");
                // opt.nextLine();
                int id9 = Integer.parseInt(opt.nextLine());
                String coord = projects[id9].getCoord();
                boolean permission = projects[id9].getUserPointer(coord).getStatus()==UserStatus.PROFESSORA || projects[id9].getUserPointer(coord).getStatus()==UserStatus.PROFESSOR || projects[id9].getUserPointer(coord).getStatus()==UserStatus.PESQUISADORA || projects[id9].getUserPointer(coord).getStatus()==UserStatus.PESQUISADOR;
                if (projectExist(id9)==true && projects[id9].getStatus()<3 && getLogin().getName().equals(projects[id9].prof_or_research) && (permission==true)){
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
                else{System.out.println("Erro. Projeto não existe, já concluído ou você não possui permissão para isso.");}
            }
            else if (option==10){
                System.out.println("Escolhida a opção 10.");

                System.out.println("Digite um usuário:");
                // opt.nextLine();
                User user10 = new User(opt.nextLine());
                boolean finded = false;
                for (int i=0; i<acc_projects; i++){
                    if (projects[i].userExist(user10)==true){
                        projects[i].printAllInfos();
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
                    projects[id11].printAllInfos();
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
                    if (projects[i].getTask().equals(task12)==true){
                        projects[i].printAllInfos();
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
                        User[] users13_2 = projects[i].getUsers();
                        int acc13 = 0;
                        while(users13_2[acc13].getName().equals("-1")!=true){
                            if (user13.equals(users13_2[acc13].getName())==true){id13_1=acc13;break;}
                            acc13++;
                        }
                        if(id13_1!=-1){break;}
                    }
                    if (id13_1!=-1){
                        // System.out.println("HERE2");
                        User user13_searched = projects[id13_1].getUserPointer(user13);
                        projects[id13].addUser(user13_searched, AllocatorStatus.INTERCAMBISTA);
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
                    User user_name14_2 = projects[i].getUserPointer(user_name14);
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
            else if (option==0){opt.close();break;}
            // return 0;
        }
        return 0;
    }
    // public static void main(String[] args){return;}
}