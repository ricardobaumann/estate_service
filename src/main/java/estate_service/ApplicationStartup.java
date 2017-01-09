package estate_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

    @Autowired
    private DiscoveryClient discoveryClient;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println(discoveryClient.getInstances("auth_service"));
    }
}
