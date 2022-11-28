import java.util.Scanner;
import java.util.ArrayList;


public class AttributeValue {
    public void runner(Scanner opt, ArrayList<Projetos> projects){
        System.out.println("Escolhida a opção 14.");
        String user_name14 = "-1";
        double new_value14 = 0.0f;
        try{
            System.out.println("Digite um nome de usuária(o):");
            user_name14 = opt.nextLine();
            System.out.println("Digite o valor da bolsa para esta(o) usuária(o):");    
            new_value14 = Double.parseDouble(opt.nextLine());

            for (int i=0; i<projects.size(); i++){
                User user_name14_2 = projects.get(i).getUserPointer(user_name14);
                user_name14_2.setPayment(new_value14);
                System.out.println("Atribuição de bolsa feita com sucesso.");
            }
        }catch (NumberFormatException | NullPointerException e){
            System.out.println("Entrada de decimal inválida ou usuária(o) não existe. Erro: "+e+"Tente novamente.");    
        }
    }    
}
