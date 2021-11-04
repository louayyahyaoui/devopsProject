pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git ..."; 
                git branch: "master", 
                    url: "https://github.com/jmaiiomar/devopsProject.git";
            }
        }
        stage('Run Unit Tests') {
            steps {
                echo 'Run unit tests from the source code' 
            }
        }

        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
       
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
