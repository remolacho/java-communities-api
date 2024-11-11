package com.communities.domain.dao;

import com.communities.domain.entities.Tenant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITenant extends CrudRepository<Tenant, Long> {
    Optional<Tenant> findBySubdomain(String subdomain);
}
