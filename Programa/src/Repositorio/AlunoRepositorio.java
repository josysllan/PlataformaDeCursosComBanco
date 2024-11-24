package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Entidades.Aluno;

public class AlunoRepositorio {

    public void adicionarAluno(Aluno aluno) {
        String sql = "INSERT INTO Aluno (nome, curso) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCurso());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerAluno(int id) {
        String sql = "DELETE FROM Aluno WHERE matricula = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarAluno() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("curso"));
                aluno.setMatricula(rs.getInt("matricula"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public void alterarAluno(Aluno aluno) {
        String sql = "UPDATE Aluno SET nome = ?, curso = ? WHERE matricula = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCurso());
            ps.setInt(3, aluno.getMatricula());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
