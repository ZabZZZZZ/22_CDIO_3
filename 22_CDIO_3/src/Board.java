class Board {
    Felt[] board = new Felt[24];
    board[0] = new Felt(1, "Start: Du modtager 2m", -2, "start" );
    board[1] = new Felt(2, "Burgerbaren: Pris: 1m", 1, "brun");
    board[2] = new Felt(3, "Pizzariaet: Pris: 1m", 1, "brun");
    board[3] = new Felt(4,"Chance! Træk et kort", 0, "chance");
    board[4] = new Felt(5,"Slikbutikken: Pris: 1m", 1, "lyseblå");
    board[5] = new Felt(6,"Iskiosken: Pris: 1m", 1, "lyseblå");
    board[6] = new Felt(7,"På besøg i fængsel", 0, "besøg");
    board[8] = new Felt(8,"Museet: Pris: 2m", 2, "lilla");
    board[3] = new Felt(9,"Biblioteket: Pris: 2m", 2, "lilla");
    board[3] = new Felt(10,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(4,"Skaterparken: Pris: 2m", 2, "lysegul");
    board[3] = new Felt(4,"Swimmingpoolen: Pris: 2m", 2, "lysegul");
    board[3] = new Felt(4,"Gratis parkering, bare slap af", 0, "parkering");
    board[3] = new Felt(4,"Spillehallen: Pris: 3m", 3, "rød");
    board[3] = new Felt(4,"Biografen: Pris: 3m", 3, "rød");
    board[3] = new Felt(4,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(4,"Legetøjsbutikken: Pris: 3m", 3, "gul");
    board[3] = new Felt(4,"Dyrehandlen: Pris: 3m", 3, "gul");
    board[3] = new Felt(4,"Gå i fængsel: Du har kørt for hurtigt", 0, "fængsel");
    board[3] = new Felt(4,"Bowlinghallen: Pris: 4m", 4, "grøn");
    board[3] = new Felt(4,"Zoologisk have: Pris: 4m", 4, "grøn");
    board[3] = new Felt(4,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(4,"Vandlandet: Pris: 5m", 5, "blå");
    board[3] = new Felt(4,"Strandpromenaden: Pris: 5m", 5, "blå");

}
