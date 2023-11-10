Advanced Angular Integration With Java Middleware
--------------------------------------------------------------------

    Lab Setup
        1. VS Code for Angular IDE
        2. NodeJS
        3. angular CLI

        4. JDK 1.8
        5. STS Latet for Java IDE
        6. MySQL Community Server

    Angular Modules

        1. Each angular app is hosued inside a top-level module called ROOT MODULE
        2. All other sub-modules are called FEATURE MODULE
        3. Lazy Loading allows a module to be loaded on the client only when requested
        4. Types of Module

            Routing     is used to define the routing config isolatedly.
            
            Routed      is a module whose top-level component is a target for a route.
            
            Domain      ia used to provide a specific feature or domain of the application.
                        For example, for an eCommerce application - SalesModule, DeliveryModule,
                        ConsumerProfileModule ...etc.,

                        ng g m NewModuleName --module parent-module-name --routing --route path-name

            Service     is used to host all services.

            Shared      is used to hold all components, pipes or other angular resources that are common
                        to the entire application.

            Widget      is used to hold reusable, application independent components or pipes or directives.

    Case Study: BudgetTracker

        1. An account can be created on this application by a registered consumer.
        2. A consumer can record as many trnasactions of type CREDIT and DEBIT
        3. The application should generate account statements as needed.


    

