/**
 * Пример шаблона
 * <p>
 * Тест ооп сборка адреса пользователя
 * предварительно собираем в StringBuilder по частям
 * далее формируем полный AdressByManyTypes пользователя
 */
public class AdresBuilderForAdress {
    public static void main(String[] args) {
        /**
         * Откуда то берем поле страны
         * остальные поля null
         * */
        AdressBuilder builderSmall = new AdressBuilder().country("US");

        /**
         * добавляем к стране поле город
         * остальные поля null
         * */
        AdressBuilder builderNormal = builderSmall.sity("AAA");
        /**
         * собираем полный AdressByManyTypes со всеми данными
         * полей null нет
         * */
        AdressByString adress = builderNormal.state("NY").build();
        System.out.println(adress);
    }
}

/**
 * полный адрес пользователя
 * предпочтительно избегать полей null
 */
class AdressByString {
    private String country;
    private String state;
    private String sity;

    public AdressByString(String country, String state, String sity) {
        this.country = country;
        this.state = state;
        this.sity = sity;
    }

    @Override
    public String toString() {
        return "AdressByString{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", sity='" + sity + '\'' +
                '}';
    }
}

/**
 * собирает даные для AdressByManyTypes
 * умеет собирать по частям
 * нужен на случай что бы лучше обработать бизнес модель
 * может иметь поля null
 */
 class AdressBuilder {
    private String country;
    private String state;
    private String sity;

    AdressByString build() {
        return new AdressByString(country, state, sity);
    }

    public AdressBuilder country(String country) {
        this.country = country;
        return this;
    }

    public AdressBuilder state(String state) {
        this.state = state;
        return this;
    }

    public AdressBuilder sity(String sity) {
        this.sity = sity;
        return this;
    }
}