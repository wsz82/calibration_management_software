package spio2023.cms.api.database.device;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.procedure.ProcedureData;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class TestDevice implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String model;

    @OneToOne(mappedBy = "testDevice")
    private ProcedureData procedureData;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeasurementTypeToTestScopes> measurementTypeToTestScopes;

    public TestDevice(spio2023.cms.model.device.TestDevice model) {
        this.model = model.getModel();
        this.measurementTypeToTestScopes = model.getScopes().entrySet().stream()
                .map(MeasurementTypeToTestScopes::new)
                .collect(Collectors.toList());
    }

}
