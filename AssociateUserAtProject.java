import java.util.Scanner;
import java.util.ArrayList;


public class AssociateUserAtProject extends Manager{
    public AssociateUserAtProject(){
        super(new User("-1"));
    }
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 5.");

        // opt.nextLine();
        try{
            System.out.println("Digite uma(um) usuária(o) para associar:");

            User user5 = new User(opt.nextLine());
            // System.out.println("USER:");System.out.println(user);
            System.out.println("Digite o ID do projeto para associar a(o) usuária(o):");
            int id5 = Integer.parseInt(opt.nextLine());
            // id5 = opt.nextInt();
            
            projects.get(id5).addUser(user5);
            System.out.println("Usuária(o) "+user5.getName()+" foi associado.");
        }
        catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e)
        {System.out.println("Erro. Usuária(o) já esta no projeto ou ID do projeto não existe.");}
    }
}