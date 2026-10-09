package merito.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {

        Iterable<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "win"));
        model.addAttribute("allUsers", users);

        return "User";
    }

    @GetMapping("/users/new")
    public String createUsers(Model model) {

        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/users/new")
    public String saveNewUser(User user){

        userRepository.save(user);

        return "redirect:/users";
    }

    @GetMapping("/users/delete{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userRepository.deleteById(id);

        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUsers(Model model, @PathVariable("id") Long id) {

        model.addAttribute("user", userRepository.findById(id));
        return "editUser";
    }

    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute("user") User user){

        userRepository.save(user);

        return "redirect:/users";
    }




}