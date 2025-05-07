package sorveteria.model;

import java.text.NumberFormat;

public abstract class Produto {
	
    protected int id, tipo;
    protected String nome;
    protected String sabor;
    protected double preco;
    
    public Produto(int id, int tipo, String nome, String sabor, double preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.sabor = sabor;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		
	    NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	    String tipoStr = switch (this.tipo) {
	        case 1 -> "Sorvete";
	        case 2 -> "Açaí";
	        default -> "Desconhecido";
	    };

	    System.out.println("ID: " + this.id);
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Tipo: " + tipoStr);
	    System.out.println("Sabor: " + this.sabor);
	    System.out.println("Preço: " + nfMoeda.format(this.preco));
	}
}
