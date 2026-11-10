package com.sena.api.parking.dto;

public record CobroDetalle(Long idTarifa, long minutostotales, long hotasCompletas, long fraccionCobradas, long tarifaHora, long tarifaFraccion, int tarifaMinutos, long valorTotal) {

}
