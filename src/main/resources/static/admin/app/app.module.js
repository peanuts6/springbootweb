"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var platform_browser_dynamic_1 = require("@angular/platform-browser-dynamic");
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var app_component_1 = require("./app.component");
var index_1 = require("./home/index");
var index_2 = require("./project/index");
var common_1 = require("@angular/common");
var app_routing_1 = require("./app.routing");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [platform_browser_1.BrowserModule, app_routing_1.routing],
        declarations: [app_component_1.AppComponent, index_1.HomeComponent, index_2.ProjectComponent],
        providers: [{ provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }],
        //providers:[{provide: APP_BASE_HREF, useValue: '/'}], // requires configuring redirects on web server
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
platform_browser_dynamic_1.platformBrowserDynamic().bootstrapModule(AppModule);
