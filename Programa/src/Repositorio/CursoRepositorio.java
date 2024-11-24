package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Entidades.Curso;

public class CursoRepositorio {

    public void adicionarCurso(Curso curso) {
        String sql = "INSERT INTO Curso (tipoCurso, titulo, horaAula, dias) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, curso.getTipoCurso().toString());
            ps.setString(2, curso.getTitulo());
            ps.setInt(3, curso.getHoraAula());
            ps.setInt(4, curso.getDias());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerCurso(int id) {
        String sql = "DELETE FROM Curso WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listarCurso() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Curso curso = new Curso(
                        Enums.TipoCurso.valueOf(rs.getString("tipoCurso")),
                        rs.getString("titulo"),
                        rs.getInt("horaAula"),
                        rs.getInt("dias")
                );
                curso.setId(rs.getInt("id"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public void alterarCurso(Curso curso) {
        String sql = "UPDATE Curso SET tipoCurso = ?, titulo = ?, horaAula = ?, dias = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, curso.getTipoCurso().toString());
            ps.setString(2, curso.getTitulo());
            ps.setInt(3, curso.getHoraAula());
            ps.setInt(4, curso.getDias());
            ps.setInt(5, curso.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
