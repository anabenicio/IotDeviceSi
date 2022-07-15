package br.ufc.pds.remote.interfaces;

import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public interface ISerializationStrategy {
	public Response deserialize(String json) throws Exception;
	public String serialize(Request request) throws Exception;
}
