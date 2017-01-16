package estate_service.services;

import estate_service.exceptions.PaymentException;
import estate_service.models.Estate;
import estate_service.models.Status;
import estate_service.models.StatusDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ricardobaumann on 16/01/17.
 */
@Component
@Aspect
public class PaymentAspect {

    @Autowired
    private PaymentClient paymentClient;

    @Before(value = "@annotation(estate_service.services.PaymentOK)")
    public void before(JoinPoint joinPoint) {
        if (joinPoint.getArgs()[0] instanceof Estate) {
            Estate estate = (Estate) joinPoint.getArgs()[0];
            StatusDTO statusDTO = paymentClient.getStatus(estate.getCreatedBy());
            if (statusDTO.getStatus()!= Status.OK) {
                throw new PaymentException(statusDTO);
            }
        }

    }

}
