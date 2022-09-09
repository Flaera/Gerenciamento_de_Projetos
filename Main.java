import java.util.Scanner;

public class Main {
    // public Manager manager = null;
    // public Scanner opt = null;
    public static void Menu(){
        System.out.println("\n--GERENCIADOR DE PROJETOS--");
        System.out.println("1 para criar um usuária(o).");
        System.out.println("2 para logar um usuária(o).");
        System.out.println("3 se esqueceu a senha de alguma ou algum usuária(o).");
        System.out.println("0 para sair do programa.");
    }
    public static void errorDataInconsistent(){System.out.println("Erro. Inconsistência nos dados.");}
    public static void main(String[] args){
        User[] users = new User[Manager.LEN_MAX_USERS];
        int acc_users = 0;
    
        Manager manager = null;
        Scanner opt = new Scanner(System.in);

        int option = -1;
        while(option!=0 && manager==null){
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
                    System.out.println("Digite Aluna(o), Professora(or) ou Pesquisadora(or):");
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
                if (acc_users>0){
                    System.out.println("Digite o nome da(o) usuária(o):");
                    String login = opt.nextLine();
                    System.out.println("Digite a senha da(o) usuária(o):");
                    String pw = opt.nextLine();
                    boolean finded = false;
                    int index=-1;
                    for (int i=0; i<acc_users; i++){
                        if (users[i].getName().equals(login)==true && users[i].getPassword().equals(pw)==true){
                            // System.out.println("HERE");
                            finded = true;
                            index = i;
                            break;
                        }
                    }
                    if (finded==true)
                    {
                        // System.out.println("Pressione enter:");
                        // opt.nextLine();
                        // opt.close();
                        // while (true){manager = new Manager(users[index]);}
                        manager = new Manager(users[index]);
                        manager.Runner();
                        break;
                    }
                }
                else{System.out.println("Não existe usuária(o) cadastradas(o). Login, senha ou e-mail podem estarem incórretas.");}
            }
            else if (option==3){
                int user_id3 = -1;
                System.out.println("Digite o nome de usuária(o):");
                String check_name = opt.nextLine();
                for (int i=0; i<acc_users; i++){
                    if (users[i].getName().equals(check_name)==true){user_id3 = i;break;}
                }
                if (user_id3!=-1){
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
                        else{errorDataInconsistent();}
                    }
                    else{errorDataInconsistent();}
                }
                else{errorDataInconsistent();}
            }
            else if (option==0){opt.close();return;}
        }
        opt.close();
    }    
}
