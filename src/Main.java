class Main {
    public static void main(String[] args) {
        Boxer b1 = new Boxer("A",80,70,100,50);
        Boxer b2 = new Boxer("B",90,20,200,50);

        Fight m1 = new Fight(b1,b2,75,100);

        m1.run();






    }
}
