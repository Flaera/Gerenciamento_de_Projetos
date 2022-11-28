import java.util.Scanner;
import java.util.ArrayList;


public class AssociateActivitieAtUser {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        try{
            System.out.println("Escolhida a opção 7.");
            
            System.out.println("Digite o ID de um projeto:");
            // opt.nextLine();
            int id_project = Integer.parseInt(opt.nextLine());
            System.out.println("Digite o ID da tarefa neste projeto:");
            int id_task = Integer.parseInt(opt.nextLine());
            System.out.println("Digite uma(um) usuária(o) para associar:");
            User user7 = new User(opt.nextLine());
            // System.out.println("INFO: "+projects.get(id_project).getActivities().get(id_task).getResponsable());
            projects.get(id_project).getActivities().get(id_task).addUserAtTask(user7);
            System.out.println("Usuária(o) "+user7.getName()+" foi associada(o).");
            // }
            // else{System.out.println("Erro. Atividade não existe ou usuária(o) já esta associada(o).");}
        }catch(NumberFormatException | NullPointerException | IndexOutOfBoundsException e){
            System.out.println("Projeto não existe ou tarefa não existe. Erro: "+e);
        }
    }    
}
