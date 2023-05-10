
public class Market extends SafeLocation{
    public Market(Player player){
        super(player,"Market",2);
    }
    private int choose;
    private boolean playerWantsToLeave = false;


    @Override
    public boolean onLocation(){
        System.out.println("----- WELCOME TO THE MARKET -----");
        System.out.println();

        while (playerWantsToLeave == false){
            System.out.println("1- Weapons\n2- Armor\n0- Leave the Market");
            choose = Player.input.nextInt();
            while (choose < 0 || choose > 3){
                System.out.println("You entered invalid input. Please try again.");
                System.out.println("1- Weapons\n2- Armor\n0- Leave the Market");
            }
            switch (choose){
                case 1:
                    while(choose != 0){
                    System.out.println("----- WEAPONS -----");
                    System.out.println();
                    for(Weapons weapon : Weapons.weaponList){
                        System.out.println("Weapon ID: " + weapon.getWeaponID() + " Weapon Name: " + weapon.getWeaponName() + " Weapon Damage: " + weapon.getWeaponDamage() + " Weapon Price: " + weapon.getWeaponCost());
                    }
                    System.out.println("Press \'0\' to get back to main menu.");
                    System.out.println("Merchant: Which would you like to buy?");
                    choose = Player.input.nextInt();
                    while (choose < 0 || choose > 3){
                        System.out.println("You entered invalid input. Please try again.");
                        System.out.println("1- Pistol\n2- Sword\n3- Rifle\n0- Back to Main Menu");
                    }
                    switch (choose){
                        case 1:
                            buyTheWeapon(choose - 1);
                            break;
                        case 2:
                            buyTheWeapon(choose - 1);
                            break;
                        case 3:
                            buyTheWeapon(choose - 1);
                            break;
                        case 0:
                            System.out.println("Back to Main Menu");
                            break;
                    }
                    }
                    break;
                case 2:
                    while(choose != 0){
                    System.out.println("----- ARMORS -----");
                    System.out.println();
                    for(Armors arm : Armors.armors){
                        System.out.println("Armor ID: " + arm.getArmorID() + " Armor Name:" + arm.getArmorName() + "Armor Defence: " + arm.getArmorDefence() + " Armor Price: " + arm.getArmorCost());
                    }
                        System.out.println("Press \'0\' to get back to main menu.");
                        System.out.println("Merchant: Which would you like to buy?");
                        choose = Player.input.nextInt();
                        while (choose < 0 || choose > 3){
                            System.out.println("You entered invalid input. Please try again.");
                            System.out.println("1- Pistol\n2- Sword\n3- Rifle\n0- Back to Main Menu");
                        }
                        switch (choose){
                            case 1:
                                buyTheArmor(choose - 1);
                                break;
                            case 2:
                                buyTheArmor(choose - 1);
                                break;
                            case 3:
                                buyTheArmor(choose - 1);
                                break;
                            case 0:
                                System.out.println("Back to Main Menu");
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Merchant: Good luck on the path traveler!");
                    playerWantsToLeave = true;
                    break;
                default:
                    System.out.println("YOU HAVE MISTYPED.");
            }
        }
        return true;
    }
    public Weapons buyTheWeapon(int i){
        if(this.getPlayer().getCharacter().getMoney() >= Weapons.getTheWeapon(i).getWeaponCost()){
            System.out.println("You just discarded the " + this.getPlayer().getInventory().getWeapon().getWeaponName());
            this.getPlayer().getCharacter().setDamage((this.getPlayer().getCharacter().getDamage() - this.getPlayer().getInventory().getWeapon().getWeaponDamage()));
            this.getPlayer().getInventory().setWeapon(Weapons.getTheWeapon(i));
            this.getPlayer().getCharacter().setDamage((this.getPlayer().getCharacter().getDamage() + this.getPlayer().getInventory().getWeapon().getWeaponDamage()));
            this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() - this.getPlayer().getInventory().getWeapon().getWeaponCost());
            System.out.println("You are using " + this.getPlayer().getInventory().getWeapon().getWeaponName() + " now with damage " + this.getPlayer().getCharacter().getDamage());
            System.out.println(this.getPlayer().getCharacter().getMoney() + " coins left.");
            this.getPlayer().printPlayerHUD();
        }
        else{
            System.out.println("***** YOU DO NOT HAVE ENOUGH COIN! *****");
            System.out.println("You have " + this.getPlayer().getCharacter().getMoney() + " coins in your pocket.");
            System.out.println("You have to earn " + (Weapons.getTheWeapon(i).getWeaponCost() - this.getPlayer().getCharacter().getMoney()) + " coins to buy " + Weapons.getTheWeapon(i).getWeaponName());
            System.out.println("You are using " + this.getPlayer().getInventory().getWeapon().getWeaponName() + " now with damage " + this.getPlayer().getCharacter().getDamage());
            this.getPlayer().printPlayerHUD();
        }
        return Weapons.getTheWeapon(i);
    }

    public Armors buyTheArmor(int i){
        if(this.getPlayer().getCharacter().getMoney() >= Armors.getTheArmor(i).getArmorCost()){
            System.out.println("You just discarded the " + this.getPlayer().getInventory().getArmor().getArmorName());
            this.getPlayer().getCharacter().setDefence((this.getPlayer().getCharacter().getDefence() - this.getPlayer().getInventory().getArmor().getArmorDefence()));
            this.getPlayer().getInventory().setArmor(Armors.getTheArmor(i));
            this.getPlayer().getCharacter().setDefence((this.getPlayer().getCharacter().getDefence() + this.getPlayer().getInventory().getArmor().getArmorDefence()));
            this.getPlayer().getCharacter().setMoney((this.getPlayer().getCharacter().getMoney() - this.getPlayer().getInventory().getArmor().getArmorCost()));
            System.out.println("You are using " + this.getPlayer().getInventory().getArmor().getArmorName() + " now with defence " + this.getPlayer().getCharacter().getDefence());
            System.out.println(this.getPlayer().getCharacter().getMoney() + " coins left.");
            this.getPlayer().printPlayerHUD();
        }
        else{
            System.out.println("***** YOU DO NOT HAVE ENOUGH COIN! *****");
            System.out.println(("You are using " + this.getPlayer().getInventory().getArmor().getArmorName() + " now with defence " + this.getPlayer().getCharacter().getDefence()));
            System.out.println("You have " + this.getPlayer().getCharacter().getMoney() + " coins in your pocket.");
            System.out.println("You have to earn " + (Armors.getTheArmor(i).getArmorCost() - this.getPlayer().getCharacter().getMoney()) + " coins to buy " + Armors.getTheArmor(i).getArmorName());
            this.getPlayer().printPlayerHUD();
        }
        return Armors.getTheArmor(i);
    }

}
