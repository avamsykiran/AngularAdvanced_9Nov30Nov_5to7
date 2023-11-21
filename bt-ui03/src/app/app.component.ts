import { Component } from '@angular/core';
import { NavLink } from './btwidgets/nav-link';
import { AuthenticationService } from './btservices/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  links:NavLink[];
  hideLogout:boolean;

  constructor(private authService:AuthenticationService,private router:Router){
    this.links=[
      {linkPath:"/home",linkText:"Sign In"},
      {linkPath:"/register",linkText:"Sign Up"}
    ];
    this.hideLogout=true;
  }

  ngOnInit(){
    this.authService.notifyUserChange.subscribe({
      next: user => {
        if(user===undefined){
          this.links=[
            {linkPath:"/home",linkText:"Sign In"},
            {linkPath:"/register",linkText:"Sign Up"}
          ];
          this.hideLogout=true;
        }else if(user.role=="ADMIN"){
          this.links=[
            {linkPath:"/home",linkText:"Admin Dashboard"}
          ];
          this.hideLogout=false;
        }else if(user.role=="ACCOUNT_HOLDER"){
          this.links=[
            {linkPath:"/home",linkText:"Accounts"}
          ];
          this.hideLogout=false;
        }
      }
    })
  }

  logOut(){
    this.authService.logOut();
    this.router.navigateByUrl("/");
  }
}