import java.util.Scanner;
import java.util.ArrayList;


public class SearchActivitie {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 12.");
                
        try{
            System.out.println("Digite o ID de um projeto:");
            int id12 = Integer.parseInt(opt.nextLine());
            System.out.println("Digite o ID de uma atividade:");
            int id12_task = Integer.parseInt(opt.nextLine());
            if (projects.get(id12).getActivities().get(id12_task)!=null){
                projects.get(id12).printAllInfos();
            }else{System.out.println("Erro. Nenhum resultado encontrado.");}
        }catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e)
        {System.out.println("Erro. Nenhum resultado encontrado.");}
    }
}
