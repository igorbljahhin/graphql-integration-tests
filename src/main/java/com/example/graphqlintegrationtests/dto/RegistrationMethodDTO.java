package ee.bookify.backend.dto;

import ee.bookify.backend.domain.RegistrationMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationMethodDTO {
    private RegistrationMethodEnum method;
}
