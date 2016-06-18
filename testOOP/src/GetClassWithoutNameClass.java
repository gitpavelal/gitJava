import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * * Java рефлексия
 *
 * Создаем юзера, берем ссылку на объект и
 * достаем из него все поля и значения
 * спрашивая имя класса и прочее
 *
 * метод может использоваться с любым классом
 *
 * */

public class GetClassWithoutNameClass {

    public static void main(String[] args) throws IllegalAccessException {


        toMyXml(new User("Mike", 25));

    }

    private static void toMyXml(Object ref) throws IllegalAccessException {

       Class clazz = ref.getClass();
       Field[] fields =  clazz.getDeclaredFields();

        System.out.println("<"+clazz.getSimpleName()+">");
        for (Field field : fields
             ) {
            System.out.println("   <"+field.getName() +">"+  field.get(ref) + "</"+   field.getName()+ ">");
        }
        System.out.println("</"+clazz.getSimpleName()+">");
    }
}



/**
 * если сделать поля приват, то field.get(ref) работать не будет
 * из-за ошибке в доступе
 * */
class User {
   protected String name;
   protected int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
