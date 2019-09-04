//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    //���û�������
    environment { 
        JENKINS_HOME = '/home/backupend'
    }
    triggers{
        pollSCM('H/25 * * * *')
    }
    stages {
        stage('Build') {
            steps{
                //����ж��е���������Ҫ����������
                //���ֻ��һ������������һ������
                sh """ 
                    mvn package
                    """
                echo 'This is a build step' 
            }
        }
        stage('scan') {
            steps{
                //����ж��е���������Ҫ����������
                //���ֻ��һ������������һ������
                sh """ 
                    sonar-scanner
                    """
                echo 'This is a scan step' 
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
                    scp $JENKINS_HOME/workspace/backend/target/jxmall-0.0.1-SNAPSHOT.jar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/java/
                """
                //����������
                archiveArtifacts artifacts: '*/*.jar', fingerprint: true
                //��չ�����
                cleanWs()

               
            }
        }
        stage('Restart') {
            steps {
                echo "This is restart serve"
                 //��������
                //��ͣ����
                sh """
                 ssh zxg1990@docker.for.mac.host.internal "cd /Users/zxg1990/src/demo/front-end-backend-demo/;sh servedown.sh"
                 ssh zxg1990@docker.for.mac.host.internal "cd /Users/zxg1990/src/demo/front-end-backend-demo/;sh serveup.sh"
                 """
            }

        }

    }
}