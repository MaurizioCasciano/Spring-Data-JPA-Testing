package org.testing.spring.data.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
public class Container {
    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Item> items;
}
