package spio2023.cms.database.calibration;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.database.BaseEntity;
import spio2023.cms.database.procedure.ProcedureData;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Calibration extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private ProcedureData procedureData;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ControlPointToInputsWithResults> controlPointToInputsWithResults;

}
