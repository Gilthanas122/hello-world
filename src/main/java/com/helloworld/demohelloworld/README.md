## DATA FLOW

### Layers

[Source](https://medium.com/@RogelioOrts/layered-architecture-spring-boot-af7dc071d2b5)
* Layered architecture: it’s a client–server architecture in which presentation, application processing, and data management functions are physically separated
* Each layer has different components
#### Why is it good?
* Software has divided concerns -> each layer can be modified separately
* Easier to maintain, everything is localised and so easier to locate within the code
* Each project structure is similar
* Other applications can use features from one layer of our layered application
* Maintainability: ow coupling between layers, more testable applications

#### Microservices

* Microservices architecture in terms of size is about dividing the features in components according to the single responsibility principle (SRP)
* The policy of a application are the functionality and the details are how the application works to accomplish the policy
* We do not care for the size of the details, only the policy should be small because of the SRP

#### Why is it bad?
* Very members of the team must know what each layer means and where to add each feature -> not clear which functionality to assign to the given layer
* This misunderstanding could lead to cross dependencies
* Can’t be used for simple application because complexity is added and there is no advantage

#### Domain
* This is the heart of the application, so the domain layer has to be isolated and it can’t depend on another layer of the application
* Domain entities: these are the entities which represents the domain
* Value objects: the difference between entities and value-objects is that two entities are equal when some of their attributes (ID, email,…) are equal and two value-objects only are equals when all their attributes are equals. 
* Factories: in this layer we can add also our entities factories or value-objects factories. We add a factory to our project in order to abstract the creation of the filters
* Business rules: rules that define or constrain some aspect of business and always resolve to either true or false
* Services: they are classes that orchestra workflows. The services are usually in the application layer, but some services require business rules for the orchestration that cannot be extracted
* Abstracted repositories: repositories provide an abstraction of data, so that our application can work with a simple abstraction that has an interface approximating that of a collection

#### Infrastructure
* This layer is about how to implement the infrastructure requirements added by the abstracted repositories of the domain layer
* The hard coded configuration or utils of the infrastructure are also included here.
* If we need entities/value-objects because the data is differently stored or retrieved than in our domain, this is the place to add them with their corresponding mapper, of course.

#### Application
* This layer supports the workflow of the application using the domain of the domain layer
* We can find services, exceptions and mappers here. The services are the most important pieces of this layer, they orchestrate the domain objects to fulfil a use case. 

#### Presentation
* The presentation layer is about how our clients interact with our application workflow or how the data is presented to the clients. This could be through a REST API, GraphQL, HTML rendered with some template engine, gRPC,… 
* One important thing here is that you shouldn’t expose the internal model, because it makes almost impossible to change the model, so it’d be difficult to evolve the application. A solution for that is creating entities/value-objects in the presentation layer mapped to the domain model with mappers, 

#### Boot
* This layer depends on every other layers previously mentioned and store the MainApplication class which starts the Spring Boot application. Because it depends on the other layers, Spring dependency injection mechanism can inject the annotated components of the others layers.
