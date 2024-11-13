package com.communities.app.controllers.enterprises;

import com.communities.app.exceptions.RecordNotFoundException;
import com.communities.app.services.enterprises.search.IEnterpriseFindService;
import com.communities.domain.entities.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SubdomainController extends ApplicationController{

    @Autowired
    public IEnterpriseFindService enterpriseFindService;

    @GetMapping("/enterprise/subdomain")
    public  ResponseEntity<?> index(@PathVariable String subdomain){
        Enterprise enterprise = enterpriseFindService.findBySubdomain(subdomain);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "success", true,
                        "message", "El subdomain es valido",
                        "data", Map.of("logo_url", enterprise.getName())
                ));
    }
}
