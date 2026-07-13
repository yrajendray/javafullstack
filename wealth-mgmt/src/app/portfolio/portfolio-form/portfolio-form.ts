import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { PortfolioService } from '../../services/portfolio';
import { Portfolio } from '../../models/Portfolio';

@Component({
  selector: 'app-portfolio-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './portfolio-form.html',
  styleUrl: './portfolio-form.css'
})
export class PortfolioFormComponent implements OnInit {

  private service = inject(PortfolioService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  isEdit = false;

  portfolio: Portfolio = {
    customerId: 0,
    portfolioName: '',
    portfolioType: '',
    riskLevel: '',
    totalValue: 0,
    status: 'Active'
  };

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEdit = true;

      this.service.getPortfolioById(+id).subscribe({

        next: (data) => {

          this.portfolio = data;

        },

        error: (err) => console.error(err)

      });

    }

  }

  savePortfolio() {

    if (this.isEdit) {

      this.service.updatePortfolio(
        this.portfolio.portfolioId!,
        this.portfolio
      ).subscribe({

        next: () => {

          alert('Portfolio Updated Successfully');

          this.router.navigate(['/portfolios']);

        }

      });

    } else {

      this.service.savePortfolio(this.portfolio).subscribe({

        next: () => {

          alert('Portfolio Added Successfully');

          this.router.navigate(['/portfolios']);

        }

      });

    }

  }

}