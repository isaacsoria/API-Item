package Services;

import Domains.Item;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Collection;

public interface ItemService {
    public void addItem(Item item) throws IOException;
    public Collection<Item> getItems();
    public Item getItem(String id) throws IOException;
    public Item editItem(Item forEdit) throws IOException;
    public void deleteItem(String id) throws IOException;
    public boolean itemExist(String id);


}
