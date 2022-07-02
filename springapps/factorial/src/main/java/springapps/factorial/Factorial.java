package springapps.factorial;

import java.util.Objects;

public class Factorial {
    private String id;
    private int number;
    private int result;

    public Factorial(String id, int number, int result) {
        this.id = id;
        this.number = number;
        this.result = result;
    }

    public Factorial(int number, int result) {
        this.number = number;
        this.result = result;
    }
    public Factorial() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factorial factorial = (Factorial) o;
        return number == factorial.number && result == factorial.result && Objects.equals(id, factorial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, result);
    }

    @Override
    public String toString() {
        return "Factorial{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", result=" + result +
                '}';
    }
}

