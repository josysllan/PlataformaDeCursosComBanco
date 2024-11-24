package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Entidades.Instrutor;

public class InstrutorRepositorio {

    public void adicionarInstrutor(Instrutor instrutor) {
        String sql = "INSERT INTO Instrutor (nome, idade) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, instrutor.getNome());
            ps.setInt(2, instrutor.getIdade());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerInstrutor(int id) {
        String sql = "DELETE FROM Instrutor WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Instrutor> listarInstrutor() {
        List<Instrutor> instrutores = new ArrayList<>();
        String sql = "SELECT * FROM Instrutor";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Instrutor instrutor = new Instrutor(rs.getString("nome"), rs.getInt("idade"));
                instrutor.setId(rs.getInt("id"));
                instrutores.add(instrutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instrutores;
    }

    public void alterarInstrutor(Instrutor instrutor) {
        String sql = "UPDATE Instrutor SET nome = ?, idade = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, instrutor.getNome());
            ps.setInt(2, instrutor.getIdade());
            ps.setInt(3, instrutor.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
