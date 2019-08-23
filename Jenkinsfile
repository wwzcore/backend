//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    //���û�������
    environment { 
        JENKINS_HOME = '/home/backend'
    }
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
                //���������ӵ����ȥ
                sh """
                    scp $JENKINS_HOME/workspace/testpip/target/jxmall-0.0.1-SNAPSHOT.jar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/java/
                """
                //����������
                archiveArtifacts artifacts: '*/*.jar', fingerprint: true
                //��չ�����
                cleanWs()
            }
        }
        
    }
}
pipeline{
    agent {label "frontend"}
    //���û�������
    stage('Test') {
            steps{
                echo 'This is a test step2'  
            }
        }
}
