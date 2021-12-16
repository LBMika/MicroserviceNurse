package fr.mika.infirmier.repository;

import fr.mika.infirmier.dto.PatientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
public class WebPatientRepository {
    private WebClient webClient;

    public WebPatientRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<PatientDTO> findAll(String id) {
        Flux<PatientDTO> patients = this.webClient.get()
                .uri("/patients/nurse/"+id)
                .retrieve()
                .bodyToFlux(PatientDTO.class);
        return patients;
    }
}
