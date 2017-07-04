/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glossary.gui;

import glossary.global.CardList;
import glossary.global.ListService;

import java.util.HashMap;

/**
 *
 * @author Papi
 */
public class Temporary {
    

    public static void main(String[] args) {
               Frame frame = new Frame(new ListService() {

                   @Override
                   public CardList[] getLitOverview() {
                       return new CardList[0];
                   }

                   @Override
                   public CardList getLitDetail(int id) {
                       return null;
                   }

                   @Override
                   public CardList save(CardList cardList) {
                       return null;
                   }

                   @Override
                   public boolean remove(int listId) {
                       return false;
                   }
               });
                frame.setVisible(true);
    }
}
