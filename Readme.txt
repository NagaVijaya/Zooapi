As zookeeper, I want to add animals to my zoo.

Rule: Animal should have a name and a type (flying, swimming, walking)

When I add an animalDto
Then it is in my zoo

API Specifications
Resource Summary

URI	HTTP Method	HTTP Status	Description
api/zoo   Post	    200 OK	add animal to zoo.


POST /api/zoo

Request Body:
{
    "name": "tiger",
    "type": "walking"
}

Response Body:
{
    "id": "812e2132-cffa-4bb6-8d17-b13c16b2c9b3",
    "name": "tiger",
    "type": "walking"
}