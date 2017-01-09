package estate_service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@RestController
@RequestMapping(path = "/estates")
public class EstateCrudController {

    @Autowired
    private EstateService estateService;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EstateDTO post(@RequestBody EstateDTO estateDTO, Principal user) {

        Estate estate = new Estate();
        BeanUtils.copyProperties(estateDTO,estate);
        estate.setCreatedBy(user.getName());
        estate = estateService.save(estate);
        BeanUtils.copyProperties(estate,estateDTO);

        return estateDTO;
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public EstateDTO get(@PathVariable("id") Long id) {
        Estate estate = estateService.find(id);
        if (estate==null) {
            throw new NotFoundException();
        }
        EstateDTO estateDTO = new EstateDTO();
        BeanUtils.copyProperties(estate,estateDTO);
        return estateDTO;
    }


}
