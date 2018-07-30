package hello.contollers;

import hello.Models.Customer;
import hello.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public String removeCustomer(@RequestParam(name = "id") Long pID){
       return removeCustomerByID(pID);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET, params = "name")
    @ResponseBody
    public String removeCustomer(@RequestParam(name = "name") String pName)
    {
        String r = "";
        List<Customer> customers = getIDList(pName);
        for(Customer c : customers){
           r+= removeCustomerByID(c.getId());
        }
        return r;
    }


    @RequestMapping(value = "/update/{newName}", method = RequestMethod.GET)
    @ResponseBody
    public String updateCusomerByID(@RequestParam(name = "id") Long pID, @PathVariable(value = "newName") String pName){

        if(customerServices.isExist(pID)){
            Optional<Customer> optionalCustomerCustomer =  customerServices.findByID(pID);
            Customer tCustomer = optionalCustomerCustomer.get();
            Customer old = new Customer(tCustomer.getId(), tCustomer.getName());
            tCustomer.setName(pName);
            customerServices.save(tCustomer);
            return "Customer updated from " + old.toString() + "to" + tCustomer;
        }

        return "ID is not exist!";
    }

    public String removeCustomerByID(Long pID){
        if(customerServices.isExist(pID)){
            Optional<Customer> optionalCustomerCustomer =  customerServices.findByID(pID);
            Customer tCustomer = optionalCustomerCustomer.get();
            customerServices.delete(tCustomer);
            return "Customer removed: " + tCustomer.toString();
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
