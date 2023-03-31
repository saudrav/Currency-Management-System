import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JWTAuthenticationService } from '../services/jwtauthentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username = 'saudrav'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  
  constructor(
    private router: Router,
    public jwtAuthenticationService: JWTAuthenticationService
  ) {}

  ngOnInit() {
  }

  handleLogin() {
    // console.log(this.username);
    // if(this.username==="saudrav" && this.password === 'dummy') {
    if(this.jwtAuthenticationService.authenticate(this.username, this.password)) {
        this.invalidLogin = false
        //Redirect to currency-management Page
        this.router.navigate(['currency-management', this.username])
    } else {
      this.invalidLogin = true
    }
  }

}
