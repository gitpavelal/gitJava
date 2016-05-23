package com.paveal.testDB;

public class Letter {
    private int letterId;
    private String letterPattern;
    private String letterTittle;

    public Letter() {

    }

    public Letter(int letterId, String letterPattern, String letterTittle) {
        this.letterId = letterId;
        this.letterPattern = letterPattern;
        this.letterTittle = letterTittle;
    }

    public int getLetterId() {
        return letterId;
    }

    public void setLetterId(int letterId) {
        this.letterId = letterId;
    }

    public String getLetterPattern() {
        return letterPattern;
    }

    public void setLetterPattern(String letterPattern) {
        this.letterPattern = letterPattern;
    }

    public String getLetterTittle() {
        return letterTittle;
    }

    public void setLetterTittle(String letterTittle) {
        this.letterTittle = letterTittle;
    }
}
