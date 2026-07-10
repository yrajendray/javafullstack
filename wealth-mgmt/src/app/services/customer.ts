import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';

import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private http = inject(HttpClient);

  private apiUrl = environment.apiUrl;

  getAllCustomers(): Observable<Customer[]> {

    return this.http.get<Customer[]>(
      `${this.apiUrl}/api/customers`
    );

  }

  getCustomerById(id:number): Observable<Customer>{

      return this.http.get<Customer>(
        `${this.apiUrl}/api/customers/${id}`
      );

  }

  saveCustomer(customer:Customer):Observable<Customer>{

      return this.http.post<Customer>(
        `${this.apiUrl}/api/customers`,
        customer
      );

  }

  updateCustomer(id:number,customer:Customer){

      return this.http.put(
        `${this.apiUrl}/api/customers/${id}`,
        customer
      );

  }

  deleteCustomer(id:number){

      return this.http.delete(
        `${this.apiUrl}/api/customers/${id}`
      );

  }

}