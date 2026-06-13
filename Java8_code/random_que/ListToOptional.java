package Java8_code.random_que;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListToOptional {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList();
        Optional<List<String>> optionalList = Optional.of(myList);
        if (optionalList.isPresent()) {
            System.out.println("value is present");
        } else {
            System.out.println("value is not present");
        }
    }
}
/*
=> Optional

      -> Introduced in Java 8

            -> Used to avoid NullPointerException (NPE)
            -> Represents a value that may or may not be present
            -> Container object which may contain a non-null value or be empty

      -> Creating Optional Objects

            -> Optional.of(value)

                  -> Used when value is definitely not null
                  -> Throws NullPointerException if value is null

                  Example:
                  Optional<String> opt = Optional.of("Java");

            -> Optional.ofNullable(value)

                  -> Used when value can be null
                  -> Returns empty Optional if value is null

                  Example:
                  Optional<String> opt = Optional.ofNullable(null);

            -> Optional.empty()

                  -> Creates an empty Optional

                  Example:
                  Optional<String> opt = Optional.empty();

      -> Checking Value Presence

            -> isPresent()

                  -> Returns true if value exists

                  Example:
                  opt.isPresent();

            -> isEmpty() (Java 11)

                  -> Returns true if Optional is empty

                  Example:
                  opt.isEmpty();

      -> Retrieving Value

            -> get()

                  -> Returns value if present
                  -> Throws NoSuchElementException if Optional is empty
                  -> Generally avoided in modern code

                  Example:
                  opt.get();

            -> orElse(defaultValue)

                  -> Returns value if present
                  -> Otherwise returns default value

                  Example:
                  opt.orElse("Default");

            -> orElseGet(Supplier)

                  -> Returns value if present
                  -> Otherwise executes Supplier and returns result
                  -> Lazy evaluation

                  Example:
                  opt.orElseGet(() -> "Default");

            -> orElseThrow()

                  -> Returns value if present
                  -> Otherwise throws exception

                  Example:
                  opt.orElseThrow();

                  Custom Exception:
                  opt.orElseThrow(() -> new RuntimeException("Not Found"));

      -> Executing Actions

            -> ifPresent()

                  -> Executes action only when value exists

                  Example:
                  opt.ifPresent(System.out::println);

            -> ifPresentOrElse() (Java 9)

                  -> Executes one action if value exists
                  -> Executes another action if value is absent

                  Example:
                  opt.ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No Value")
                  );

      -> Filtering Values

            -> filter(Predicate)

                  -> Returns Optional containing value only if condition matches
                  -> Otherwise returns empty Optional

                  Example:
                  opt.filter(name -> name.startsWith("J"));

      -> Transforming Values

            -> map(Function)

                  -> Transforms value inside Optional
                  -> Returns Optional of transformed value

                  Example:
                  Optional<Integer> length =
                          opt.map(String::length);

                  Flow:
                  Optional<String>
                           ↓
                  Optional<Integer>

            -> flatMap(Function)

                  -> Used when mapping function already returns Optional
                  -> Prevents nested Optional

                  Example:
                  opt.flatMap(value ->
                          Optional.of(value.toUpperCase()));

                  Difference:

                  map()
                  Optional<String>
                           ↓
                  Optional<Optional<String>>

                  flatMap()
                  Optional<String>
                           ↓
                  Optional<String>

      -> Additional Methods

            -> or() (Java 9)

                  -> Returns current Optional if value exists
                  -> Otherwise returns another Optional

                  Example:
                  opt.or(() -> Optional.of("Default"));

            -> stream() (Java 9)

                  -> Converts Optional into Stream
                  -> Useful in Stream Pipelines

                  Example:
                  opt.stream()
                     .forEach(System.out::println);

      -> Most Frequently Used Methods

            -> ofNullable()
            -> ifPresent()
            -> map()
            -> flatMap()
            -> filter()
            -> orElse()
            -> orElseGet()
            -> orElseThrow()

      -> Interview Points

            -> get() should generally be avoided
            -> orElse() eagerly evaluates default value
            -> orElseGet() lazily evaluates Supplier
            -> map() transforms value
            -> flatMap() avoids Optional<Optional<T>>
            -> filter() applies condition
            -> ifPresent() executes action only when value exists
*/

