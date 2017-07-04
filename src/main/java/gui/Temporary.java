/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.HashMap;

/**
 *
 * @author Papi
 */
public class Temporary {
    

    public static void main(String[] args) {
               Frame frame = new Frame(new Iface() {
                                     @Override
                   public boolean deleteList(String listName) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }

                   @Override
                   public boolean editList(String listName) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }

                   @Override
                   public boolean deleteFromList(String listName, String key) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }

                   @Override
                   public boolean updateList(String listName, HashMap Translations) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }

                   @Override
                   public String[] getListNames() {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }
               });
                frame.setVisible(true);
    }
}
