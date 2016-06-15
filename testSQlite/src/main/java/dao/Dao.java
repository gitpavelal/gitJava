package dao;

import java.util.List;

public interface Dao<T> {

    public void addInStore(T t) ;

    public void updateInStore(T t) ;

    public void removeInStore(T t) ;

    public List<T> getListBooksStore() ;

}
