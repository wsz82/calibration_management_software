package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.device.TestDevice;

public interface DeviceRepository extends JpaRepository<TestDevice, Long> {
}
