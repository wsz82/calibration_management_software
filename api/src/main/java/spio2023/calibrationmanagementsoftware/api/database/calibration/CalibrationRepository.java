package spio2023.calibrationmanagementsoftware.api.database.calibration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalibrationRepository extends JpaRepository<Calibration, Long> {
}