package Services;

import Domains.Item;

import java.util.Collection;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders.*;

public class ItemServiceImpl implements ItemService {
    public void addUsuario(Item item) {
        
    }

    public Collection<Item> getItems() {
        return null;
    }

    public Item getItem(String id) {
        return null;
    }

    public Item editItem(Item forEdit) {
        return null;
    }

    public void deleteItem(String id) {

    }

    public boolean itemExist(String id) {
        return false;
    }
}
