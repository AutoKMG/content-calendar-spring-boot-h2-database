package springbootpractice.kmg.springbootfirstpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    String[] myWelcomeMessages = {
            "Welcome to my simple API",
            "use /api/content to display all content",
            "use /api/content/{id} to find a specific content with id",
            "post is configured on /api/content",
            "delete and put are configured on /api/content/{id}",
            "to search contents with title use /api/content/filter/{keyword}",
            "to search contents with status use /api/content/filter/status/{status}",
    };
    @GetMapping("/")
    public String[] home(){
        return myWelcomeMessages;
    }
}
