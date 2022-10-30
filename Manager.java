import java.util.Scanner;
import java.util.ArrayList;

public class Manager extends Projetos implements MainManager{
    public static int acc_projects=0;
    private static ArrayList<Projetos> projects;
    private static Scanner opt;
    public static User user_data;
    public Manager(User _user_data){
        super();
        user_data = _user_data;
        // for (int i=0; i<LEN_MAX_USERS; i++){projects.get(i).setID(-1);}
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
        System.out.println("Digite 15 para adicionar uma descrição a um projeto.");
        System.out.println("Digite 16 para definir data de inicio e término de um projeto.");
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

            System.out.print("Digite se a(o) "+(acc+1)+"ª usuária(o) é aluna(o), professora(or) ou pesquisadora(or): ");
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
                    System.out.print("   "+users.get(acc).getName()+"("+users.get(acc).getEmail()+", "+users.get(acc).getPayment()+", "+users.get(acc).getStatus()+", "+users.get(acc).getAllocStatus()+")");
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

                System.out.print("Data de inicio: ");
                System.out.println(projects.get(i).getData().getDataCreationString());
                System.out.print("Data de término: ");
                System.out.println(projects.get(i).getData().getDataTerminateString());

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
                
                try{
                    System.out.println("Escolhida a opção 1.");
                    
                    System.out.println("Digite a tarefa:");
                    String scan0;
                    scan0=opt.nextLine();
                    
                    System.out.println("Digite o número de usuárias(os): ");
                    int max = Integer.parseInt(opt.nextLine());
                    ArrayList<User> scan1;
                    scan1 = editUsers(max);

                    System.out.println("Digite a(o) coordenadora(or):");
                    String scan2;    
                    scan2 = opt.nextLine();

                    projects.add(new Projetos(acc_projects, scan0, scan1, scan2));
                    // acc_projects++;

                    projects.get(acc_projects).printAllInfos();
                    acc_projects += 1;
                    // opt.nextLine();
                } catch (NullPointerException e) {
                    System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
                } catch (NumberFormatException e){
                    System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
                } catch (IllegalArgumentException e){
                    System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
                }
            }
            else if (option==2){
                System.out.println("Escolhida a opção 2.");
                System.out.println("Digite o ID do projeto que deseja remover:");
                int choose_id = -1;
                try{
                    choose_id = Integer.parseInt(opt.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Inválida entrada. Erro: "+e+" Tente novamente.");
                }
                int search;
                if(choose_id>=0 && choose_id<acc_projects){
                    search = findProject(projects, choose_id);
                    if (search!=-1){
                        projects.get(search).setID(-1);
                        projects.get(search).setTask("");
                        projects.get(search).setUsers(null);
                        projects.get(search).setCoord("");
                        System.out.println("Remoção concluída.");
                    }
                    if (search==-1){System.out.println("ID não encontrado.");}
                }
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
                try{
                    int id_choosed = Integer.parseInt(opt.nextLine());
                    int id_finded = findProject(projects, id_choosed);
                    if (id_finded!=-1){
                        //Editar
                        System.out.println("Digite a nova tarefa do Projeto:");
                        String up_task;
                        // opt.nextLine();
                        up_task = opt.nextLine();

                        System.out.println("Digite o novo número de usuárias(os) deste projeto:");
                        int max = Integer.parseInt(opt.nextLine());
                        // opt.nextLine();
                        System.out.println("Digite as(os) novas(os) usuárias(os) deste projeto:");
                        ArrayList<User> up_users;
                        up_users = editUsers(max);

                        System.out.println("Digite a(o) nova(o) coordenadora(or) deste projeto:");
                        String up_coord = opt.nextLine();

                        projects.get(id_finded).updateProject(up_task, up_users, up_coord);
                    }
                } catch (IndexOutOfBoundsException | NumberFormatException | NullPointerException e){
                    System.out.println("Algum erro com entradas dos números ou dos textos. Erro: "+e+" Tente novamente.");
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
                        ArrayList<User> users13_2 = projects.get(i).getUsers();
                        int acc13 = 0;
                        while(users13_2.get(acc13).getName().equals("-1")!=true){
                            if (user13.equals(users13_2.get(acc13).getName())==true){id13_1=acc13;break;}
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
                String user_name14 = "-1";
                double new_value14 = 0.0f;
                try{
                    System.out.println("Digite um nome de usuária(o):");
                    user_name14 = opt.nextLine();
                    System.out.println("Digite o valor da bolsa para esta(o) usuária(o):");    
                    new_value14 = Double.parseDouble(opt.nextLine());

                    for (int i=0; i<acc_projects; i++){
                        User user_name14_2 = projects.get(i).getUserPointer(user_name14);
                        user_name14_2.setPayment(new_value14);
                        System.out.println("Atribuição de bolsa feita com sucesso.");
                    }
                }catch (NumberFormatException | NullPointerException e){
                    System.out.println("Entrada de decimal inválida ou usuária(o) não existe. Erro: "+e+"Tente novamente.");    
                }
            }
            else if (option==15){
                System.out.println("Escolhida a opção 15.");
                System.out.println("Digite o ID do projeto que deseja editar a descrição:");
                int choose_id = -1;
                try{
                    choose_id = Integer.parseInt(opt.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Inválida entrada. Erro: "+e+" Tente novamente.");
                }
                int search;
                if(choose_id>=0 && choose_id<acc_projects){
                    search = findProject(projects, choose_id);
                    if (search!=-1){
                        System.out.println("Digite a nova descrição até apertar ENTER.");
                        projects.get(search).setDescription(opt.nextLine());
                        System.out.println("Alteração concluída.");
                    }
                    if (search==-1){System.out.println("ID não encontrado.");}
                }
            }
            else if (option==16){
                System.out.println("Escolhida a opção 16.");
                try{
                    int id16 = -1;
                    int search;
                    System.out.println("Escolha o ID do projeto:");
                    id16 = Integer.parseInt(opt.nextLine());
                    if(id16>=0 && id16<acc_projects){
                        search = findProject(projects, id16);
                        if (search!=-1){

                            System.out.println("Digite a data de início do projeto:");
                            System.out.println("Digite o dia:");
                            int day_init = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o mês:");
                            int montly_init = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o ano:");
                            int year_init = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite a hora:");
                            int hour_init = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o minuto:");
                            int min_init = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o segundo:");
                            int sec_init = Integer.parseInt(opt.nextLine());
                            projects.get(search).getData().setDataCreationString(day_init, montly_init, year_init,
                             hour_init, min_init, sec_init);

                            System.out.println("Digite a data de término do projeto:");
                            System.out.println("Digite o dia:");
                            int day_term = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o mês:");
                            int montly_term = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o ano:");
                            int year_term = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite a hora:");
                            int hour_term = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o minuto:");
                            int min_term = Integer.parseInt(opt.nextLine());
                            System.out.println("Digite o segundo:");
                            int sec_term = Integer.parseInt(opt.nextLine());
                            projects.get(search).getData().setDataTerminateString(day_term, montly_term, year_term,
                            hour_term, min_term, sec_term);
                        }
                    }
                }
                catch (NumberFormatException | NullPointerException e){
                    System.out.println("ID não encontrado. Erro: "+e);
                }
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