package basics.model;

public enum OliveColor {
	BLACK("Black"), GREEN("Green"), GOLDEN("Golden");
	
	private String colorAsString;
	
	private OliveColor(String colorAsString) {
		this.colorAsString = colorAsString;
	}
	
	@Override
	/*
	The toString method for class Object returns a string consisting of the name of the class of which
	the object is an instance, the at-sign character `@', and the unsigned hexadecimal representation of
	the hash code of the object.
	 */
	public String toString() {
		return this.colorAsString;
	}
}
