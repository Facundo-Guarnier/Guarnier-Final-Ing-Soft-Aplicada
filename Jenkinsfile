#!/usr/bin/env groovy

node {
        stage('check java') {
            sh "java -version"
        }

        dir('01-jhipster') {

            stage('clean') {
                sh "chmod +x mvnw"
                sh "./mvnw -ntp clean -P-webapp"
            }

            // stage('check node') {
            //     sh "node -v"
            // }

            // stage('check maven') {
            //     sh "mvnw -version"
            // }

            stage('nohttp') {
                sh "./mvnw -ntp checkstyle:check"
            }

            stage('install tools') {
                sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:install-node-and-npm@install-node-and-npm"
            }

            stage('check npm') {
                sh "npm -v"
            }

            stage('check docker') {
                sh "docker -v"
            }

            stage('check docker-compose') {
                sh "docker-compose -v"
            }


//             // stage('npm install') {
//             //     sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm"
//             // }
//             // stage('backend tests') {
//             //     try {
//             //         // sh "./mvnw -ntp verify -P-webapp"
//             //         sh "mvn test"
//             //     } catch(err) {
//             //         throw err
//             //     } finally {
//             //         junit '**/target/surefire-reports/TEST-*.xml,**/target/failsafe-reports/TEST-*.xml'
//             //     }
//             // }

//             // stage('frontend tests') {
//             //     try {
//             //         // sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm -Dfrontend.npm.arguments='run test'"
//             //         sh "npm run test"
//             //     } catch(err) {
//             //         throw err
//             //     } finally {
//             //         junit '**/target/test-results/TESTS-results-jest.xml'
//             //     }
//             // }

//             // stage('packaging') {
//             //     sh "./mvnw -ntp verify -P-webapp -Pprod -DskipTests"
//             //     archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
//             // }

//             // stage('publish docker') {
//             //     withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'DOCKER_REGISTRY_PWD', usernameVariable: 'DOCKER_REGISTRY_USER')]) {
//             //         sh './mvnw -ntp jib:build'
//             //     }
//             // }
//         }
    }
}