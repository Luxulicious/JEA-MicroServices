import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {baseUrlReservations} from '../api/api-resource';

@Injectable()
export class ReservationService {

    constructor(private httpClient: HttpClient) {}
    private baseUrl: string = baseUrlReservations;

    public getAllScreenings(): Observable<any> {
        const url: string = this.baseUrl + "getAllScreenings";
        return this.httpClient.get<any>(url);
    }

    public reserve(screeningId: number, seatNumbers: number[], reservedBy: string): Observable<any> {
        const url: string = this.baseUrl + "reserve";
        const headers: HttpHeaders = new HttpHeaders();
        return this.httpClient.post(url, {screeningId: screeningId, seatNumbers: seatNumbers, reservedBy: reservedBy}, {headers: headers})
    }

}
