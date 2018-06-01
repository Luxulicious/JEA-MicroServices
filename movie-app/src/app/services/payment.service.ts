import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {baseUrlReservations} from '../api/api-resource';

@Injectable()
export class PaymentService {
    private baseUrl = baseUrlReservations;
    public reservedBy: string = "";
    public seatNumbers: number[] = [];
    public screeningId: number;

    constructor(private httpClient: HttpClient) {
    }

    public markAsPayed() {
        const url: string = this.baseUrl + "markAsPayed";
        const headers: HttpHeaders = new HttpHeaders();
        return this.httpClient.put(url, {screeningId: this.screeningId, seatNumbers: this.seatNumbers, reservedBy: this.reservedBy}, {headers: headers});
    }
}