class Board {
    Felt[] board = new Felt[24];
    board[0] = new Felt(0, "Start: Du modtager 2m", -2, "start" );
    board[1] = new Felt(1, "Burgerbaren: Pris: 1m", 1, "brun");
    board[2] = new Felt(2, "Pizzariaet: Pris: 1m", 1, "brun");
    board[3] = new Felt(3,"Chance! Træk et kort", 0, "chance");
    board[4] = new Felt(4,"Slikbutikken: Pris: 1m", 1, "lyseblå");
    board[5] = new Felt(5,"Iskiosken: Pris: 1m", 1, "lyseblå");
    board[6] = new Felt(6,"På besøg i fængsel", 0, "besøg");
    board[8] = new Felt(7,"Museet: Pris: 2m", 2, "lilla");
    board[3] = new Felt(8,"Biblioteket: Pris: 2m", 2, "lilla");
    board[3] = new Felt(9,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(10,"Skaterparken: Pris: 2m", 2, "lysegul");
    board[3] = new Felt(11,"Swimmingpoolen: Pris: 2m", 2, "lysegul");
    board[3] = new Felt(12,"Gratis parkering, bare slap af", 0, "parkering");
    board[3] = new Felt(13,"Spillehallen: Pris: 3m", 3, "rød");
    board[3] = new Felt(14,"Biografen: Pris: 3m", 3, "rød");
    board[3] = new Felt(15,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(16,"Legetøjsbutikken: Pris: 3m", 3, "gul");
    board[3] = new Felt(17,"Dyrehandlen: Pris: 3m", 3, "gul");
    board[3] = new Felt(18,"Gå i fængsel: Du har kørt for hurtigt", 0, "fængsel");
    board[3] = new Felt(19,"Bowlinghallen: Pris: 4m", 4, "grøn");
    board[3] = new Felt(20,"Zoologisk have: Pris: 4m", 4, "grøn");
    board[3] = new Felt(21,"Chance! Træk et kort", 0, "chance");
    board[3] = new Felt(22,"Vandlandet: Pris: 5m", 5, "blå");
    board[3] = new Felt(23,"Strandpromenaden: Pris: 5m", 5, "blå");

}
