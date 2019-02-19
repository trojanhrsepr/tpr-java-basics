package basics.test;

public class ExceptionCustom extends Exception {
    // Can be any long value
    public static final long serialVersionUID = 42L;

    // Also need to write custom code to make the code throw exception using throw(new ExceptionCustom());
    @Override
    public String getMessage() {
        return "Custom Exception message";
    }
}
