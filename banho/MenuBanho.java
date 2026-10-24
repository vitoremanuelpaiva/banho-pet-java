package banho;
import java.util.Scanner;


public class MenuBanho {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        Banho banho = new Banho();
        while (menu) {
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer com água");
            System.out.println("3 - Abastecer com shampoo");
            System.out.println("4 - Verificar nível de água");
            System.out.println("5 - Verificar nível de shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("10 - Sair");
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    if (banho.darBanho()){
                        System.out.println("Seu pet foi banhado com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 2:
                    if (banho.abastecerAgua()){
                        System.out.println("Sua máquina foi abastecida de água com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 3:
                    if (banho.abastecerShampoo()){
                        System.out.println("Sua máquina foi abastecida de shampoo com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 4:
                    System.out.println("Nível atual de água: "+ banho.getCapacidadeAgua() +"L");
                    break;
                case 5:
                    System.out.println("Nível atual de shampoo: "+ banho.getCapacidadeShampoo()+"L");
                    break;
                case 6:
                    if (banho.temPetBanho()){
                        System.out.println("Está com um pet no banho");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 7:
                    if (banho.colocarPet()){
                        System.out.println("Pet colocado na máquina com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 8:
                    if (banho.retirarPet()){
                        System.out.println("Pet retirado da máquina com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 9:
                    if (banho.limparMaquina()){
                        System.out.println("Sua máquina foi limpada com sucesso!");
                    }
                    else{
                        System.out.println(banho.getMotivoFalha());
                    }
                    break;
                case 10:
                    System.out.println("Fechando o programa...");
                    menu = false;
                    break;
                default:
                    System.out.println("Digite um dos valores na sua tela");
                    break;
            }
        }

        scanner.close();
    }

}   
