package sorveteria;

import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        int opcao, tipoAdmin;
        int tentativas = 3;
        String senhaCorreta = "123";

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Acessar como Cliente");
            System.out.println("2 - Acessar como Admin");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1 -> {
                    // Parte de Cliente comentada
                    /*
                    System.out.println("Entrando como cliente...");
                    while (true) {
                        System.out.println("1 - Visualizar Produtos");
                        System.out.println("2 - Ver Carrinho");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoCliente = scan.nextInt();

                        switch (opcaoCliente) {
                        case 1 -> {  // Acessar como Cliente
                        	}
                        }
                    }
                    */
                }
                case 2 -> {
                    while (tentativas > 0) {
                        System.out.print("Digite a senha: ");
                        String senha = scan.next();

                        if (senha.equals("123")) {
                            System.out.println("Acesso concedido ✅");

                            while (true) {
                                System.out.println("\n=== MENU ADMIN ===");
                                System.out.println("1 - Cadastrar Produto");
                                System.out.println("2 - Consultar Produto");
                                System.out.println("3 - Listar Produtos");
                                System.out.println("4 - Atualizar Produto");
                                System.out.println("5 - Deletar Produto");
                                System.out.println("0 - Voltar");
                                System.out.print("Escolha uma opção: ");
                                tipoAdmin = scan.nextInt();

                                if (tipoAdmin == 0) {
                                    System.out.println("Voltando ao menu principal...");
                                    break;
                                }

                                switch (tipoAdmin) {
                                    case 1 -> {
                                        System.out.println("Cadastrar Produto (implementação futura)");
                                        keyPress();
                                    }
                                    case 2 -> {
                                        System.out.println("Consultar Produto (implementação futura)");
                                        keyPress();
                                    }
                                    case 3 -> {
                                        System.out.println("Listar Produtos (implementação futura)");
                                        keyPress();
                                    }
                                    case 4 -> {
                                        System.out.println("Atualizar Produto (implementação futura)");
                                        keyPress();
                                    }
                                    case 5 -> {
                                        System.out.println("Deletar Produto (implementação futura)");
                                        keyPress();
                                    }
                                    default -> System.out.println("Opção inválida.");
                                }
                            }

                            break;
                        } else {
                            tentativas--;
                            System.out.println("Senha incorreta! Tentativas restantes: " + tentativas);

                            if (tentativas == 0) {
                                System.out.println("Número máximo de tentativas. Acesso negado.");
                            }
                        }
                    }
                }
              
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                    sobre();
                    scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println("\nPressione Enter para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();  // Espera o usuário pressionar Enter
        } catch (Exception e) {
            System.err.println("Erro ao ler entrada do teclado.");
        }
    }

    public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Thiago Tasseli - tasselii.dev@outlook.com.br");
		System.out.println("github.com/tasseli");
		System.out.println("*********************************************************");
    }
}
