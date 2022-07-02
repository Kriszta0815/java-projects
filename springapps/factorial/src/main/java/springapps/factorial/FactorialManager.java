package springapps.factorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactorialManager {
    private final int numberOne;
    private final FactorialRepository factorialRepository;
    private final  FactorialCalculator factorialCalculator;

    public FactorialManager(@Value("${factorial.numberOne}") int numberOne, FactorialRepository factorialRepository, FactorialCalculator factorialCalculator) {
        this.numberOne = numberOne;
        this.factorialRepository = factorialRepository;
        this.factorialCalculator = factorialCalculator;
    }
    public List<Factorial> findAll() {
        return factorialRepository.findAll();
    }
    public Optional<Factorial> getOne(int number) {
        return factorialRepository.findByNumber(number);
    }

    public Factorial calculate(int number) {
        Optional<Factorial> factorialOptional = factorialRepository.findByNumber(number);
        if(factorialOptional.isPresent()) {
            return factorialOptional.get();
        }
        Factorial factorial = new Factorial(number, factorialCalculator.calculateFactorial(number));
        return factorialRepository.save(factorial);
    }
}

