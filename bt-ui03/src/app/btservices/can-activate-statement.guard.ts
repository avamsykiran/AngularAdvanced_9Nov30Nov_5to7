import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const canActivateStatementGuard: CanActivateFn = (route, state) => {
  let authService:AuthenticationService = inject(AuthenticationService);
  return (authService.isLoggedIn() && authService.getRole()=='ACCOUNT_HOLDER') 
  || (inject(Router).createUrlTree(["/home"]));
};
