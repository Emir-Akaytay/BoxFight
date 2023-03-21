class Fight {
    Boxer b1;
    Boxer b2;
    int minWeight;
    int maxWeight;
    int startChance;

    Fight(Boxer b1, Boxer b2, int minWeight, int maxWeight) {
        this.b1 = b1;
        this.b2 = b2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.startChance = (int) (Math.random() * 100);
    }

    void run() {
        if (checkWeight()) {
            System.out.println("\nGerekli Kontroller Yapıldı Maç Başlıyor !...");
            int counter = 1;
            startMatch();
            while((0 <= this.b1.health) && (0 <= this.b2.health)) {
                if (this.startChance <= 50) {
                    System.out.println("\n"+counter+". ROUND ==========");
                    this.b1.hit(this.b2);
                    if (isWin()) {
                        break;
                    }
                    this.b2.hit(this.b1);
                    if (isWin()) {
                        break;
                    }
                    printHeal();
                } else {
                    System.out.println("\n"+counter+". ROUND ==========");
                    this.b2.hit(this.b1);
                    if (isWin()) {
                        break;
                    }
                    this.b1.hit(this.b2);
                    if (isWin()) {
                        break;
                    }
                    printHeal();
                }
                counter++;
            }
        } else {
            System.out.println("Kilo Şartları Sağlanmadığından Maç Oynatılamaz !");
        }
    }

    boolean checkWeight() {
        return ((this.minWeight<= this.b1.weight && this.b1.weight <= this.maxWeight) && (this.minWeight<= this.b2.weight && this.b2.weight <= this.maxWeight));
    }
    boolean isWin() {
        if (this.b1.health == 0) {
            System.out.println("\nKAZANAN OYUNCU : "+this.b2.name);
            System.out.println(this.b1.name+" ===> "+this.b1.health+" CAN ");
            System.out.println(this.b2.name+" ===> "+this.b2.health+" CAN ");
            return true;
        } else if (this.b2.health == 0) {
            System.out.println("\nKAZANAN OYUNCU : "+this.b1.name);
            System.out.println(this.b1.name+" ===> "+this.b1.health+" CAN ");
            System.out.println(this.b2.name+" ===> "+this.b2.health+" CAN ");
            return true;
        } else {
            return false;
        }
    }

    void printHeal() {
        if (this.startChance <= 50) {
            System.out.println("\n"+this.b1.name+" ===> "+this.b1.health+" CAN ");
            System.out.println(this.b2.name+" ===> "+this.b2.health+" CAN ");
        } else {
            System.out.println("\n"+this.b2.name+" ===> "+this.b2.health+" CAN ");
            System.out.println(this.b1.name+" ===> "+this.b1.health+" CAN ");
        }
    }

    void startMatch() {
        if (this.startChance <= 50) {
            System.out.println("Maça "+this.b1.name+" Adlı Oyuncu Başlayacak...");
            System.out.println("\n"+this.b1.name+" ===> "+this.b1.health+" CAN ");
            System.out.println(this.b2.name+" ===> "+this.b2.health+" CAN ");
        } else {
            System.out.println("Maça "+this.b2.name+" Adlı Oyuncu Başlayacak...");
            System.out.println("\n"+this.b2.name+" ===> "+this.b2.health+" CAN ");
            System.out.println(this.b1.name+" ===> "+this.b1.health+" CAN ");
        }
    }

}

