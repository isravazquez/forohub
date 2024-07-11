package com.jaimevazquez.forohub.domain.topico;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(),
                topico.getCurso());
    }
}
