import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Currency } from '../home/home.component';
import { CurrencyService } from '../services/api/currency.service';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-currency-management',
  templateUrl: './currency-management.component.html',
  styleUrls: ['./currency-management.component.css']
})
export class CurrencyManagementComponent implements OnInit {

  message : String = 'Table will load soon';
  user : String = '';
  currs : Currency[] = [];

  constructor(
    private route:ActivatedRoute,
    private currencyService : CurrencyService
  ) {}

  ngOnInit() {
    this.user = this.route.snapshot.params['name'];
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
