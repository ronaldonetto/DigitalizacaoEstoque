package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ronaldo neto
 */
public class UserDAO {

    public boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND senha = ?";
        try (Connection conexao = ConexaoBancoDeDados.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao bancov de dados" + e.getMessage());
            return false;
        }

    }

}
