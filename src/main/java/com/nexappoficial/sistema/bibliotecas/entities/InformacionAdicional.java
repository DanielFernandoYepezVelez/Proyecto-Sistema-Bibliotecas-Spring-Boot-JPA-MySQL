package com.nexappoficial.sistema.bibliotecas.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "informaciones_adicionales", schema = "generico")
@Setter
@Getter
@EqualsAndHashCode
public class InformacionAdicional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_adicional")
    private Long id;

    private String idioma;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_libro")
    private Libro libro;

    public InformacionAdicional() {
        // TODO document why this constructor is empty
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
