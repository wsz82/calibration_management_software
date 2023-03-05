package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.calibration.Calibration;

public interface CalibrationRepository extends JpaRepository<Calibration, Long> {
}
