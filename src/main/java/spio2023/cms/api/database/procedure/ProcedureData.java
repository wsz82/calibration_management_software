package spio2023.cms.api.database.procedure;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.device.TestDevice;
import spio2023.cms.api.database.instrument.ReferenceInstrument;
import spio2023.cms.model.procedure.Procedure;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ProcedureData implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TestDevice testDevice;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ReferenceInstrument referenceInstrument;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ProcedureSettings procedureSettings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProcedureStep> procedureSteps;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeasurementTypeToControlPoints> measurementTypeToControlPoints;


    public ProcedureData(String name, Procedure input) {
        this.name = name;
        this.testDevice = new TestDevice(input.getTestDevice());
        this.referenceInstrument = new ReferenceInstrument(input.getReferenceInstrument());
        this.procedureSettings = new ProcedureSettings(input.getSettings());
        this.procedureSteps = input.getSteps().stream()
                .map(ProcedureStep::new)
                .collect(Collectors.toList());
        this.measurementTypeToControlPoints = input.getControlPoints().entrySet().stream()
                .map(MeasurementTypeToControlPoints::new)
                .collect(Collectors.toList());
    }

}
