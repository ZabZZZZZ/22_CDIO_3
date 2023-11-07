class Chancekort {
    

    public void Fremtilstart(Player player){
        player.location = 1;
    }
    public void Femfrem(Player player){
        int felter = 0;

        var v = new java.util.Scanner(System.in);
        System.out.println("Du har trukket chancekortet 'fem felter frem!'. indtast et tal fra 1-5 i terminalen");
        felter = v.nextInt();
        v.close();
        if(felter>5){
            felter = 5;
        }
        if(player.location + felter <=23){
            player.location = player.location + felter;
        }else{
            player.location = player.location + felter - 23;
        }
    }
    public void fremellerom(Player player){
        int choice = 0;
        System.out.println("Tryk 1 for et rykke et felt frem eller tryk 2 for at trække endnu et chancekort");
        var v = new java.util.Scanner(System.in);
        choice = v.nextInt();
        v.close();
        if(choice==1){
            if(player.location + 1 <=24){
                player.location = player.location + felter;
            }
            else{
                player.location = player.location + 1 - 23;
            }
        }
        else{
            //simulatelanding på chancekort felt
        }
    }
    public void fremtilstrand(Player player){
        player.location = 23;
    }
    
    

}

