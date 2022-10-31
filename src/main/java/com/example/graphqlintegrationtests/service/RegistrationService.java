package com.example.graphqlintegrationtests.service;

import com.example.graphqlintegrationtests.domain.RegistrationMethodEnum;
import com.example.graphqlintegrationtests.dto.RegistrationMethodDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RegistrationService {
    public Collection<RegistrationMethodDTO> getRegistrationMethods() {
        final Collection<RegistrationMethodDTO> list = new ArrayList<>();

        RegistrationMethodDTO obj;

        obj = new RegistrationMethodDTO();
        obj.setMethod(RegistrationMethodEnum.MAGIC_LINK);
        list.add(obj);

        obj = new RegistrationMethodDTO();
        obj.setMethod(RegistrationMethodEnum.USERNAME);
        list.add(obj);

        obj = new RegistrationMethodDTO();
        obj.setMethod(RegistrationMethodEnum.GOOGLE);
        list.add(obj);

        obj = new RegistrationMethodDTO();
        obj.setMethod(RegistrationMethodEnum.FACEBOOK);
        list.add(obj);

        return list;
    }
}
