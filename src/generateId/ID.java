package generateId;

public class ID {
    private static long counter = 1;
    public static long generateId(){
        return counter++;
    }
}
