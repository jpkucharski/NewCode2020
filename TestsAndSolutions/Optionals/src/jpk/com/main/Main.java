package jpk.com.main;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        System.out.println("Is Present? " + empty.isPresent());
        System.out.println("Is empty? " + empty.isEmpty());
//--------------------------------------------------------------------
        Optional<String> empty1 = Optional.of("hello");
        System.out.println("Is Present? " + empty1.isPresent());
        System.out.println("Is empty? " + empty1.isEmpty());
//--------------------------------------------------------------------
        Optional<String> string1 = Optional.of("hello");
        Optional<String> string2 = Optional.ofNullable(null);
        String orElse = string1.orElse("world");
        String orElse1 = string2.orElse("world");
        System.out.println(orElse);
        System.out.println(orElse1);
//--------------------------------------------------------------------
        Optional<String> helloToUpperCase = Optional.ofNullable("hello");
        String orElse2 = helloToUpperCase
                .map(x -> x.toUpperCase())
                .orElse("world");
        System.out.println(orElse2);
//--------------------------------------------------------------------
        Optional<String> hello = Optional.ofNullable("hello");
        String orElseGet = hello
                .map(x -> x)
                .orElseGet(() -> {
                    return "World";
                });
        System.out.println(orElseGet);
//--------------------------------------------------------------------
//        Optional<String> hello1 = Optional.ofNullable(null);
//        String orElseGet1 = hello1
//                .map(x -> x.toUpperCase())
//                .orElseThrow(IllegalStateException::new);
//        System.out.println(orElseGet1);
//--------------------------------------------------------------------
        Optional<String> hello2 = Optional.ofNullable("hello");
        hello2.ifPresent(world -> {
            System.out.println("isPresent!");
        });
//--------------------------------------------------------------------
        Optional<String> hello3 = Optional.ofNullable("hello");
        hello3.ifPresentOrElse(System.out::println, () -> {
            System.out.println("Is not present!!!");
        });
//--------------------------------------------------------------------


        Person erica = new Person("erica", "ERICA@123.com");
        Person kamila = new Person("kamila", null);
        Person maria = new Person("maria", "maria@123.com");

        System.out.println(erica.
                getEmail().
                map(String::toLowerCase)
                .orElse("Email is null!"));
        System.out.println(kamila
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email is null!"));
        System.out.println(maria.
                getEmail()
                .map(String::toLowerCase)
                .orElse("Email is null!"));
    }
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}