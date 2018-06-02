import {Component, OnInit} from '@angular/core';
import {RatingService} from '../services/rating.service';
import {Rating} from '../models/rating';

@Component({
    selector: 'app-rating',
    templateUrl: './rating.component.html',
    styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
    private movieTitle: string;
    private email: string;
    private ratings: Rating[];

    constructor(private ratingService: RatingService) {}

    ngOnInit() {
        this.getAll();
    }

    private like() {
        this.ratingService.like(this.movieTitle, this.email)
            .subscribe(response => {
                console.log('liked');
                this.getAll();
            },
            error => {
                console.log(error);
            })
    }

    private dislike() {
        this.ratingService.dislike(this.movieTitle, this.email)
            .subscribe(response => {
                console.log('disliked');
                this.getAll();
            },
            error => {
                console.log(error);
            })
    }
    
    private getAll(){
        this.ratingService.getAll()
            .subscribe(response => {
                this.ratings = response;
            },
            error => {
                console.log(error);
            });
    }

}
