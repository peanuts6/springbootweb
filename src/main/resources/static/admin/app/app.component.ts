import { Component } from '@angular/core';

@Component({
    selector: 'app',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'sec app';
}

// import {Component} from '@angular/core';
// @Component({
//     selector: 'app',
//     template: `
//         <a [routerLink]="['/']">Home</a>
//         <a [routerLink]="['/product']">Product Details</a>
//         <router-outlet></router-outlet>
//     `
// })
// export class AppComponent {}
