package sorveteria.model;

public class Sorvete extends Produto {
	
    private String tipo; // Pote ou Massa

    public Sorvete(int id, String nome, String sabor, double preco, String tipo) {
        super(id, nome, sabor, preco);
        this.tipo = tipo;
    }
 
    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    @Override
    public void visualizar() {
        System.out.printf("[Sorvete] %s | Sabor: %s | Tipo: %s | Preço: R$ %.2f\n", nome, sabor, tipo, preco);
    }
}
