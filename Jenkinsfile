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
    agent {label "backend"}
    //���û�������
    environment { 
        JENKINS_HOME = '/home/frontend'
    }
    stages {
        stage('Build') {
            steps{
                //����ж��е���������Ҫ����������
                //���ֻ��һ������������һ������
                //sh "touch 1.txt"
                sh """ 
                    yarn install
                    yarn build
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
                //�Ƚ���ѹ��
                //�����ȥ
                //��ѹ��
                sh """
                    cd $JENKINS_HOME/workspace/testpip/
                    tar -cvf dist.tar dist
                    scp $JENKINS_HOME/workspace/testpip/dist.tar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/front-end/
                """
                //����������
                archiveArtifacts artifacts: '*/*.tar ', fingerprint: true
                //��չ�����
                cleanWs()
            }
        }
        
    }
}
