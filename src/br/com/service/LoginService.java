package br.com.service;

import br.com.dao.UserDAO;
/**
 *
 * @author ronaldo neto
 */
public class LoginService {
    
    private final UserDAO UserDAO = new UserDAO();
    
    public boolean authenticate(String username, String password){
        return UserDAO.validateUser(username, password);
    }
}
