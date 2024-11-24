package Servico;

import java.util.List;
import java.util.Scanner;

import Entidades.Instrutor;
import Interfaces.IInstrutor;
import Repositorio.InstrutorRepositorio;

public class InstrutorServico implements IInstrutor {
    private static final Scanner scanner = new Scanner(System.in);
    private InstrutorRepositorio instrutorRepositorio = new InstrutorRepositorio();

    public InstrutorServico(InstrutorRepositorio instrutorRepositorio) {
        this.instrutorRepositorio = instrutorRepositorio;
    }

    @Override
    public void adicionarInstrutor(String nome, int idade) {
        Instrutor instrutor = new Instrutor(nome, idade);
        instrutorRepositorio.adicionarInstrutor(instrutor);
        System.out.println("Instrutor adicionado com sucesso!");
    }

    @Override
    public void removerInstrutor(int id) {
        List<Instrutor> instrutores = instrutorRepositorio.listarInstrutor();
        if (instrutores.isEmpty()) {
            System.out.println("Erro: Não existem instrutores cadastrados!");
        } else {
            instrutorRepositorio.removerInstrutor(id);
            System.out.println("\nInstrutor ID: " + id + ". Removido com sucesso!");
        }
    }

    @Override
    public void alterarInstrutor(int id) {
        List<Instrutor> instrutores = instrutorRepositorio.listarInstrutor();
        if (instrutores.isEmpty()) {
            System.out.println("Erro: Não existem instrutores cadastrados!");
        } else {
            Instrutor instrutor = instrutores.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
            if (instrutor != null) {
                System.out.print("Novo Nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Nova Idade: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                instrutor.setNome(novoNome);
                instrutor.setIdade(novaIdade);
                instrutorRepositorio.alterarInstrutor(instrutor);
                System.out.println("\nInstrutor atualizado com sucesso!");
            } else {
                System.out.println("Erro: ID de instrutor inválido!");
            }
        }
    }

    @Override
    public void listarInstrutor() {
        List<Instrutor> instrutores = instrutorRepositorio.listarInstrutor();
        if (instrutores.isEmpty()) {
            System.out.println("Erro: Não existem instrutores cadastrados!");
        } else {
            for (Instrutor i : instrutores) {
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Instrutor ID: " + i.getId() + "\n");
                System.out.print(" | Nome: " + i.getNome());
                System.out.print(" | Idade: " + i.getIdade());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }
}
