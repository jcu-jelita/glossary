package glossary.global;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public interface ListService {

    CardList[] getLitOverview();

    CardList getLitDetail(int id);

    CardList save(CardList cardList);

    boolean remove(int listId);
}
