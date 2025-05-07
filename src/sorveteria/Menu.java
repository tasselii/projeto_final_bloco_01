package sorveteria;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import sorveteria.controller.ProdutoController;
import sorveteria.model.Acai;
import sorveteria.model.Produto;
import sorveteria.model.Sorvete;
import sorveteria.util.Cores;

//... (imports e cabeçalho mantidos)

public class Menu {

 public static void main(String[] args) {

     Scanner scan = new Scanner(System.in).useLocale(Locale.US);
     ProdutoController produtos = new ProdutoController();

     int opcao, tipoAdmin, tipo;
     int tentativas = 3;
     String senhaCorreta = "123";
     double preco;

     Acai s1 = new Acai(produtos.gerarNumero(), 1, "Açaí Tropical", "Tradicional", 15.90, "Médio", "Granola, Leite Condensado", "Sem açúcar");
     produtos.cadastrar(s1);

     Sorvete s2 = new Sorvete(produtos.gerarNumero(), 1, "Napolitano", "Doce", 12.90, "Pote");
     produtos.cadastrar(s2);

     Acai s3 = new Acai(produtos.gerarNumero(), 1, "Açaí Energia", "Banana com Mel", 16.50, "Grande", "Granola, Paçoca", "Adição de proteína");
     produtos.cadastrar(s3);

     Acai s4 = new Acai(produtos.gerarNumero(), 1, "Açaí Refrescante", "Menta com Chocolate", 14.90, "Pequeno", "Chocoball, Leite em pó", "Sem lactose");
     produtos.cadastrar(s4);

     Sorvete s5 = new Sorvete(produtos.gerarNumero(), 1, "Chocolate Belga", "Chocolate", 13.90, "Massa");
     produtos.cadastrar(s5);

     Sorvete s6 = new Sorvete(produtos.gerarNumero(), 1, "Frutas Tropicais", "Abacaxi com Hortelã", 11.90, "Pote");
     produtos.cadastrar(s6);

     while (true) {
    	 System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
    	 System.out.println("╔═══════════════════════════════════════════════════╗");
    	 System.out.println("║" + Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "         ❄️  MENU ADMIN - SORVETERIA  ❄️           " + Cores.TEXT_CYAN + "║");
    	 System.out.println("╠═══════════════════════════════════════════════════╣");
    	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 1 - Entrar como Cliente                           " + Cores.TEXT_CYAN + "║");
    	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 2 - Entrar como Admin                             " + Cores.TEXT_CYAN + "║");
    	 System.out.println("║" + Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + " 0 - Sair                                          " + Cores.TEXT_CYAN + "║");
    	 System.out.println("╚═══════════════════════════════════════════════════╝"+Cores.TEXT_RESET);
         opcao = scan.nextInt();

         int numero;
         switch (opcao) {
             case 1 -> {
                 produtos.listarTodos();
                 if (produtos.listaProdutos.isEmpty()) {
                     continue;
                 } else {
                     while (true) {
                         System.out.print("\nDigite o número do produto que deseja (0 para voltar): ");
                         int compra = scan.nextInt();

                         if (compra == 0) {
                             System.out.println("Voltando ao início...");
                             break;
                         }

                         produtos.comprarProduto(compra);
                         produtos.reorganizarids(compra);

                         System.out.print("\nDeseja continuar comprando? (S/N): ");
                         String escolhaCliente = scan.next();

                         if (escolhaCliente.equalsIgnoreCase("n")) {
                             System.out.println("\nEncerrando compras...");
                             break;
                         }
                         produtos.listarTodos();
                     }
                 }
             }

             case 2 -> {
                 while (tentativas > 0) {
                     System.out.print("Digite a senha: ");
                     String senha = scan.next();

                     if (senha.equals(senhaCorreta)) {
                         System.out.println("Acesso concedido ✅");

                         while (true) {
                        	 System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
                        	 System.out.println("╔═══════════════════════════════════════════════════╗");
                        	 System.out.println("║" + Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "         ❄️  MENU ADMIN - SORVETERIA  ❄️           " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("╠═══════════════════════════════════════════════════╣");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 1 - Cadastrar Produto                             " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 2 - Consultar Produto por ID                      " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 3 - Listar Todos os Produtos                      " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 4 - Atualizar Produto                             " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 5 - Deletar Produto                               " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 6 - Ver Compras Realizadas                        " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("║" + Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + " 0 - Voltar                                        " + Cores.TEXT_CYAN + "║");
                        	 System.out.println("╚═══════════════════════════════════════════════════╝");
                        	 System.out.print(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Selecione uma opção do menu: " + Cores.TEXT_RESET);
                             tipoAdmin = scan.nextInt();

                             if (tipoAdmin == 0) {
                                 System.out.println("Voltando ao menu principal...");
                                 break;
                             }

                             switch (tipoAdmin) {
                                 case 1 -> {
                                     System.out.print("\nDigite o marca do Produto: ");
                                     scan.nextLine();
                                     String marca = scan.nextLine();

                                     System.out.print("\nDigite o preço do Produto: ");
                                     preco = scan.nextDouble();

                                     System.out.print("\nDigite o tipo: \n");
                                     System.out.println("1 - Sorvete");
                                     System.out.println("2 - Açaí\n");
                                     tipo = scan.nextInt();

                                     scan.nextLine();

                                     System.out.print("\nDigite o sabor: ");
                                     String sabor = scan.nextLine();

                                     switch (tipo) {
                                         case 1 -> {
                                             System.out.println("\nDigite o tipo de Sorvete:");
                                             System.out.println("1 - Pote");
                                             System.out.println("2 - Massa");
                                             int tipoSorvete = scan.nextInt();
                                             scan.nextLine();

                                             String tipoProduto = (tipoSorvete == 1) ? "Pote" : "Massa";

                                             produtos.cadastrar(new Sorvete(produtos.gerarNumero(), tipo, marca, sabor, preco, tipoProduto));
                                             System.out.println("\nSorvete cadastrado com sucesso!");
                                         }

                                         case 2 -> {
                                             System.out.print("\nDigite o tamanho (P/M/G): ");
                                             String tamanho = scan.nextLine();

                                             System.out.print("\nDigite os adicionais separados por vírgula: ");
                                             String adicionais = scan.nextLine();

                                             System.out.print("\nDigite observações (ou deixe em branco): ");
                                             String observacoes = scan.nextLine();

                                             produtos.cadastrar(new Acai(produtos.gerarNumero(), tipo, marca, sabor, preco, tamanho, adicionais, observacoes));
                                             System.out.println("\nAçaí cadastrado com sucesso!");
                                         }

                                         default -> System.out.println("Tipo inválido!");
                                     }
                                     keyPress();
                                 }

                                 case 2 -> {
                                     produtos.listarTodos();
                                     System.out.println("Digite o Numero do Produto que você deseja Consultar: ");
                                     numero = scan.nextInt();

                                     produtos.consultarPorId(numero);
                                     keyPress();
                                 }

                                 case 3 -> {
                                     produtos.listarTodos();
                                     keyPress();
                                 }

                                 case 4 -> { 
                                    produtos.listarTodos();

                                    System.out.println("Digite o número do produto: ");
	        	                	numero = scan.nextInt();

	        	                	Optional<Produto> atualizarProduto = produtos.buscarNaCollection(numero);

                                     System.out.print("\nDigite o marca do Produto: ");
                                     scan.nextLine();
                                     String marca = scan.nextLine();

                                     System.out.print("\nDigite o preço do Produto: ");
                                     preco = scan.nextDouble();

                                     System.out.print("\nDigite o tipo: \n");
                                     System.out.println("1 - Sorvete");
                                     System.out.println("2 - Açaí\n");
                                     tipo = scan.nextInt();

                                     scan.nextLine();

                                     System.out.print("\nDigite o sabor: ");
                                     String sabor = scan.nextLine();

                                     switch (tipo) {
                                         case 1 -> {
                                             System.out.println("\nDigite o tipo de Sorvete:");
                                             System.out.println("1 - Pote");
                                             System.out.println("2 - Massa");
                                             int tipoSorvete = scan.nextInt();
                                             scan.nextLine();

                                             String tipoProduto = (tipoSorvete == 1) ? "Pote" : "Massa";

                                             produtos.atualizar(new Sorvete(produtos.gerarNumero(), tipo, marca, sabor, preco, tipoProduto));
                                         }

                                         case 2 -> {
                                             System.out.print("\nDigite o tamanho (P/M/G): ");
                                             String tamanho = scan.nextLine();

                                             System.out.print("\nDigite os adicionais separados por vírgula: ");
                                             String adicionais = scan.nextLine();

                                             System.out.print("\nDigite observações (ou deixe em branco): ");
                                             String observacoes = scan.nextLine();

                                             produtos.atualizar(new Acai(produtos.gerarNumero(), tipo, marca, sabor, preco, tamanho, adicionais, observacoes));
                                         }

                                         default -> System.out.println("Tipo inválido!");
                                     }
                                     System.out.println("Produto Atualizado! ✅\n");
                                     keyPress();
                                 }

                                 case 5 -> {
                                     produtos.listarTodos();
                                     System.out.print("\nDigite o Numero do Produto: ");
                                     int numeroDeletar = scan.nextInt();

                                     produtos.deletar(numeroDeletar);
                                     keyPress();
                                 }

                                 case 6 -> {
                                     produtos.verCarrinho();
                                     keyPress();
                                 }

                                 default -> System.out.println(Cores.TEXT_RED+"Opção inválida.");
                             }
                         }

                         break;
                     } else {
                         tentativas--;
                         System.out.println(Cores.TEXT_RED+"Senha incorreta! Tentativas restantes: " + tentativas+Cores.TEXT_RESET);
                         if (tentativas == 0) {
                             System.out.println(Cores.TEXT_RED+"Número máximo de tentativas. Acesso negado."+Cores.TEXT_RESET);
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

             default -> System.out.println(Cores.TEXT_RED+"Opção inválida!"+Cores.TEXT_RESET);
         }
     }
 }

 public static void keyPress() {
     try {
         System.out.println("\nPressione Enter para continuar...");
         Scanner scanner = new Scanner(System.in);
         scanner.nextLine();
     } catch (Exception e) {
         System.err.println("Erro ao ler entrada do teclado.");
     }
 }

 public static void sobre() {
	 		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +
			    Cores.TEXT_CYAN + "\n╔════════════════════════════════════════════════════╗");
			System.out.println("║" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "  Projeto Desenvolvido por:                        " + Cores.TEXT_CYAN + " ║");
			System.out.println("║" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "  Thiago Tasseli - " +
			    Cores.TEXT_BLUE_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND + "tasselii.dev@outlook.com.br" +
			    Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "     " + Cores.TEXT_CYAN + " ║");
			System.out.println("║  " + Cores.TEXT_BLUE_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND +
			    "github.com/tasselii" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "                              " + Cores.TEXT_CYAN + " ║");
			System.out.println("╚════════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
 }
}
