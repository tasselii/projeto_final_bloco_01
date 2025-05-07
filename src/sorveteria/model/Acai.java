package sorveteria.model;

import java.util.Arrays;
import java.util.List;

import sorveteria.util.Cores;

public class Acai extends Produto {
	
    private String tamanho; // P, M, G
    private String adicionais;
    private String observacoes;

	public Acai(int id, int tipo, String nome, String sabor, double preco, String tamanho, String adicionais,
			String observacoes) {
		super(id, tipo, nome, sabor, preco);
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
	
	List<String> adicionaisAcai = Arrays.asList(this.adicionais);

	@Override
	public void visualizar() {
	    System.out.println("🍧 Açaí #" + this.id);
	    System.out.println();
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Sabor: " + this.sabor);
	    System.out.printf("Preço: R$ %.2f\n", this.preco);
	    System.out.println("Tamanho: " + this.tamanho);

	    System.out.println("Adicionais:");
	    Arrays.stream(this.adicionais.split(","))
	          .map(String::trim)
	          .forEach(adicional -> System.out.println("- " + adicional));

	    System.out.println("Observações: " + this.observacoes);
	    System.out.println(Cores.TEXT_BLUE_BRIGHT + "-------------------------------" + Cores.TEXT_RESET);
	}

}
