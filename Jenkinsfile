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
        
}
}
