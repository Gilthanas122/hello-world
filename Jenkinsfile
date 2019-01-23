pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                sh  'gradle build'
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
