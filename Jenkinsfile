pipeline {
  agent any
  tools {
    maven 'maven 3.9.0'
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  stages {
    stage('Build') {
      steps {
        bat 'mvn surefire-report:report'
        bat 'tree'
      }
    }
  }
  post {
    always {
           publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site', reportFiles: 'surefire-report.html', reportName: 'Surefire Report', reportTitles: '', useWrapperFileDirectly: true])

    }
  }
}