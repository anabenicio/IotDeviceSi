package br.ufc.pds.remote.interfaces;

import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public interface ISerializationStrategy {
	public Request deserialize(String json);
	public String serialize(Response response);
}
