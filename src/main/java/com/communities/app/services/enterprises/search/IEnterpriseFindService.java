package com.communities.app.services.enterprises.search;

import com.communities.domain.entities.Enterprise;

import java.util.Optional;

public interface IEnterpriseFindService {
    public Optional<Enterprise> findBySubdomain(String subdomain);
}
