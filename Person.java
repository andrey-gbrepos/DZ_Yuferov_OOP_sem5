
/**
 * Абстрактный класс Person (Люди)
 */
public abstract class Person {
    String idPerson;
    String position;
    String firstName;
    String lastName;
    String numGroup;
    public Person(String idPerson) {
        this.idPerson = idPerson;
        this.position = "unknown";
        this.firstName = "unknown";
        this.lastName = "unknown";
        this.numGroup = "";
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getPosition() {
        return position;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String fullName() {
        return String.format("%s %s %s", firstName, lastName);
    }

    public String getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(String numGroup) {
        this.numGroup = numGroup;
    }
    
    @Override 
    public String toString(){
        return String.format("\n %s %s %s %s %s", idPerson, position, firstName, lastName, numGroup);
}
}