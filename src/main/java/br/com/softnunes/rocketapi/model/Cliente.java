package br.com.softnunes.rocketapi.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	@Column(nullable = false, length = 150)
	private String nome;

	@NotEmpty(message = "{campo.sobrenome.obrigatorio}")
	@Column(nullable = false, length = 150)
	private String sobrenome;

	@Column(name = "data_nascimento", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotNull(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	@Column(nullable = false, length = 11)
	private String cpf;


	@NotEmpty(message = "{campo.nomeMae.obrigatorio}")
	@Column(nullable = false, length = 150)
	private String nomeMae;

	@NotEmpty(message = "{campo.sobrenomeMae.obrigatorio}")
	@Column(nullable = false, length = 150)
	private String sobrenomeMae;
	
	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private List<Documento> documentos;

	@PrePersist
	public void prePrersist() {
		setDataCadastro(LocalDate.now());
	}
}
