package fr.mika.infirmier.entity;

import fr.mika.infirmier.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Nurse {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String proPhone;
    private String homePhone;
    private Address address;
    List<PatientDTO> patients = new ArrayList<>();

    public void addPatient(PatientDTO patientDTO) {
        this.patients.add(patientDTO);
    }
}
