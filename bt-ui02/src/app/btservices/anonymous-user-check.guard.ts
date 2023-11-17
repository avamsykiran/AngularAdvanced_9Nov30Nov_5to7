import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const anonymousUserCheckGuard: CanActivateFn = (route, state) => {
  let authService : AuthenticationService = inject(AuthenticationService);
  let router:Router = inject(Router);
  return !authService.isLoggedIn() || 
    (authService.getRole()=="ADMIN" && router.createUrlTree(['/admins'])) ||
    (authService.getRole()=="ACCOUNT_HOLDER" && router.createUrlTree(['/accounts'])) ;
};
