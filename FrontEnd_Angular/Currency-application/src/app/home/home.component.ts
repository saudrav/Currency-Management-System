import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../services/api/currency.service';
import { HttpHeaders } from '@angular/common/http';

export class Currency {
  constructor(
    public id: number,
    public currencyFrom: string,
    public currencyTo: string,
    public currencyRate: number
  ) {}
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  message : String = 'Home Page loading...';
  currs : Currency[] = [];  

  constructor(
    private currencyService : CurrencyService
    ) {}

  ngOnInit() {
    this.fetchAllCurrency();
  }

  fetchAllCurrency() {    
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+sessionStorage.getItem('token'));
    this.currencyService.retrieveAllCurrency(headers).subscribe(
      response => {
        console.log(response);
        this.currs = response;
      }
    )
  }

}


export class Class1{

}

export class Class2{

}
