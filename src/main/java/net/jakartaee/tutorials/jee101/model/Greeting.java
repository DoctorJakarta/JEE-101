package net.jakartaee.tutorials.jee101.model;

public class Greeting {
	private String _title;
	private String _name;
	
	public Greeting(String _title, String _name) {
		this._title = _title;
		this._name = _name;
	}

	public String get_title() {
		return _title;
	}

	public String get_name() {
		return _name;
	}	
	
}
