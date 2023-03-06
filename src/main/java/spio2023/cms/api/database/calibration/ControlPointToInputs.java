package spio2023.cms.api.database.calibration;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.results.Inputs;
import spio2023.cms.api.database.unit.ControlPoint;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ControlPointToInputs implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ControlPoint controlPoint;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Inputs inputs;

}
