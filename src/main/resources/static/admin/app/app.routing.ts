import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/index";
import {ProjectComponent} from "./project/index";

const routes: Routes = [
    {path: '',        component: HomeComponent},
    {path: 'project', component: ProjectComponent}
];

export const routing = RouterModule.forRoot(routes);
