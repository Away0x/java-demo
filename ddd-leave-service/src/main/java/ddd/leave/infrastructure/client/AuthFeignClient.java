package ddd.leave.infrastructure.client;

import ddd.leave.domain.person.entity.Person;
import ddd.leave.infrastructure.common.api.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "auth-service",
        path = "/demo/auth",
//        url = "localhost:8081",
        fallback = AuthFeignClient.DefaultFallback.class
)
public interface AuthFeignClient {

    @PostMapping(value = "/login")
    Response login(Person person);

    /**
     * 容错处理类，当调用失败时，简单返回空字符串
     */
    @Component
    public class DefaultFallback implements AuthFeignClient {
        @Override
        public Response login(Person person) {
            return Response.failed("服务调用失败");
        }
    }

}
