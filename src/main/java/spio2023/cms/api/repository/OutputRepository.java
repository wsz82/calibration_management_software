package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.results.Output;

public interface OutputRepository extends JpaRepository<Output, Long> {
}
