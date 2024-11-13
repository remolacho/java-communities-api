package com.communities.app.services.enterprises.search;

import com.communities.domain.entities.Enterprise;

public interface IEnterpriseFindService {
    public Enterprise findBySubdomain(String subdomain);
    public Enterprise findById(Long id);
}
