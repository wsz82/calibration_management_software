package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.database.calibration.ControlPointToInputsWithResults;

public interface ControlPointToInputsWithResultsRepository extends JpaRepository<ControlPointToInputsWithResults, Long> {
}
