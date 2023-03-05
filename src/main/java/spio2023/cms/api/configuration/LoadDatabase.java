package spio2023.cms.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spio2023.cms.api.database.device.TestDevice;
import spio2023.cms.api.database.instrument.ReferenceInstrument;
import spio2023.cms.api.database.procedure.ProcedureData;
import spio2023.cms.api.repository.DeviceRepository;
import spio2023.cms.api.repository.InstrumentRepository;
import spio2023.cms.model.sample.SampleData_BC06;
import spio2023.cms.model.sample.SampleData_PP_METEX_3610;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DeviceRepository deviceRepository, InstrumentRepository instrumentRepository) {
        return args -> {
            log.info("Preloading " + instrumentRepository.save(new ReferenceInstrument(SampleData_BC06.thermometer_P755())));
            log.info("Preloading " + deviceRepository.save(new TestDevice(SampleData_BC06.thermometer_BC06(), new ProcedureData("BC06", SampleData_BC06.procedure()))));
            log.info("Preloading " + instrumentRepository.save(new ReferenceInstrument(SampleData_PP_METEX_3610.multimeter_INMEL7000())));
            log.info("Preloading " + deviceRepository.save(new TestDevice(SampleData_PP_METEX_3610.multimeter_PP_METEX_3610(), new ProcedureData("PP METEX3610", SampleData_PP_METEX_3610.procedure()))));
        };
    }

}
