// M1 - Нийлбэр оноо болон үсгэн дүнг шалгах тест

package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн")
    void testGradeA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(95);

        // Assert
        assertEquals("A", result);
    }

    @Test
    @DisplayName("85 оноо B дүн")
    void testGradeB() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(85);

        // Assert
        assertEquals("B", result);
    }

    @Test
    @DisplayName("75 оноо C дүн")
    void testGradeC() {
        GradeCalculator calc = new GradeCalculator();

        String result = calc.letterGrade(75);

        assertEquals("C", result);
    }

    @Test
    @DisplayName("65 оноо D дүн")
    void testGradeD() {
        GradeCalculator calc = new GradeCalculator();

        String result = calc.letterGrade(65);

        assertEquals("D", result);
    }

    @Test
    @DisplayName("30 оноо F дүн")
    void testGradeF() {
        GradeCalculator calc = new GradeCalculator();

        String result = calc.letterGrade(30);

        assertEquals("F", result);
    }

    @Test
    @DisplayName("Сөрөг оноо")
    void testNegativeScore() {
        GradeCalculator calc = new GradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(-1));
    }

    @Test
    @DisplayName("100-аас их оноо")
    void testScoreAbove100() {
        GradeCalculator calc = new GradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(101));
    }

    @Test
    @DisplayName("Нийлбэр оноо 100")
    void testTotalScore() {
        GradeCalculator calc = new GradeCalculator();

        double result = calc.totalScore(10, 40, 10, 10, 30);

        assertEquals(100.0, result, 0.001);
    }

    @Test
    @DisplayName("Ирцийн оноо сөрөг")
    void testNegativeAttendance() {
        GradeCalculator calc = new GradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30));
    }

    @Test
    @DisplayName("Лабораторийн оноо хэтэрсэн")
    void testInvalidLabScore() {
        GradeCalculator calc = new GradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30));
    }

    @ParameterizedTest
    @DisplayName("Дүнгийн хязгаарын утгууд")
    @CsvSource({
        "90, A",
        "89.99, B",
        "80, B",
        "79.99, C",
        "70, C",
        "69.99, D",
        "60, D",
        "59.99, F",
        "0, F",
        "100, A"
    })
    void letterGradeBoundaries(double score, String expected) {
        GradeCalculator calc = new GradeCalculator();

        String result = calc.letterGrade(score);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("Нийлбэр оноог өөр утгуудаар шалгах")
    @CsvSource({
        "10, 40, 10, 10, 30, 100",
        "8, 30, 7, 8, 25, 78",
        "0, 0, 0, 0, 0, 0",
        "5, 20, 5, 5, 15, 50"
    })
    void totalScoreValues(double att, double lab,
                          double quiz1, double quiz2,
                          double exam, double expected) {

        GradeCalculator calc = new GradeCalculator();

        double result = calc.totalScore(
                att, lab, quiz1, quiz2, exam);

        assertEquals(expected, result, 0.001);
    }
}