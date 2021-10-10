package ddd.leave.interfaces.facade;

import ddd.leave.application.service.LoginApplicationService;
import ddd.leave.infrastructure.common.api.Response;
import ddd.leave.interfaces.assembler.PersonAssembler;
import ddd.leave.interfaces.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthApi {

    @Autowired
    LoginApplicationService loginApplicationService;

    /*
       http post localhost:8080/auth/login \
       personId="1" personName="name" roleId="1" personType="INTERNAL" \
       createTime="2021-10-08 09:10:10" lastModifyTime="2021-10-08 09:10:10" status="ENABLE" \
        --form
     */
    @PostMapping("/login")
    public Response login(PersonDTO personDTO) {
        try {
            return loginApplicationService.login(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
