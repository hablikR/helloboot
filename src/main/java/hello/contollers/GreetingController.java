package hello.contollers;

import hello.Models.Greeting;
import hello.StaticFunctions;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static StaticFunctions Sf = new StaticFunctions();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="JSON") String name) {
        return new Greeting(String.format(template, name));
    }

    @RequestMapping("/api/greeting/{userName}")
    public Greeting greetingUser(@PathVariable(value="userName") String name) {
        return new Greeting(String.format(template, Sf.CapitalFirstLetter(name)));
    }


}