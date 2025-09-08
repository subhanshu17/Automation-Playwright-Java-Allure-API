# Playwright + Java + TestNG + Cucumber + API + Allure + Logger + HTML Report (Ready-to-run)

## Prereqs
- Java 11+
- Maven
- (Optional) Allure CLI for opening reports locally

## Run
# default env = qa
mvn -Denv=qa clean test
mvn -Denv=qa allure:report

# open the generated HTML
open target/site/allure-maven-plugin/index.html
