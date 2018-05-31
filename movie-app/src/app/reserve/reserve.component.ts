import {Component, OnInit} from '@angular/core';
import {Screening} from '../models/screening';
import {ReservationService} from '../services/reservation.service';

@Component({
    selector: 'app-reserve',
    templateUrl: './reserve.component.html',
    styleUrls: ['./reserve.component.css']
})
export class ReserveComponent implements OnInit {

    constructor(private reservationService: ReservationService) {}

    ngOnInit() {
        this.getAllScreenings();
    }

    public allScreenings: Screening[] = [];
    public selectedScreening: Screening;
    public screeningsSelect: any[] = [];

    private getAllScreenings(): void {
        this.reservationService.getAllScreenings()
            .subscribe(response => {
                console.log(response);
                this.allScreenings = response;
                this.populateScreeningSelect(this.allScreenings);
            },
                error => {
                    console.log(error);
                });
    }

    private populateScreeningSelect(screenings: Screening[]) {
        for (let i = 0; i < screenings.length; i++) {
            this.screeningsSelect.push({value: screenings[i], viewValue: screenings[i].movieTitle + " - " + screenings[i].startTime + " till " + screenings[i].endTime});
        }
    }

}
