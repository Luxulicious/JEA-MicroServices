import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { PaymentComponent } from './payment/payment.component';
import { RatingComponent } from './rating/rating.component';
import { ReserveComponent } from './reserve/reserve.component';


@NgModule({
  declarations: [
    AppComponent,
    PaymentComponent,
    RatingComponent,
    ReserveComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
