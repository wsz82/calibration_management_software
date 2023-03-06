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
public class ControlPoint implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parameter> parameters;

    public ControlPoint(spio2023.cms.model.unit.ControlPoint model) {
        this.parameters = Arrays.stream(model.getParameters())
                .map(Parameter::new)
                .collect(Collectors.toList()
        );
    }

}
