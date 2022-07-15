package br.ufc.pds.remote.model;

public class RemoteException{

	String message;
	String stack;
	
	public RemoteException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}
	
}
