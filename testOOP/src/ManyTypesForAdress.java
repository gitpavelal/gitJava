
public class ManyTypesForAdress {

    public static void main(String[] args) {

        /**
         * DSL
         *
         * при создании  видно что класс обладает несколькими типами
         * и какими понятно по смыслу
         * не приходтся гадать что где находится
         * */

        AdressByManyTypes adress = new AdressByManyTypes(
                AdressByManyTypes.Country_.country("US"),
                AdressByManyTypes.State_.state("NY"),
                AdressByManyTypes.Sity_.sity("NY"));

        System.out.println(adress);
    }


}


/**
 * полный адрес пользователя
 */

class AdressByManyTypes {
    private String country;
    private String state;
    private String sity;

    public AdressByManyTypes(Country_ country, State_ state, Sity_ sity) {
        this.country = country.s;
        this.state = state.s;
        this.sity = sity.s;
    }

    @Override
    public String toString() {
        return "AdressByManyTypes{" +
                "country=" + country +
                ", state=" + state +
                ", sity=" + sity +
                '}';
    }

    /**
     * создаем совой тип для каждого элементна для наглядности
     */
    public static class Country_ {
        private String s;

        public Country_(String s) {
            this.s = s;
        }

        public static Country_ country(String s) {
            return new Country_(s);
        }
    }

    public static class State_ {
        private String s;

        public State_(String s) {
            this.s = s;
        }

        public static State_ state(String s) {
            return new State_(s);
        }
    }

    public static class Sity_ {
        private String s;

        public Sity_(String s) {
            this.s = s;
        }

        public static Sity_ sity(String s) {
            return new Sity_(s);
        }
    }


}

