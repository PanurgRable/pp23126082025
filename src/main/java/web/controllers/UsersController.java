package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.servece.UserServece;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserServece userServece;

    @Autowired
    public UsersController(UserServece userServece) {
        this.userServece = userServece;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userServece.index());
        return "users/index";
    }


    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServece.show(id));
        return "users/show";
    }

    // форма добавления нового пользователя
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }


    @PostMapping()
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";
        userServece.save(user);
        return "redirect:/users";
    }


    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userServece.delete(id);
        return "redirect:/users";
    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userServece.show(id));
        return "users/edit";
    }

    // обновление пользователя (id передаётся как ?id=1)
    @PostMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam("id") int id) {
        if (bindingResult.hasErrors())
            return "users/edit";
        userServece.update(id, user);
        return "redirect:/users";
    }
}









