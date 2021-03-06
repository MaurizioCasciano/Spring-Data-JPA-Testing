package org.testing.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.testing.spring.data.jpa.domain.Container;

import java.util.UUID;

@Repository
public interface ContainerRepository extends JpaRepository<Container, UUID> {
}
