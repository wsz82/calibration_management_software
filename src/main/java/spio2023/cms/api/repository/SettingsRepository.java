package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.procedure.ProcedureSettings;

public interface SettingsRepository extends JpaRepository<ProcedureSettings, Long> {
}
