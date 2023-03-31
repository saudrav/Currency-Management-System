import { Component, OnInit } from '@angular/core';
import { JWTAuthenticationService } from '../services/jwtauthentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent  implements OnInit {
  isUserLoggedIn : boolean = false;

  constructor(
    public jwtAuthenticationService: JWTAuthenticationService
    ) { }

  ngOnInit() {
    this.isUserLoggedIn = this.jwtAuthenticationService.isUserLoggedIn();
  }

}
