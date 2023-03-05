package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.instrument.ReferenceInstrument;

public interface InstrumentRepository extends JpaRepository<ReferenceInstrument, Long> {
}
