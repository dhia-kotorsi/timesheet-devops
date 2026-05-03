pipeline {
    agent any

    tools {
        jdk 'JDK-8'
        maven 'Maven-3.9.15'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project with Maven...'
                bat 'mvn clean compile -DskipTests'
            }
        }

        stage('Reset Database') {
            steps {
                echo 'Resetting test database...'
                bat """
                    "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe" -u root -padmin timesheet-devops-db -e "DELETE FROM t_user; ALTER TABLE t_user AUTO_INCREMENT = 1; INSERT INTO t_user (first_name, last_name, date_naissance, role) VALUES ('User1','Last1','1990-01-01','INGENIEUR'),('User2','Last2','1990-01-02','INGENIEUR'),('User3','Last3','1990-01-03','ADMINISTRATEUR'),('User4','Last4','1990-01-04','TECHNICIEN'),('User5','Last5','1990-01-05','INGENIEUR'),('User6','Last6','1990-01-06','CHEF_DEPARTEMENT'),('User7','Last7','1990-01-07','INGENIEUR'),('User8','Last8','1990-01-08','TECHNICIEN'),('User9','Last9','1990-01-09','ADMINISTRATEUR'),('User10','Last10','1990-01-10','INGENIEUR');"
                """
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package -DskipTests'
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}