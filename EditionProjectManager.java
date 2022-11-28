import java.util.Scanner;
import java.util.ArrayList;


public class EditionProjectManager extends Manager{
    public EditionProjectManager(){
        super(new User("-1"));
    }
    public void runner(Scanner opt, ArrayList<Projetos> projects){
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
}
