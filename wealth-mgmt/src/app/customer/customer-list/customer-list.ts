import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';

import { CustomerService } from '../../services/customer';
import { Customer } from '../../models/customer';


import { ChangeDetectorRef } from '@angular/core';




@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.css'
})
export class CustomerListComponent implements OnInit {

customers: any[] = [];

title = 'Customer List Component';

  private service = inject(CustomerService);
  private router = inject(Router);

  private cdr = inject(ChangeDetectorRef);

  ngOnInit(): void {
     console.log('Customer List Component Loaded');

      this.loadCustomers();

     
  }

  
ngDoCheck() {
  console.log('Current Customers:', this.customers);
}


 loadCustomers() {

  this.service.getAllCustomers().subscribe({

    next: (data: any) => {

      console.log("Response:", data);

      this.customers = [...data];
      this.cdr.detectChanges();

      console.log("Assigned:", this.customers);

      
setTimeout(() => {
    console.log('After 2 seconds:', this.customers);
    // this.test();
  }, 2000);


    },

    error: (err) => {

      console.error(err);

    }

  });

}

  edit(id: number) {
    this.router.navigate(['/customer/edit', id]);
  }

  delete(id: number) {

    if(confirm('Delete Customer?')){

      this.service.deleteCustomer(id).subscribe(()=>{
          this.loadCustomers();
      });

    }

  }

  test() {
  console.log("Customers:", this.customers);
  alert("Length = " + this.customers.length);
}

}