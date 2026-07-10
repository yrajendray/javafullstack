import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {

  const router = inject(Router);

  const token = localStorage.getItem('token');

  console.log('JWT Token:', token);

  if (token) {
    return true;
  }

  console.log('No token found. Redirecting to login.');

  router.navigate(['/login']);

  return false;
};