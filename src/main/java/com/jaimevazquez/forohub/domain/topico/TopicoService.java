package com.jaimevazquez.forohub.domain.topico;

import com.jaimevazquez.forohub.domain.topico.validaciones.ValidadorDeTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    List<ValidadorDeTopicos> validadorDeTopicos;

    public DatosDetalleTopico registrarTopico(DatosRegistroTopico datosRegistroTopico){

        validadorDeTopicos.forEach(v -> v.validarRegistro(datosRegistroTopico));

        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }

    public DatosDetalleTopico actualizarTopico(Long id, DatosActualizarTopico datosActualizarTopico){

        validadorDeTopicos.forEach(v -> v.validarActualizacion(datosActualizarTopico));

        Topico topico = topicoRepository.getReferenceById(id);
        if(datosActualizarTopico.titulo() != null) topico.setTitulo(datosActualizarTopico.titulo());
        if(datosActualizarTopico.mensaje() != null) topico.setMensaje(datosActualizarTopico.mensaje());
        if(datosActualizarTopico.status() != null) topico.setStatus(datosActualizarTopico.status());
        if(datosActualizarTopico.autor() != null) topico.setAutor(datosActualizarTopico.autor());
        if(datosActualizarTopico.curso() != null) topico.setCurso(datosActualizarTopico.curso());

        DatosDetalleTopico datosDetalleTopico = new DatosDetalleTopico(topico);
        return datosDetalleTopico;
    }
}
