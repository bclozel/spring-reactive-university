# Spring Reactive University

## MongoDB should be installed and started

Can be downloaded from here: https://www.mongodb.com/download-center

Start it with [`mongod`](https://docs.mongodb.com/manual/reference/program/mongod/)

## Prepare the authentication tokens

* Get your gitter token from https://developer.gitter.im/apps
* Create a new Github personal access token here: https://github.com/settings/tokens

Add both values as properties in `application-secret.properties` with the configuration
keys `dashboard.github.username`, `dashboard.github.token` and `dashboard.gitter.token`.

## Launching

Application will be be available at http://localhost:8080/