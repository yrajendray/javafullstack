import { Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login';
import { RegisterComponent } from './auth/register/register';
import { LayoutComponent } from './layout/layout';
import { HomeComponent } from './dashboard/home/home';
import { CustomerListComponent } from './customer/customer-list/customer-list';
import { CustomerFormComponent } from './customer/customer-form/customer-form';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [

  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'register',
    component: RegisterComponent
  },

  {
    path: '',
    component: LayoutComponent,
    canActivate: [authGuard],
    children: [

      {
        path: 'home',
        component: HomeComponent
      },

      {
        path: 'customers',
        component: CustomerListComponent
      },

      {
        path: 'customer/add',
        component: CustomerFormComponent
      },

      {
        path: 'customer/edit/:id',
        component: CustomerFormComponent
      }

    ]
  },

  {
    path: '**',
    redirectTo: 'login'
  }

];