package com.sena.api.parking.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sena.api.parking.model.Tarifa;
import com.sena.api.parking.model.TipoVehiculo;
import com.sena.api.parking.repository.EspacioParqueoRepository;
import com.sena.api.parking.repository.TarifaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class TarifaInicializador implements ApplicationRunner {

	private final TarifaRepository tarifarepo;
	private final TarifaProperties props;

	@Override
	public void run(ApplicationArguments args) {
		// TODO Auto-generated method stub
		for (TipoVehiculo tipo : TipoVehiculo.values()) {
			if (tarifarepo.existsByTipoAndVigenteHastaIsNull(tipo)) {
				continue;
			}
			TarifaProperties.Valores v = props.getTipos().get(tipo);
			tarifarepo.save(Tarifa.builder().tipo(tipo).valorHora(v.getHora()).valorFraccion(v.getFraccion())
					.fraccionMinutos(props.getFraccionMinutos()).vigenteDesde(ZonaHoraria.ahora()).build());
			log.info("Tarifa Inicial creada para {}", tipo);

		}
	}

}
