import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { JWTAuthenticationService } from './jwtauthentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(public jwtAuthenticationService: JWTAuthenticationService,
    public route: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.jwtAuthenticationService.isUserLoggedIn()) {
      return true;
    }
    this.route.navigate(['home']);
    return false;
  }

}
