package Servico;

import java.util.List;
import java.util.Scanner;

import Entidades.Aluno;
import Interfaces.IAluno;
import Repositorio.AlunoRepositorio;

public class AlunoServico implements IAluno {
    private static final Scanner scanner = new Scanner(System.in);
    private AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

    public AlunoServico(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    @Override
    public void adicionarAluno(String nome, String curso) {
        Aluno aluno = new Aluno(nome, curso);
        alunoRepositorio.adicionarAluno(aluno);
        System.out.println("\nAluno(a) adicionado com sucesso!");
    }

    @Override
    public void alterarAluno(int id) {
        List<Aluno> alunos = alunoRepositorio.listarAluno();
        if (alunos.isEmpty()) {
            System.out.println("Não existe aluno(s) matriculado(s)!");
        } else {
            Aluno aluno = alunos.stream().filter(a -> a.getMatricula() == id).findFirst().orElse(null);
            if (aluno != null) {
                System.out.print("Novo Nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Novo Curso: ");
                String novoCurso = scanner.nextLine();
                aluno.setNome(novoNome);
                aluno.setCurso(novoCurso);
                alunoRepositorio.alterarAluno(aluno);
                System.out.println("\nMatricula atualizada com sucesso!");
            } else {
                System.out.println("Matricula inválida!");
            }
        }
    }

    @Override
    public void removerAluno(int id) {
        List<Aluno> alunos = alunoRepositorio.listarAluno();
        if (alunos.isEmpty()) {
            System.out.println("Não existe aluno(s) matriculado(s)!");
        } else {
            alunoRepositorio.removerAluno(id);
            System.out.println("\nMatricula: " + id + ". Removida com sucesso!");
        }
    }

    @Override
    public void listarAluno() {
        List<Aluno> alunos = alunoRepositorio.listarAluno();
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia!");
        } else {
            for (Aluno a : alunos) {
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Matricula do Aluno(a): " + a.getMatricula() + "\n");
                System.out.print(" | Nome: " + a.getNome());
                System.out.print(" | Curso: " + a.getCurso());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }
}
