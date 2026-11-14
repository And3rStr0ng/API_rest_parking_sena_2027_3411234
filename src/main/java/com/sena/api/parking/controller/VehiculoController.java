package com.sena.api.parking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.api.parking.dto.RegistroResponse;
import com.sena.api.parking.dto.VehiculoResponse;
import com.sena.api.parking.service.RegistroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

	private final RegistroService service;

	@GetMapping
	public List<VehiculoResponse> listar() {
		return service.listarVehiculos();
	}

	@GetMapping("/{placa}/registros")
	public List<RegistroResponse> historial(@PathVariable String placa) {
		return service.historialPorPlaca(placa);
	}
}
