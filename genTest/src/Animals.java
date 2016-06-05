

public class Animals<T> {
    private T object;



    public Animals() {
    }

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public T getDog() {
        Animals<Integer> dog = new Animals<>();
        return ((T) dog);
    }

    public T getCat(){
        Double cat = 10.0;
        return (T) cat;
    }

    public T getBird(){
        String bird = "b";
        return (T)bird;
    }

//    public void feed(Food food){
//        objec
//    }



}

//
//    Feed feed = new Feed();
//    Food food = new Food();
//    Animals animals = new Animals();
//    Animals<Integer> dog = new Animals<>();
//
//        System.out.println(animals.getCat().getClass().getSimpleName());
//System.out.println(dog.getObject().getClass().getSimpleName());
//        System.out.println(animals.getDog().getClass().getSimpleName());
////        System.out.println(animals.getBird().getClass().getSimpleName());
//
//
//        System.out.println(feed.getMeat().getClass().getSimpleName());
//        System.out.println(feed.getFish().getClass().getSimpleName());
//
//
