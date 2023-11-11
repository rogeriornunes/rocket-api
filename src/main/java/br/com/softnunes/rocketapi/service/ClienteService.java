package br.com.softnunes.rocketapi.service;

import br.com.softnunes.rocketapi.dto.ClienteDto;
import br.com.softnunes.rocketapi.exception.UsuarioCadastradoException;
import br.com.softnunes.rocketapi.model.Cliente;
import br.com.softnunes.rocketapi.model.Municipio;
import br.com.softnunes.rocketapi.repository.ClienteRepository;
import br.com.softnunes.rocketapi.repository.MunicipioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Cliente salvar(ClienteDto clienteDto) {
        Cliente cliente = convertToEntity(clienteDto);
        validarCadastro(cliente);
        Municipio municipio = municipioRepository.save(getMunicipio(clienteDto));
        cliente.setMunicipio(municipio);
        return clienteRepository.save(cliente);
    }

    private void validarCadastro(Cliente cliente) {
        if(cliente.getId() != null){
            boolean exists = clienteRepository.existsById(cliente.getId());
            if (exists) {
                throw new UsuarioCadastradoException(cliente.getNome());
            }
        }
    }

    private Municipio getMunicipio(ClienteDto clienteDto){
        Municipio municipio = new Municipio();
        municipio.setCidade(clienteDto.getCidade());
        municipio.setEstado(clienteDto.getEstado());
       return municipio;
    }

    private Cliente convertToEntity(ClienteDto clienteDto) throws ParseException {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        return cliente;
    }
}
