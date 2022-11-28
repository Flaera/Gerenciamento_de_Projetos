import java.util.Scanner;
import java.util.ArrayList;


public class CreateProjectManager extends Manager{
    public CreateProjectManager(){
        super(new User("-1"));
    }
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        try{
            System.out.println("Escolhida a opção 1.");
            
            System.out.println("Digite a tarefa:");
            String scan0;
            scan0=opt.nextLine();
            
            System.out.println("Digite o número de usuárias(os): ");
            int max = Integer.parseInt(opt.nextLine());
            ArrayList<User> scan1;
            scan1 = editUsers(max);

            System.out.println("Digite a(o) coordenadora(or):");
            String scan2;    
            scan2 = opt.nextLine();
            
            System.out.println("Quantas tarefas terão esse projeto?");
            int n_tasks = 0;
            n_tasks = Integer.parseInt(opt.nextLine());
            ArrayList<Activitie> acts = new ArrayList<>();
            for (int i=0; i<n_tasks; ++i)
            {
                System.out.println("Digite os dados da "+(i+1)+"ª atividade:");
                String describe;
                String responsa;
                System.out.println("Digite a descrição da tarefa:");
                describe = opt.nextLine();
                System.out.println("Digite a(o) responsável pela tarefa:");
                responsa = opt.nextLine();
                acts.add(new Activitie(describe, responsa));
            }

            projects.add(new Projetos(acc_projects, scan0, scan1, scan2, acts));

            projects.get(acc_projects).printAllInfos();
            acc_projects += 1;
            // opt.nextLine();
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
        } catch (NumberFormatException e){
            System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
        } catch (IllegalArgumentException e){
            System.out.println("Erro em alguma entrada: "+e+" Tente novamente.");
        }    
    }
}