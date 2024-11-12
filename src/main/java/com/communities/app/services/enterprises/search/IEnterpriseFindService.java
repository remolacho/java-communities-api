package com.communities.app.services.enterprises.search;

import com.communities.app.exceptions.TenantElementException;
import com.communities.domain.entities.Enterprise;

import java.util.Optional;

public interface IEnterpriseFindService {
    public Optional<Enterprise> findBySubdomain(String subdomain) throws TenantElementException;
    public Enterprise findById(Long id) throws TenantElementException;
}
