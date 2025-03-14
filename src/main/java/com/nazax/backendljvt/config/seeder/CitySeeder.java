package com.nazax.backendljvt.config.seeder;

import com.nazax.backendljvt.entity.Cidade;
import com.nazax.backendljvt.entity.Estado;
import com.nazax.backendljvt.repository.CidadeRepository;
import com.nazax.backendljvt.repository.EstadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CitySeeder implements CommandLineRunner {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public CitySeeder(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) {
        if (cidadeRepository.count() == 0) { // Verifica se já existem cidades no banco
            Map<Long, List<String>> cidadesPorEstado = new HashMap<>();

            // Associa IDs dos estados às suas respectivas cidades
            cidadesPorEstado.put(11L, List.of("Cuiabá", "Várzea Grande", "Rondonópolis"));
            cidadesPorEstado.put(12L, List.of("Campo Grande", "Dourados", "Três Lagoas"));
            cidadesPorEstado.put(13L, List.of("Belo Horizonte", "Uberlândia", "Juiz de Fora"));
            cidadesPorEstado.put(14L, List.of("Belém", "Ananindeua", "Marabá"));
            cidadesPorEstado.put(15L, List.of("João Pessoa", "Campina Grande", "Santa Rita"));
            cidadesPorEstado.put(16L, List.of("Curitiba", "Londrina", "Maringá"));
            cidadesPorEstado.put(17L, List.of("Recife", "Jaboatão dos Guararapes", "Olinda"));
            cidadesPorEstado.put(18L, List.of("Palmas", "Gurupi", "Araguaína"));
            cidadesPorEstado.put(19L, List.of("Rio de Janeiro", "Niterói", "Campos dos Goytacazes"));
            cidadesPorEstado.put(20L, List.of("Natal", "Mossoró", "Parnamirim"));
            cidadesPorEstado.put(21L, List.of("Porto Alegre", "Caxias do Sul", "Pelotas"));
            cidadesPorEstado.put(22L, List.of("Porto Velho", "Ji-Paraná", "Ariquemes"));
            cidadesPorEstado.put(23L, List.of("Boa Vista", "Rorainópolis", "Caracaraí"));
            cidadesPorEstado.put(24L, List.of("Florianópolis", "Joinville", "Criciúma"));
            cidadesPorEstado.put(25L, List.of("São Paulo", "Campinas", "Santos"));
            cidadesPorEstado.put(26L, List.of("Aracaju", "Lagarto", "Itabaiana"));
            cidadesPorEstado.put(27L, List.of("Palmas", "Gurupi", "Araguaína"));

            for (Map.Entry<Long, List<String>> entry : cidadesPorEstado.entrySet()) {
                Long estadoId = entry.getKey();
                Optional<Estado> estadoOpt = estadoRepository.findById(estadoId);

                if (estadoOpt.isPresent()) {
                    Estado estado = estadoOpt.get();
                    List<Cidade> cidadesParaSalvar = new ArrayList<>();

                    for (String nomeCidade : entry.getValue()) {
                        cidadesParaSalvar.add(new Cidade(nomeCidade, estado));
                    }

                    cidadeRepository.saveAll(cidadesParaSalvar);
                    System.out.println("Cidades do estado " + estado.getNome() + " inseridas!");
                } else {
                    System.out.println("⚠ Estado com ID " + estadoId + " não encontrado!");
                }
            }
        } else {
            System.out.println("Cidades já existem no banco!");
        }
    }
}
