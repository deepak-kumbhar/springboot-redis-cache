# springboot-redis-cache
This repository consist the simple example of springboot crud application using redis cache

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Clone the application
```git clone https://github.com/deepak-kumbhar/springboot-redis-cache.git```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.redis.SpringbootRedisApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

1. Add blog 

Request: 
```
[
	{
		"id":1,
		"title":"changed blog name",
		"author":"deepak",
		"content":"this is blog 1 content",
		"tags":["java","learning"]
	}
]
```

Response:
```
{
    "id": 1,
    "title": "changed blog name",
    "author": "deepak",
    "content": "this is blog 1 content",
    "tags": [
        "java",
        "learning"
    ]
}
```

2. Get blog by id
Request:
```
Add blog id in path param
```

Response:
```
{
    "id": 1,
    "title": "changed blog name",
    "author": "deepak",
    "content": "this is blog 1 content",
    "tags": [
        "java",
        "learning"
    ]
}
```

Now if you look on the console log message, according to that at first time when you try to get blog it will fetch blog details from DB and when you try again it will fetch the same data from cache as no console log will be going to print. 

When you make any changes(Update) in the same object, then it will update the data and update the cache as well.

