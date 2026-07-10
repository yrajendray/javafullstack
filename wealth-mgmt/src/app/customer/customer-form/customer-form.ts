import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { CustomerService } from '../../services/customer';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-customer-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './customer-form.html',
  styleUrl: './customer-form.css'
})
export class CustomerFormComponent implements OnInit {

  private customerService = inject(CustomerService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  isEdit = false;

  customer: Customer = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    panNumber: '',
    aadhaarNumber: '',
    dob: '',
    gender: '',
    address: '',
    city: '',
    state: '',
    pincode: '',
    riskProfile: '',
    annualIncome: 0
  };

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEdit = true;

      this.customerService.getCustomerById(+id).subscribe({

        next: (data) => {

          this.customer = data;

        },

        error: (err) => console.error(err)

      });

    }

  }

  saveCustomer() {

    if (this.isEdit) {

      this.customerService.updateCustomer(
        this.customer.customerId!,
        this.customer
      ).subscribe({

        next: () => {

          alert('Customer Updated Successfully');

          this.router.navigate(['/customers']);

        },

        error: (err) => console.error(err)

      });

    } else {

      this.customerService.saveCustomer(this.customer).subscribe({

        next: () => {

          alert('Customer Added Successfully');

          this.router.navigate(['/customers']);

        },

        error: (err) => console.error(err)

      });

    }

  }

}