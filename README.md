# E-commerce UI Automation (Java)

UI automation portfolio project built with Java 21, Selenium WebDriver, JUnit 5, and Maven. The tests use the public SauceDemo training application.

## Covered scenarios

- Login with valid and invalid credentials
- Product catalogue visibility and sorting
- Adding and removing products from the cart
- Completing checkout and verifying order confirmation
- Browser setup/teardown and configurable browser settings

## Prerequisites

- JDK 21
- Maven 3.9+
- Chrome or Firefox installed
- Internet access to open https://www.saucedemo.com/

Selenium Manager normally resolves the required browser driver automatically.

## Run

Run all tests:

```bash
mvn clean test
```

Run one test class:

```bash
mvn -Dtest=LoginTests test
```

Run using Firefox:

```bash
mvn -Dbrowser=firefox clean test
```

Run headless:

```bash
mvn -Dheadless=true clean test
```

The default browser is Chrome. Override settings with Maven system properties or edit `src/test/resources/config.properties`.

## Test account

The SauceDemo training site documents `standard_user` and `secret_sauce` as a standard test account. These are public demo credentials, not real user credentials.

## Design

- `pages/`: Page Object Model classes and UI interactions
- `driver/`: WebDriver creation
- `config/`: Configuration loading
- `tests/`: JUnit test scenarios
- `data/`: Test data
- `utils/`: Supporting utilities

## Notes

This is a portfolio/demo project, not a production test suite. Public demo websites can change their UI or availability. Keep assertions focused on observable behavior and update locators if the site changes.
