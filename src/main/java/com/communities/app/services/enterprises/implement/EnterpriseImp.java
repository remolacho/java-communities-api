package com.communities.app.services.enterprises.implement;

import com.communities.app.services.enterprises.search.IEnterpriseFindService;
import com.communities.domain.entities.Enterprise;
import com.communities.app.services.attachable.ActiveStorage;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseImp {
    private final IEnterpriseFindService enterpriseFindService;
    private final ActiveStorage activeStorage;

    public EnterpriseImp(IEnterpriseFindService enterpriseFindService,
                         ActiveStorage activeStorage) {

        this.enterpriseFindService = enterpriseFindService;
        this.activeStorage = activeStorage;
    }

    public Enterprise getEnterprise(String subdomain){
        return assignEnterpriseUrls(enterpriseFindService.findBySubdomain(subdomain));
    }

    public Enterprise getEnterprise(Long id){
        return assignEnterpriseUrls(enterpriseFindService.findById(id));
    }

    private Enterprise assignEnterpriseUrls(Enterprise enterprise){
        enterprise.setLogoUrl(resourceUrl(enterprise.getId(), "logo"));
        enterprise.setBannerUrl(resourceUrl(enterprise.getId(), "banner"));
        return enterprise;
    }

    private String resourceUrl(long id, String resource) {
        return activeStorage.getUrlResource(id, "Enterprise", resource);
    }
}
