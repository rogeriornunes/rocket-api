package br.com.softnunes.rocketapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String cidade;

    @NotEmpty(message = "{campo.estado.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String estado;
}
