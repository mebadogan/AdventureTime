
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
        System.out.println("What would you like to buy?");
        System.out.println("1- Weapons\n 2- Armor\n 3- Leave the Market");

        while (playerWantsToLeave == false){
            System.out.println("1- Weapons\n 2- Armor\n 3- Leave the Market");
            choose = Player.input.nextInt();
            while (choose < 1 || choose > 3){
                System.out.println("You entered invalid input. Please try again.");
                System.out.println(" 1- Weapons\n 2- Armor\n 3- Leave the Market");
            }
            switch (choose){
                case 1:
                    System.out.println("----- WEAPONS -----");
                    Weapons[] weaponList = {new Pistol(), new Sword(), new Rifle()};
                    for(Weapons weap : weaponList){
                        System.out.println("Weapon ID: " + weap.getWeaponID() + " Weapon Name:" + weap.getWeaponName() + "Weapon Damage: " + weap.getWeaponDamage() + " Weapon Price: " + weap.getWeaponCost());
                    }

                    break;
                case 2:
                    System.out.println("----- ARMORS -----");
                    for(Armors arm : Armors.armors()){
                        System.out.println("Armor ID: " + arm.getId() + " Armor Name:" + arm.getName() + "Armor Defence: " + arm.getDefence() + " Armor Price: " + arm.getArmorCost());
                    }
                    break;
                case 3:
                    System.out.println("Good luck on the path traveler!");
                    playerWantsToLeave = true;
                    break;
                default:
                    System.out.println("YOU HAVE MISTYPED.");
            }
        }
        return true;
    }
}
