package fr.mika.infirmier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private Long socialNumber;
}
