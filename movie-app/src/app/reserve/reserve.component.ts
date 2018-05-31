import {Component, OnInit} from '@angular/core';
import {Screening} from '../models/screening';
import {ReservationService} from '../services/reservation.service';
import {Seat} from '../models/seat';

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

    private allScreenings: Screening[] = [];
    private selectedScreening: Screening;
    private screeningsSelect: any[] = [];
    private seatOptions: Seat[] = [];
    private selectedSeats: Seat[] = [];
    private name: string = "";

    private reserve(): void {
        let seatNumbers: number[] = [];
        for (let i = 0; i < this.selectedSeats.length; i++) {
            seatNumbers.push(this.selectedSeats[i].seatNumber);
        }
        this.reservationService.reserve(this.selectedScreening.id, seatNumbers, this.name)
            .subscribe(response => {
                //TODO Show success page or give the option to pay ahead of time
            },
                error => {
                    console.log(error);
                });
    }

    private isScreeningSelected(): boolean {
        return this.selectedScreening != null;
    }

    private getAllScreenings(): void {
        this.reservationService.getAllScreenings()
            .subscribe(response => {
                console.log(response);
                this.allScreenings = response;
                this.populateScreeningsSelect(this.allScreenings);

            },
                error => {
                    console.log(error);
                });
    }

    private handleSeatChange(seatId: number): void {
        let seatToRemoveIndex: number = -99999;
        for (let i = 0; i < this.selectedSeats.length; i++) {
            if (this.selectedSeats[i].seatId == seatId) {
                seatToRemoveIndex = i;
                break;
            }
        }
        if (seatToRemoveIndex != -99999) {
            this.selectedSeats.splice(seatToRemoveIndex, 1);
        }
        else {
            let seatToAdd: Seat;
            for (let i = 0; i < this.seatOptions.length; i++) {
                if (this.seatOptions[i].seatId == seatId) {
                    seatToAdd = this.seatOptions[i];
                }
            }
            if (seatToAdd) {
                this.selectedSeats.push(seatToAdd)
            }
        }
        console.log("Seats: " + this.selectedSeats)
    }

    private changedScreening(): void {
        this.selectedSeats = [];
        if (this.isScreeningSelected()) {
            this.populateSeatOptions(this.selectedScreening.seats);
        }
    }

    private populateScreeningsSelect(screenings: Screening[]) {
        this.screeningsSelect = [];
        for (let i = 0; i < screenings.length; i++) {
            this.screeningsSelect.push({value: screenings[i], viewValue: screenings[i].movieTitle + " - " + screenings[i].startTime + " till " + screenings[i].endTime});
        }
    }

    private populateSeatOptions(seats: Seat[]) {
        this.seatOptions = [];
        for (let i = 0; i < seats.length; i++) {
            this.seatOptions.push(seats[i]);
        }
    }
}
