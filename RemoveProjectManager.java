import java.util.Scanner;
import java.util.ArrayList;


public class RemoveProjectManager extends Manager{
    public RemoveProjectManager(){
        super(new User("-1"));
    }
    public void runner(Scanner opt, ArrayList<Projetos> projects){
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
}
