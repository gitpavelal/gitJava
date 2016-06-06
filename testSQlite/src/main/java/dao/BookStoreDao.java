package dao;



import java.util.List;

public interface BookStoreDao {

    public void addInStore(Object object);

    public void updateInStore(Object object);

    public void removeInStore(Object object);

    public List<Object> getListBooksStore();
}
