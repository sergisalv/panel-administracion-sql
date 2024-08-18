package academy.atl.customers.controller;


import academy.atl.customers.entities.User;
import academy.atl.customers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired //Lo carga automaticamente a través de inyección de dependencias.
    private UserService service;

    @GetMapping("/user/{id}") //Traer un cliente específico
    public User getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }
    @GetMapping("/user") //Traer todos los clientes
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @DeleteMapping ("/user/{id}") //Eliminar un cliente
    public void removeUser(@PathVariable Integer id) {
        service.removeUser(id);

    }

    @PostMapping ("/user") //Agregar cliente
    public void addUser(@RequestBody User user) {
        service.addUser(user);


    }

    @PutMapping ("/user/{id}") //Modificar cliente
    public void updateUser(@PathVariable Integer id,
                               @RequestBody User updateuser) {
        service.updateUser(id, updateuser);

    }
    @GetMapping("/user/search") //Búsqueda
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name ="address", required = false) String address) {
        return service.searchUser(email, address);
    }




}

