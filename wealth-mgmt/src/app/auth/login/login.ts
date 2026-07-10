import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../services/auth';
import { LoginRequest } from '../../models/login-request';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class LoginComponent {

  loginRequest: LoginRequest = {
    username: '',
    password: ''
  };

  errorMessage = '';

  private authService = inject(AuthService);
  private router = inject(Router);

  login(): void {

    // Remove old token before login
    localStorage.removeItem('token');
    localStorage.removeItem('username');

    this.authService.login(this.loginRequest).subscribe({

      next: (response: any) => {

        console.log('Login Response:', response);

        // Save JWT Token
        this.authService.saveToken(response.token);

        // Save Username
        localStorage.setItem('username', this.loginRequest.username);

        // Redirect to Home
        this.router.navigate(['/home']);

      },

      error: (err) => {

        console.error(err);

        this.errorMessage = 'Invalid Username or Password';

      }

    });

  }

}