pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                sh  './gradlew build'
            }

            post{
                success{
                    echo 'Now Archiving ....'

                    archiveArtifacts artifacts : '**/*.war'
                }
            }
        }
    }
}
