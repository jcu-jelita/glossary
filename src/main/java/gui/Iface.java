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
public interface Iface {

    String[] getListNames();

    boolean deleteList(String listName);

    boolean editList(String listName);

    
    
    boolean updateList(String listName, HashMap translations);

    boolean deleteFromList(String listName, String key);

}
