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
      `${this.apiUrl}/customers`
    );

  }

  getCustomerById(id:number): Observable<Customer>{

      return this.http.get<Customer>(
        `${this.apiUrl}/customers/${id}`
      );

  }

  saveCustomer(customer:Customer):Observable<Customer>{

      return this.http.post<Customer>(
        `${this.apiUrl}/customers`,
        customer
      );

  }

  updateCustomer(id:number,customer:Customer){

      return this.http.put(
        `${this.apiUrl}/customers/${id}`,
        customer
      );

  }

  deleteCustomer(id:number){

      return this.http.delete(
        `${this.apiUrl}/customers/${id}`
      );

  }

}