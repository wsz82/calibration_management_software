package spio2023.cms.database.device;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import spio2023.cms.database.BaseEntity;
import spio2023.cms.database.unit.MeasurementType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class MeasurementTypeToTestScopes extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private MeasurementType measurementType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestScope> scopes;

    public MeasurementTypeToTestScopes(Map.Entry<spio2023.cms.model.unit.MeasurementType, List<spio2023.cms.model.device.TestScope>> model) {
        this.measurementType = new MeasurementType(model.getKey());
        this.scopes = model.getValue().stream()
                .map(TestScope::new)
                .collect(Collectors.toList());
    }

}
