# backend
This a demo of a CRUD Java Spring Boot Student REST API Application with 3 layers :Controller,Service layer and the DAO layer or Repository
with Spring DataJPA and mySQL.
HTTP clients like POSTMANN sends CRUD operations like GET,POST,PUT and Delete to the Controller which layer depends on the Service layer
that also depends on the Repository layer.The DAO layers interacts with the Database and sends back the response to the HTTP REST client.

REST Client like POSTMANN <------GET  --->  Controller layer <-->Bussiness/Service Layer <--->DAO or Repository Layer <-->Database  
                          <------POST--->
                          <------PUT---->
                          <------Delete->
                        


