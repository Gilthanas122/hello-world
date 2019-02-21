# DATA FLOW

## Layers

[Source](https://medium.com/@RogelioOrts/layered-architecture-spring-boot-af7dc071d2b5)
* Layered architecture: it’s a client–server architecture in which presentation, application processing, and data management functions are physically separated
* Each layer has different components
### Pros
* Software has divided concerns -> each layer can be modified separately
* Easier to maintain, everything is localised and so easier to locate within the code
* Each project structure is similar
* Other applications can use features from one layer of our layered application
* Maintainability: ow coupling between layers, more testable applications

### Microservices

* Microservices architecture in terms of size is about dividing the features in components according to the single responsibility principle (SRP)
* The policy of a application are the functionality and the details are how the application works to accomplish the policy
* We do not care for the size of the details, only the policy should be small because of the SRP

### Cons
* Very members of the team must know what each layer means and where to add each feature -> not clear which functionality to assign to the given layer
* This misunderstanding could lead to cross dependencies
* Can’t be used for simple application because complexity is added and there is no advantage

### Domain
![alt text](https://github.com/Gilthanas122/hello-world/blob/master/src/main/java/images/imagesforreadme/domain.jpeg "Logo Title Text 1")
* This is the heart of the application, so the domain layer has to be isolated and it can’t depend on another layer of the application
* Domain entities: these are the entities which represents the domain
* Value objects: the difference between entities and value-objects is that two entities are equal when some of their attributes (ID, email,…) are equal and two value-objects only are equals when all their attributes are equals. 
* Factories: in this layer we can add also our entities factories or value-objects factories. We add a factory to our project in order to abstract the creation of the filters
* Business rules: rules that define or constrain some aspect of business and always resolve to either true or false
* Services: they are classes that orchestra workflows. The services are usually in the application layer, but some services require business rules for the orchestration that cannot be extracted
* Abstracted repositories: repositories provide an abstraction of data, so that our application can work with a simple abstraction that has an interface approximating that of a collection

### Infrastructure
* This layer is about how to implement the infrastructure requirements added by the abstracted repositories of the domain layer
* The hard coded configuration or utils of the infrastructure are also included here
* If we need entities/value-objects because the data is differently stored or retrieved than in our domain, this is the place to add them with their corresponding mapper, of course

### Application
* This layer supports the workflow of the application using the domain of the domain layer
* We can find services, exceptions and mappers here. The services are the most important pieces of this layer, they orchestrate the domain objects to fulfil a use case. 

### Presentation
* The presentation layer is about how our clients interact with our application workflow or how the data is presented to the clients. This could be through a REST API, GraphQL, HTML rendered with some template engine, gRPC,… 
* One important thing here is that you shouldn’t expose the internal model, because it makes almost impossible to change the model, so it’d be difficult to evolve the application. A solution for that is creating entities/value-objects in the presentation layer mapped to the domain model with mappers

### Boot
* This layer depends on every other layers previously mentioned and store the MainApplication class which starts the Spring Boot application. Because it depends on the other layers, Spring dependency injection mechanism can inject the annotated components of the others layers

## Source 2 -> 3 layers
[Source](https://www.petrikainulainen.net/software-development/design/understanding-spring-web-application-architecture-the-classic-way/)
![alt text](https://github.com/Gilthanas122/hello-world/blob/master/src/main/java/images/imagesforreadme/layer2.png "Logo Title Text 1")

### Web Layer
* Is the uppermost layer of a web application. It is responsible of processing user’s input and returning the correct response back to the user. The web layer must also handle the exceptions thrown by the other layers. Because the web layer is the entry point of our application, it must take care of authentication and act as a first line of defense against unauthorized users.
* Handles only data transfer objects.
### Service Leyer
* Resides below the web layer. It acts as a transaction boundary and contains both application and infrastructure services. The application services provides the public API of the service layer. They also act as a transaction boundary and are responsible of authorization. The infrastructure services contain the “plumbing code” that communicates with external resources such as file systems, databases, or email servers. Often these methods are used by more than a one application service
* Takes data transfer objects (and basic types) as method parameters. It can handle domain model objects but it can return only data transfer objects back to the web layer.
### Repository layer
* Is the lowest layer of a web application. It is responsible of communicating with the used data storage.
* The repository layer takes entities (and basic types) as method parameters and returns entities (and basic types).

### Components and Layer communication
* The components that belong to a specific layer can use the components that belong to the same layer or to the layer below it
* A data transfer object is an object that is just a simple data container, and these objects are used to carry data between different processes and between the layers of our application
* A domain model consists of three different objects:
1. A domain service is a stateless class that provides operations which are related to a domain concept but aren’t a “natural” part of an entity or a value object
2. An entity is an object that is defined by its identity which stays unchanged through its entire lifecycle
3. A value object describes a property or a thing, and these objects don’t have their own identity or lifecycle. The lifecycle of a value object is bound to the lifecycle of an entity

## MVC
![alt text](https://github.com/Gilthanas122/hello-world/blob/master/src/main/java/images/imagesforreadme/mvc.jpg "Logo Title Text 1")

[Source](https://medium.com/datadriveninvestor/model-view-controller-mvc-75bcb0103d66)

### Model
* It is the representation of information or data that you want to display to user. Model have classes 
* Classes define different parts of your website.

### View
* it is all the front end code via which the website is presented in front of the user (UI/UX). It includes all the CSS, HTML and JavaScript
* Partial View is one of the benefits. Partial view helps you call a specific section of the page without reloading the entire page

### Controller
* It contains all the logic of your website. Controller also has class with the all methods and logics. It acts as the interface between the Model and View

### Pros
* MVC platform is secure and systematic. Most of the programming languages use this platform
* If you use MVC you can use the same code multiple times. Just point the view to the model you want to use
* In MVC it is easy to track bugs and fix them
* Updating code is also easy, code can be easily understood by any programmer if he/she has the understanding of MVC
* It is very handy for large-scale projects

### Cons
* Building MVC means dealing with large number of files. Sometimes for a single webpage you might need 3–5 files
* Complex file structure means your website performance might get affected
* If the programmer is not familiar, he might face problems in tracking the code properly

## Spring Boot Components
[Source](https://www.journaldev.com/7989/key-components-and-internals-of-spring-boot-framework)
### Spring Boot Starters
* Combine a group of common or related dependencies into single dependencies
* Add dependencies to pom.xml or build.gradle -> tedious work
* Spring Boot Starter component combines all related jars into single jar file so that we can add only jar file dependency to our build files. Instead of adding above 4 jars files to our build file, we need to add one and only one jar file: “spring-boot-starter-web” jar file
* Then add “spring-boot-starter-web” jar file dependency to our build file
#### Pros
* Spring Boot Starter reduces defining many dependencies simplify project build dependencies
* Spring Boot Starter simplifies project build dependencies

### Spring Boot AutoConfigurator
* Reduce the Spring Configuration
* No need to define single XML configuration and almost no or minimal Annotation configuration. Spring Boot AutoConfigurator component will take care of providing those information
* With “spring-boot-starter-web” jar file in our project build file, then Spring Boot AutoConfigurator will resolve views, view resolvers etc. automatically
#### Pros
* Spring Boot Starter reduces build’s dependencies and Spring Boot AutoConfigurator reduces the Spring Configuration.
* Spring Boot Starter has a dependency on Spring Boot AutoConfigurator, Spring Boot Starter triggers Spring Boot AutoConfigurator automatically

### Spring Boot CLI
* Spring Boot software to run and test Spring Boot applications from command prompt.
* Spring Boot CLI has introduced a new “spring” command to execute Groovy Scripts from command prompt.

### Spring Boot Actuator
* Providing Management EndPoints to Spring Boot Applications
* Spring Boot Applications Metrics

### Internals of Spring Boot Framework
* Groovy, we don’t need to add some some imports and no need to add some dependencies to Groovy project. When we compile Groovy scripts using Groovy Compiler(groovyc), it will automatically adds all default import statements then compile it
* Groovy Programming language contains a JAR Dependency Resolver to resolve and add all required jar files to Groovy Project classpath
* When we run Groovy Scripts from CLI Command prompt, it uses this main() method to run the Spring Boot Application.

### Grape
* Grape is an Embedded Dependency Resolution engine. Grape is a JAR Dependency Manager embedded into Groovy. Grape lets us quickly add maven repository dependencies to our project classpath to reduce build file definitions.
