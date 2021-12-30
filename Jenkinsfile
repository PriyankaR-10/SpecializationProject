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
                script{
                    def mavenPom = readMavenPom file: 'pom.xml'
                nexusArtifactUploader artifacts:[
                    [
                      artifactId: 'SpringBootRest-3', 
                      classifier: '',
                        file: "target/SpringBootRest-3-${mavenPom.version}.war", 
                      type: 'war'
                    ]
                  ],
                  credentialsId: '623a7bba-d3ad-4186-9ff7-62c633b5722c', 
                  groupId: 'com.th',
                  nexusUrl: '3.139.100.136:8081',
                  nexusVersion: 'nexus3',
                  protocol: 'http',
                  repository: 'maven-snapshots',
                  version: '${mavenPom.version}'
            }
        }
    }
 }
