package br.com.controller;

import br.com.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author ronaldo neto
 */
public class LoginController {
    
    @FXML
    private TextField TextUsuario;
    
    @FXML
    private PasswordField TextSenha;
    
    private final LoginService LoginService = new LoginService();
    
    @FXML
    private void handleLogin (ActionEvent event){
        String username = TextUsuario.getText();
        String password = TextSenha.getText();
        
        if(username.isEmpty() || password.isEmpty()){
            showAlert(AlertType.WARNING, "Aviso", "Preencha todos os campos!");
            return;
        }
        
        boolean isAuthenticate = LoginService.authenticate(username, password);
        
        if(isAuthenticate){
            showAlert(AlertType.INFORMATION, "Sucesso", "Login realizado com sucesso!");
        }else{
            showAlert(AlertType.ERROR, "Erro", "Usuário ou senha inválidos");
        }
        
    }
    
    private void showAlert(AlertType alertType, String title, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
