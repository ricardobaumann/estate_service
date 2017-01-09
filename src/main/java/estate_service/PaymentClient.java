package estate_service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by ricardobaumann on 08/01/17.
 */
@Component
@Configuration
public class PaymentClient {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private EurekaClient eurekaClient;//using it because loadBalanced restTemplate was not working

    public StatusDTO getStatus(String username) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        InstanceInfo instance = eurekaClient.getNextServerFromEureka("payments",false);

        return restTemplate.exchange(instance.getHomePageUrl()+"payments/users/{username}/status", HttpMethod.GET, entity, StatusDTO.class,username).getBody();
    };

}
