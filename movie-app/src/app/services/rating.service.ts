import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {baseUrlRatings} from '../api/api-resource';

@Injectable()
export class RatingService {
    private baseUrl = baseUrlRatings + 'ratings/';

    constructor(private httpClient: HttpClient) {
    }

    public like(movieTitle: string, email: string) {
        const url: string = this.baseUrl + 'like';
        const headers: HttpHeaders = new HttpHeaders();
        return this.httpClient.put(url, {movieTitle: movieTitle, email: email}, {headers: headers});
    }

    public dislike(movieTitle: string, email: string) {
        const url: string = this.baseUrl + 'dislike';
        const headers: HttpHeaders = new HttpHeaders();
        return this.httpClient.put(url, {movieTitle: movieTitle, email: email}, {headers: headers});
    }
    
    public getAll(): Observable<any>{
        const url: string = this.baseUrl;
        return this.httpClient.get<any>(url);
    }
    
}