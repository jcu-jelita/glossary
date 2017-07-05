/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glossary.gui;

import glossary.global.*;

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
                       System.out.println("Fetching cardList");
                       return new CardList[]{
                               new CardList(0, "Prvni seznam", null),
                               new CardList(1, "Druhý seznam", null)
                       };
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
               }, new TestService() {
                   @Override
                   public int getWordCount(int listId) {
                       return 0;
                   }

                   @Override
                   public WritingTest createWritingTest(int listId, int wordCount) {
                       return null;
                   }

                   @Override
                   public PracticeTest cretePracticeTest(int listId, int wordCount) {
                       return null;
                   }
               });
                frame.setVisible(true);
    }
}
