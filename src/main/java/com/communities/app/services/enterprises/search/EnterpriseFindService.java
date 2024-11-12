package com.communities.app.services.enterprises.search;

import com.communities.domain.dao.IEnterprise;
import com.communities.domain.entities.Enterprise;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnterpriseFindService implements IEnterpriseFindService {
    public final IEnterprise enterprise;

    public EnterpriseFindService(IEnterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public Optional<Enterprise> findBySubdomain(String subdomain) {
        return enterprise.findBySubdomain(subdomain);
    }
}
