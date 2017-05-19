package estate_service.models;

import lombok.Data;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@Data
public class EstateDTO {

    private String address;

    private EstateType estateType;

    private Long id;

    private String createdBy;

}
