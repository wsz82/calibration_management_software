package spio2023.cms.api.database.results;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.ControlPoint;
import spio2023.cms.model.unit.Prefix;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Results implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ControlPoint controlPoint;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Inputs inputs;

    private Prefix prefix;

    private double meanReferenceValue;

    private double meanTestValue;

    private double error;

    private double uncertaintyA;

    private double uncertaintyB;

    private double uncertaintyC;

    private double uncertainty;

    private double lowerBoundary;

    private double upperBoundary;

    private boolean pass;

    public Results(ControlPoint controlPoint, spio2023.cms.model.procedure.results.Results model) {
        this.controlPoint = controlPoint;
        this.inputs = new Inputs(model.getInputs());
        this.prefix = model.getPrefix();
        this.meanReferenceValue = model.getMeanReferenceValue();
        this.meanTestValue = model.getMeanTestValue();
        this.error = model.getError();
        this.uncertaintyA = model.getUncertaintyA();
        this.uncertaintyB = model.getUncertaintyB();
        this.uncertaintyC = model.getUncertaintyC();
        this.uncertainty = model.getUncertainty();
        this.lowerBoundary = model.getLowerBoundary();
        this.upperBoundary = model.getUpperBoundary();
        this.pass = model.isPass();
    }

}
