package academy.atl.customers.controller;


import academy.atl.customers.entities.Customer;
import academy.atl.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired //Lo carga automaticamente a través de inyección de dependencias.
    private CustomerService service;

    @GetMapping("/customer/{id}") //Traer un cliente específico
    public Customer getCustomer(@PathVariable Integer id) {
        return service.getCustomer(id);
    }
    @GetMapping("/customer") //Traer todos los clientes
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping ("/customer/{id}") //Eliminar un cliente
    public void removeCustomer(@PathVariable Integer id) {
        service.removeCustomer(id);

    }

    @PostMapping ("/customer") //Agregar cliente
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);


    }

    @PutMapping ("/customer/{id}") //Modificar cliente
    public void updateCustomer(@PathVariable Integer id,
                               @RequestBody Customer updatecustomer) {
        service.updateCustomer(id, updatecustomer);

    }
    @GetMapping("/customer/search") //Búsqueda
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email,
                                      @RequestParam(name ="address", required = false) String address) {
        return service.searchCustomer(email, address);
        }




}
