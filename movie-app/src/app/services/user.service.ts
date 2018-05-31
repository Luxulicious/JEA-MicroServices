import {Injectable} from '@angular/core';
import {baseUrl} from '../api/api-resource';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class UserService {
    private userUrl = baseUrl + 'users/';
    
    constructor(private httpClient: HttpClient){
    }
    
    public sendMail(email: string, name: string, ticketId: number): Observable<any>{
        const url = this.userUrl + 'mail/' + email + '/' + name + '/' + ticketId;
        return this.httpClient.get<any>(url);
    }
}