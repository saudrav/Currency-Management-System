import { Component, OnInit } from '@angular/core';
import { JWTAuthenticationService } from '../services/jwtauthentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit{

  constructor(
    public jwtAuthenticationService : JWTAuthenticationService
    ) {}


  ngOnInit() {
    this.jwtAuthenticationService.logout();
  }

}
