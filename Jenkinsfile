pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  stages {
    stage('Build') {
      steps {
        sh './mvn clean install surefire-report:report'
        sh 'tree'
      }
    }
  }
  post {
    success {
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site', reportFiles: 'surefire-report.html', reportName: 'Surefire Report', reportTitles: '', useWrapperFileDirectly: true])
    }
  }
}