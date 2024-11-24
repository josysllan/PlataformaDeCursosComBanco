package Interfaces;

public interface IInstrutor {
    public void adicionarInstrutor(String nome, int idade);
    public void removerInstrutor(int id);
    public void alterarInstrutor(int id);
    public void listarInstrutor();
}
