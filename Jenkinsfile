pipeline {
  agent any
  stages {
    stage('Get Base Image') {
      steps {
        sh 'docker pull maven:3.5.4-jdk-8'
      }
    }
    stage('Build Project') {
      steps {
        sh '''export M2_HOME=/opt/maven
export PATH=${PATH}:${M2_HOME}/bin
mvn clean package'''
      }
    }
    stage('Build') {
      steps {
        sh 'docker build -t addrbook_test:1.0.0 .'
      }
    }
    stage('Launch Microservice') {
      steps {
        sh 'docker run --name addrbook_test -d --rm -v /root/.m2:/root/.m2 -p 10080:10080 addrbook_test:1.0.0'
      }
    }
  }
}