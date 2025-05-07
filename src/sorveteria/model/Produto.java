package sorveteria.model;

import java.text.NumberFormat;

public abstract class Produto {
	
    protected int id, tipo;
    protected String marca;
    protected String sabor;
    protected double preco;
    
    public Produto(int id, int tipo, String marca, String sabor, double preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.sabor = sabor;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void visualizar() {
		
	    NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	    String tipoStr = switch (this.tipo) {
	        case 1 -> "Sorvete";
	        case 2 -> "Açaí";
	        default -> "Desconhecido";
	    };

	    System.out.println("ID: " + this.id);
	    System.out.println("Marca: " + this.marca);
	    System.out.println("Tipo: " + tipoStr);
	    System.out.println("Sabor: " + this.sabor);
	    System.out.println("Preço: " + nfMoeda.format(this.preco));
	}
}
