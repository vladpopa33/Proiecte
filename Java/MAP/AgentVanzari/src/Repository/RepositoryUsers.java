/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Domain.User;
import java.util.ArrayList;

/**
 *
 * @author Eugen
 */
public class RepositoryUsers {
    private ArrayList<User> users = new ArrayList<User>();
    
    public boolean CheckUserLogin(String numeu,String parola) {
           return true;
    }
    
    public User ReadUser() {
        User utilizator = null;
        return utilizator;
    }
    
    public void WriteUser(User utilizator) {
        
    }
}

