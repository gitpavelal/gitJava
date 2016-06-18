import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OopPrinciples {
/**
 * Полиморфизм
 *
 *Свойство некоторой системы быть возможным применимым к не скольким типам.
 *
 *Имеет высокую вероятность повторного использования кода
 *
 * Пример: метода last выдает последний элемент любой коллекции, даже treeSet
 *применимо да же к более высокому интерфейсу Iterable
 *
 * если поставить List на вход метода, то некоторые коллекции такие как
 * HashSet или другие будут не иметь некоторых методов, для вывода элемента
 *  и метод окажется менее полиморфным.
 *
 * Subtype polymorphism полиморфиз подтипов, метод в качестве аргуметов принимает
 * предка, тогда этот предок и все его потомки будут корректно работать с этим методом
 *
 * Generics для генерелификации методов, создают отдельный тип Т, который может вариваться
 * при выборе тех или иных даных в методе String, Integer и прочее.
 * Таким образом создается более унифицированный метод, т.е. бесконечное семейство типов
 *
     **/
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        System.out.println(last(list));
    }
    public static Object last(Collection list) {
        Iterator iterator = list.iterator();
        Object res = null;

        while (iterator.hasNext()) {
            res = iterator.next();
        }
        return res;
    }


/**
 * Наследование
 *
 *Наследование это способ образнования нового типа из старого типа
 * при котором получаем весь функционал страрого типа
 *  и можно его расширять и изменять.
 *  нельзя закрывать функционал.
 *
 *  Пример. метод toString в Object, если создаем свой к примеру User,
 *   то мы имеем такой же метод toString, и его можем переопределить и
 *   перечислить поля. убрать этот метод невозможно.
 *
 * */




/**
 * Инкапсуляция(сокрытие)
 *
 *
 *
 * */





/**
 * Делегирование
 *
 * Аггрегаци
 *
 * Композиция
 *
 * */

}