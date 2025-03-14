package com.nazax.backendljvt.config.seeder;

import com.nazax.backendljvt.entity.Estado;
import com.nazax.backendljvt.repository.EstadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StateSeeder implements CommandLineRunner {

    private final EstadoRepository estadoRepository;

    public StateSeeder(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) {
        if (estadoRepository.count() == 0) {
            List<Estado> estados = List.of(
                    new Estado("Acre", "AC"),
                    new Estado("Alagoas", "AL"),
                    new Estado("Amapá", "AP"),
                    new Estado("Amazonas", "AM"),
                    new Estado("Bahia", "BA"),
                    new Estado("Ceará", "CE"),
                    new Estado("Distrito Federal", "DF"),
                    new Estado("Espírito Santo", "ES"),
                    new Estado("Goiás", "GO"),
                    new Estado("Maranhão", "MA"),
                    new Estado("Mato Grosso", "MT"),
                    new Estado("Mato Grosso do Sul", "MS"),
                    new Estado("Minas Gerais", "MG"),
                    new Estado("Pará", "PA"),
                    new Estado("Paraíba", "PB"),
                    new Estado("Paraná", "PR"),
                    new Estado("Pernambuco", "PE"),
                    new Estado("Piauí", "PI"),
                    new Estado("Rio de Janeiro", "RJ"),
                    new Estado("Rio Grande do Norte", "RN"),
                    new Estado("Rio Grande do Sul", "RS"),
                    new Estado("Rondônia", "RO"),
                    new Estado("Roraima", "RR"),
                    new Estado("Santa Catarina", "SC"),
                    new Estado("São Paulo", "SP"),
                    new Estado("Sergipe", "SE"),
                    new Estado("Tocantins", "TO")
            );

            estadoRepository.saveAll(estados);
            System.out.println("Estados inseridos no banco!");
        } else {
            System.out.println("Estados já existem no banco!");
        }
    }

}
