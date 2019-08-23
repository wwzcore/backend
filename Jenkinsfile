//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    //设置环境变量
    environment { 
        JENKINS_HOME = '/home/backend'
    }
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
                //将产出物扔到外边去
                sh """
                    scp $JENKINS_HOME/workspace/testpip/target/jxmall-0.0.1-SNAPSHOT.jar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/java/
                """
                //保留产出物
                archiveArtifacts artifacts: '*/*.jar', fingerprint: true
                //清空工作区
                cleanWs()
            }
        }
        
    }
    agent {label "backend"}
    //设置环境变量
    environment { 
        JENKINS_HOME = '/home/frontend'
    }
    stages {
        stage('Build') {
            steps{
                //如果有多行的命令，则必须要加三个引号
                //如果只有一行命令，则可以是一个引号
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
                //将产出物扔到外边去
                //先进行压缩
                //扔外边去
                //解压缩
                sh """
                    cd $JENKINS_HOME/workspace/testpip/
                    tar -cvf dist.tar dist
                    scp $JENKINS_HOME/workspace/testpip/dist.tar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/front-end/
                """
                //保留产出物
                archiveArtifacts artifacts: '*/*.tar ', fingerprint: true
                //清空工作区
                cleanWs()
            }
        }
        
    }
}
