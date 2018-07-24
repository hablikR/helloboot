package hello.contollers;

import hello.Customer;
import hello.services.CustomerServices;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
public class CustomerController {

    private CustomerServices customerServices;

    @RequestMapping("/findall")
    public Collection<Customer> findAllCustomer(){
        return (Collection<Customer>) this.customerServices.findAll();
    }


    @RequestMapping(value  = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public void setCustomerServices(@RequestParam(name = "name") String pname){
        Customer customerItem  =new Customer(pname);
        customerServices.save(customerItem);
    }

}
