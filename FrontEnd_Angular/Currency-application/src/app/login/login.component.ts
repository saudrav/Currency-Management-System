import { Component } from '@angular/core';
import { Router } from '@angular/router';

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
    private router: Router
    //private hardcodedAuthenticationService: HardcodedAuthenticationService
  ) {}

  ngOnInit() {
  }

  handleLogin() {
    // console.log(this.username);
    if(this.username==="saudrav" && this.password === 'dummy') {
    //if(this.hardcodedAuthenticationService.authenticate(this.username, this.password)) {
      //Redirect to home Page
      this.invalidLogin = false
      this.router.navigate(['currency-management', this.username])
    } else {
      this.invalidLogin = true
    }
  }

}
