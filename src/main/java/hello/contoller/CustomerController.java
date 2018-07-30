package hello.contoller;

import hello.model.Customer;
import hello.service.CustomerServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServicesImpl customerServicesImpl;

    @RequestMapping(value =  "/findall", method = RequestMethod.GET)
    public List<Customer> findAllCustomer(){
        return this.customerServicesImpl.findAll();
    }

    @RequestMapping(value = "/add/{name}", method = RequestMethod.POST)
    public @ResponseBody String addNewCustomer(@PathVariable(value = "name") String name){
        Customer customerItem  =new Customer(name);
        customerServicesImpl.save(customerItem);
        return "Customer added: " + customerItem.toString();
    }

    @RequestMapping(value = "/remove/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Customer> removeCustomer(@PathVariable(value = "name") String name){
        List<Customer> r = new ArrayList<Customer>();
        List<Customer> customers =  customerServicesImpl.getIDList(name);
        for(Customer c : customers){
           r.add(removeCustomerByID(c.getId()));
        }
        return null;
    }

    @RequestMapping(value = "/update/{newName}", method = RequestMethod.PUT)
    @ResponseBody
    public Customer updateCusomerByID(@RequestParam(name = "id") Long pID, @PathVariable(value = "newName") String pName){
        if(customerServicesImpl.isExist(pID)){
           return customerServicesImpl.updateService(pID, pName);
        }
        return null;
    }

    public Customer removeCustomerByID(Long pID){
        if(customerServicesImpl.isExist(pID)){
            return customerServicesImpl.deleteService(pID);
        }
        return null;
    }
}
