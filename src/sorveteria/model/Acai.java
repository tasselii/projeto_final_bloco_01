package sorveteria.model;

public class Acai extends Produto {
    private String tamanho; // P, M, G
    private String adicionais;
    private String observacoes;

    public Acai(int id, String nome, String sabor, double preco, String tamanho, String adicionais, String observacoes) {
        super(id, nome, sabor, preco);
        this.tamanho = tamanho;
        this.adicionais = adicionais;
        this.observacoes = observacoes;
    }

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	@Override
	public void visualizar() {
        System.out.printf("🍧 Açaí #%d | Nome: %s | Sabor: %s | Preço: R$ %.2f\n", this.id, this.nome, this.sabor, this.preco);
        System.out.printf("Tamanho: %s | Adicionais: %s | Observações: %s\n", this.tamanho, this.adicionais, this.observacoes);
        System.out.println("-------------------------------");
    }
}
