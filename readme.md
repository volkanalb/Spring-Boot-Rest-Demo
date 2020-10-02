[![CodeFactor](https://www.codefactor.io/repository/github/volkanalb/spring-boot-rest-demo/badge)](https://www.codefactor.io/repository/github/volkanalb/spring-boot-rest-demo)

# Spring Boot Rest Demo
This is an example project to initialize Rest services with Spring Boot. 

## How To Run

```bash
git clone https://github.com/volkanalb/Spring-Boot-Rest-Demo.git
cd Spring-Boot-Rest-Demo
mvn spring-boot:run
```

# REST API

The REST API to the example app is described below. You can also find example [Postman Requests](https://www.getpostman.com/collections/3e9d1e8a493cad9ac4c3) in the link.

## Get list of Models

### Request

`GET /model/`

    curl -i -H 'Accept: application/json' http://localhost:8083/model/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

    []

## Create a new Model

### Request

`POST /model/`

    curl -i -H 'Accept: application/json' -d 'id=1&name=volkan' http://localhost:8083/model

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /model/1
    Content-Length: 36

    {"id":1,"name":"volkan"}

## Get a specific Model

### Request

`GET /model/1`

    curl -i -H 'Accept: application/json' http://localhost:8083/model/1

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

    {"id":1,"name":"volkan"}

## Get a non-existent Model

### Request

`GET /model/2`

    curl -i -H 'Accept: application/json' http://localhost:8083/model/2

### Response

    HTTP/1.1 404 Not Found
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 404 Not Found
    Connection: close
    Content-Type: application/json
    Content-Length: 35

    {"status":404,"reason":"Not found"}

## Create another new Model

### Request

`POST /model/`

    curl -i -H 'Accept: application/json' -d 'id=2&name=albayrak' http://localhost:8083/model

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:31 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /model/2
    Content-Length: 35

    {"id":2,"name":"albarak"}

## Get list of Models again

### Request

`GET /model/`

    curl -i -H 'Accept: application/json' http://localhost:8083/model/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:31 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 74

    [{"id":1,"name":"volkan"},{"id":2,"name":"albayrak"}]

## Change a Model

### Request

`PUT /model/:id`

    curl -i -H 'Accept: application/json' -X PUT -d 'id=2&name=volkan' http://localhost:8083/model

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:31 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 41

    {"id":2,"name":"volkan"}

## Delete a Model

### Request

`DELETE /model/id`

    curl -i -H 'Accept: application/json' -X DELETE http://localhost:8083/model/1/

## Try to delete same Model again

### Request

`DELETE /model/id`

    curl -i -H 'Accept: application/json' -X DELETE http://localhost:8083/model/1/

### Response

    {"status":404,"reason":"Not found"}


## Developed by

Volkan Albayrak

###Hactoberfest commit
