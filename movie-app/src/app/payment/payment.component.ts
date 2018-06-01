import {Component, OnInit, AfterViewChecked} from '@angular/core';
import {UserService} from '../services/user.service';

declare let paypal: any;

@Component({
    selector: 'app-payment',
    templateUrl: './payment.component.html',
    styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

    addScript: boolean = false;
    paypalLoad: boolean = true;
    paymentSuccess: boolean = false;
    finalAmount: number = 10;

    constructor(private userService: UserService) {}

    ngOnInit() {
    }
    
    private sendMail(){
        this.userService.sendMail('ctestemail999@gmail.com', 'Tom', 1)
            .subscribe(response => {
               console.log(response); 
            });
    }
    
    paypalConfig = {
        env: 'sandbox',
        client: {
            sandbox: 'ASf0hM8KCvUkBpgCuZ7Ht66fEga4V-32fs7aw6bgNJ4Opn7di_pi3sr9it3KMwYLNfdQBBwbcdvLfyhS',
            production: ''
        },
        commit: true,
        payment: (data, actions) => {
            return actions.payment.create({
                payment: {
                    transactions: [
                        {amount: {total: this.finalAmount, currency: 'EUR'}}
                    ]
                }
            });
        },
        onAuthorize: (data, actions) => {
            return actions.payment.execute().then((payment) => {
                console.log('payment succeeded');
                this.paymentSuccess = true;
                this.sendMail();
            })
        }
    };

    ngAfterViewChecked(): void {
        if (!this.addScript) {
            this.addPaypalScript().then(() => {
                paypal.Button.render(this.paypalConfig, '#paypal-checkout-btn');
                this.paypalLoad = false;
            })
        }
    }

    addPaypalScript() {
        this.addScript = true;
        return new Promise((resolve, reject) => {
            let scripttagElement = document.createElement('script');
            scripttagElement.src = 'https://www.paypalobjects.com/api/checkout.js';
            scripttagElement.onload = resolve;
            document.body.appendChild(scripttagElement);
        })
    }

}
