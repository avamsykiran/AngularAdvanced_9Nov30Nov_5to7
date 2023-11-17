import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './welcome/login/login.component';
import { RegisterComponent } from './welcome/register/register.component';
import { anonymousUserCheckGuard } from './btservices/anonymous-user-check.guard';
import { adminUserCheckGuard } from './btservices/admin-user-check.guard';
import { accountHolderUserCheckGuard } from './btservices/account-holder-user-check.guard';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', component: LoginComponent,canActivate:[anonymousUserCheckGuard] },
  { path: 'register', component: RegisterComponent,canActivate:[anonymousUserCheckGuard] },
  { path: 'admins', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),canActivate:[adminUserCheckGuard] },
  { path: 'accounts/:cid', loadChildren: () => import('./accounts/accounts.module').then(m => m.AccountsModule),canActivate:[accountHolderUserCheckGuard] },
  { path: 'statement/:aid', loadChildren: () => import('./statement/statement.module').then(m => m.StatementModule),canActivate:[accountHolderUserCheckGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
