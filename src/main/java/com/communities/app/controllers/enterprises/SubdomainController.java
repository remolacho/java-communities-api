package com.communities.app.controllers.enterprises;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubdomainController extends ApplicationController{

    @GetMapping("/enterprise/subdomain")
    public String index(@PathVariable String subdomain){
        return "Hola estamos Arriba!!!! " + subdomain;
    }
}
