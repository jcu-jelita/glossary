package glossary.global;

import java.util.ArrayList;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public interface ListService {

    /**
     * Get array of list objects without words.
     *
     * @return When storage is empty, return empty array
     */
    ArrayList<CardList> getLitOverview();

    CardList getLitDetail(int id);

    CardList save(CardList cardList);

    boolean remove(int listId);
}
