import { Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login';
import { RegisterComponent } from './auth/register/register';
import { LayoutComponent } from './layout/layout';
import { HomeComponent } from './dashboard/home/home';
import { CustomerListComponent } from './customer/customer-list/customer-list';
import { CustomerFormComponent } from './customer/customer-form/customer-form';
import { PortfolioListComponent } from './portfolio/portfolio-list/portfolio-list';
import { PortfolioFormComponent } from './portfolio/portfolio-form/portfolio-form';
import { InvestmentListComponent } from './investment/investment-list/investment-list';
import { InvestmentFormComponent } from './investment/investment-form/investment-form';
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
      },
      {
     path: 'portfolios',
      component: PortfolioListComponent
      },
    {
    path: 'portfolio/add',
    component: PortfolioFormComponent
    },
    {
      path: 'portfolio/edit/:id',
      component: PortfolioFormComponent
  },{
  path: 'investments',
  component: InvestmentListComponent
},
{
  path: 'investment/add',
  component: InvestmentFormComponent
},
{
  path: 'investment/edit/:id',
  component: InvestmentFormComponent
},

    ]
  },

  {
    path: '**',
    redirectTo: 'login'
  }

];