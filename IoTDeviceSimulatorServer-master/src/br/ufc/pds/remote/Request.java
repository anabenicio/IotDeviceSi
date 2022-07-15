package br.ufc.pds.remote;

public class Request {

	String method;
	String type;
	String identifier;
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return "Request [method=" + method + ", type=" + type + ", identifier=" + identifier + "]";
	}
	
}
