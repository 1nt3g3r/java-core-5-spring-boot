pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew release'
            }
        }
        stage('Deploy') {
            steps {
                sh 'scp testapp.jar root@134.209.234.164:/root/testapp'
            }
        }
    }
}