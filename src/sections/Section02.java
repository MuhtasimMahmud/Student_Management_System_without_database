package sections;

public class Section02 {

    private static int seats = 7;

    public Section02(int seats) {
        this.seats = seats;
    }

    public static int getSeats() {
        return seats;
    }

    public static void setSeats(int s) {
        seats = s;
    }
}
