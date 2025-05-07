package sorveteria.model;

public abstract class Produto {
    protected int id;
    protected String nome;
    protected String sabor;
    protected double preco;

    public Produto(int id, String nome, String sabor, double preco) {
        this.id = id;
        this.nome = nome;
        this.sabor = sabor;
        this.preco = preco;
    }

    public void visualizar() {
        System.out.println("Produto #" + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Sabor: " + this.sabor);
        System.out.println("Preço: R$ " + String.format("%.2f", this.preco));
    }
}
