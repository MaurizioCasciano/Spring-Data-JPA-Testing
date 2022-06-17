package org.testing.spring.data.jpa.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
public class Container {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Item> items;
}
