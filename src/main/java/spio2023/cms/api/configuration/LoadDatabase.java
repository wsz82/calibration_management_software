package spio2023.cms.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spio2023.cms.api.database.procedure.ProcedureData;
import spio2023.cms.api.repository.ProcedureRepository;
import spio2023.cms.model.sample.SampleData_BC06;
import spio2023.cms.model.sample.SampleData_PP_METEX_3610;

@Configuration
@Profile({"dev", "default"})
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProcedureRepository repository) {
        repository.deleteAll();
        return args -> {
            log.info("Preloading " + repository.save(new ProcedureData("BC06", SampleData_BC06.procedure())));
            log.info("Preloading " + repository.save(new ProcedureData("PP METEX3610", SampleData_PP_METEX_3610.procedure())));
        };
    }

}
