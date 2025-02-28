package br.com.controller;

//Importações do JavFX
import br.com.model.Produto;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import br.com.dao.ProdutoDAO;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
/**
 *
 * @author ronal
 */
public class EntradaProdutosController {

    @FXML
    private TextField textOs, textProduto, textMedida, textDescricao, textFornecedor, textPesquisar, textUnidadeMedida, textCategoria;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button btnNovo, btnSalvar, btnEditar, btnExcluir, btnCancelar, btnPesquisar, btnSair;
    
    @FXML
    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
    
    @FXML
    private ListView<Produto> listView;
    
    private ProdutoDAO produtoDAO = new ProdutoDAO();  
    
    
    //Método para inicializar automaticamente ao carregar a FXML
    public void initialize() {
        //COnfigurações iniciais, como carregar categoria e unidade de medida.
       
    }
    
   
    //Método para o botão "Novo". Reutilizando o método de limpar os campos da tela entrada de produtos.
    @FXML
    private void onNovoClick(){
        limparCampos();
        System.out.println("Campos limpos!");
    }
    
     @FXML
     private void onSalvarClick()throws SQLException{
         salvarProduto();
     }
     
     //Método para salvar os produtos.
     private void salvarProduto()throws SQLException{
         System.out.println("Método salvarProduto() chamado.");
         
         //Validação dos campos
         if(textOs.getText().isEmpty()  || 
            textProduto.getText().isEmpty() ||
            textMedida.getText().isEmpty() ||
            textDescricao.getText().isEmpty() ||
            textCategoria.getText().isEmpty() ||
            textFornecedor.getText().isEmpty() ||
            datePicker.getValue() == null) {
             
             //Exibe um alerta se algum campo estiver vazio ou inválido
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Campos Obrigatórios");
             alert.setHeaderText("Preencha todos os campos obrigatórios!");
             alert.setContentText("Por favor, verifique se todos os campos estão preenchidos corretamente.");
             alert.showAndWait();
             return; //Encerra o método se houver campos inválidos
         }
         
         //Continua com a criação do objeto produto
         Produto produto = new Produto();
         
         produto.setOs(textOs.getText());
         produto.setProduto(textProduto.getText());
         produto.setMedida(textMedida.getText());
         produto.setDescricao(textDescricao.getText());
         produto.setCategoria(textCategoria.getText());
         produto.setUnidadeMedida(textUnidadeMedida.getText());
         produto.setFornecedor(textFornecedor.getText());
         produto.setData(LocalDateTime.now());
         
         //Salva o produto
         produtoDAO.salvar(produto);
         
         //Adiciona o produto no observabelist (isso vai atualizar o ListView automaticamente).
         listaProdutos.add(produto);
         
         listView.setItems(listaProdutos);
         
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Sucesso");
         alert.setHeaderText("Produto cadastrado com sucesso");
         alert.showAndWait();
     }
    
    //Método para limpar os campos na tela de entrada de produtos
    private void limparCampos() {
        textOs.clear();
        textProduto.clear();
        textMedida.clear();
        textDescricao.clear();
        textFornecedor.clear();
        textPesquisar.clear();
        textUnidadeMedida.clear();
        textCategoria.clear();
        datePicker.setValue(null);
    }

}
