package com.communities.app.services.enterprises.search;

import com.communities.app.exceptions.RecordNotFoundException;
import com.communities.domain.dao.IEnterprise;
import com.communities.domain.entities.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseFindService implements IEnterpriseFindService {
    public final IEnterprise enterprise;

    public EnterpriseFindService(IEnterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public Enterprise findBySubdomain(String subdomain){
        return enterprise.findBySubdomain(subdomain)
                .orElseThrow(() ->new RecordNotFoundException("The enterprise not found"));
    }

    @Override
    public Enterprise findById(Long id) {
        return enterprise.findById(id).orElseThrow(() ->new RecordNotFoundException("The enterprise not found"));
    }
}
