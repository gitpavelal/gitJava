package service;

import java.util.List;

public interface BookStoreService {

    public void addInStore(Object object);

    public void updateInStore(Object object);

    public void removeInStore(Object object);

    public List<Object> listInStore();
}
