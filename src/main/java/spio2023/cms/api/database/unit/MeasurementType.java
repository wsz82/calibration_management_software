package spio2023.cms.api.database.unit;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class MeasurementType implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String symbol;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unit> units;

    public MeasurementType(spio2023.cms.model.unit.MeasurementType model) {
        this.name = model.getName();
        this.symbol = model.getSymbol();
        this.units = Arrays.stream(model.getUnits())
                .map(Unit::new)
                .collect(Collectors.toList());
    }
}
