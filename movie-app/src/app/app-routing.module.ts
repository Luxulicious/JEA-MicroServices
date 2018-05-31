import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PaymentComponent} from './payment/payment.component';
import {ReserveComponent} from './reserve/reserve.component';
import {RatingComponent} from './rating/rating.component';

const routes: Routes = [
    //{path: '', redirectTo: '/reserve', pathMatch: 'full'},
    {path: 'reserve', component: ReserveComponent},
    {path: 'rating', component: RatingComponent},
    {path: 'payment', component: PaymentComponent}
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}


