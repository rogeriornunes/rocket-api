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
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{campo.arquivo.obrigatorio}")
    @Column(nullable = false, length = 100)
    private byte[] arquivo;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    @Column(nullable = false, length = 100)
    private String nome;
}
