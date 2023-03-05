package spio2023.cms.api.database.calibration;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.procedure.ProcedureData;

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

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<ControlPointToInputsWithResults> controlPointToInputsWithResults;

}
