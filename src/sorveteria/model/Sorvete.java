package sorveteria.model;

import sorveteria.util.Cores;

public class Sorvete extends Produto {
	
	private String tipoProduto; // Pote ou Massa

    public Sorvete(int id, int tipo, String marca, String sabor, double preco, String tipoProduto) {
		super(id, tipo, marca, sabor, preco);
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
		System.out.println("Marca: " + this.marca);
		System.out.println("Sabor: " + this.sabor);
		System.out.println("Tipo: " + this.tipoProduto);
		System.out.printf("Preço: R$ %.2f\n", this.preco);
		System.out.println(Cores.TEXT_BLUE_BRIGHT +"-------------------------------"+ Cores.TEXT_RESET);

    }
}
