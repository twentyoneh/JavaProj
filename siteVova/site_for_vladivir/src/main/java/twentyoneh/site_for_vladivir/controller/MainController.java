package twentyoneh.site_for_vladivir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "forward:../adept/src/index.html";
    }
    
}
