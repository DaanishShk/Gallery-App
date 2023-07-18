# Gallery App

This project is a CRUD app that allows the user to view and save images.

[![Java][java]](#)
[![Spring][spring-boot]](#)
[![Thymeleaf][thymeleaf]](#)
[![Postgres][postgresql]](#)

## Description

The application provides the functionality of a simple gallery app. There are two main parts to the app, the viewer and the add/edit section. 

* To save a new image a name, url (preview will be shown if valid) and description are required.
* Saved images are displayed in a responsive 3x3 grid. Pagination and search features are provided.
* Clicking an image shows the stored details with options to edit or delete.

A fallback page is present in case of errors like incorrect or missing site urls. 

## Built with

The following technologies were used for development:
1. [Spring Boot](https://spring.io/projects/spring-boot) - framework for backend in java
2. [Thymeleaf](https://www.thymeleaf.org/) - templating engine to render views
3. [PostgreSQL](https://www.postgresql.org/) - sql database to store image data

## Getting Started
For building and running the application you need:

- [JDK 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) or higher
- [Maven 3](https://maven.apache.org/download.cgi) or higher
- [PostgreSQL](https://www.postgresql.org/download/)

### Running the application locally

Configure the `application.properties` file for connection to your database. Build the project using: 
```
mvn clean install
```

Execute the `main` method in the `GalleryApplication.java` class from your IDE.
The [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) can also be used with the following command:
```shell
mvn spring-boot:run
```

## Demo

View a demo of the project [here](https://gallery-app-production.up.railway.app/).


## Author

Daanish Shaikh - [@github](https://github.com/DaanishShk)\
repo link - [Gallery App](https://github.com/DaanishShk/Gallery-App)


## License

This project is licensed under the MIT License.



[java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[spring-boot]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[thymeleaf]: https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white
[postgresql]: https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white