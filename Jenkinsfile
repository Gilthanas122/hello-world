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
        stage ('Deploy build in a staging area'){
            steps{
                build job: 'Rueppellii - Practice/pityu_deploy_pipeline'
            }
        }
    }
}
