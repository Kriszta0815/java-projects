package springapps.opinion;

public class User {

    private String id;
    private String firstName;

    private String lastName;
    private String opinion;

    public User(String firstName, String lastName, String opinion) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.opinion = opinion;
    }
    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
