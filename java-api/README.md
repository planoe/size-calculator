# Java implementation of Secret Sauce Size Calculator 

## How to set up and launch the application

    $ cd frontend && npm install && webpack && cd ../java-api && mvn clean package && java -jar target/size-calculator-1.0.0.jar server test-config.yml


## Overall design

Dropwizard is used for the Microservice framework. All the code is located into the java-api folder.

Guice was chosen as  dependency injection framework (here its use was simplified through the use of a GuiceBundle).

The app is serving the static assets (HTML and js files) through the use of the AssetBundle. Please note that for convenience reasons as part of this exercise, the assets are generated from the npm & webpack commands to the path *src/main/resources/assets*. Configurable asset bundle could be used for getting static assets outside of the application path.

As the application cannot be served on the same path as the static assets (http://dropwizard.readthedocs.io/en/latest/manual/core.html, section "Serving Assets"), I decided to serve the API under /api

The used testing framework is Spock - I like Spock for its simplicity in the syntax and also better readability

No database was chosen in the scope of this interview exercise. To keep it short, portable and simple, the data is stored in a simple JSON file and read from the application.
However the use of the JSON format was not random - I had in mind to use some kind of document-based databases for a real world application (MongoDB or other), as the size charts are a perfect use case for a document format.

## A few design/technical details

I add to slightly change the calls in the front-end javascript as the api is served under /api

The input data file is configurable in the test-config.yml file

The model design for the object mapping the data of the input file is probably not optimal/consistent (for instance Brand also exist in the api package) - but it is working fine in this exercise. If we had a database instead it would probably not even exist.

The calls are using a DAO under the hood. These DAOs are interfaces, which make it very simple to switch to any other database technology behind. The corresponding implementation would need to be implemented, tested and the only change would be the class mapping in the Guice Module class.

The objects used for the API responses are in the *api/* package. Google's AutoValue was chosen for these value classes.


## To be continued ...
This application is missing a few things for being production-ready. There were not implemented as it is outside of the scope of this  interview exercise.

* A popup when the size is not available - for now the UI is not handling an error case
* Better size prediction - here it is pretty simple it is just looking for the asked size, which is only an integer. It should :
    * Support decimal numbers
    * Try to give the best matching size if the asked measurement is inbetween two sizes. However these business rules are not clear/defined.
    * Provide better error messages if the measurement is out of bounds
* Application health checks
* Documentation of API (for instance with Swagger, there's a Swagger Bundle for that)
* Documentation of code in general
* Make static files more configurable
* Integration tests
* ... I am sure I am forgetting some :)




