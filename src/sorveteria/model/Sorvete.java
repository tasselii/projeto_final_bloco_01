package sorveteria.model;

import sorveteria.util.Cores;

public class Sorvete extends Produto {
	
	private String tipoProduto; // Pote ou Massa

    public Sorvete(int id, int tipo, String nome, String sabor, double preco, String tipoProduto) {
		super(id, tipo, nome, sabor, preco);
		this.tipoProduto = tipoProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Override
    public void visualizar() {
		System.out.println("🍨 Sorvete #" + this.id);
		System.out.println();
		System.out.println("Nome: " + this.nome);
		System.out.println("Sabor: " + this.sabor);
		System.out.println("Tipo: " + this.tipoProduto);
		System.out.printf("Preço: R$ %.2f\n", this.preco);
		System.out.println(Cores.TEXT_BLUE_BRIGHT +"-------------------------------"+ Cores.TEXT_RESET);

    }
}
