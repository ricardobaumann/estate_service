package estate_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@Service
public class EstateService {

    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private PaymentClient paymentClient;

    @RolesAllowed("ROLE_ADMIN")
    public Estate save(Estate estate) {
        StatusDTO statusDTO = paymentClient.getStatus(estate.getCreatedBy());
        if (statusDTO.getStatus()!=Status.OK) {
            throw new PaymentException(statusDTO);
        }
        return estateRepository.save(estate);
    }

    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    public Estate find(Long id) {
        return estateRepository.findOne(id);
    }
}
