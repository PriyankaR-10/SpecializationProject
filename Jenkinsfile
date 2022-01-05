pipeline {
    agent any
    tools {
         maven 'maven3'
    }
    stages{
        stage('Build'){
            steps{
                  sh script: 'mvn clean package'
            }
        }
        stage('Upload War To Nexus'){
            steps{ 
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'SpringBootRest-3', 
                        classifier: '', 
                        file: 'target/SpringBootRest-3-0.0.1-SNAPSHOT.jar', 
                        type: 'jar'
                    ]
                ], 
                    credentialsId: '59b4ac10-1df6-4993-81d3-c4e96b7bddf2', 
                    groupId: 'com.th', 
                    nexusUrl: '18.219.225.49:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'maven-snapshots', 
                    version: '0.0.1-SNAPSHOT'
            }
        }
    }
 }
