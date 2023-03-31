import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Currency } from 'src/app/home/home.component';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  constructor(
    private http : HttpClient
  ) { }

  retrieveAllCurrency() {
      return this.http.get<Currency[]>('http://localhost:8765/currency-exchange/all');
  }
}
