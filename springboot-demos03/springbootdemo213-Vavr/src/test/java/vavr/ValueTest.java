package vavr;

import com.kenshine.vavr.value.Person;
import com.kenshine.vavr.value.PersonValidator;
import io.vavr.CheckedFunction0;
import io.vavr.Lazy;
import io.vavr.collection.Seq;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 9:11
 * @description：值测试
 * @modified By：
 * @version: $
 */
public class ValueTest {

    /**
     * 1. java8Null值处理
     * 不会出现异常
     */
    @Test
    public void test01_java8_Optional(){
        Optional<String> maybeFoo = Optional.of("foo");
        then(maybeFoo.get()).isEqualTo("foo");
        Optional<String> maybeFooBar = maybeFoo.map(s -> (String)null)
                .map(s -> s.toUpperCase() + "bar");
        then(maybeFooBar.isPresent()).isFalse();
    }

    /**
     * 2. Vavr的null会出现异常
     */
    @Test
    public void test02_Option(){
        Option<String> maybeFoo = Option.of("foo");
        then(maybeFoo.get()).isEqualTo("foo");
        try {
            maybeFoo.map(s -> (String)null)
                    .map(s -> s.toUpperCase() + "bar");
            Assert.fail();
        } catch (NullPointerException e) {
            // this is clearly not the correct approach
        }
    }

    /**
     * 3.Option可以使用filterMap处理null
     */
    @Test
    public void test03_filterMap(){
        Option<String> maybeFoo = Option.of("foo");
        then(maybeFoo.get()).isEqualTo("foo");
        Option<String> maybeFooBar = maybeFoo.map(s -> (String)null)
                .flatMap(s -> Option.of(s)
                        .map(t -> t.toUpperCase() + "bar"));
        then(maybeFooBar.isEmpty()).isTrue();


        Option<String> maybeFoo1 = Option.of("foo");
        then(maybeFoo1.get()).isEqualTo("foo");
        Option<String> maybeFooBar1 = maybeFoo1.flatMap(s -> Option.of((String)null))
                .map(s -> s.toUpperCase() + "bar");
        then(maybeFooBar1.isEmpty()).isTrue();
    }

    /**
     * 4.Try
     */
    @Test
    public void test04_try(){
//        A result = Try.of(this::bunchOfWork)
//                .recover(x -> Match(x).of(
//                        Case($(instanceOf(Exception_1.class)), t -> somethingWithException(t)),
//                        Case($(instanceOf(Exception_2.class)), t -> somethingWithException(t)),
//                        Case($(instanceOf(Exception_n.class)), t -> somethingWithException(t))
//                ))
//                .getOrElse(other);
    }

    /**
     * 5.Lazy
     */
    @Test
    public void test05_Lazy(){
        Lazy<Double> lazy = Lazy.of(Math::random);
        lazy.isEvaluated(); // = false
        lazy.get();         // = 0.123 (random generated)
        lazy.isEvaluated(); // = true
        lazy.get();         // = 0.123 (memoized)
    }

    /**
     * 6.Either
     */
    @Test
    public void test06_Either(){
        Either<String,Integer> value = compute().right().map(i -> i * 2).toEither();
        System.out.println(value);
    }

    private Either<String,Integer> compute() {
//        return Either.left("error");
        return Either.right(1);
    }

    /**
     * 7. Future
     */
    @Test
    public void test07_future(){
        Future<Integer> future = Future.of(new CheckedFunction0<Integer>() {
            @Override
            public Integer apply() throws Throwable {
                return 1;
            }
        });
        System.out.println(future.get());
    }

    /**
     * 8.Validation
     */
    @Test
    public void test08_Validation(){
        PersonValidator personValidator = new PersonValidator();

        // Valid(Person(John Doe, 30))
        Validation<Seq<String>, Person> valid = personValidator.validatePerson("John Doe", 30);

        // Invalid(List(Name contains invalid characters: '!4?', Age must be greater than 0))
        Validation<Seq<String>, Person> invalid = personValidator.validatePerson("John? Doe!4", -1);

        System.out.println(valid);
        System.out.println(invalid);
    }




}
