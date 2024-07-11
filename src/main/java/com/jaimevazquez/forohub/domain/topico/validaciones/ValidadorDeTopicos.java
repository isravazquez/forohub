package com.jaimevazquez.forohub.domain.topico.validaciones;

import com.jaimevazquez.forohub.domain.topico.DatosActualizarTopico;
import com.jaimevazquez.forohub.domain.topico.DatosRegistroTopico;

public interface ValidadorDeTopicos {
    public void validarRegistro(DatosRegistroTopico datosRegistroTopico);
    public void validarActualizacion(DatosActualizarTopico datosActualizarTopico);
}
