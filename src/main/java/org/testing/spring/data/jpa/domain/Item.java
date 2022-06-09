package org.testing.spring.data.jpa.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Item {
    @Id
    private UUID id;

    @ManyToOne(optional = false)
    private Container container;
}
