package sections;

public class Section01 {

    private static int seats = 8;

    public Section01(int seats) {
        this.seats = seats;
    }

    public static int getSeats() {
        return seats;
    }

    public static void setSeats(int s) {
        seats = s;
    }
}
