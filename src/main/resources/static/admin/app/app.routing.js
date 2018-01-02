"use strict";
exports.__esModule = true;
var router_1 = require("@angular/router");
var index_1 = require("./home/index");
var index_2 = require("./project/index");
var routes = [
    { path: '', component: index_1.HomeComponent },
    { path: 'project', component: index_2.ProjectComponent }
];
exports.routing = router_1.RouterModule.forRoot(routes);
