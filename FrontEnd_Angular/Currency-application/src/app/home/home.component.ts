import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../services/api/currency.service';

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
    this.currencyService.retrieveAllCurrency().subscribe(
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
