//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    stages {
        stage('Build') {
            steps{
                //����ж��е���������Ҫ����������
                //���ֻ��һ������������һ������
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
