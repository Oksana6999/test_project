package Lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static Lesson4.Functions.*;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);



    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится один раз перед всеми тестами");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка числа: простое или нет")
    void givenPrimeNumberWhenCallIsPrimeThenTrue() {
        boolean result = isPrime(7);
        assertTrue(result);
        logger.info("INFO_BUG");
        logger.error("ERROR!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("После каждого теста");
    }

//    @Test
//    void isPalindromePositiveTest() {
//        assertTrue(isPalindrome("147741"));
//    }

//    @Test
//    void isPalindromePositiveTest2() {
//        assertTrue(isPalindrome("1476741"));
//    }

    @ParameterizedTest
    @ValueSource (strings = {"147741", "1476741"})
    void isPalindromePositiveTest(String word) {
        assertTrue(isPalindrome(word));
    }

    @Test
    void isNotPalindrome() {
        assertFalse(isPalindrome("12"));
    }

    @ParameterizedTest
    @CsvSource({"true, 123321", "false, 12"})
    void commonPalindromeTest(boolean expectedResult, String word) {
        assertEquals(expectedResult, isPalindrome(word));
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")

    void catTest(Cat cat, Integer age) {
        assertEquals(age, cat.getAge());
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Barsik", 10), 8),
                Arguments.of(new Cat("Vaska", 2), 2)
        );
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится один раз после всех тестов.");
    }
}
