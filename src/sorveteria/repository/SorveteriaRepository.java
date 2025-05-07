package sorveteria.repository;


import sorveteria.model.Produto;

public interface SorveteriaRepository {

	// CRUD
	public void consultarPorId(int numero);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	
	// Adicionais
	public void reorganizarids(int id);
	public void comprarProduto(int id);
	public void verCarrinho();   
	public void calcularLucro();
	public long quantidade();
	
}
