package basics.model;

public enum OliveName {
    // String appended to convert uppercase to lowercase
    // Each bracket acts as an instance of the enum. So constructor is called whenever class is mapped to Enum.
    // my overrided toString then converts this to class name value in string and returns it
    KALAMATA("Kalamata"), LIGURIAN("Ligurian"), NEWTEST("NewTest");

    private String name;

    // Constructor for enum can only be called by Enum itself. So can't be public
    OliveName(String name) {
        this.name = name;
    }

    // Every Java class and enum has a toString method. Default toString method translates the identifier
    // Default toString method displays the class hashcode and acts as identifier
    // Override shows that the parent class method is being overridden
    @Override
    public String toString() {
        return name;
    }
}
