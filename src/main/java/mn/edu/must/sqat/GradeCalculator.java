// Оюутны нийлбэр оноо болон үсгэн дүн тооцох

package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {

        if (!Double.isFinite(score) || score < 0 || score > 100) {
            throw new IllegalArgumentException("Буруу оноо");
        }

        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";

        return "F";
    }

    public double totalScore(double att, double lab,
                             double quiz1, double quiz2,
                             double exam) {

        if (!Double.isFinite(att) ||
            !Double.isFinite(lab) ||
            !Double.isFinite(quiz1) ||
            !Double.isFinite(quiz2) ||
            !Double.isFinite(exam) ||
            att < 0 || att > 10 ||
            lab < 0 || lab > 40 ||
            quiz1 < 0 || quiz1 > 10 ||
            quiz2 < 0 || quiz2 > 10 ||
            exam < 0 || exam > 30) {

            throw new IllegalArgumentException("Оноо хязгаараас хэтэрсэн");
        }

        return att + lab + quiz1 + quiz2 + exam;
    }
}