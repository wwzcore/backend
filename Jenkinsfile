//Jenkinsfile (Declarative Pipeline)
pipeline{
    agent {label "backend"}
    //设置环境变量
    environment { 
        JENKINS_HOME = '/home/backupend'
    }
    triggers{
        pollSCM('H/25 * * * *')
    }
    stages {
        stage('Build') {
            steps{
                //如果有多行的命令，则必须要加三个引号
                //如果只有一行命令，则可以是一个引号
                sh """ 
                    mvn package
                    """
                echo 'This is a build step' 
            }
        }
        stage('scan') {
            steps{
                //如果有多行的命令，则必须要加三个引号
                //如果只有一行命令，则可以是一个引号
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
                //将产出物扔到外边去
                sh """
                    scp $JENKINS_HOME/workspace/backend/target/jxmall-0.0.1-SNAPSHOT.jar \
                        zxg1990@docker.for.mac.host.internal:/Users/zxg1990/src/demo/front-end-backend-demo/java/
                """
                //保留产出物
                archiveArtifacts artifacts: '*/*.jar', fingerprint: true
                //清空工作区
                cleanWs()

               
            }
        }
        stage('Restart') {
            steps {
                echo "This is restart serve"
                 //重启服务
                //先停服务
                sh """
                 ssh zxg1990@docker.for.mac.host.internal "cd /Users/zxg1990/src/demo/front-end-backend-demo/;sh servedown.sh"
                 ssh zxg1990@docker.for.mac.host.internal "cd /Users/zxg1990/src/demo/front-end-backend-demo/;sh serveup.sh"
                 """
            }

        }

    }
}