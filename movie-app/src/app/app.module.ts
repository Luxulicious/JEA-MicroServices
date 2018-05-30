import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { PaymentComponent } from './payment/payment.component';
import { RatingComponent } from './rating/rating.component';
import { ReserveComponent } from './reserve/reserve.component';
import { AppRoutingModule } from './app-routing.module';
import {UserService} from './services/user.service';


@NgModule({
  declarations: [
    AppComponent,
    PaymentComponent,
    RatingComponent,
    ReserveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
      UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
