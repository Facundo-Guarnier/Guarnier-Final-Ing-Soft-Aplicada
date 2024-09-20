#!/usr/bin/env groovy

node {

    stage('checkout') {
        //! Clona el repositorio y usa la configuración definida en  jenkis
        checkout scm
    }

    stage('check java') {
        //! Verifica si java esta instalado
        sh "java -version"
    }

    dir('01-jhipster') {
        //! Cambia el directorio de trabajo

        stage('clean') {
            //! Permisos y limpieza
            sh "chmod +x mvnw"
            sh "./mvnw -ntp clean -P-webapp"
        }
        stage('nohttp') {
            //! Analiza el estilo del código, similar a EsLint
            sh "./mvnw -ntp checkstyle:check"
        }

        stage('install tools') {
            //! Instala Node y npm
            sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:install-node-and-npm@install-node-and-npm"
        }

        stage('npm install') {
            //! Instala las dependencias de npm
            sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm"
            sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm@npm-install"
        }

        stage('packaging') {
            //! Empaqueta la aplicación
            sh "chmod -R 755 node_modules"
            sh "./mvnw -ntp verify -P-webapp -Pprod -DskipTests"
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }

        def dockerImage
            stage('publish docker') {
                //! Publica la imagen en dockerhub
                withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'DOCKER_REGISTRY_PWD', usernameVariable: 'DOCKER_REGISTRY_USER')]) {
                    sh "./mvnw -ntp jib:build -Djib.to.image=$DOCKER_REGISTRY_USER/01-jhipster:latest -X"
            }
        }

    }
}