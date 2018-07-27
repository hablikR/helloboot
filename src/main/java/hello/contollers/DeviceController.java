package hello.contollers;

import hello.services.DeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceServices deviceServices;


}
