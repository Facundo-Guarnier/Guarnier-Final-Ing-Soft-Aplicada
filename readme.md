# 01-jhipster

Node version: 16.16.0

```
$ jhipster import-jdl .\library.jh
```

# 02-elk-docker
## Actualizar credenciales
Ejecutar los siguientes 2 comandos. El primero quedará dando error, entonces en la segunda terminar se ejecuta el segundo comando.

```
# Terminal 1
$ docker-compose up

# Terminal 2
$ curl -D- -X POST -u elastic:changeme 'http://localhost:9200/_license/start_basic?acknowledge=true'
```

Web App: ```http://localhost:5601```

# 03-pwa-ionic-angular
Node version: <18.16.0
```
$ npm run start
```

Web App: ```http://localhost:4200/```