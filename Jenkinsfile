//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    stages {
        stage('Build') {
            steps{
                sh "touch 1.txt"
                echo 'This is a build step' 
            }
        }
        stage('Test') {
            steps{
                echo 'This is a test step'  
            }
        }
        stage('Deploy') {
            steps{
                echo 'This is a deploy step'    
            }
        }
    }
}
