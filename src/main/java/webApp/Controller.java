package webApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nichaurasia on Wednesday, February/05/2020 at 3:39 PM
 */

@RestController
public class Controller {

    @GetMapping("/")
    public String HelloWorld(){
        return "Batch Program runs....";
    }
}