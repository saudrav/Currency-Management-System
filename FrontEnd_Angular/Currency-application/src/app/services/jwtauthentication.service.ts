import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JWTAuthenticationService {

  constructor(public route: Router) { }

  authenticate(username: string, token: string) : boolean {
    if(username==="saudrav" && token === 'dummy') {
      sessionStorage.setItem('authenticatedUser', username)
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser')
    this.route.navigate(['home']);
  }

}
