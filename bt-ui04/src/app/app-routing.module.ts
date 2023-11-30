import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './welcome/login/login.component';
import { RegisterComponent } from './welcome/register/register.component';
import { canMatchHomeToLoginGuard } from './btservices/can-match-home-to-login.guard';
import { canMatchHomeToAdminGuard } from './btservices/can-match-home-to-admin.guard';
import { canMatchHomeToAccountsGuard } from './btservices/can-match-home-to-accounts.guard';
import { canActivateRegisterGuard } from './btservices/can-activate-register.guard';
import { canActivateStatementGuard } from './btservices/can-activate-statement.guard';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'home', component: LoginComponent, canMatch:[canMatchHomeToLoginGuard] },
  { path: 'home', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule), canMatch:[canMatchHomeToAdminGuard] },
  { path: 'home', loadChildren: () => import('./accounts/accounts.module').then(m => m.AccountsModule), canMatch:[canMatchHomeToAccountsGuard] },
  { path: 'register', component: RegisterComponent, canActivate:[canActivateRegisterGuard] },
  { path: 'statement/:aid', loadChildren: () => import('./statement/statement.module').then(m => m.StatementModule), canActivate:[canActivateStatementGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
