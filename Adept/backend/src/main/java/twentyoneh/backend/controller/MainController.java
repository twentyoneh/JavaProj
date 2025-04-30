package twentyoneh.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        // return "forward:/frontend/browser/index.html";
        return "index.html";
    }   
}
