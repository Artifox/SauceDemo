>mvn versions:display-dependency-updates
```sh
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ....... 3.141.59 -> 4.0.0-beta-1
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0
```
>mvn clean test -Dtest=LoginTest

```sh
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 22.88 s - in tests.LoginTest
```

Login page:
    1) Valid Login
    2) Empty Login
    3) Invalid Login

Products page:
    1) Add product to cart
    2) Remove produce from cart
    3) Sort products
    4) Open detailed product page
    5) Open cart page

Detailed product page:
    1) Add product to cart
    2) Remove product from cart
    3) Back to all products page
    4) Open cart page

Cart page:
    1) Remove product from cart
    2) Open detailed product page
    3) Back to all products page
    4) Open checkout information page

Checkout information page:
    1) Sent valid form
    2) Sent empty form
    3) Sent invalid form
    4) Cancel action

Checkout overview page:
    1) Finish action
    2) Cancel action
    3) Presence of proper information on the page
