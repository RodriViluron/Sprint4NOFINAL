package com.Spring3Pimienta.Spring4.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Empleado extends Base{
    private String nombre;

    private String apellido;

    private String telefono;

    private int codigoEmpleado;

    private int dni;

    private String email;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
