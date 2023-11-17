import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const accountHolderUserCheckGuard: CanActivateFn = (route, state) => {
  let authService : AuthenticationService = inject(AuthenticationService);
  let router:Router = inject(Router);
  return authService.getRole()=="ACCOUNT_HOLDER" || 
      (authService.getRole()=="ADMIN" && router.createUrlTree(['/admins'])) ||
      (!authService.isLoggedIn() && router.createUrlTree(['/login']));
};
