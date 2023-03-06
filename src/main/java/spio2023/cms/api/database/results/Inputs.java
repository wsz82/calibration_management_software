package spio2023.cms.api.database.results;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Inputs implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoubleValue> referenceDoubleValues;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoubleValue> testDoubleValues;

    public Inputs(spio2023.cms.model.procedure.results.Inputs model) {
        this.referenceDoubleValues = model.getReferenceValues().stream()
                .map(DoubleValue::new)
                .collect(Collectors.toList());
        this.testDoubleValues = model.getTestValues().stream()
                .map(DoubleValue::new)
                .collect(Collectors.toList());
    }

}
