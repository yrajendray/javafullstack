import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { Portfolio } from '../models/Portfolio';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  private http = inject(HttpClient);

  private apiUrl = environment.apiUrl;

  getAllPortfolios(): Observable<Portfolio[]> {

    return this.http.get<Portfolio[]>(
      `${this.apiUrl}/api/portfolios`
    );

  }

  getPortfolioById(id: number): Observable<Portfolio> {

    return this.http.get<Portfolio>(
      `${this.apiUrl}/api/portfolios/${id}`
    );

  }

  savePortfolio(portfolio: Portfolio) {

    return this.http.post(
      `${this.apiUrl}/api/portfolios`,
      portfolio
    );

  }

  updatePortfolio(id: number, portfolio: Portfolio) {

    return this.http.put(
      `${this.apiUrl}/api/portfolios/${id}`,
      portfolio
    );

  }

  deletePortfolio(id: number) {

    return this.http.delete(
      `${this.apiUrl}/api/portfolios/${id}`
    );

  }

}