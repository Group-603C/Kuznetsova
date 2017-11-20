public class Main {

    public static void main(String[] args){

        Point instance = new Point(4,5,2);

        System.out.println(instance.getX());
        System.out.println(instance.getY());
        System.out.println(instance.getZ());
        System.out.println(instance.distanceTo(instance));
    }
}
