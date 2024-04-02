pipeline {
    agent any

    stages {
        stage('Install dependencies') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'scanner'

                    withSonarQubeEnv {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }

        stage('Building images (spring and mongo)') {
            steps {
                script {
                    sh 'docker-compose build'
                }
            }
        }

        stage('Deploy Nexus') {
            steps {
                script {
                    sh 'docker run -d --name nexus sonatype/nexus3'
                }
            }
        }
    }
}
