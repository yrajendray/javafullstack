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

    this.authService.login(this.loginRequest).subscribe({

      next: (response) => {

        this.authService.saveToken(response.token);

        this.router.navigate(['/home']);

      },

      error: () => {

        this.errorMessage = 'Invalid Username or Password';

      }

    });

  }

}
