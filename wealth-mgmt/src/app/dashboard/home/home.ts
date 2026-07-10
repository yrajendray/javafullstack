import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})

export class HomeComponent {

  totalCustomers = 25;
  totalPortfolios = 18;
  totalInvestments = 150;
  totalValue = '₹4.50 Cr';

}