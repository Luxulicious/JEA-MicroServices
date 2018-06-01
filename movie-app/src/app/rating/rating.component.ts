import {Component, OnInit} from '@angular/core';
import {RatingService} from '../services/rating.service';

@Component({
    selector: 'app-rating',
    templateUrl: './rating.component.html',
    styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
    private movieTitle: string;
    private email: string;

    constructor(private ratingService: RatingService) {}

    ngOnInit() {
    }

    private like() {
        this.ratingService.like(this.movieTitle, this.email)
            .subscribe(response => {
                console.log('liked');
            },
            error => {
                console.log(error);
            })
    }

    private dislike() {
        this.ratingService.dislike(this.movieTitle, this.email)
            .subscribe(response => {
                console.log('disliked');
            },
            error => {
                console.log(error);
            })
    }

}
