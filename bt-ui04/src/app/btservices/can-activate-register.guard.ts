import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

export const canActivateRegisterGuard: CanActivateFn = (route, state) => {
  return !inject(AuthenticationService).isLoggedIn() || (inject(Router).createUrlTree(["/home"]));
};
