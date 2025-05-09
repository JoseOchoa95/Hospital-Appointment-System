package com.kosmos.consultorio.init;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.ConsultorioEntity;
import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.DoctorEntity;
import com.kosmos.consultorio.infrastructure.adpter.persistence.repositories.ConsultorioRepository;
import com.kosmos.consultorio.infrastructure.adpter.persistence.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DoctorRepository doctorRepository, ConsultorioRepository consultorioRepository) {
        return args -> {

            DoctorEntity jose = new DoctorEntity(
                    "Jose",
                    "Ochoa",
                    "Jarquin",
                    "Variatria"
            );

            DoctorEntity pedro = new DoctorEntity(
                    "Pedro",
                    "Carrasco",
                    "Alfaro",
                    "Cirujia"
            );

            DoctorEntity sara = new DoctorEntity(
                    "Alan",
                    "Antonio",
                    "Cruz",
                    "Nutricion"
            );

            for (DoctorEntity doctor : Arrays.asList(jose, pedro, sara)) {
                doctorRepository.save(doctor);
            }

            ConsultorioEntity consultorio1 = new ConsultorioEntity(
                    1,
                    1
            );

            ConsultorioEntity consultorio2 = new ConsultorioEntity(
                    2,
                    1
            );

            ConsultorioEntity consultorio3 = new ConsultorioEntity(
                    3,
                    1
            );

            for (ConsultorioEntity consultorio : Arrays.asList(consultorio1, consultorio2, consultorio3)) {
                consultorioRepository.save(consultorio);
            }
        };
    }

}
