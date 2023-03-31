import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CurrencyManagementComponent } from './currency-management/currency-management.component';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path : '' , component: HomeComponent},
  { path : 'login' , component : LoginComponent },
  { path : 'home' , component : HomeComponent },
  { path : 'currency-management/:name' , component : CurrencyManagementComponent},
  { path : '**' , component : ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
