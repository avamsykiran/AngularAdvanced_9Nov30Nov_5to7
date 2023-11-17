import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const adminUserCheckGuard: CanActivateFn = (route, state) => {
  let authService : AuthenticationService = inject(AuthenticationService);
  let router:Router = inject(Router);
  return authService.getRole()=="ADMIN" || 
      (authService.getRole()=="ACCOUNT_HOLDER" && router.createUrlTree(['/accounts'])) ||
      (!authService.isLoggedIn() && router.createUrlTree(['/login']));
};
