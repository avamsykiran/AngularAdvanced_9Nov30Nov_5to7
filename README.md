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

    Widget

        is a reusable component and is completly decoupled to the actual application.

        NavBar
            title, links and hideLogout are the attributes
            logoutClick was an event attribute.

        MsgBox
            type attribute      info/error (accordingly the message box theam must change alert-info/alert-danger)
            msg attribute       is the information to be displayed    
            CLOSE button click must be handled by the main app

            sample template
                <div class="alert p-4">
                    {{msg}}
                    <button type="button">CLOSE</button>
                </div>

    Router Guards

        Are services that verify if a route shall work or not

        CanAcivate
        CanDeactivate
        CanMatch
        CanActivateChild

        CanActivate     return true for the navigation to happen or
                        should return an alternate url tree.

            const routes: Routes = [
                { path: '', pathMatch: 'full', redirectTo: '/login' },
                { path: 'login', component: LoginComponent,canActivate:[anonymousUserCheckGuard] },
                { path: 'dashboard', component: DashBoardComponent,canActivate:[loggedInUserCheckGuard] }
            ];

        CanDeactivate   return true for the current path to be left (navigate from current path to elsewhere).

        CanMatch        return true for the path to be matched or
                        return false for the path to be skipped from matching.

            const routes: Routes = [
                { path: '', pathMatch: 'full', component: LoginComponent,canMatch:[anonymousUserCheckGuard] },
                { path: '', pathMatch: 'full', component: DashBoardComponent,canMatch:[loggedInUserCheckGuard] }
            ];
        