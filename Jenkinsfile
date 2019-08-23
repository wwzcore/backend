//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    stages {
        stage('Build') {
            steps{
                touch 1.txt
                echo 'This is a build step' 
            }
        }
        stage('Test') {
            steps{
                touch 2.txt
                echo 'This is a test step'  
            }
        }
        stage('Deploy') {
            steps{
                touch 3.txt
                echo 'This is a deploy step'    
            }
        }
    }
}
