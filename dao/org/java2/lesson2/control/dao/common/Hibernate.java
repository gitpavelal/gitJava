package org.java2.lesson2.control.common;

/**
 * Наш хибернейт
 * Также будет реализован как Singlton
 * Не потока защищенный
 */
public class Hibernate {
    private static Hibernate insnance;

    private Hibernate() {
        //no-op
    }

    public static Hibernate getInsnance() {
        if (insnance == null)
            insnance = new Hibernate();
        return insnance;
    }
}
