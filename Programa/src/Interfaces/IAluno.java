package Interfaces;

public interface IAluno {
    public void adicionarAluno(String aluno, String curso);
    public void removerAluno(int id);
    public void alterarAluno(int id);
    public void listarAluno();
}
