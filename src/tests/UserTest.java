/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import services.UserServices;
import utils.MyConnection;
import entities.User;
/**
 *
 * @author LENOVO
 */
public class UserTest {
    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        UserServices use = new UserServices();
        User u1 = new User("Aymen","97262697","Sahloul","Sousse","93977499","aymen.zaabar@espri.tn","admin",1200);
        User u2=new User("Hassen","123456789","Khzema","Sousse","19819800","hassen.hochlef@espri.tn","admin",500.5f);
        //use.addUser(u2);
       // System.out.println(use.retrieveallUser()); 

    }
}
