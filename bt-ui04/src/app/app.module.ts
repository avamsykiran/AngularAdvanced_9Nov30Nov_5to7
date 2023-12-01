import { NgModule, inject } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BTWidgetsModule } from './btwidgets/btwidgets.module';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeModule } from './welcome/welcome.module';
import { AuthenticationService } from './btservices/authentication.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    WelcomeModule,
    BTWidgetsModule,
    HttpClientModule,
    JwtModule.forRoot({
      config:{
        tokenGetter: () => inject(AuthenticationService).getToken()??null
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
