# 01-jhipster

jhipster import-jdl .\library.jh

# 02-elk

docker-compose up 
curl -D- -X POST -u elastic:changeme 'http://localhost:9200/_license/start_basic?acknowledge=true'

App web: http://localhost:5601

# 03-pwa