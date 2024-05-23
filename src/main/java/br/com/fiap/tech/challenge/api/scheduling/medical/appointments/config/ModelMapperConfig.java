package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(List<TypeMapConfiguration> config) {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        config.forEach(conf -> conf.configure(mapper));

        return mapper;
    }
}
