package spio2023.cms.api.database.device;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.MeasurementType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class MeasurementTypeToTestScopes implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MeasurementType measurementType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestScope> scopes;

    public MeasurementTypeToTestScopes(Map.Entry<spio2023.cms.model.unit.MeasurementType, List<spio2023.cms.model.device.TestScope>> model) {
        this.measurementType = new MeasurementType(model.getKey());
        this.scopes = model.getValue().stream()
                .map(TestScope::new)
                .collect(Collectors.toList());
    }

}
