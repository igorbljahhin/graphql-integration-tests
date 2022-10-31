package ee.bookify.backend.service;

import ee.bookify.backend.config.FeaturesConfig;
import ee.bookify.backend.domain.RegistrationMethodEnum;
import ee.bookify.backend.dto.RegistrationMethodDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class RegistrationService {
    @Autowired
    private FeaturesConfig featuresConfig;

    public Collection<RegistrationMethodDTO> getRegistrationMethods() {
        final Collection<RegistrationMethodDTO> list = new ArrayList<>();

        if (featuresConfig.getRegistrationUsingMagicLink().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.MAGIC_LINK)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingUsername().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.USERNAME)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingEstSmartId().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.EST_SMART_ID)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingEstMobileId().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.EST_MOBILE_ID)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingEstIdCard().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.EST_ID_CARD)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingGoogle().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.GOOGLE)  
                            .build()
            );
        }

        if (featuresConfig.getRegistrationUsingFacebook().isEnabled()) {
            list.add(
                    RegistrationMethodDTO.builder()
                            .method(RegistrationMethodEnum.FACEBOOK)  
                            .build()
            );
        }

        return list;
    }
}
