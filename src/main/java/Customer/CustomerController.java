package Customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    List<Customer> all(){

        return repository.findAll();
    }

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id){

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("we could't find any customer the the id (%s)", id)));
    }

    @PostMapping("/customer")
    Customer save(@RequestBody Customer newCustomer){

        return repository.save(newCustomer);
    }

    @PutMapping("/customer/{id}")
    Customer saveUpdate(@PathVariable Long id, @RequestBody Customer newCustomer){

        return repository.save(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    void delete(@PathVariable Long id){

        repository.deleteById(id);
    }
}
