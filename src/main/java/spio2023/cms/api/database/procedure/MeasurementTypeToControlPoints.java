package spio2023.cms.api.database.procedure;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.ControlPoint;
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
public class MeasurementTypeToControlPoints implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MeasurementType measurementType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ControlPoint> controlPoints;

    public MeasurementTypeToControlPoints(Map.Entry<spio2023.cms.model.unit.MeasurementType, List<spio2023.cms.model.unit.ControlPoint>> entry) {
        this.measurementType = new MeasurementType(entry.getKey());
        this.controlPoints = entry.getValue().stream()
                .map(ControlPoint::new)
                .collect(Collectors.toList());
    }

}
