package com.jaimevazquez.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        String username,
        @NotBlank
        String contrasena
) {
}
