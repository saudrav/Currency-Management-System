import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CurrencyService } from './currency.service';

@Injectable({
  providedIn: 'root'
})

export class JWTAuthenticationService {

  constructor(
    public route: Router,
    private currencyService : CurrencyService
  ) {}

  authenticate(username: string, password: string) {

    let val : string;

    const requestBody = {
      username: username,
      password: password
    };

    return new Promise((resolve, reject) => {
      this.currencyService.authenticateUser(requestBody)
        .subscribe({
          next: response => {
            console.log(response);
            sessionStorage.setItem('authenticatedUser', response.username);
            sessionStorage.setItem('token', response.token);
            sessionStorage.setItem('role', response.role);
            resolve('SUCCESS');
          },
          error: error => {
            console.error(error);
            reject('UNAUTHORIZED');
          }
        });
    });   
    

    // old Approach  
    // this.currencyService.authenticateUser(requestBody).subscribe(
    //   response => {
    //     console.log(response);
    //     sessionStorage.setItem('authenticatedUser', response.username);
    //     sessionStorage.setItem('token', response.token);
    //     sessionStorage.setItem('role', response.role);
    //   },
    //   error => {
    //     console.error(error);
    //   }
    // );

  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('role')
    this.route.navigate(['home']);
  }

}
