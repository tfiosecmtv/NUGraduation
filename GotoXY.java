public class GotoXY extends State {
    public GotoXY() {
        x2 = (Math.random() * 751) + 0;
        y2 = (Math.random() * 351) + 0;
        x1 = 0.1;
        y1 = 0.1;
        s = "GotoXY";
    }
    public void step(Entity e) {
        if (x2 == 0 && y2 == 0) {
            return;
        } else if (x2 == 0 && y2 < e.position.y) {
            first();
        } else if (x2 > e.position.x && y2 < e.position.y) {
            second();
        } else if (y2 == 0 && x2 > e.position.x) {
            third();
        } else if (x2 > e.position.x && e.position.y < y2) {
            fourth();
        } else if (x2 == 0 && e.position.y < y2) {
            five();
        } else if (x2 < e.position.x && y2 > e.position.y) {
            sixth();
        } else if (x2 < e.position.x && y2 == 0) {
            seventh();
        } else if (x2 < e.position.x && y2 < e.position.y) {
            eighth();
        }
    }
}