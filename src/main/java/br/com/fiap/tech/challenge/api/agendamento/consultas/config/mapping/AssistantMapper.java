package br.com.fiap.tech.challenge.api.agendamento.consultas.config.mapping;

import br.com.fiap.tech.challenge.api.agendamento.consultas.config.TypeMapConfiguration;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.AssistantRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Assistant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AssistantMapper implements TypeMapConfiguration {

    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.typeMap(AssistantRequest.class, Assistant.class)
                .addMapping(AssistantRequest::getUser, Assistant::setUser)
                .addMapping(AssistantRequest::getAddress, Assistant::setAddress);
    }
}
