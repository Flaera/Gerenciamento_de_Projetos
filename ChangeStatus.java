import java.util.Scanner;
import java.util.ArrayList;


public class ChangeStatus extends Manager{
    public ChangeStatus(){
        super(new User("-1"));
    }
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 9.");

        System.out.println("Digite um ID de projeto para alterar o status:");
        // opt.nextLine();
        try{
            int id9 = Integer.parseInt(opt.nextLine());
            String coord = projects.get(id9).getCoord();
            boolean permission = projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PROFESSORA || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PROFESSOR || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PESQUISADORA || projects.get(id9).getUserPointer(coord).getStatus()==UserStatus.PESQUISADOR;
            if (projectExist(id9)==true && projects.get(id9).getStatus()<3 && getLogin().getName().equals(projects.get(id9).getCoord()) && (permission==true)){
                System.out.print("Coord. "+projects.get(id9).getCoord()+", confirma a alteração de status de \""+projects.get(id9).getStringState()+"\"");
                projects.get(id9).setStatus(projects.get(id9).getStatus()+1);
                System.out.println(" para \""+projects.get(id9).getStringState()+"\"?");
                System.out.println("Digite 1 para confirmar ou outro número para não confirmar:");
                int confirm = Integer.parseInt(opt.nextLine());
                if (confirm==1){System.out.println("Alteração concluída");}
                else if (projects.get(id9).getStatus()>0){
                    projects.get(id9).setStatus(projects.get(id9).getStatus()-1);
                    System.out.println("Alteração não concluída.");
                }
                else{
                    System.out.println("Alteração não concluída.");
                }
            }
        }
        catch(NullPointerException | NumberFormatException | IndexOutOfBoundsException e)
        {System.out.println("Dados fornecidos inválidos, projeto não existe, já concluído ou você não possui permissão para isso. Erro: "+e);}
    }    
}
