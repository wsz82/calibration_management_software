package spio2023.cms.api.database.procedure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ProcedureSettings implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private int measurementSeries;

    private boolean referenceValuesFromControlPoint;

    public ProcedureSettings(spio2023.cms.model.procedure.Settings model) {
        this.measurementSeries = model.getMeasurementSeries();
        this.referenceValuesFromControlPoint = model.isReferenceValuesFromControlPoint();
    }

}
