package sorveteria.repository;


import sorveteria.model.Produto;

public interface SorveteriaRepository {

	public void consultarPorId(int numero);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	public void reorganizarids(int id);                   
}
