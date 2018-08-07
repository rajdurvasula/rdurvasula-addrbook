pipeline {
  agent {
    docker {
      image 'maven:3.5.4-jdk-8'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'mvn --version'
      }
    }
    stage('Execute Script') {
      steps {
        sh 'sh \'mvn --version\''
      }
    }
  }
}