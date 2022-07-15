package br.ufc.pds.iot.service.interfaces;

import java.util.List;

public interface IIoTRepository<T> {
	public T find(String identifier) throws Exception;
	public void add(T t);
	public List<T> getAll();
}
