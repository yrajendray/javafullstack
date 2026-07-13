import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { InvestmentService } from '../../services/investment';
import { Investment } from '../../models/investment';

@Component({
  selector: 'app-investment-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './investment-form.html',
  styleUrl: './investment-form.css'
})
export class InvestmentFormComponent implements OnInit {

  private service = inject(InvestmentService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  isEdit = false;

  investment: Investment = {
    portfolioId: 0,
    investmentName: '',
    investmentType: '',
    quantity: 0,
    purchasePrice: 0,
    currentPrice: 0,
    totalValue: 0,
    purchaseDate: '',
    status: 'Active'
  };

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEdit = true;

      this.service.getInvestmentById(+id).subscribe({

        next: (data) => {

          this.investment = data;
          this.calculateValue();

        }

      });

    }

  }

  calculateValue() {

    this.investment.totalValue =
      (this.investment.quantity || 0) *
      (this.investment.currentPrice || 0);

  }

  saveInvestment() {

    if (this.isEdit) {

      this.service.updateInvestment(
        this.investment.investmentId!,
        this.investment
      ).subscribe(() => {

        alert('Investment Updated Successfully');

        this.router.navigate(['/investments']);

      });

    } else {

      this.service.saveInvestment(this.investment).subscribe(() => {

        alert('Investment Added Successfully');

        this.router.navigate(['/investments']);

      });

    }

  }

}