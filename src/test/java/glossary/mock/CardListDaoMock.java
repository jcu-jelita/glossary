package glossary.mock;

import glossary.engine.dao.CardListDao;
import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardListDaoMock implements CardListDao {

    @Override
    public List<CardList> findAll() {
        List<CardList> list = new ArrayList<>();
        CardList cl1 = new CardList(0,"Trasporation");
        CardList cl2 = new CardList(1,"Jobs");
        CardList cl3 = new CardList(2,"School");
        CardList cl4 = new CardList(3,"Weather");
        CardList cl5 = new CardList(4,"Family");
        CardList cl6 = new CardList(5,"Fruit");
        list.add(cl1);
        list.add(cl2);
        list.add(cl3);
        list.add(cl4);
        list.add(cl5);
        list.add(cl6);
        return list;
    }
    //TODO Pája review please
    @Override
    public CardList save(CardList cardList, List<Card> cards) {
        CardList cl = new CardList(0,"Animals");

        return cl;
    }

    @Override
    public boolean remove(int listId) {
        return true;
    }
}
