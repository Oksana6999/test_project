package Lesson4;
// HomeWork 4


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static Lesson4.AreaTriangle.areaOfTriangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTriangleTest {

    @Test
    @DisplayName("Вычисление площади треугольника по трем сторонам")
    void whatIsAreaOfTriangle() {
        assertEquals(6, areaOfTriangle(3,4,5));
    }

    @ParameterizedTest
    @DisplayName("Вычисление площади треугольника, таблицы значений")
    @CsvSource({"6, 3, 4, 5", "6.745368781616021, 4.5, 3, 5.5"})
    void whatIsAreaTriangle(double expectedResult, double a, double b, double c)  {
        assertEquals(expectedResult, areaOfTriangle(a, b, c));
    }
}
