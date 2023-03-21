class Boxer {
    String name;
    int weight;
    int damage;
    int health;
    int blockChance;
    int possibleDamage;

    Boxer(String name,int weight,int damage,int health,int blockChance) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
        this.health = health;
        this.blockChance = blockChance;
        this.possibleDamage = 0;
    }

    void hit(Boxer foe) {
        int randomValue = (int) (Math.random() * 100);
        if(randomValue <= blockChance) {
            System.out.println(this.name+" ===> "+foe.name+" BLOKLADI !");
        } else {
            int maxDamage = this.damage + 20 + 1;
            int minDamage = this.damage - 20;
            int range = (maxDamage - minDamage);
            this.possibleDamage = (int) (Math.random() * range) + minDamage;
            System.out.println(this.name+" ===> "+this.possibleDamage+" VURDU !");
            foe.health -= this.possibleDamage;
        }
        if (foe.health - this.possibleDamage < 0) {
            foe.health = 0;
        }
    }
}
