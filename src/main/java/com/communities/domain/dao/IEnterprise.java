package com.communities.domain.dao;

import com.communities.domain.entities.Enterprise;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IEnterprise extends CrudRepository<Enterprise, Long> {
    Optional<Enterprise> findBySubdomain(String subdomain);
}
