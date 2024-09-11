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

Node version: 16.16.0

```bash
# Crear proyecto
$ jhipster import-jdl .\library.jh

# Inicar: Windows
$ npm run start:win

# Inicar: Linux
$ npm run start:lin

# Test Backend
mvn test

# Test Frontend
$ npm run test
```


## 02-elk-docker
<div align="center">
    <img src="https://cdn.simpleicons.org/elastic/005571" alt="ELK Logo" width="80">
</div>

### Actualizar credenciales
Ejecutar los siguientes 2 comandos. El primero quedará dando error, entonces en la segunda terminar se ejecuta el segundo comando.

```bash
# Terminal 1
$ docker-compose up

# Terminal 2
$ curl -D- -X POST -u elastic:changeme 'http://localhost:9200/_license/start_basic?acknowledge=true'
```

Web App: ```http://localhost:5601```

## 03-pwa-ionic-angular
<div align="center">
    <img src="https://cdn.simpleicons.org/ionic/3880FF" alt="Ionic Logo" width="80">
</div>

Node version: <18.16.0

```bash
# Inciar
$ npm run start
```

Web App: ```http://localhost:4200/```