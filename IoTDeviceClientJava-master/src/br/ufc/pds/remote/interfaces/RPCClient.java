package br.ufc.pds.remote.interfaces;

public interface RPCClient {
	public void connect(String host) throws Exception;
	public void send(String data) throws Exception;
	public String receive() throws Exception;
	public void stop() throws Exception;
}
