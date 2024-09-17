<div align="center">
  <img src="https://um.edu.ar/wp-content/themes/um/img/logo--header.png" alt="Logo de la Universidad de Mendoza" width="100">
</div>

# Descripción

Proyecto final para la materia "Ingeniería de Software Aplicada" cursada en el 2° semestre de 2023 en la Universidad de Mendoza.

# Objetivos

Crear una aplicación donde se apliquen los conceptos aprendidos durante el cursado.

* Crear una aplicación en JHipster basado en un modelo de clases jdl.
* Crear dos test de unidad. R: Test en AdminUserDTOTest y UserDTOTest.
* Crear tres test E2E en Cypress. Algunos de los test deberán hacer el login utilanzo la API y para luego probar alguna funcionalidad.
* Hacer un deploy en docker.
* Implementar un servidor de logs (ELK) que tome los logs en docker.
* Crear una aplicación progresiva en ionic que consuma una API del proyecto JHipste.
* Convertir la aplicación Ionic en PWA permitiendo que pueda funcionar sin conexión.
* Implementar un servidor de integración contínua (Jenkins) que lea el repositorio y genere una imagen docker de la aplicación (Dockerhub).

## 01-jhipster

<div align="center">
  <img src="https://cdn.simpleicons.org/jhipster/326690" alt="JHipster Logo" width="80">
</div>

### Dependencias:

* Node version: 16.16.0
* Java: ``$ sudo apt install openjdk-17-jre-headless``
* Cypres: ``$ sudo apt-get install libgtk2.0-0 libgtk-3-0 libgbm-dev libnotify-dev libnss3 libxss1 libasound2 libxtst6 xauth xvfb``
* Maven: ``$ sudo apt install maven``
* Yeoman: ``$ npm install -g yo``
* JHipster: ``$ npm install -g generator-jhipster``

### Comandos:

```bash
# Crear proyecto
$ jhipster import-jdl .\library.jh

# Inicar: Windows
$ npm run start:win

# Inicar: Linux
$ npm run start:lin

# Test Backend
$ mvn test

# Test Frontend
$ npm run test

# Test e2e
$ npm run cypress
```

## 02-elk-docker

<div align="center">
    <img src="https://cdn.simpleicons.org/elastic/005571" alt="ELK Logo" width="80">
</div>

### Dependencias:

* Docker

### Actualizar credenciales

Ejecutar los siguientes 2 comandos. El primero quedará dando error, entonces en la segunda terminar se ejecuta el segundo comando.

```bash
# Terminal 1
$ docker-compose up

# Terminal 2
$ curl -D- -X POST -u elastic:changeme 'http://localhost:9200/_license/start_basic?acknowledge=true'
```

Web App: [``http://localhost:5601``](http://localhost:5601)
Archivo con logs personalizados: ``01-jhipster\src\main\java\guarnier\um\web\rest\UserResource.java`` -> ``getAllUsers()``
Ingresar en [``http://localhost:5601/app/discover``](http://localhost:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:60000),time:(from:now-15m,to:now))&_a=(columns:!(),filters:!(),index:'logs-*',interval:auto,query:(language:kuery,query:'LOG%20EN%20GET%20ALL%20USERS'),sort:!(!('@timestamp',desc)))) y buscar ``LOG EN GET ALL USERS``

## 03-pwa-ionic-angular

<div align="center">
    <img src="https://cdn.simpleicons.org/ionic/3880FF" alt="Ionic Logo" width="80">
</div>

### Dependencias:

* Node version: > 18.16.0

### Comandos:

```bash
# Inciar
$ npm run start:dev
```

Web App: [``http://localhost:4200/``](http://localhost:4200/)


## 04-jenkins

### Comandos: 

```bash
# Inicializar Jenkins en el proyecto
$ jhipster ci-cd

# Imagen docker
$ docker container run -d --name jenkins -p 8090:8080 -p 50000:50000 jenkins/jenkins


```

User: admin
Password: 45047bbf915a42a2a110bdaa40d5e1ed
Web App: [``http://localhost:8090/``](http://localhost:8090/)