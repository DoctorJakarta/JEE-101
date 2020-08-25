package net.jakartaee.tutorial.jee101.model;

public class Greeting {
	public enum VARIANT { HELLO, NAMASTE }
	private VARIANT _variant;
	private String _title;
	private String _name;
	
	public Greeting(VARIANT variant, String title, String name) {
		_variant = variant;
		_title = title;
		_name = name;
	}
	

	public VARIANT getVariant() {
		return _variant;
	}
	public void setVariant(VARIANT variant) {
		_variant = variant;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}


	@Override
	public String toString() {
		return _variant + " " + _title + " " + _name;
	}	
	
	
}
