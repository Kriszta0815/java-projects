package springapps.factorial;

import org.springframework.stereotype.Service;

@Service
public class FactorialCalculator {

    public int calculateFactorial(int numberInput) {
        if(numberInput==0) return 1;
        return numberInput * calculateFactorial((numberInput - 1));
    }
}
