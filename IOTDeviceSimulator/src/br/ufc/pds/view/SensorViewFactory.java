package br.ufc.pds.view;

import br.ufc.pds.models.Sensor;
import br.ufc.pds.models.SensorAmbiente;
import br.ufc.pds.models.SensorEletricidade;
import br.ufc.pds.models.SensorPessoa;
import br.ufc.pds.models.SensorVeiculo;

public class SensorViewFactory implements ISensorViewFactory{

	public void createSensorView(Sensor sensor){
		if(sensor instanceof SensorPessoa){
			new SensorPessoaView((SensorPessoa)sensor).show();
		}
		else if(sensor instanceof SensorAmbiente){
			new SensorAmbienteView((SensorAmbiente)sensor).show();
		}
		else if(sensor instanceof SensorEletricidade){
			new SensorEletricidadeView((SensorEletricidade)sensor).show();
		}
		else if(sensor instanceof SensorVeiculo){
			new SensorVeiculoView((SensorVeiculo)sensor).show();
		}
	}
	
}
