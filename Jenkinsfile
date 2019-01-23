pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                sh  'gradle buildg'
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
