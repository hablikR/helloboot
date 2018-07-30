package hello.contoller;

import hello.model.Devices;
import hello.service.DeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceServices deviceServices;

    @RequestMapping("/findall2")
    public List<Devices> findAllCustomer(){
        return this.deviceServices.findAll();
    }

}
