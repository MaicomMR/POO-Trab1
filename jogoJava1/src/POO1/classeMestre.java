package POO1;

import java.util.Scanner;

public class classeMestre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cachorroBase c = new cachorroBase();
        pessoaBase p = new pessoaBase();
        // fome 0 min / 100 max
        // energia 0 min / 100 max
        // vontade de cagar 0 min / 10 max

        c.energia = 0;
        c.fome = 0;
        c.sede = 0;
        c.saude = 50;
        c.tedio = 50;
        

        System.out.println("=======================");
        System.out.println("== CUSCO SIMULATOR  ==");
        System.out.println("=======================\n");
        System.out.println("Pressione 'Enter' Para iniciar o jogo");

        System.out.println("Você já possui um cusco cadastrado?");
        System.out.println("1. Sim, já tenho!");
        System.out.println("2. Não, bora cadastrar ele");
        int verificador = sc.nextInt();

        if (verificador == 2) {
            sc.nextLine();

            System.out.println("\nInforme o nome do seu Cusco:");
            c.nome = sc.nextLine();

            System.out.println("\nInforme o peso do " + c.nome);
            c.peso = sc.nextInt();
            while (c.peso <= 0) {
                System.out.println("\nPor favor informe um valor válido para o peso do " + c.nome);
                c.peso = sc.nextInt();
            }
            if (c.peso < 9) {
                System.out.println("\nCom " + c.peso + "Kg o/a " + c.nome + " se encaixa no porte PEQUENO");
                System.out.println("Seu porte foi registrado conforme o peso.");
                c.porte = 1;
            } else if (c.peso >= 9 && c.peso < 20) {
                System.out.println("\nCom " + c.peso + "Kg o/a " + c.nome + " se encaixa no porte MÉDIO");
                System.out.println("Seu porte foi registrado conforme o peso.");
                c.porte = 2;
            } else if (c.peso >= 20 && c.peso < 40) {
                System.out.println("\nCom " + c.peso + "Kg o/a " + c.nome + " se encaixa no porte GRANDE");
                System.out.println("Seu porte foi registrado conforme o peso.");
                c.porte = 3;
            } else if (c.peso >= 40) {
                System.out.println("\nCom " + c.peso + "Kg o/a " + c.nome + " se encaixa no porte GIGANTE");
                System.out.println("Seu porte foi registrado conforme o peso.");
                c.porte = 4;
            }

            System.out.println("\nInforme a idade do " + c.nome);
            c.idade = sc.nextInt();
            sc.nextLine();
            System.out.println("\nInforme o pedigree " + c.nome + "\nOu SRD caso seja um vira lata");
            c.pedigree = sc.nextLine();
            if (c.pedigree.equals("SRD") || c.pedigree.equals("srd")) {
                System.out.println("\nVocê tem um vira lata <3");
            }
        } else {
            while (true) {
                System.out.println("\nO que o " + c.nome + " vai fazer agora?");
                System.out.println("1. Dar comida");
                System.out.println("2. Dar agua");
                System.out.println("3. Por para dormir");
                System.out.println("4. Levar para correr");
                System.out.println("5. Levar no parque");
                System.out.println("6. Levar para cagar(Não esqueça do saquinho para a bosta)");
                System.out.println("7. Dar Banho");
                System.out.println("8. Levar no Veterinario");
                int OpcaoMenu = sc.nextInt();
                switch (OpcaoMenu) {
                    case 1: //comer
                        c.energia = c.energia + 2;
                        c.sede = c.sede + 10;
                        c.tedio = c.tedio + 5;
                        c.fome = 0;
                        c.vontadeDeCagar = c.vontadeDeCagar + 60;
                        break;
                    case 2: // dar agua
                        c.energia = c.energia + 3;
                        c.energia = c.energia + 3;
                        c.tedio = c.tedio + 5;
                        c.sede = 0;
                        c.vontadeDeCagar = c.vontadeDeCagar + 5;
                        break;
                    case 3: // dormir
                        if (c.idade >= 8) {
                            c.energia = 100 - (c.idade * 2);
                        } else {
                            c.energia = 100;
                        }
                        c.fome = c.fome + 20;
                        c.sede = c.sede + 15;
                        c.tedio = c.tedio + 30;
                        c.vontadeDeCagar = c.vontadeDeCagar + 5;
                        break;
                    case 4: //correr
                        c.energia = c.energia - 50;
                        c.fome = c.fome + 50;
                        c.sede = c.sede + 70;
                        c.saude = c.saude + 5;
                        c.tedio = c.tedio - 30;
                        c.vontadeDeCagar = c.vontadeDeCagar + 5;
                        c.tedio = c.tedio - 50;
                        break;
                    case 5: //ir parque
                        c.energia = c.energia - 25;
                        c.fome = c.fome + 20;
                        c.sede = c.sede + 25;
                        c.tedio = c.tedio - 40;
                        break;
                    case 6: //cagar
                        c.energia = c.energia - 5;
                        c.sede = c.sede - 5;
                        c.vontadeDeCagar = 0;
                        break;
                    case 7: // Banho
                        break;
                    case 8: // Veterinario
                        break;
                    default:
                        System.out.println("Informe uma ação válida");
                        break;
                }
                System.out.println("Energia: " + c.energia);
                System.out.println("Fome: " + c.fome);
                System.out.println("Sede: " + c.sede);
                System.out.println("Tédio: " + c.tedio);
                System.out.println("Saúde: " + c.saude);
                System.out.println("Idade: " + c.idade);
                System.out.println("Vontade de fazer cocô: " + c.vontadeDeCagar);
                
                if (c.energia <= 0 || c.saude <= 0) {
                    System.out.println("\nSeu cusco(a) morreu");
                    System.out.println(c.nome + " R.I.P");
                }

            }
        }

        //   String nome;
        //  String pedigree;
        //  String anoNascimento;
        //  int idade;
        //  int energia;
        //  int vontadeDeCagar;
        //  int fome;
    }
}
