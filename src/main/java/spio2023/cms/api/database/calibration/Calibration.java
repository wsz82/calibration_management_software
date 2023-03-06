package spio2023.cms.api.database.calibration;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.procedure.ProcedureData;
import spio2023.cms.api.database.results.Output;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Calibration implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    private ProcedureData procedureData;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ControlPointToInputs> controlPointToInputs = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Output output;

}
