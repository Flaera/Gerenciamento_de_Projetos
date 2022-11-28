import java.util.Scanner;
import java.util.ArrayList;


public class AssociateProjectAtUser{
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 6.");
                
        // opt.nextLine();
        // boolean search = projectExist(id6);
        try{
            System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
            int id6 = Integer.parseInt(opt.nextLine());
            System.out.println("Digite a(o) usuária(o) a ser associada(o):");
            User user_name = new User(opt.nextLine());
            projects.get(id6).addUser(user_name);
            System.out.println("Usuária(o) "+user_name.getName()+" foi associado.");
        }
        catch(NumberFormatException | NullPointerException | IndexOutOfBoundsException e)
        {System.out.println("Erro. Projeto não existe ou usuária(o) não existe.");}
    }    
}
