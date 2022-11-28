import java.util.Scanner;
import java.util.ArrayList;


public class InterchangeUser {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 13.");

        try{
            System.out.println("Digite a(o) usuária(o) que deseja intercambiar:");
            String user13 = opt.nextLine();
            // User user13Pointer = new User(user13);
            System.out.println("Digite o ID do projeto que vai receber a(o) intercambista:");
            int id13 = Integer.parseInt(opt.nextLine());

            User user13_searched = new User("-1");
            for (int i=0; i<projects.size(); ++i){
                int acc13 = 0;
                while(projects.get(i).getUsers().get(acc13).getName().equals("-1")==false){
                    user13_searched = projects.get(i).getUserPointer(user13);
                    acc13++;
                }
            }

            if (user13_searched.getName().equals("-1")==false){
                projects.get(id13).addUser(user13_searched, AllocatorStatus.INTERCAMBISTA);
                User new1 = new User("-1");
                projects.get(id13+1).addUser(new1);
                System.out.println("Intercâmbio feito.");
            }
        }catch(NullPointerException | NumberFormatException | IndexOutOfBoundsException e){
            System.out.println("Projeto não existe ou usuário não existe. Erro: "+e);
        }
        
    }
}
