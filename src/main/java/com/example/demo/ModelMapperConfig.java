package com.example.demo;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        addPropertiesType(modelMapper);
        return modelMapper;
    }

    private void addPropertiesType(ModelMapper modelMapper){
        Converter<Collection<PersonAddress>, List<Address>> personListConverter = context -> context.getSource().stream().map(PersonAddress::getAddress).collect(Collectors.toList());
        modelMapper.typeMap(Person.class, PersonDTO.class)
                .addMappings(mapping -> {
                    mapping.skip(Person::getName, PersonDTO::setName);
                    mapping.using(personListConverter).map(Person::getPersonAddresses, PersonDTO::setAddressDTOS);
                });
    }
}
