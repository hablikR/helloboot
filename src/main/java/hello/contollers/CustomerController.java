package hello.contollers;

import hello.Models.Customer;
import hello.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @RequestMapping("/findall")
    public List<Customer> findAllCustomer(){
        return this.customerServices.findAll();
    }


    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    @ResponseBody
    public String addNewCustomer(@RequestParam(name = "name") String pname){
        Customer customerItem  =new Customer(pname);
        customerServices.save(customerItem);
        return "Customer added: " + customerItem.toString();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET, params = "id")
    @ResponseBody
    public String removeCustomer(@RequestParam(name = "id") Long PID){
       return removeCustomerByID(PID);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET, params = "name")
    @ResponseBody
    public String removeCustomer(@RequestParam(name = "name") String PName){
        String r = "";
        List<Customer> customers = getIDList(PName);
        for(Customer c : customers){
           r+= removeCustomerByID(c.getId());
        }
        return r;
    }

    public String removeCustomerByID(Long PID){
        if(customerServices.isExist(PID)){
            Optional<Customer> optionalCustomerCustomer =  customerServices.findByID(PID);
            Customer tCustomer = optionalCustomerCustomer.get();
            customerServices.delete(tCustomer);
            return "Customer removed: " + tCustomer.toString();
        }
        return "ID is not exist!";
    }

    @RequestMapping(value = "/update/{newName}", method = RequestMethod.GET)
    @ResponseBody
    public String updateCusomerByID(@RequestParam(name = "id") Long PID, @PathVariable(value = "newName") String PName){

        if(customerServices.isExist(PID)){
            Optional<Customer> optionalCustomerCustomer =  customerServices.findByID(PID);
            Customer tCustomer = optionalCustomerCustomer.get();
            Customer old = new Customer(tCustomer.getId(), tCustomer.getName());
            tCustomer.setName(PName);
            customerServices.save(tCustomer);
            return "Customer updated from " + old.toString() + "to" + tCustomer;
        }

        return "ID is not exist!";
    }

    public List<Customer> getIDList(String PName){
        ArrayList<Customer> newCustomerList = new ArrayList<>();
        for(Customer c : customerServices.findAll()){
            if(c.getName().equals(PName))
                newCustomerList.add(c);
        }
        return newCustomerList;
    }
}
