package fr.mika.infirmier.repository;

import fr.mika.infirmier.entity.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Nurse, String> {
}
