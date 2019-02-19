package basics.model;

public class Olive implements Comparable<Olive> {

    // public static final String KALAMATA = "Kalamata";
    // public static final String LIGURIAN = "Ligurian";

    private OliveName name = OliveName.KALAMATA;
    private OliveColor color = OliveColor.BLACK;
    public int oil;

    // Snippet of code runs before constructors
    // In classes with multiple constructors, this code will run no matter which constructor is used
    {
        System.out.println("Initializer");
        oil = 3;
    }

    public Olive() {}

    public Olive(OliveName name, OliveColor color, int oil) {
        this.name = name;
        this.color = color;
        this.oil = oil;
    }

    public void call(int threadId) {
        System.out.println("Calling from "+threadId);
    }

    public OliveName getName() {
        return name;
    }

    public void setName(OliveName name) {
        this.name = name;
    }

    public OliveColor getColor() {
        return color;
    }

    public void setColor(OliveColor color) {
        this.color = color;
    }

    public int crush() {
        System.out.println("This is from ");
        // Commented out getOrigin()
        System.out.println("Ouch!");
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override
    public String toString() {
        return "oliveName: " + this.name.toString() +
                ", color: " + this.color.toString();
    }

    // Compare by class name and add according to classes. Only 2 elements will be added
    /*public int compareTo(Olive o) {
        String s1 = this.getClass().getSimpleName();
        String s2 = o.getClass().getSimpleName();
        return s1.compareTo(s2);
    }*/

    @Override
    public int compareTo(Olive oc) {
        OliveColor o1 = this.color;
        OliveColor o2 = oc.getColor();
        return o1.compareTo(o2);
    }

    // Use of member classes is a better way of encapsulation. Nobody can now access OliveType without
    // Going through Olive class.
    class OliveType {}

    public String getOrigin() { return ""; }
}
