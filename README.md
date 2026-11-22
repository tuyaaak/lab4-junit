# Лаборатори №4 - Нэгжийн тест JUnit 5

**Оюутны нэр:** С.Туяацэцэг
**Оюутны код:** B210910804

## Ашигласан орчин

**Java:**

```text
$ java -version
openjdk version "25.0.5.0.2" 2026-10-22 LTS
OpenJDK Runtime Environment Microsoft-15804669 (build 25.0.5.0.2+1-LTS)
OpenJDK 64-Bit Server VM Microsoft-15804669 (build 25.0.5.0.2+1-LTS, mixed mode, sharing)
```

**Maven:**

```text
$ mvn -version
Apache Maven 3.10.0 (c43a36b8d67be7e0805a411bc0898af1a51f5472)
Maven home: /usr/local/sdkman/candidates/maven/current
Java version: 25.0.5.0.2, vendor: Microsoft, runtime: /usr/local/sdkman/candidates/java/25.0.5.0+2-ms
Default locale: en, platform encoding: UTF-8, time zone: Etc/UTC
OS name: "linux", version: "6.8.0-1070-azure", arch: "amd64", family: "unix"
```

## 1. GradeCalculator

Нийлбэр оноо болон үсгэн дүн тооцох
хоёр метод бичив.

letterGrade() нь 0-100 оноог үсгэн дүнд
хөрвүүлнэ.

totalScore() нь дараах оноог нийлүүлж бодно.

| Үнэлгээ | Дээд оноо |
|---|---|
| Ирц | 10 |
| Лаб, бие даалт | 40 |
| Сорил 1 | 10 |
| Сорил 2 | 10 |
| Шалгалт | 30 |
| Нийт | 100 |

Хязгаараас гарсан утгад IllegalArgumentException
шиднэ.

## 2. Нэгжийн тест

Тестүүдийг AAA бүтцээр бичиж,
@DisplayName ашигласан.

| Тест | Оролт | Expected |
|---|---|---|
| testGradeA | 95 | A |
| testGradeB | 85 | B |
| testGradeC | 75 | C |
| testGradeD | 65 | D |
| testGradeF | 30 | F |
| testNegativeScore | -1 | Exception |
| testScoreAbove100 | 101 | Exception |
| testTotalScore | 10,40,10,10,30 | 100 |
| testNegativeAttendance | att=-5 | Exception |
| testInvalidLabScore | lab=41 | Exception |

## 3. Parameterized тест

letterGradeBoundaries:

| Оролт | Expected |
|---|---|
| 90 | A |
| 89.99 | B |
| 80 | B |
| 79.99 | C |
| 70 | C |
| 69.99 | D |
| 60 | D |
| 59.99 | F |
| 0 | F |
| 100 | A |

totalScoreValues:

| Ирц | Лаб | Сорил 1 | Сорил 2 | Шалгалт | Нийт |
|---|---|---|---|---|---|
| 10 | 40 | 10 | 10 | 30 | 100 |
| 8 | 30 | 7 | 8 | 25 | 78 |
| 0 | 0 | 0 | 0 | 0 | 0 |
| 5 | 20 | 5 | 5 | 15 | 50 |

## 4. Мутацийн туршилт

Анхны код:

```java
if (score >= 90) return "A";
```

Түр өөрчилсөн код:

```java
if (score > 90) return "A";
```

letterGradeBoundaries тестийн 90 оноотой
тохиолдол унасан.

```text
GradeCalculatorTest.letterGradeBoundaries:135
expected: <A> but was: <B>
Tests run: 24, Failures: 1, Errors: 0, Skipped: 0
BUILD FAILURE
```

90 оноо A биш B болж байгааг тест илрүүлсэн.

Үр дүн: results/mvn-test-mutant.txt

## 5. Эцсийн үр дүн

Мутацийг буцааж сэргээгээд бүх тестийг
дахин ажиллуулав.

| Тестийн төрөл | Метод | Тестийн тоо |
|---|---|---|
| Ердийн тест | 10 | 10 |
| Parameterized | 2 | 14 |
| Нийт | 12 | 24 |

```text
Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Үр дүн: results/mvn-test.txt

## Дүгнэлт

JUnit 5 ашиглан дүн тооцох хоёр методыг шалгав.
Ердийн болон буруу оролтуудад тест бичсэн.
Parameterized тестээр олон утгыг нэг методоор
шалгах боломжтой байсан.
90 онооны хязгаарын тест хамгийн сонирхолтой байв.
Харьцуулах операторыг өөрчлөхөд уг тест унасан.
Ингэснээр ердийн утгаас гадна хязгаарын утгыг
шалгах хэрэгтэйг харсан.
Кодоо сэргээсний дараа бүх 24 тест амжилттай болсон.

## AI туслахын хэрэглээ

ChatGPT ашиглан класс болон тестийн код боловсруулах,
JUnit, Maven, Git командуудыг тайлбарлуулахад
тусламж авсан.
Тест болон мутацийн туршилтыг Codespaces дээр
ажиллуулж, үр дүнг шалгасан.