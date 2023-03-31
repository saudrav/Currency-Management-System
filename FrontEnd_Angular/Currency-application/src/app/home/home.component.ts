import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  message : String = 'Home Page loading...';

  constructor() {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}

export class Class1{

}

export class Class2{

}
