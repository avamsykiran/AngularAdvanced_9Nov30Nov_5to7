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
  isReqInProgress!:boolean;
  
  constructor(private authService:AuthenticationService,private router:Router){
    this.unm="";
    this.pwd="";
  }

  formSubmitted(){
    this.isReqInProgress=true;
    this.authService.autenticate(this.unm,this.pwd).subscribe({
      next: isLoggedIn => {
        if(isLoggedIn){
          this.router.navigateByUrl("");
        }else{
          this.errMsg="Invalid Credits! Login Denied!"
        }
      },
      error: err =>{
        console.log(err);
        this.errMsg="Invalid Credits! Or Can not reach Server right now!"
      },
      complete: () => this.isReqInProgress=false
    });
    
  }
}
