package Services;

import Domains.Item;

import java.util.Collection;

public interface ItemService {
    public void addUsuario(Item item);
    public Collection<Item> getItems();
    public Item getItem(String id);
    public Item editItem(Item forEdit);
    public void deleteItem(String id);
    public boolean itemExist(String id);


}
