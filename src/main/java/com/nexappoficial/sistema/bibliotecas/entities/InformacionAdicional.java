package com.nexappoficial.sistema.bibliotecas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "libros", schema = "generico")
@Setter
@Getter
@EqualsAndHashCode
public class InformacionAdicional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idioma;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;

    public InformacionAdicional() {
        // TODO document why this constructor is empty
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
