package spio2023.cms.api.database.instrument;

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
public class MeasurementTypeToReferenceScopes implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MeasurementType measurementType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferenceScope> scopes;

    public MeasurementTypeToReferenceScopes(Map.Entry<spio2023.cms.model.unit.MeasurementType, List<spio2023.cms.model.instrument.ReferenceScope>> model) {
        this.measurementType = new MeasurementType(model.getKey());
        this.scopes = model.getValue().stream()
                .map(ReferenceScope::new)
                .collect(Collectors.toList());
    }

}
