//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    stages {
        stage('Build') {
            steps{
                //如果有多行的命令，则必须要加三个引号
                //如果只有一行命令，则可以是一个引号
                //sh "touch 1.txt"
                sh """ 
                    mvn package
                    """
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
                archiveArtifacts artifacts: '*/jxmall-0.0.1-SNAPSHOT.jar', fingerprint: true
                cleanWs()
            }
        }
        
    }
}
