1) mvn versions:display-dependency-updates

[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ....... 3.141.59 -> 4.0.0-beta-1
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0

2) mvn -Dtest=LoginTest test

[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 22.88 s - in tests.LoginTest

3) mvn -Dtest=LoginTest#successfulLogin test

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.81 s - in tests.LoginTest

