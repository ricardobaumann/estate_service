package estate_service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ricardobaumann on 08/01/17.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class PaymentException extends RuntimeException {
    public PaymentException(StatusDTO statusDTO) {
        super(statusDTO.getStatus().toString());
    }
}
