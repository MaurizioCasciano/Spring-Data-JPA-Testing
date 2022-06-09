package org.testing.spring.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testing.spring.data.jpa.domain.Container;
import org.testing.spring.data.jpa.domain.Item;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@SpringBootTest
public class ContainerRepositoryTests {
    @Autowired
    private ContainerRepository containerRepository;

    @Test
    public void testSaveContainer(){
        final UUID containerID = UUID.randomUUID();

        Container container = new Container();
        container.setId(containerID);

        Collection<Item> items = new HashSet<>();

        final UUID itemID = UUID.randomUUID();

        Item item = new Item();
        item.setId(itemID);
        item.setContainer(container);

        items.add(item);

        container.setItems(items);

        this.containerRepository.save(container);

        this.containerRepository.save(container);
    }
}
