import {Seat} from "./seat";

export class Screening {
    id: number;
    movieTitle: string;
    startTime: Date;
    endTime: Date;
    price: number;
    seats: Seat[];

    /*
    public toString(): string {
        return this.movieTitle + " - " + this.startTime + " till " + this.endTime;
    }
    */
}
