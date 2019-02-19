package basics.model;

public class Kalamata extends Olive {
    public Kalamata() {
        super(OliveName.KALAMATA, OliveColor.GREEN,3 );
    }

    // Either do this or make class abstract
    @Override
    public String getOrigin() {
        return "Greece";
    }
}
