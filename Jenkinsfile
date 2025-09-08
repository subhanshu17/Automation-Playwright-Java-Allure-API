pipeline {
  agent any
  tools { jdk 'jdk17'; maven 'maven3' }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build & Test') { steps { sh "mvn -Denv=qa clean test" } }
    stage('Allure Report') { steps { sh "mvn -Denv=qa allure:report" } }
    stage('Publish') { steps { allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] } }
  }
  post { always { archiveArtifacts artifacts: 'target/site/allure-maven-plugin/**', allowEmptyArchive: true } }
}
