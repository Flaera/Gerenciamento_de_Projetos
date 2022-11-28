import java.util.Scanner;
import java.util.ArrayList;


public class SearchIDProject {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 11.");
        try{
            System.out.println("Digite um ID de projeto para consultar:");
            // opt.nextLine();
            int id11 = Integer.parseInt(opt.nextLine());
            projects.get(id11).printAllInfos();
        }
        catch(NumberFormatException | IndexOutOfBoundsException e)
        {System.out.println("Erro. Nenhum resultado encontrado. Erro do tipo: "+e);}
    }
}
