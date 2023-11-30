import { CanMatchFn } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { inject } from '@angular/core';

export const canMatchHomeToAccountsGuard: CanMatchFn = (route, segments) => {
  let authService:AuthenticationService = inject(AuthenticationService);
  return authService.isLoggedIn() && authService.getRole()=='ACCOUNT_HOLDER';
};
