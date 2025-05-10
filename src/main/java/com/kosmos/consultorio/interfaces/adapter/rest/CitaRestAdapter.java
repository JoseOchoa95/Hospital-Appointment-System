package com.kosmos.consultorio.interfaces.adapter.rest;

import com.kosmos.consultorio.application.port.input.CreateCitaUseCase;
import com.kosmos.consultorio.application.port.input.GetCitaUseCase;
import com.kosmos.consultorio.application.port.input.UpdateCitaUseCase;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaRestAdapter {

    private final CreateCitaUseCase createCitaUseCase;
    private final UpdateCitaUseCase updateCitaUseCase;

    public CitaRestAdapter(CreateCitaUseCase createCitaUseCase, UpdateCitaUseCase updateCitaUseCase) {
        this.createCitaUseCase = createCitaUseCase;
        this.updateCitaUseCase = updateCitaUseCase;
    }

    @PutMapping("/nueva")
    public ResponseEntity<Integer> createCita(
            @RequestBody CitaRequest cita
    ) {
        return ResponseEntity.ok(createCitaUseCase.createCita(cita));
    }

    @PatchMapping("/{idCita}/actualizar")
    public ResponseEntity<Void> updateCita(
            @PathVariable Integer idCita,
            @RequestBody CitaRequest cita
    ){
        updateCitaUseCase.updateCita(idCita, cita);
        return ResponseEntity.ok().build();
    }
}
