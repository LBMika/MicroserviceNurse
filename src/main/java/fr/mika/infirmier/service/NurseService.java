package fr.mika.infirmier.service;

import fr.mika.infirmier.dto.PatientDTO;
import fr.mika.infirmier.entity.Nurse;
import fr.mika.infirmier.repository.NurseRepository;
import fr.mika.infirmier.repository.WebPatientRepository;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


public class NurseService {
    private ModelMapper mapper;
    private NurseRepository repository;
    private WebPatientRepository patienRepository;

    public NurseService(NurseRepository repository, WebPatientRepository patienRepository, ModelMapper mapper) {
        this.repository = repository;
        this.patienRepository = patienRepository;
        this.mapper = mapper;
    }

    public List<Nurse> findAll() {
        return this.repository.findAll();
    }

    public Nurse findById(String id) {
        // Get the nurse
        Nurse nurse = this.repository.findById(id).orElse(null);
        if (nurse!=null) {
            Flux<PatientDTO> patients = this.patienRepository.findAll(nurse.getId());
            // patients.flatMap(patientDTO -> nurse.addPatient(patientDTO));
            Mono<List<PatientDTO>> monoPatients = patients.collectList();
            nurse.setPatients(monoPatients.block());
            /*
            List<PatientDTO> patientsDTOList = monoPatients.block();
            for (PatientDTO p : patientsDTOList)
                nurse.addPatient(p);

             */
        }
        return nurse;
       //  return this.repository.findById(id).orElse(null);
    }

    public Nurse save(Nurse nurse) {
        return this.repository.save(nurse);
    }

    public Nurse update(Nurse nurse) {
        return this.repository.save(nurse);
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
    }
}
