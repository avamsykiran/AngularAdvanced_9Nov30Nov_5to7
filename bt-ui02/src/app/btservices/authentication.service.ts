import { Injectable } from '@angular/core';
import { BTUser } from './models/btuser';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  users:BTUser[];

  currentUser!:BTUser|undefined;

  constructor() {
    this.users=[
      {userName:'admin',password:'admin',role:"ADMIN"},
      {userName:'user',password:'user',role:"ACCOUNT_HOLDER"}
    ];
   }

   autenticate(userName:string,password:string) : boolean {
    let user:BTUser|undefined = this.users.find(u => u.userName===userName);
    if(user && user.password===password){
      this.currentUser=user;
    }
    return this.isLoggedIn();
   }

   isLoggedIn():boolean{
    return this.currentUser!=null && this.currentUser!=undefined;
   }

   logOut():void{
    this.currentUser=undefined;
   }

   getUserName():string|undefined{
    return this.currentUser?.userName;    
   }

   getRole():string|undefined{
    return this.currentUser?.role;
   }
}
