package View;

import java.util.Scanner;

import Enums.TipoCurso;
import Repositorio.AlunoRepositorio;
import Repositorio.CursoRepositorio;
import Repositorio.InstrutorRepositorio;
import Servico.AlunoServico;
import Servico.CursoServico;
import Servico.InstrutorServico;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
    private static InstrutorRepositorio instrutorRepositorio = new InstrutorRepositorio();
    private static CursoRepositorio cursoRepositorio = new CursoRepositorio();
    private static AlunoServico alunoServico = new AlunoServico(alunoRepositorio);
    private static InstrutorServico instrutorServico = new InstrutorServico(instrutorRepositorio);
    private static CursoServico cursoServico = new CursoServico(cursoRepositorio);

    public static void main(String[] args) {
        boolean sair = false;
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    criarAluno();
                    break;
                case 2:
                    alunoServico.listarAluno();
                    break;
                case 3:
                    alterarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    criarInstrutorECurso();
                    break;
                case 6:
                    listarInstrutores();
                    break;
                case 7:
                    alterarInstrutor();
                    break;
                case 8:
                    removerInstrutor();
                    break;
                case 9:
                    listarCursos();
                    break;
                case 10:
                    alterarCurso();
                    break;
                case 11:
                    removerCurso();
                    break;
                case 0:
                    sair = true;
                    break;
            }
        } while (!sair);
    }

    public static void menuPrincipal() {
        System.out.println("\n--------------------------------");
        System.out.println("SELECIONE SUA OPÇÃO:");
        System.out.print("| 1.Criar Aluno |");
        System.out.print(" 2.Listar Alunos |");
        System.out.print(" 3.Alterar Aluno |");
        System.out.print(" 4.Remover Aluno |");
        System.out.print(" 5.Criar Instrutor e Curso |");
        System.out.print("\n| 6.Listar Instrutores |");
        System.out.print(" 7.Alterar Instrutor |");
        System.out.print(" 8.Remover Instrutor |");
        System.out.print(" 9.Listar Cursos |");
        System.out.print(" 10.Alterar Curso |");
        System.out.print(" 11.Remover Curso |");
        System.out.print("\n| 0. Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    private static void criarAluno() {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        alunoServico.adicionarAluno(nome, curso);
    }

    private static void removerAluno() {
        System.out.print("\nInforme o número da matrícula: ");
        int matricula = scanner.nextInt();
        alunoServico.removerAluno(matricula);
    }

    private static void alterarAluno() {
        System.out.print("\nInforme o número da matrícula: ");
        int matricula = scanner.nextInt();
        alunoServico.alterarAluno(matricula);
    }

    private static void listarInstrutores() {
        instrutorServico.listarInstrutor();
    }

    private static void alterarInstrutor() {
        System.out.print("\nInforme o ID do instrutor: ");
        int id = scanner.nextInt();
        instrutorServico.alterarInstrutor(id);
    }

    private static void removerInstrutor() {
        System.out.print("\nInforme o ID do instrutor: ");
        int id = scanner.nextInt();
        instrutorServico.removerInstrutor(id);
    }

    private static void listarCursos() {
        cursoServico.listarCurso();
    }

    private static void alterarCurso() {
        System.out.print("\nInforme o ID do curso: ");
        int id = scanner.nextInt();
        cursoServico.alterarCurso(id);
    }

    private static void removerCurso() {
        System.out.print("\nInforme o ID do curso: ");
        int id = scanner.nextInt();
        cursoServico.removerCurso(id);
    }

    private static void criarInstrutorECurso() {
        cursoServico.adicionarCurso(TipoCurso.PRESENCIAL, "Curso de Java", 30, 60);
        cursoServico.adicionarCurso(TipoCurso.ONLINE, "Curso de PHP", 20, 40);
        instrutorServico.adicionarInstrutor("José", 30);
        instrutorServico.adicionarInstrutor("Maria", 25);
    }
}
