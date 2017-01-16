package estate_service.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@Data
@Entity
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String address;

    @NotNull
    private EstateType estateType;

    @NotEmpty
    private String createdBy;
}
