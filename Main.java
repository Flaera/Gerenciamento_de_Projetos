import java.util.Scanner;
import java.util.List;
import java.util.Stack;

public class Main{
    // public Manager manager = null;
    // public Scanner opt = null;
    public static void Menu(){
        System.out.println("\n--GERENCIADOR DE PROJETOS--");
        System.out.println("1 para criar um usuária(o).");
        System.out.println("2 para logar um usuária(o).");
        System.out.println("3 se esqueceu a senha de alguma ou algum usuária(o).");
        System.out.println("0 para sair do programa.");
    }
    public static void main(String[] args){
        User[] users = new User[MainManager.LEN_MAX_USERS];
        int acc_users = 0;

        Stack<Manager> manager = new Stack<Manager>();
        manager.add(null);
        Scanner opt = new Scanner(System.in);

        int option = -1;
        while(option!=0){ //&& manager==null){
            Menu();
            option = Integer.parseInt(opt.nextLine());
            // option = opt.nextInt();

            if (option==1){
                System.out.println("Digite um nome de usuária(o):");
                String name = opt.nextLine();
                System.out.println("Digite um e-mail para a(o) usuária(o):");
                String email = opt.nextLine();
                System.out.println("Digite uma senha para a(o) usuária(o):");
                String password = opt.nextLine();
                System.out.println("Deseja inserir o tipo de usuária(o). Digite \"S\" para sim ou \"N\" para não");
                String like_status = opt.nextLine().toUpperCase();
                if (like_status.equals("S")==true){
                    System.out.print("Digite se a(o) "+(name)+" usuária(o) é graduanda(o), mestranda(o), doutoranda(o), técnica(o), desenvolvedora(or), testadora(or), analista, professora(or) ou pesquisadora(or): ");
                    UserStatus status = UserStatus.valueOf(opt.nextLine().toUpperCase());
                    User new_user = new User(name, email, password, status, 0.0, AllocatorStatus.DEFINITIVE);
                    users[acc_users] = new_user;
                }
                else{
                    User new_user = new User(name, email, password);
                    users[acc_users] = new_user;
                }
                acc_users++;
            }
            else if (option==2){
                String login;
                String pw;
                boolean finded = false;
                int index=-1;
                try{
                    System.out.println("Digite o nome da(o) usuária(o):");
                    login = opt.nextLine();
                    System.out.println("Digite a senha da(o) usuária(o):");
                    pw = opt.nextLine();
                    for (int i=0; i<acc_users; i++){
                        if (users[i].getName().equals(login)==true && users[i].getPassword().equals(pw)==true){
                            // System.out.println("HERE");
                            finded = true;
                            index = i;
                            break;
                        }
                    }
                } catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                    finded = false;
                    System.out.println("Usuária(o) não encontrada(o) ou dados não conferem.");
                }
                if (finded==true)
                {
                    // System.out.println("Pressione enter:");
                    // opt.nextLine();
                    // opt.close();
                    // while (true){manager = new Manager(users[index]);}
                    Manager manager_current = null;
                    manager_current = manager.push(new Manager(users[index]));
                    // System.out.println("do_task:"+do_task+", "+"acc_main:"+acc_main);
                    // int do_task=1;
                    // do_task = manager[acc_main].Runner();
                    manager_current.Runner(0);
                    // while(do_task!=0){
                    //     manager[acc_main].subMenu1();
                        
                    //     int input=0;while(opt.hasNextLine()){
                    //     input = Integer.parseInt(opt.nextLine());break;}
                        
                        
                    //     do_task = manager[acc_main].Runner(input);
                    //     if (do_task==-1){
                    //         //retroceda
                    //         if (acc_main>0){
                    //             // Manager aux = manager[acc_main];
                    //             acc_main--;
                    //             // manager[acc_main] = aux;
                    //         }
                    //         System.out.println("do_task1:"+do_task+"acc_main:"+acc_main);
                    //     }
                    //     else if (do_task>=1 && do_task<=16){
                    //     // else if (do_task==1 && acc_main<Manager.LEN_MAX_USERS){
                    //         //forward, avance
                    //         Manager aux = manager[acc_main];
                    //         acc_main++;
                    //         manager[acc_main] = aux;
                    //         System.out.println("do_task2:"+do_task+"acc_main:"+acc_main);
                    //     }
                        
                    //     // else if (do_task==0){continue;}
                    //     // else{manager[acc_main]=manager[acc_main];}
                    // }//while(do_task!=0);
                    System.out.println("Finishing program...");
                    break;
                }
            }
            else if (option==3){
                int user_id3 = -1;
                System.out.println("Digite o nome de usuária(o):");
                String check_name = "-1";
                try{
                    check_name = opt.nextLine();
                    for (int i=0; i<acc_users; i++){
                        if (users[i].getName().equals(check_name)==true){user_id3 = i;break;}
                    }
                    System.out.println("Digite o e-mail da(o) usuária(o):");
                    String check_email = opt.nextLine();
                    if (check_email.equals(users[user_id3].getEmail())==true){
                            System.out.println("Digite a nova senha da(o) usuária(o):");
                            String pw = opt.nextLine();
                            System.out.println("Digite novamente a senha para confirmar:");
                            String pw2 = opt.nextLine();
                            if (pw.equals(pw2)==true){
                                users[user_id3].setPassword(pw2);
                                System.out.println("Senha nova registrada.");
                            }
                    }
                }
                catch (NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException e){
                    System.out.println("Senhas não conferem ou ha inconsistencia nos dados.");
                }
            }
            else if (option==0){opt.close();return;}
        }
        opt.close();
    }    
}
