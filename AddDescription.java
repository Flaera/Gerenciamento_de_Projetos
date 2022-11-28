import java.util.Scanner;
import java.util.ArrayList;

public class AddDescription extends Manager{
    public AddDescription(){super(new User("-1"));}
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 15.");
        System.out.println("Digite o ID do projeto que deseja editar a descrição:");
        int choose_id = -1;
        try{
            choose_id = Integer.parseInt(opt.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Inválida entrada. Erro: "+e+" Tente novamente.");
        }
        int search;
        if(choose_id>=0 && choose_id<projects.size()){
            search = findProject(projects, choose_id);
            if (search!=-1){
                System.out.println("Digite a nova descrição até apertar ENTER.");
                projects.get(search).setDescription(opt.nextLine());
                System.out.println("Alteração concluída.");
            }
            if (search==-1){System.out.println("ID não encontrado.");}
        }
    }
}
