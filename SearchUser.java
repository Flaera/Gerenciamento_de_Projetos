import java.util.Scanner;
import java.util.ArrayList;

public class SearchUser {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 10.");
        try{
            System.out.println("Digite um usuário:");
            // opt.nextLine();
            User user10 = new User(opt.nextLine());
            
            for (int i=0; i<projects.size(); i++){
                if (projects.get(i).userExist(user10)==true){
                    projects.get(i).printAllInfos();
                }
            }
        }catch(NullPointerException | NumberFormatException e)
        {System.out.println("Erro. Nenhum resultado encontrado.");}
    }    
}
