import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {PaymentComponent} from './payment/payment.component';
import {RatingComponent} from './rating/rating.component';
import {ReserveComponent} from './reserve/reserve.component';
import {AppRoutingModule} from './app-routing.module';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {ReservationService} from './services/reservation.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
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
        HttpClientModule,
        AppRoutingModule,
        MatSelectModule,
        MatFormFieldModule,
        MatCardModule,
        FormsModule,
        MatInputModule,
        BrowserAnimationsModule
    ],
    providers: [ReservationService, UserService],
    bootstrap: [AppComponent]

})
export class AppModule {}
