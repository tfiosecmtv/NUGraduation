public class ZigZag extends State {

    public ZigZag() {
        x1 = 0.1;
        y1 = 0.1;
        s = "Zigzag";
    }

    public void step(Entity e) {
        if ((e.position.x >= 0 && e.position.y >= 0) && (e.position.x <= 750 && e.position.y <= 350)) {

        } else if (e.position.y <= 0) {
            int randomInt = (int) (Math.random() * 5);
            if (randomInt == 0) {
                third();
            }
            if (randomInt == 1) {
                fourth();
            }
            if (randomInt == 2) {
                five();
            }
            if (randomInt == 3) {
                sixth();
            }
            if (randomInt == 4) {
                seventh();
            }
        } else if (e.position.x >= 750) {
            int randomInt = (int) (Math.random() * 5);
            if (randomInt == 0) {
                first();
            }
            if (randomInt == 1) {
                five();
            }
            if (randomInt == 2) {
                sixth();
            }
            if (randomInt == 3) {
                seventh();
            }
            if (randomInt == 4) {
                eighth();
            }
        } else if (e.position.y >= 350) {
            int randomInt = (int) (Math.random() * 5);
            if (randomInt == 0) {
                first();
            }
            if (randomInt == 1) {
                second();
            }
            if (randomInt == 2) {
                third();
            }
            if (randomInt == 3) {
                seventh();
            }
            if (randomInt == 4) {
                eighth();
            }
        } else if (e.position.x <= 0) {
            int randomInt = (int) (Math.random() * 5);
            if (randomInt == 0) {
                first();
            }
            if (randomInt == 1) {
                second();
            }
            if (randomInt == 2) {
                third();
            }
            if (randomInt == 3) {
                fourth();
            }
            if (randomInt == 4) {
                five();
            }
        }
    }
}