package com.communities.app.exceptions.callbacks;

import com.communities.app.exceptions.TenantElementException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SchemaExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.communities.domain.dao.*.*(..))", throwing = "ex")
    public void handleSchemaNotFoundException(InvalidDataAccessResourceUsageException ex) {
        throw new TenantElementException("the schema not found");
    }
}