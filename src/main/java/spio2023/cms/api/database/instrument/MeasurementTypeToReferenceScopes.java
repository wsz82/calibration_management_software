package spio2023.cms.api.database.instrument;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class MeasurementTypeToReferenceScopes extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private MeasurementType measurementType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReferenceScope> scopes;

    public MeasurementTypeToReferenceScopes(Map.Entry<spio2023.cms.model.unit.MeasurementType, List<spio2023.cms.model.instrument.ReferenceScope>> model) {
        this.measurementType = new MeasurementType(model.getKey());
        this.scopes = model.getValue().stream()
                .map(ReferenceScope::new)
                .collect(Collectors.toList());
    }

}
