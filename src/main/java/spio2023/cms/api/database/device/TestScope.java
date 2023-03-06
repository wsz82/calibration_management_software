package spio2023.cms.api.database.device;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class TestScope implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scope> scopes;

    private double accuracy;

    private int resolutionExponent;

    public TestScope(spio2023.cms.model.device.TestScope model) {
        this.scopes = Arrays.stream(model.getScopes())
                .map(Scope::new)
                .collect(Collectors.toList());
    }

}
