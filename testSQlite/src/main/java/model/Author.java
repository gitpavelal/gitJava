package model;

public class Author {
    private int autorId;
    private String authorFirstName;
    private String authorSecondName;
    private String authorMiddleName;


    public Author() {

    }

    public Author(String authorFirstName, String authorSecondName, String authorMiddleName) {
        this.authorFirstName = authorFirstName;
        this.authorSecondName = authorSecondName;
        this.authorMiddleName = authorMiddleName;
    }

    public Author(int autorId, String authorFirstName, String authorSecondName, String authorMiddleName) {
        this.autorId = autorId;
        this.authorFirstName = authorFirstName;
        this.authorSecondName = authorSecondName;
        this.authorMiddleName = authorMiddleName;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    public String getAuthorMiddleName() {
        return authorMiddleName;
    }

    public void setAuthorMiddleName(String authorMiddleName) {
        this.authorMiddleName = authorMiddleName;
    }

    @Override
    public String toString() {
        return "{" +
                "id автора= '" + autorId +
                "' имя= '" + authorFirstName + '\'' +
                " фамилия= '" + authorSecondName + '\'' +
                " отчество= '" + authorMiddleName + '\'' +
                '}';
    }
}
