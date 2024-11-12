package com.communities.app.controllers.enterprises;

import com.communities.app.services.enterprises.search.IEnterpriseFindService;
import com.communities.domain.dao.IEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubdomainController extends ApplicationController{

    @Autowired
    public IEnterpriseFindService enterpriseFindService;

    @GetMapping("/enterprise/subdomain")
    public String index(@PathVariable String subdomain){
        logger.info("Se ejecuta el evento nombre de la empresa ########### " +
                enterpriseFindService.findBySubdomain(subdomain).orElse(null).getName());

        return "Hola estamos Arriba!!!! " + subdomain;
    }
}
