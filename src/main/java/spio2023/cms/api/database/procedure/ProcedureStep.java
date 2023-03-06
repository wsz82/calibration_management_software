package spio2023.cms.api.database.procedure;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.ControlPoint;
import spio2023.cms.model.procedure.step.DisplayStep;
import spio2023.cms.model.procedure.step.InputsStep;
import spio2023.cms.model.procedure.step.Step;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ProcedureStep implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private String message;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ControlPoint controlPoint;

    public ProcedureStep(Step input) {
        this.type = input.getStepType().name();
        if (input instanceof DisplayStep concreteInput) {
            this.message = concreteInput.getMessage();
        } else if (input instanceof InputsStep concreteInput) {
            this.message = concreteInput.getMessage();
            this.controlPoint = new ControlPoint(concreteInput.getControlPoint());
        }
    }

}
