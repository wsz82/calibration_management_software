package spio2023.cms.api.database.instrument;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ReferenceInstrument implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String model;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeasurementTypeToReferenceScopes> measurementTypeToReferenceScopes;

    public ReferenceInstrument(spio2023.cms.model.instrument.ReferenceInstrument model) {
        this.model = model.getModel();
        this.measurementTypeToReferenceScopes = model.getScopes().entrySet().stream()
                .map(MeasurementTypeToReferenceScopes::new)
                .collect(Collectors.toList());
    }

}
