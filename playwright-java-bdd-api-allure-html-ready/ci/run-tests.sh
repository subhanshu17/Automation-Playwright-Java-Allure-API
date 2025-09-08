#!/bin/bash
ENV=${1:-qa}
mvn -Denv=$ENV clean test
mvn -Denv=$ENV allure:report
echo "Allure HTML at target/site/allure-maven-plugin/index.html"
