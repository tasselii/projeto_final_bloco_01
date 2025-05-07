package sorveteria.controller;

import java.util.ArrayList;
import java.util.Optional;

import sorveteria.model.Produto;
import sorveteria.repository.SorveteriaRepository;
import sorveteria.util.Cores;

public class ProdutoController implements SorveteriaRepository {
	
	public ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	public ArrayList<Produto> listaCompras = new ArrayList<>();
	
	int id = 0;

	@Override
	public void consultarPorId(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		
		if(produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\nA Conta %d não foi encontrado", id);
		
	}

	@Override
	public void listarTodos() {
	    if (listaProdutos.isEmpty()) {
	        System.out.println(Cores.TEXT_RED +"O estoque está vazio."+ Cores.TEXT_RESET);
	    } else {
	        System.out.println(Cores.TEXT_WHITE_BRIGHT +"\n *" + "** Produtos Disponíveis * "+ "*"+ "*");
	        System.out.println(Cores.TEXT_BLUE_BRIGHT +"-------------------------------"+ Cores.TEXT_WHITE + Cores.TEXT_WHITE_BRIGHT );
	        
	        listaProdutos.forEach(p -> {
	            if (p.getTipo() != 1 && p.getTipo() != 2) {
	                System.out.println("Tipo Inválido:");
	            }
	            p.visualizar();
	        });        
	        }
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		
	}

	@Override
	public void atualizar(Produto produto) {
	    Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

	    if (buscaProduto.isPresent()) {
	        int indice = listaProdutos.indexOf(buscaProduto.get());
	        listaProdutos.set(indice, produto);

	        System.out.println("\nProduto atualizado com sucesso:\n");
	        produto.visualizar();
	        System.out.println("Produto Atualizado! ✅\n");
	    } 
	}

	@Override
	public void deletar(int numero) {
	    Optional<Produto> deletarProduto = buscarNaCollection(numero);
	    
	    if (deletarProduto.isPresent()) {
	        if (listaProdutos.remove(deletarProduto.get())) {
	            System.out.printf("\nA Conta número %d foi excluída com sucesso!\n", numero);
	        }
	    } else {
	        System.out.printf("\nA Conta %d não foi encontrada\n", numero);
	    }
	}
	
	@Override
	public void comprarProduto(int id) {
	    Optional<Produto> produto = buscarNaCollection(id);

	    if (produto.isPresent()) {
	        Produto produtoSelecionado = produto.get();
	        if (listaProdutos.remove(produtoSelecionado)) {
	            listaCompras.add(produtoSelecionado);
	            System.out.printf("\n%s comprado com sucesso.\n", produtoSelecionado.getMarca());
	        } else {
	            System.out.printf("\nO produto com ID %d não foi encontrado na lista de produtos.\n", id);
	        }
	    }
	}

	@Override
	public void reorganizarids(int id) {
		int novoId = 1;
	    for (Produto produto : listaProdutos) {
	        produto.setId(novoId++);
	    }
	}
	
	public int gerarNumero() {
		return ++ id;
	}

	public Optional<Produto> buscarNaCollection(int id) {
	    return listaProdutos.stream()
	                      .filter(Produto -> Produto.getId() == id)
	                      .findFirst();
	}
	
	@Override
	public void verCarrinho() {

	    if (listaCompras.isEmpty()) {
	        System.out.println(Cores.TEXT_RED + "\nNenhum produto foi Comprado.\n" + Cores.TEXT_RESET);
	    } else {
	        System.out.println(Cores.TEXT_WHITE_BRIGHT + "\n*** Compras Realizadas ***");
	        System.out.println(Cores.TEXT_BLUE_BRIGHT + "-------------------------------" + Cores.TEXT_WHITE_BRIGHT);

	        for (Produto p : listaCompras) {
	            p.visualizar();
	            
	        }
	    }
	}
}
