package br.com.dao;

import br.com.controller.EntradaProdutosController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.model.Produto;
import br.com.dao.ConexaoBancoDeDados;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author ronaldo neto
 */
public class ProdutoDAO {

    //Método para salvar os produtos no banco de dados.
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produtos (os_produto, nome_produto, categoria, unidade_medida, quantidade, fornecedor, descricao, data_hora)  VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexaoBancoDeDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getOs());
            stmt.setString(2, produto.getProduto());
            stmt.setString(3, produto.getCategoria());
            stmt.setString(4, produto.getUnidadeMedida());
            stmt.setString(5, produto.getMedida());
            stmt.setString(6, produto.getDescricao());
            stmt.setString(7, produto.getFornecedor());

            //Obtém a data e hora atual
            LocalDateTime dataComHoraAtual = LocalDateTime.now();

            //Converte LocalDateTime para TimeStamp
            Timestamp timestamp = Timestamp.valueOf(dataComHoraAtual);
            stmt.setTimestamp(8, timestamp);

            stmt.executeUpdate();
        }
    }
     
    //Método para buscar os produtos cadastrados no banco de dados.
    public List<Produto> buscarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos"; //Consulta SQL
        try (Connection conn = ConexaoBancoDeDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setOs(rs.getString("os_produto"));
                produto.setProduto(rs.getString("nome_produto"));
                produto.setMedida(rs.getString("quantidade_metro"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setData(rs.getTimestamp("data_cadastro").toLocalDateTime());
                produtos.add(produto);
            }
        }

        return produtos;
    }
}
