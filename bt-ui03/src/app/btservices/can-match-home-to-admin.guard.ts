import { CanMatchFn } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const canMatchHomeToAdminGuard: CanMatchFn = (route, segments) => {
  let authService:AuthenticationService = inject(AuthenticationService);
  return authService.isLoggedIn() && authService.getRole()=='ADMIN';
};
