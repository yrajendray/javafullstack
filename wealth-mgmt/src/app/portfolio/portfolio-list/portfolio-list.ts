import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

import { PortfolioService } from '../../services/portfolio';
import { Portfolio } from '../../models/Portfolio';

import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-portfolio-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './portfolio-list.html',
  styleUrl: './portfolio-list.css'
})
export class PortfolioListComponent implements OnInit {

  portfolios: Portfolio[] = [];

  private service = inject(PortfolioService);
  private router = inject(Router);

  private cdr = inject(ChangeDetectorRef);
  

  ngOnInit(): void {
    this.loadPortfolios();
  }

  loadPortfolios() {

    this.service.getAllPortfolios().subscribe({

      next: (data) => {

        this.portfolios = data;
          this.cdr.detectChanges();

      },

      error: (err) => {

        console.error(err);

      }

    });

  }

  edit(id: number) {

    this.router.navigate(['/portfolio/edit', id]);

  }

  delete(id: number) {

    if (confirm('Delete Portfolio?')) {

      this.service.deletePortfolio(id).subscribe(() => {

        alert('Portfolio Deleted Successfully');

        this.loadPortfolios();

      });

    }

  }

}