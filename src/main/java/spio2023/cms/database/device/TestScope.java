package spio2023.cms.database.device;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import spio2023.cms.database.BaseEntity;
import spio2023.cms.database.unit.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class TestScope extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Scope> scopes;

    private double accuracy;

    private int resolutionExponent;

    public TestScope(spio2023.cms.model.device.TestScope model) {
        this.scopes = Arrays.stream(model.getScopes())
                .map(Scope::new)
                .collect(Collectors.toList());
    }

}
