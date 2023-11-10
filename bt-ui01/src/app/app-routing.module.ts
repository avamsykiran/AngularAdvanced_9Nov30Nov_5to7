import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', component: LoginComponent },
  { path: 'regoster', component: RegisterComponent },
  { path: 'admins', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path: 'accounts/:cid', loadChildren: () => import('./accounts/accounts.module').then(m => m.AccountsModule) },
  { path: 'statement/:aid', loadChildren: () => import('./statement/statement.module').then(m => m.StatementModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
