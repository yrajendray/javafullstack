import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { Investment } from '../models/investment';

@Injectable({
  providedIn: 'root'
})
export class InvestmentService {

  private http = inject(HttpClient);

  private apiUrl = environment.apiUrl;

  getAllInvestments(): Observable<Investment[]> {

    return this.http.get<Investment[]>(
      `${this.apiUrl}/api/investments`
    );

  }

  getInvestmentById(id: number): Observable<Investment> {

    return this.http.get<Investment>(
      `${this.apiUrl}/api/investments/${id}`
    );

  }

  saveInvestment(investment: Investment) {

    return this.http.post(
      `${this.apiUrl}/api/investments`,
      investment
    );

  }

  updateInvestment(id: number, investment: Investment) {

    return this.http.put(
      `${this.apiUrl}/api/investments/${id}`,
      investment
    );

  }

  deleteInvestment(id: number) {

    return this.http.delete(
      `${this.apiUrl}/api/investments/${id}`
    );

  }

}