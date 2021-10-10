package ddd.leave.application.service;

import ddd.leave.domain.person.entity.Person;
import ddd.leave.infrastructure.client.AuthFeignClient;
import ddd.leave.infrastructure.common.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginApplicationService {

    @Autowired
    AuthFeignClient authFeignClient;

    public Response login(Person person) {
        // 调用鉴权微服务
        return authFeignClient.login(person);
    }

}
