/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Product;
import Repository.RepositoryProducts;
import Repository.RepositoryUsers;

/**
 *
 * @author Eugen
 */
public class Controller {
    private RepositoryProducts repop;
    private RepositoryUsers repou;
    
    public Controller(RepositoryProducts rp, RepositoryUsers ru){
        repop = rp;
        repou = ru;
    } 
    
    
    public boolean CheckUserLogin() {
        return true;
    }
    
    public void AddProduct(Product p) {
        repop.AddProduct(p);
    }
    
    public void UpdateProduct(Product p) {
        repop.UpdateProduct(p);
    }
    
    public void DeleteProduct(Product p) {
        repop.RemoveProduct(p);
    }
    
    public void PlaceNewOrder(Product p, int cant) {
        repop.PlaceNewOrder(p, cant);
    }
    
    
}
