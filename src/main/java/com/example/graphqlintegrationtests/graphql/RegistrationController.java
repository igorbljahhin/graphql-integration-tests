package ee.bookify.backend.graphql;

import ee.bookify.backend.dto.RegistrationMethodDTO;
import ee.bookify.backend.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @QueryMapping()
    public Collection<RegistrationMethodDTO> registrationMethods() {
        return registrationService.getRegistrationMethods();
    }
}
