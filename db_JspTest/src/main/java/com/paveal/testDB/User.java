package com.paveal.testDB;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private int userArrears;

    public User() {

    }

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        DbWorker worker;
    }

    public User(int userId, String userName, String userPassword, int userArrears) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userArrears = userArrears;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserArrears() {
        return userArrears;
    }

    public void setUserArrears(int userArrears) {
        this.userArrears = userArrears;
    }


}
