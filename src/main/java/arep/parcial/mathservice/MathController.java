package arep.parcial.mathservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("linearSearch")
    public AnswerServer linearSearch(@RequestParam(value="list") Integer[] list, @RequestParam(value="value") Integer value){
        return new AnswerServer("binarySearch",list,value,mathService.linealSearch(list,value));
    }

    @PostMapping("/binarySearch")
    public AnswerServer binarySearch(@RequestParam(value="list") Integer[] list, @RequestParam(value="value") Integer value){
        return new AnswerServer("binarySearch",list,value,mathService.linealSearch(list,value));
    }
}
