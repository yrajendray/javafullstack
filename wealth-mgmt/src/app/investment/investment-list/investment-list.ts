import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

import { InvestmentService } from '../../services/investment';
import { Investment } from '../../models/investment';

import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-investment-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './investment-list.html',
  styleUrl: './investment-list.css'
})
export class InvestmentListComponent implements OnInit {

  investments: Investment[] = [];

  private service = inject(InvestmentService);
  private router = inject(Router);

    private cdr = inject(ChangeDetectorRef);

  ngOnInit(): void {
    this.loadInvestments();
  }

  loadInvestments() {

    this.service.getAllInvestments().subscribe({

      next: (data) => {

        this.investments = data;
        this.cdr.detectChanges();

      },

      error: (err) => {

        console.error(err);

      }

    });

  }

  edit(id: number) {

    this.router.navigate(['/investment/edit', id]);

  }

  delete(id: number) {

    if (confirm('Delete Investment?')) {

      this.service.deleteInvestment(id).subscribe(() => {

        alert('Investment Deleted Successfully');

        this.loadInvestments();

      });

    }

  }

}