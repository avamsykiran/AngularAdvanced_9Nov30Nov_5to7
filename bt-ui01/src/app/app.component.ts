import { Component } from '@angular/core';
import { NavLink } from './btwidgets/nav-link';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  links:NavLink[];

  constructor(){
    this.links=[
      {linkPath:"/login",linkText:"Sign In"},
      {linkPath:"/register",linkText:"Sign Up"}
    ];
  }

  logout(){
    alert("logout is happening");
  }
}
