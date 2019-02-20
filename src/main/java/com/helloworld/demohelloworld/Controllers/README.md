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

## HTTP REQUEST
[Source](https://developer.mozilla.org/en-US/docs/Web/HTTP/Messages)
* HTTP requests are messages sent by the client to initiate an action on the server. Their start-line contain three elements:
* Contains three elements:
1. HTTP Method
2. The request target, usually a URL, or the absolute path of the protocol, port, and domain are usually characterized by the request context. 
3. The HTTP version, which defines the structure of the remaining message, acting as an indicator of the expected version to use for the response.
### REQUEST HEADER
*  client and the server to pass additional information with the request or the response
*  request-header fields allow the client to pass additional information about the request, and about the client itself, to the server
* 
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


### REQUEST BODY
* optional for an HTTP message but if it is available, then it is used to carry the entity-body associated with the request or response
*  one which carries the actual HTTP request data (including form data and uploaded, etc.) and HTTP response data from the server ( including files, images, etc.)
* requests fetching resources, like GET, HEAD, DELETE, or OPTIONS, usually don't need one.
### Types
* Single-resource bodies, consisting of one single file, defined by the two headers: Content-Type and Content-Length.
* Multiple-resource bodies, consisting of a multipart body, each containing a different bit of information. This is typically associated with HTML Forms.

## HTTP RESPONSE
* The start line of an HTTP response, called the status line, contains the following information:
* The protocol version, usually HTTP/1.1.
* A status code, indicating success or failure of the request. Common status codes are 200, 404, or 302
* A status text. A brief, purely informational, textual description of the status code to help a human understand the HTTP message.

### RESPONSE HEADER
* Header almost the same

### RESPONSE BODY
* Not all responses have one: responses with a status code, like 201 or 204, usually don't.

#### TYPES
* Single-resource bodies, consisting of a single file of known length, defined by the two headers: Content-Type and Content-Length.
* Single-resource bodies, consisting of a single file of unknown length, encoded by chunks with Transfer-Encoding set to chunked.
* Multiple-resource bodies, consisting of a multipart body, each containing a different section of information. These are relatively rare.

## HTTP RESPONSE STATUS CODES
[Source](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
* HTTP response status codes indicate whether a specific HTTP request has been successfully completed.
#### Information responses
* 101 Switching Protocol This code is sent in response to an Upgrade request header by the client, and indicates the protocol the server is switching to.
#### Successful responses
* 200 Ok
* 201 Created
#### Redirection messages
* 300 Multiple choice
* 302 Found
#### Client error responses
* 400 Bad request
* 401 Unauthorised
* 404 Not found
* 408 Request timeout
#### Server error responses
* 500 Internal server error
* 502 Bad gateway
* 503 Service Unavailable

## HTTP - HTTPS
### HTTP
[Source](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)
*  protocol which allows the fetching of resources, such as HTML documents
* foundation of any data exchange on the Web and a client-server protocol, which means requests are initiated by the recipient, usually the Web browser
* The messages sent by the client, usually a Web browser, are called requests and the messages sent by the server as an answer are called responses.
#### Components
##### Client
*  user-agent is any tool that acts on the behalf of the user. This role is primarily performed by the Web browser;
* initiating request
##### Webserver
* On the opposite side of the communication channel, is the server which serves the document as requested by the client. 
##### Proxies
* Between the Web browser and the server, numerous computers and machines relay the HTTP message
* Those operating at the application layers are generally called proxies
* Functions: caching, filtering, load balancing, authentication, logging
#### Basic aspects of HTTP
* SIMPLE -> simple and readable by humans
* EXTENSIBLE -> New functionality can even be introduced by a simple agreement between a client and a server about a new header's semantics.
* STATELESS -> there is no link between two requests being successively carried out on the same connection <-> not sessionsless -> cookies allow the use of stateful sessions
* CONNECTION -> HTTP subsequently relies on the TCP standard, which is connection-based, even though a connection is not always required.
### HTTPS
[Source](https://tiptopsecurity.com/how-does-https-work-rsa-encryption-explained/)
* The HTTP Strict Transport Security header informs the browser that it should never load a site using HTTP and should automatically convert all attempts to access the site using HTTP to HTTPS requests instead.
*  HTTP is not secure because it transports information in plain text
* 1994 new encryption protocol named Secure Socket Layer (SSL) to the original HTTP. This became known as “HTTP over SSL” or “HTTP Secure”. Otherwise known as HTTPS.
* keeps your stuff secret by encrypting it as it moves between your browser and the website’s server
##### You need three things to encrypt your data:
The data you want to encrypt
A unique encryption key (just a long string of random text)
An encryption algorithm (a math function that “garbles” the data)
* symmetric encryption -> same key -> Symmetric encryption, by itself, won’t work because you don’t control the other end of the connection
* assymetric encryption -> key pairs: When one of the keys (either public or private) is used to encrypt some data, only the other key can be used to decrypt it.

## URL
[Source](https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.1.0/com.ibm.cics.ts.internet.doc/topics/dfhtl_uricomp.html)
* URL (Uniform Resource Locator) is a specific type of URI (Universal Resource Identifier)
* URL is used when a web client makes a request to a server for a resource
* URI is defined as any character string that identifies a resource. A URL is defined as those URIs that identify a resource by its location or by the means used to access it, rather than by a name or other attribute of the resource.
### Parts of URL
#### SCHEME
* identifies the protocol to be used to access the resource on the Internet. It can be HTTP (without SSL) or HTTPS (with SSL).
#### PATH
* The path identifies the specific resource in the host that the web client wants to access. For example, /software/htp/cics/index.html.
#### Query string
* Follows the path component, and provides a string of information that the resource can use for some purpose (for example, as parameters for a search or as data to be processed
* Usually a string of name and value pairs; for example, term=bluebird
