# Cucumber Testing (API test and Web test)

API automation test at https://dummyapi.io/ for testing Create, Read, and Delete method. 
Web automation test at https://www.demoblaze.com/ for testing some feature on the website.
The automation testing is created with lessons learned at JayJay School as final project.

# Table of Content
* [Concept Included](#concept-included)
* [Pre-requisites](#prerequisites)
* [Running the Test](#running-the-test)

# Concept Included

- Shared state across cucumber step definitions
- Page Object pattern
- Common web page interaction methods
- Common api interaction methods
- Externalised test configuration
- Commonly used test utility classes

# Prerequisites

## Tools

- Maven
- Cucumber-JVM
- Rest-assured
- JUnit
- Selenium Webdriver

## Requirements

- JDK above version 8
- Gradle version 8.5 or Gradle Wrapper
- Firefox and geckodriver (can be change in config)

## Repository Installing Tutorial

**Clone this repository and navigate to the code directory as shown below :**

```bash
git clone https://github.com/ichsanmp/cucumber_testing
cd cucumber_testing
```

## File Configuration

- Setup testing with code :

```bash
test {
    useJUnitPlatform()
    systemProperty "cucumber.filter.tags", System.getProperty("cucumber.filter.tags")
}
```

- Setup gradle task testing with code :

```bash
configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}
```

- Setup cucumber testing with code :

```bash
tasks.register('webTest') {
    description("Running Cucumber Web Testing")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/cucumber-webtest-report.html',
                    '--plugin', 'pretty',
                    '--glue', 'demoblaze',
                    '--tags', "@web_testing",
                    'src/test/resources/webTesting'
            ]
        }
    }
}

tasks.register('apiTest') {
    description("Running Cucumber API Testing")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/cucumber-apitest-report.html',
                    '--plugin', 'pretty',
                    '--glue', 'dummyAPI_io',
                    '--tags', "@api_testing",
                    'src/test/resources/apiTesting'
            ]
        }
    }
}
```

## Project Structure

```bash
(Name_of_Project)
  src
    test
      java
        demoblaze
          Helper
            utility.java
          Page
            (name_of_page).java
          Runner
            webRunner.java
          StepDefinition
            hooks.java
            (feature).java
        dummyAPI_io
          helper
            jsonSchema
              get_list_userSchema.json
              post_create_userSchema.json
            endpoint.java
            models.java
            utility.java
          page
            (name_of_page).java
          runner
            apiRunner.java
          stepDefinition
            hooks.java
            (feature).java
      resources
        feature
          apiTesting
            (feature).feature
          webTesting
            (feature).feature
```
# Running the Test

**Test Scenario** will be executed in terminal using command line :

- Web Testing
```bash
./gradlew webTest
```

- API Testing
```bash
./gradlew apiTest
```

**Report** from this testing will be saved in the project folder locate at **reports**

## Feature to be tested
- Register and Login Page
- Selecting product and adding product to cart
- Validation total price in cart
- Validation create an order after checkout
- Send CRUD on rest API