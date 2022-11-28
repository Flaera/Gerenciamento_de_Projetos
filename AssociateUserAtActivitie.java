import java.util.Scanner;
import java.util.ArrayList;


public class AssociateUserAtActivitie {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 8.");

        try{
            System.out.println("Digite uma(um) usuária(o) para ser associada(o):");
            // opt.nextLine();
            User user8 = new User(opt.nextLine());
            System.out.println("Digite um ID de projeto:");
            int id8 = Integer.parseInt(opt.nextLine());
            System.out.println("Digite o ID de uma atividade para associar:");
            int id_task8 = Integer.parseInt(opt.nextLine());
            projects.get(id8).getActivities().get(id_task8).addUserAtTask(user8);
            System.out.println("Usuária(o) "+user8.getName()+" foi associada(o).");
        }
        catch(NumberFormatException | NullPointerException | IndexOutOfBoundsException e){
            System.out.println("Erro. O projeto ou atividade não existe.");
        }
    }    
}
