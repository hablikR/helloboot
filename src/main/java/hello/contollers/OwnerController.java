package hello.contollers;

import hello.Models.Owners;
import hello.services.OwnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @Autowired
    private OwnerServices ownerServices;

}
