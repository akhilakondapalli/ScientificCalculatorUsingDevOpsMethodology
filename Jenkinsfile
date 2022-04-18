pipeline {
   
    agent any

    stages {
        stage('Step 1 : Git Clone') {
            steps {
                script{
                    git branch : 'main' , url : "https://github.com/akhilakondapalli/ScientificCalculatorUsingDevOpsMethodology.git"
                }
            }
            
        }
        
        stage('Step 2 : Maven Build'){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }
        
        stage('Step 3 :Build Docker Image'){
            steps{
                script{
                    imageName = docker.build "akhila7113/scientificcalculator"
                }
            }
        }
        
        stage('Step 4 : push image to docker hub'){
            steps{
                script{
                    docker.withRegistry('','docker-jenkins'){
                        imageName.push()
                    }
                }
            }
        }
        
        stage('Step 5 : Ansible pull image from docker hub'){
            steps{
                script{
                    ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'deploy-docker/inventory', playbook: 'deploy-docker/deploy-image.yml', sudoUser: null
                    }
                }
            }
        }
        
}

