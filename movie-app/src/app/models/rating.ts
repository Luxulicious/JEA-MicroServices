export class Rating{
    movieTitle: string;
    currentRank: number;
    numberOfUsersRated: number;
    
    constructor(movieTitle: string, currentRank: number, numberOfUsersRated: number){
        this.movieTitle = movieTitle;
        this.currentRank = currentRank;
        this.numberOfUsersRated = numberOfUsersRated;
    }
}