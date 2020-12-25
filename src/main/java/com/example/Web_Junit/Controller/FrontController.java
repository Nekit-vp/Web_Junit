package com.example.Web_Junit.Controller;

import com.example.Web_Junit.model.Note;
import com.example.Web_Junit.model.User;
import com.example.Web_Junit.repository.NoteRepository;
import com.example.Web_Junit.repository.UserRepository;
import com.example.Web_Junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("in")
public class FrontController {

    @Autowired
    private NoteRepository noteRepository;

    private final UserService userService;

    @Autowired
    public FrontController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("sign_in")
    public String getSignIn(Map<String, Object> model) {
        model.put("error", "");

        return "sign_in";
    }

//    @GetMapping("write")
//    public String getMain(Map<String, Object> model){
//        model.put("error", "");
//        Iterable<Note> noses = noteRepository.findAll();
//        model.put("notes", noses);
//        return "Shop";
//    }

    @GetMapping("write")
    public String getLogPas(@RequestParam String login, @RequestParam String password,
                            Map<String, Object> model) {
        if (User.isValid(login, password)) {

            if (userService.isNotNull(login)) {

                if (userService.check(login, password)) {
                    model.put("error", "");
                    Iterable<Note> noses = noteRepository.findAll();
                    model.put("notes", noses);
                    return "Shop";
                } else {
                    model.put("error", "Wrong password!");
                    return "sign_in";
                }
            } else {
                model.put("error", "User is not found!");
                return "sign_in";
            }
        } else {
            model.put("error", "Fill in the fields!");
            return "sign_in";
        }
    }

    @GetMapping("sign_up")
    public String getSignUp(Map<String, Object> model) {
        model.put("error", "");
        return "sign_up";
    }

    @GetMapping("writeNewUser")
    public String getSignUp(@RequestParam String login, @RequestParam String password,
                            Map<String, Object> model) {
        if (User.isValid(login, password)) {

            if (!userService.isNotNull(login)) {
                userService.create(login, password);
                model.put("error", "");
                return "sign_in";
            } else {
                model.put("error", "User is already taken!");
                return "sign_up";
            }
        } else {
            model.put("error", "Fill in the fields!");
            return "sign_up";
        }

    }

    @GetMapping("add")
    public String addNote(@RequestParam String text, @RequestParam String tag,
                          Map<String, Object> model) {

        Note note = new Note(text, tag);
        noteRepository.save(note);

        Iterable<Note> noses = noteRepository.findAll();
        model.put("notes", noses);


        return "Shop";
    }


}
