import { Injectable } from '@angular/core';
import { BTUser } from './models/btuser';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  users:BTUser[];

  currentUser!:BTUser|undefined;

  notifyUserChange:BehaviorSubject<BTUser|undefined>;

  constructor() {
    this.users=[
      {userName:'admin',password:'admin',role:"ADMIN"},
      {userName:'user',password:'user',role:"ACCOUNT_HOLDER"}
    ];
    this.notifyUserChange=new BehaviorSubject<BTUser|undefined>(undefined);
   }

   autenticate(userName:string,password:string) : boolean {
    let user:BTUser|undefined = this.users.find(u => u.userName===userName);
    if(user && user.password===password){
      this.currentUser=user;
      this.notifyUserChange.next({...this.currentUser,password:''});
    }
    return this.isLoggedIn();
   }

   isLoggedIn():boolean{
    return this.currentUser!=null && this.currentUser!=undefined;
   }

   logOut():void{
    this.currentUser=undefined;
    this.notifyUserChange.next(undefined);
   }

   getUserName():string|undefined{
    return this.currentUser?.userName;    
   }

   getRole():string|undefined{
    return this.currentUser?.role;
   }
}
