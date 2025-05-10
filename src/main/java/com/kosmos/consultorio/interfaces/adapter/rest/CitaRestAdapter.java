package com.kosmos.consultorio.interfaces.adapter.rest;

import com.kosmos.consultorio.application.port.input.CreateCitaUseCase;
import com.kosmos.consultorio.application.port.input.DeleteCitaUseCase;
import com.kosmos.consultorio.application.port.input.GetCitaUseCase;
import com.kosmos.consultorio.application.port.input.UpdateCitaUseCase;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/cita")
public class CitaRestAdapter {

    private final CreateCitaUseCase createCitaUseCase;
    private final UpdateCitaUseCase updateCitaUseCase;
    private final DeleteCitaUseCase deleteCitaUseCase;
    private final GetCitaUseCase getCitaUseCase;

    public CitaRestAdapter(CreateCitaUseCase createCitaUseCase, UpdateCitaUseCase updateCitaUseCase, DeleteCitaUseCase deleteCitaUseCase, GetCitaUseCase getCitaUseCase) {
        this.createCitaUseCase = createCitaUseCase;
        this.updateCitaUseCase = updateCitaUseCase;
        this.deleteCitaUseCase = deleteCitaUseCase;
        this.getCitaUseCase = getCitaUseCase;
    }

    @PutMapping("/nueva")
    public ResponseEntity<Integer> createCita(
            @RequestBody CitaRequest cita
    ) {
        return ResponseEntity.ok(createCitaUseCase.createCita(cita));
    }

    @PatchMapping("/{idCita}")
    public ResponseEntity<Void> updateCita(
            @PathVariable Integer idCita,
            @RequestBody CitaRequest cita
    ){
        updateCitaUseCase.updateCita(idCita, cita);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCita}")
    public ResponseEntity<Void> deleteCita(
            @PathVariable Integer idCita
    ){
        deleteCitaUseCase.deleteCita(idCita);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Void> getCita(
            @RequestParam Integer idDoctor,
            @RequestParam Integer idConsultorio,
            @RequestParam LocalDate fecha,
            @RequestParam LocalTime hora
    ){
        getCitaUseCase.getCita(idDoctor, idConsultorio, fecha, hora);
        return ResponseEntity.ok().build();
    }
}
