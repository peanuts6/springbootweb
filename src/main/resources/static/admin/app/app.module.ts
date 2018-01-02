import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {HomeComponent} from "./home/index";
import {ProjectComponent} from "./project/index";
import {LocationStrategy, HashLocationStrategy, APP_BASE_HREF} from '@angular/common';
import {routing} from './app.routing';

@NgModule({
    imports:      [ BrowserModule, routing ],
    declarations: [ AppComponent, HomeComponent, ProjectComponent],
    providers:[{provide: LocationStrategy, useClass: HashLocationStrategy}],
    //providers:[{provide: APP_BASE_HREF, useValue: '/'}], // requires configuring redirects on web server
    bootstrap:    [ AppComponent ]
})
class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);
