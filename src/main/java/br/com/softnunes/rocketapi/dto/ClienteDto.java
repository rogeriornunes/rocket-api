package br.com.softnunes.rocketapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClienteDto {

    @NotEmpty(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotEmpty(message = "O campo Nome é obrigatório.")
    private String sobrenome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo CPF é obrigatório.")
    @CPF(message = "O campo CPF é invalido.")
    private String cpf;

    @NotEmpty(message = "O campo Nome Mãe é obrigatório.")
    private String nomeMae;

    @NotEmpty(message = "O campo Sobrenome Mãe é obrigatório.")
    private String sobrenomeMae;

    @NotEmpty(message = "O campo Cidade é obrigatório.")
    private String cidade;

    @NotEmpty(message = "O campo Estado é obrigatório.")
    private String estado;

    @NotEmpty(message = "O campo Usuário é obrigatório.")
    private String username;

    @NotEmpty(message = "O campo Senha é obrigatório.")
    private String password;

   /* @NotEmpty(message = "O campo Cidade é obrigatório.")
    private String cidade;

    @NotEmpty(message = "O campo Estado é obrigatório.")
    private String estado;

    @NotEmpty(message = "O campo Usuário é obrigatório.")
    private String usuario;

    @NotEmpty(message = "O campo Senha é obrigatório.")
    private String senha;*/
}

