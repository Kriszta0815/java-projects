package springapps.factorial;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FactorialRepository extends MongoRepository<Factorial, String> {
    Optional<Factorial> findByNumber(int number);
}
