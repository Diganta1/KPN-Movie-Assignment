#Welcome Customer Interest Movie World

In this project we have built a Movie Interest service where it will serach customer interst and based on that application will response back list of movie details.
Endpoint controller part accepts {Id} and search and retrieve interest part of user from database and match it with movie criteria and filter the response.

## Endpoint 

If Id is Valid : 
localhost:8080/api/yourapp/v1/movie/suggestion/customer/id/{1002}

Response :  StatusCode 200

{
    "movieCategory": [
        {
            "title": "Once Upon a Time... in Hollywood",
            "imdb": "https://www.imdb.com/title/tt7131622"
        },
        {
            "title": "The Shawshank Redemption",
            "imdb": "https://www.imdb.com/title/tt0111161"
        }
    ]
}

If Id is not valid : StatusCode 401

{
    "timestamp": "2019-10-02T08:00:00.290+0000",
    "message": "User ID: 1008 does not exists"
}

#H2 database details

We are running database on 8080 port 

Login: http://localhost:8080/console/



Table relationship :

Movie  [OneTOMany]  Actor    (Indicates a movie can have multiple Actors)
Genre -- Wrapper for Genres
Profile  [OneToMany] Interests  (Indicates a customer has many interests)

##Swagger:

Swagger has been implemented 

http://localhost:8080/swagger-ui.html#/customer-controller

JDBC Url: jdbc:h2:mem:testdb

You can implement swagger docs as well


##Exception

Maintained neat exception via ControllerAdvise

UserNotExistsException has been implemented.
