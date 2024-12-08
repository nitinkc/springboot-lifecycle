refer [https://nitinkc.github.io/spring/microservices/springboot-startup/](https://nitinkc.github.io/spring/microservices/springboot-startup/)


# Session Scoped Bean
```bash
curl --location 'localhost:8080/session/get'
```

### Example sequence for Scenario: Collaborative Editing
Imagine a collaborative editing application where multiple API endpoints allow 
a user to update their session-specific editing preferences or perform operations 
concurrently. Each HTTP request might be processed by a separate thread, 
but all updates belong to the same session.

```bash
Request 1 (Tab A): /session/update-preference?key=color&value=blue
Request 2 (Tab B): /session/update-preference?key=font&value=arial
Request 3 (Tab A): /session/preferences

curl --location --request POST 'http://localhost:8080/session/update-preference?key=color&value=blue'
curl --location --request POST 'http://localhost:8080/session/update-preference?key=font&value=arial'
curl --location 'http://localhost:8080/session/preferences'
```

# Prototype Scoped Bean

```bash
curl --location 'localhost:8080/prototype/new'

curl --location 'localhost:8080/prototype/service'
```