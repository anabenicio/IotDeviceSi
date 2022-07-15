package br.ufc.pds.iot.service;

import java.util.List;

import br.ufc.pds.models.Sensor;

public interface IIoTRepository<T> {
	public T find(String identifier) throws Exception;
	public void add(T t);
	public List<T> getAll();
}
