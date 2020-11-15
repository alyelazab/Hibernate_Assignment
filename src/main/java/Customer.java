public class Customer {
    private int ID;
    private String firstName;
    private String lastName;

    public Customer(int i, String fname, String lname){
        this.ID = i;
        this.firstName = fname;
        this.lastName = lname;
    }

    public Customer() {
        this.ID = -1;
        this.firstName = null;
        this.lastName = null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}
