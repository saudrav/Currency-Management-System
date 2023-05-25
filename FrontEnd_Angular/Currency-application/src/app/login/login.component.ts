import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JWTAuthenticationService } from '../services/api/jwtauthentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  username : string;
  password : string;
  errorMessage = 'Invalid Credentials';
  invalidLogin : boolean;

  
  constructor(
    private router: Router,
    public jwtAuthenticationService: JWTAuthenticationService
  ) {}

  ngOnInit() {
  }

  handleLogin() {
    
    this.jwtAuthenticationService.authenticate(this.username, this.password)
      .then( status => {
        console.log('login Status : '+status)
        this.invalidLogin = false;
        //Redirect to currency-management Page
        this.router.navigate(['currency-management', this.username]);
        
      })
      .catch(error => {
        console.error('login Status : '+error);
        // Handle error here        
        this.invalidLogin = true
      });
  }

}
