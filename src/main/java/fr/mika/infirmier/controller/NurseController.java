package fr.mika.infirmier.controller;

import fr.mika.infirmier.entity.Nurse;
import fr.mika.infirmier.service.NurseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/nurses")
public class NurseController {
    private ModelMapper mapper;
    private NurseService service;

    public NurseController(NurseService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Nurse> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> findById(@PathVariable String id) {
        ResponseEntity result;
        Nurse nurse = this.service.findById(id);
        if (nurse==null)
            result = ResponseEntity.notFound().build();
        else
            result = ResponseEntity.ok(nurse);
        return result;
    }

    @PostMapping
    public ResponseEntity<Nurse> save(@RequestBody Nurse nurse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(nurse));
    }

    @PutMapping
    public ResponseEntity<Nurse> updateById(@RequestBody Nurse nurse) {
        return ResponseEntity.ok(this.service.update(nurse));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody Nurse nurse) {
        this.service.deleteById(nurse.getId());
        return ResponseEntity.ok(true);
    }
}
