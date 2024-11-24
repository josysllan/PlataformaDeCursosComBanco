package Servico;

import java.util.List;
import java.util.Scanner;

import Entidades.Curso;
import Enums.TipoCurso;
import Interfaces.ICurso;
import Repositorio.CursoRepositorio;

public class CursoServico implements ICurso {
    private static final Scanner scanner = new Scanner(System.in);
    private CursoRepositorio cursoRepositorio = new CursoRepositorio();

    public CursoServico(CursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public void adicionarCurso(TipoCurso tipoCurso, String titulo, int horaAula, int dias) {
        Curso curso = new Curso(tipoCurso, titulo, horaAula, dias);
        cursoRepositorio.adicionarCurso(curso);
        System.out.println("Curso adicionado com sucesso!");
    }

    @Override
    public void removerCurso(int id) {
        List<Curso> cursos = cursoRepositorio.listarCurso();
        if (cursos.isEmpty()) {
            System.out.println("Erro: Não existem cursos cadastrados!");
        } else {
            cursoRepositorio.removerCurso(id);
            System.out.println("\nCurso ID: " + id + ". Removido com sucesso!");
        }
    }

    @Override
    public void alterarCurso(int id) {
        List<Curso> cursos = cursoRepositorio.listarCurso();
        if (cursos.isEmpty()) {
            System.out.println("Erro: Não existem cursos cadastrados!");
        } else {
            Curso curso = cursos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
            if (curso != null) {
                System.out.print("Novo Tipo: 1.PRESENCIAL | 2.ONLINE | ");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                System.out.print("Titulo: ");
                String titulo = scanner.nextLine();
                System.out.print("Hora Aula: ");
                int horaAula = scanner.nextInt();
                System.out.print("Dias: ");
                int dias = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                
                if (opcao == 1) {
                    curso.setTipoCurso(TipoCurso.PRESENCIAL);
                } else if (opcao == 2) {
                    curso.setTipoCurso(TipoCurso.ONLINE);
                }
                curso.setTitulo(titulo);
                curso.setHoraAula(horaAula);
                curso.setDias(dias);
                cursoRepositorio.alterarCurso(curso);
                System.out.println("\nCurso atualizado com sucesso!");
            } else {
                System.out.println("Erro: ID de curso inválido!");
            }
        }
    }

    @Override
    public void listarCurso() {
        List<Curso> cursos = cursoRepositorio.listarCurso();
        if (cursos.isEmpty()) {
            System.out.println("Erro: Não existem cursos cadastrados!");
        } else {
            for (Curso c : cursos) {
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Curso ID: " + c.getId() + "\n");
                System.out.print(" | Tipo: " + c.getTipoCurso());
                System.out.print(" | Titulo: " + c.getTitulo());
                System.out.print(" | Hora Aula: " + c.getHoraAula());
                System.out.print(" | Dias: " + c.getDias());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }
}
