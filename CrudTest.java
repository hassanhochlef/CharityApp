/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.User;
import services.UserServices;
import tools.MyConnection;
/**
 *
 * @author LENOVO
 */
public class CrudTest {
    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        UserServices use = new UserServices();
        User u1 = new User("Aymen","Zaabar","93977499","Sahloul","Sousse","aymen.zaabar@espri.tn","admin");
        User u2= new User ("hassen","hochlef","25243341","khzema","sousse","hassen.hochlef@esprit.tn","donneur");
        //use.addUsers(u2);
        //System.out.println(use.retrieveUser()); 
        //use.deleteUser("25243341");
        //use.updateUser("25243341", u1);
        
    }
    
}
