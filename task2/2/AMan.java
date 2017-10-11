public abstract class AMan {
    private String name;
    private String surname;

    public AMan(String name, String surname){
        System.out.println("AMan");
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String newSurname) {
        surname = newSurname;
    }
}
