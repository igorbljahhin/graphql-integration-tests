package com.example.graphqlintegrationtests.graphql;

import com.example.graphqlintegrationtests.dto.RegistrationMethodDTO;
import com.example.graphqlintegrationtests.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @QueryMapping()
    public Collection<RegistrationMethodDTO> registrationMethods() {
        return registrationService.getRegistrationMethods();
    }
}
