package com.communities.app.services.enterprises.search;

import com.communities.app.exceptions.RecordNotFoundException;
import com.communities.domain.dao.IActiveStorageAttachment;
import com.communities.domain.dao.IEnterprise;
import com.communities.domain.entities.Enterprise;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnterpriseFindService implements IEnterpriseFindService {
    public final IEnterprise enterprise;
    public final IActiveStorageAttachment attachment;

    public EnterpriseFindService(IEnterprise enterprise, IActiveStorageAttachment attachment) {
        this.enterprise = enterprise;
        this.attachment = attachment;
    }

    @Override
    @Transactional(readOnly = true)
    public Enterprise findBySubdomain(String subdomain){
        return enterprise.findBySubdomain(subdomain)
                .orElseThrow(() ->new RecordNotFoundException("The enterprise not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Enterprise findById(Long id) {
        return enterprise.findById(id).orElseThrow(() ->new RecordNotFoundException("The enterprise not found"));
    }
}
