package springapps.factorial;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factorial")
public class FactorialEndpoint {
    private final FactorialManager factorialManager;

    public FactorialEndpoint(FactorialManager factorialManager) {
        this.factorialManager = factorialManager;
    }
    @GetMapping
    List<Factorial> getAll() {
        return factorialManager.findAll();
    }

    @PostMapping
    Factorial post(@RequestBody int number) {
        return factorialManager.calculate(number);
    }

    @GetMapping("/{number}")
    Factorial getOne(@PathVariable int number) {
        return factorialManager.getOne(number).orElse(null);
    }

}
