# Endpoints
## Params in the Controller methods
### @Requestparam
* retrieve the URL parameter and map it to the method argument.
* mostly in GET requests

### @Pathvariable
*  annotation can be used to handle dynamic URIs where one or more of the URI value works as a parameter
*  we can map the URI variable to one of the method arguments.

### @Modelattribute
*  property of the Model object and is used to prepare the model data. This annotation binds a method variable or the model object to a named model attribute
* can be use on the parameters level (pass in a param) or on method level
* on method level developers can add the values in the Model at a global level + every request, a default value will be there in the controller for every response


## HEADER
*  client and the server to pass additional information with the request or the response
*  request-header fields allow the client to pass additional information about the request, and about the client itself, to the server
### Grouping according to context
* General header: Headers applying to both requests and responses but with no relation to the data eventually transmitted in the body.
* Request header: Headers containing more information about the resource to be fetched or about the client itself.
* Response header: Headers with additional information about the response, like its location or about the server itself (name and version etc.).
* Entity header: Headers containing more information about the body of the entity, like its content length or its MIME-type.
### Grouping proxy handling
#### End-to-end headers
    * These headers must be transmitted to the final recipient of the message; that is, the server for a request or the client for a response. Intermediate proxies must retransmit end-to-end headers unmodified and caches must store them.
#### Hop-by-hop headers
* These headers are meaningful only for a single transport-level connection and must not be retransmitted by proxies or cached. Such headers are: Connection, Keep-Alive, Proxy-Authenticate, Proxy-Authorization, TE, Trailer, Transfer-Encoding and Upgrade. Note that only hop-by-hop headers may be set using the Connection general header.

## Body
* optional for an HTTP message but if it is available, then it is used to carry the entity-body associated with the request or response
*  one which carries the actual HTTP request data (including form data and uploaded, etc.) and HTTP response data from the server ( including files, images, etc.)



