import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Currency } from 'src/app/home/home.component';

@Injectable({
  providedIn: 'root'
})

export class CurrencyService {


  constructor(
    private http : HttpClient
  ) {}

  authenticateUser(requestBody: { username: string; password: string; }) {
    return this.http.post<any>('http://localhost:8765/auth/token', requestBody);
  }

  retrieveAllCurrency(headers : HttpHeaders): Observable<Currency[]> {
      return this.http.get<Currency[]>('http://localhost:8765/currency-exchange/all', {headers});
  }
}
