class Chancekort {
    

    public void Fremtilstart(Player player){
        player.location = 1;
    }
    public void Femfrem(Player player){
        if(player.location<=19){
            player.location = player.location + 5;
        }else{
            player.location = player.location + 5 - 24;
        }
    }
    
}

