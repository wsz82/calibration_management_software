package spio2023.cms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spio2023.cms.api.database.results.Inputs;

public interface InputsRepository extends JpaRepository<Inputs, Long> {
}