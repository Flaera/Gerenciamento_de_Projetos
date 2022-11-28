import java.util.Scanner;
import java.util.ArrayList;


public class SetDateTime extends Manager{
    public SetDateTime(){super(new User("-1"));}
    public void runner(Scanner opt, ArrayList<Projetos> projects){

        System.out.println("Escolhida a opção 16.");
        try{
            int id16 = -1;
            int search;
            System.out.println("Escolha o ID do projeto:");
            id16 = Integer.parseInt(opt.nextLine());
            if(id16>=0 && id16<projects.size()){
                search = findProject(projects, id16);
                if (search!=-1){

                    System.out.println("Digite a data de início do projeto:");
                    System.out.println("Digite o dia:");
                    int day_init = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o mês:");
                    int montly_init = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o ano:");
                    int year_init = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite a hora:");
                    int hour_init = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o minuto:");
                    int min_init = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o segundo:");
                    int sec_init = Integer.parseInt(opt.nextLine());
                    projects.get(search).getData().setDataCreationString(day_init, montly_init, year_init,
                     hour_init, min_init, sec_init);

                    System.out.println("Digite a data de término do projeto:");
                    System.out.println("Digite o dia:");
                    int day_term = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o mês:");
                    int montly_term = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o ano:");
                    int year_term = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite a hora:");
                    int hour_term = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o minuto:");
                    int min_term = Integer.parseInt(opt.nextLine());
                    System.out.println("Digite o segundo:");
                    int sec_term = Integer.parseInt(opt.nextLine());
                    projects.get(search).getData().setDataTerminateString(day_term, montly_term, year_term,
                    hour_term, min_term, sec_term);
                }
            }
        }
        catch (NumberFormatException | NullPointerException e){
            System.out.println("ID não encontrado. Erro: "+e);
        }
    }
}
