package springapps.factorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FactorialManagerTest {
    @Autowired
    FactorialManager factorialManager;
    @MockBean
    FactorialRepository factorialRepository;
    @Value("${factorial.numberOne}")
    int numberOne;
    @Test
    void findAll() {
        factorialManager.findAll();
        Mockito.verify(factorialRepository).findAll();
    }

    @Test
    void getOne_empty() {
        int number = 3;
        Mockito.when(factorialRepository.findByNumber(number)).thenReturn(Optional.empty());
        Optional<Factorial> optionalFactorial = factorialManager.getOne(number);
        Assertions.assertTrue(optionalFactorial.isEmpty());
        Mockito.verify(factorialRepository).findByNumber(number);
    }
    @Test
    void getOne() {
        int number = 3;
        Mockito.when(factorialRepository.findByNumber(number)).thenReturn(Optional.of(new Factorial(number, 54)));
        Optional<Factorial> optionalFactorial = factorialManager.getOne(number);
        Assertions.assertTrue(optionalFactorial.isPresent());
        Mockito.verify(factorialRepository).findByNumber(number);
    }
    @DirtiesContext
    @Test
    void calculate_exist() {
        int number = 3;
        Optional<Factorial> optionalFactorial = Optional.of(new Factorial(number, 54));
        Mockito.when(factorialRepository.findByNumber(number)).thenReturn(optionalFactorial);
        Factorial result = factorialManager.calculate(3);
        Factorial expected = optionalFactorial.get();
        Assertions.assertEquals(expected, result);
        Mockito.verify(factorialRepository).findByNumber(number);

    }

    @Test
    void calculate_notExist() {
        int number = 4;
        Mockito.when(factorialRepository.findByNumber(number)).thenReturn(Optional.empty());
        factorialManager.calculate(number);
        Mockito.verify(factorialRepository).save(any(Factorial.class));

    }
}