/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Domain.Product;
import java.util.ArrayList;

/**
 *
 * @author Eugen
 */
public class RepositoryProducts {
    private ArrayList<Product> products = new ArrayList<Product>();
    
    public Product ReadProduct() {
        Product produs = null;
        return produs;
    }
    
    public void AddProduct(Product produs) {
        
    }
    
    public void RemoveProduct(Product produs) {
        
    }
    
    public void UpdateProduct(Product produs) {
        
    }
    
    public ArrayList<Product> getProductsList() {
        return products;
        
    }
    
    public void PlaceNewOrder(Product produs, int cant) {
        
    }
}
