package country;

public class NoSuchCountryException extends Exception {
    public NoSuchCountryException(final String name) {
        System.out.println("Страны '" + name + "' не существует");
    }
}
