package fr.mika.infirmier.configuration;

import fr.mika.infirmier.repository.NurseRepository;
import fr.mika.infirmier.repository.WebPatientRepository;
import fr.mika.infirmier.service.NurseService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurseConfiguration {
    @Bean
    public NurseService nurseService(NurseRepository repository, WebPatientRepository patienRepository, ModelMapper mapper) {
        return new NurseService(repository, patienRepository, mapper);
    }
}
