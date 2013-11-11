/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentdevanzarigui;

import Controller.Controller;
import Repository.RepositoryProducts;
import Repository.RepositoryUsers;

/**
 *
 * @author Eugen
 */
public class AgentDeVanzariGUI {
    
    public static void main(String[] args) {
        new AgentDeVanzariWindow().setVisible(true);
        RepositoryProducts rp=new RepositoryProducts();
        RepositoryUsers ru=new RepositoryUsers();
        Controller c=new Controller(rp,ru);
        new ConsultCatalogFrame().setVisible(true);
        new ManageCatalogFrame().setVisible(true);
    }
}

