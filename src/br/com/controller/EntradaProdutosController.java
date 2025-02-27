package br.com.controller;

//Importações do JavFX
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
