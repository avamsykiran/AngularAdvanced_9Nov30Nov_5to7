import { inject } from '@angular/core';
import { CanMatchFn } from '@angular/router';
import { AuthenticationService } from './authentication.service';

export const canMatchHomeToLoginGuard: CanMatchFn = (route, segments) => {
  return !inject(AuthenticationService).isLoggedIn();
};
