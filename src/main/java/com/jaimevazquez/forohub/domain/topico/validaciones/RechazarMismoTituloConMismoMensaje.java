package com.jaimevazquez.forohub.domain.topico.validaciones;

import com.jaimevazquez.forohub.domain.topico.DatosActualizarTopico;
import com.jaimevazquez.forohub.domain.topico.DatosRegistroTopico;
import com.jaimevazquez.forohub.domain.topico.Topico;
import com.jaimevazquez.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RechazarMismoTituloConMismoMensaje implements ValidadorDeTopicos {
    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validarRegistro(DatosRegistroTopico datosRegistroTopico){
        List<Topico> listaDeTopicos = topicoRepository.findAllByTitulo(datosRegistroTopico.titulo());

        listaDeTopicos.forEach(t -> {
            if(t.getMensaje().equalsIgnoreCase(datosRegistroTopico.mensaje())) throw new ValidationException("El topico ya se existe con mismo titulo y mensaje");
        });
    }

    @Override
    public void validarActualizacion(DatosActualizarTopico datosActualizarTopico) {
        List<Topico> listaDeTopicos = topicoRepository.findAllByTitulo(datosActualizarTopico.titulo());

        listaDeTopicos.forEach(t -> {
            if(t.getMensaje().equalsIgnoreCase(datosActualizarTopico.mensaje())) throw new ValidationException("El topico ya se existe con mismo titulo y mensaje");
        });
    }
}
