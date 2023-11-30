import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/btservices/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  unm:string;
  pwd:string;
  errMsg!:string;
  
  constructor(private authService:AuthenticationService,private router:Router){
    this.unm="";
    this.pwd="";
  }

  formSubmitted(){
    if(this.authService.autenticate(this.unm,this.pwd)){
      this.router.navigateByUrl("");
    }else{
      this.errMsg="Invalid Credits! Login Denied!"
    }
  }
}
