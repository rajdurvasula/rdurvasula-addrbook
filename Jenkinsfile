pipeline {
  agent {
    docker {
      image 'maven:3.5.4-jdk-8'
    }

  }
  stages {
    stage('Execute Script') {
      steps {
        sh '/bin/bash whoami'
      }
    }
  }
}