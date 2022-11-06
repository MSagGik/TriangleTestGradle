import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    // проверка корректности длин сторон треугольника
    @ParameterizedTest
    @CsvSource({"3,4,5","1,1,1","3,4,6"})
    public void testIsTriangle(int a, int b, int c) {
        assertTrue(Triangle.isTriangle(a, b, c));
    }
    // обратная проверка корректности длин сторон треугольника
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 12})
    public void testNotTriangle(int thirdSide) {
        assertFalse(Triangle.isTriangle(1, 1, thirdSide));
    }
    // проверка корректности вычисления площади треугольника
    @ParameterizedTest
    @CsvSource({"3,4,5,6","1,1,1,0.4330127018922193","3,4,6,5.332682251925386"})
    public void testArea(int a, int b, int c, double area) {
        assertEquals(area, Triangle.area(a, b, c)); // сначала идёт ожидаемое значение, а потом реальное
    }
    // проверка корректности вычисления радиуса описанной окружности
    @ParameterizedTest
    @CsvSource({"3,4,5,2.5","1,1,1,0.5773502691896258","3,4,6,3.375412062757167"})
    public void testRadius(int a, int b, int c, double radius) {
        assertEquals(radius, Triangle.radius(a, b, c));
    }
}