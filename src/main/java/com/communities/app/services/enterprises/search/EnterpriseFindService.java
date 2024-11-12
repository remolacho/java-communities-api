package com.communities.app.services.enterprises.search;

import com.communities.app.exceptions.RecordNotFoundException;
import com.communities.app.exceptions.TenantElementException;
import com.communities.domain.dao.IEnterprise;
import com.communities.domain.entities.Enterprise;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
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
        try {
            return enterprise.findBySubdomain(subdomain);
        }catch (InvalidDataAccessResourceUsageException e) {
            throw new TenantElementException("The subdomain is not valid: " + subdomain);
        }
    }

    @Override
    public Enterprise findById(Long id) {
        try {
            return enterprise.findById(id).orElseThrow(() ->new RecordNotFoundException("The enterprise not found"));
        }catch (InvalidDataAccessResourceUsageException e) {
            throw new TenantElementException("The subdomain is not valid");
        }
    }
}
