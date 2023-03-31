import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

export class Currency {
  constructor(
    public id: number,
    public currFrom: string,
    public currTo: string,
    public currRate: number
  ) {}
}

@Component({
  selector: 'app-currency-management',
  templateUrl: './currency-management.component.html',
  styleUrls: ['./currency-management.component.css']
})
export class CurrencyManagementComponent implements OnInit {

  message : String = 'Table will load soon';
  user : String = '';
  //currs : Currency[] = [];  
  currs : Currency[] = [
    new Currency(1, 'USD', 'INR', 82.75),
    new Currency(2, 'EUR', 'INR', 95.50),
    new Currency(3, 'AUD', 'INR', 45.37)
  ];

  constructor(
    private route:ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.user = this.route.snapshot.params['name'];
  }

}
