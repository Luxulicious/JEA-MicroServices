import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
	{ path: '', redirectTo: '/payment', pathMatch: 'full' },
	{ path: 'payment', component: PaymentComponent }
];

@NgModule({
	exports: [RouterModule],
	imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}


