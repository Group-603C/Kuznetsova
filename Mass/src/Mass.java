import java.util.Scanner;
import java.util.Arrays;


public class Mass
{

    public static void main(String[] args)
    {
        Scanner mass = new Scanner(System.in);
        int length;

        System.out.print("Введите число - ");
        length = mass.nextInt();

        int[] array = new int[length];

        System.out.print("Введите элементы массива - \n ");
        for (int i = 0; i < length; i++)
        {
            array[i] = mass.nextInt();
        }

        System.out.println("Min - " + FindMinimum(array));
        System.out.println("Max - " + FindMaximum(array));
        System.out.println("Average - " + FindAverage(array));
        System.out.println("Median - " + FindMedian(array));
        System.out.println("Geometric Average - " + FindGeometricAverage(array));


    }


    public static int FindMinimum(int[] entities)
    {
        int minimum = Integer.MAX_VALUE;

        if( (entities == null) || (entities.length==0)  )
        {
            return minimum;
        }

        for (int j: entities)
        {
            minimum = Math.min(minimum, j);
        }

        return minimum;
    }

    public static int FindMaximum(int[] entities)
    {
        int maximum = Integer.MIN_VALUE;

        if( (entities == null) || (entities.length==0)  )
        {
            return maximum;
        }
        for (int j: entities)
        {
            maximum = Math.max(maximum, j);
        }

        return maximum;

    }

    public static double FindAverage(int[] entities)
    {
        double arithmetic = 0;
        if( (entities == null) || (entities.length==0) )
        {
            return 0;
        }

        for (int i : entities)
        {
            arithmetic += i;
        }

        return arithmetic / entities.length;
    }

    public static double FindMedian(int[] entities)
    {
        if( (entities == null) || (entities.length==0) )
        {
            return 0;
        }

        int[] entitiesCopy = entities.clone();
        Arrays.sort(entitiesCopy);

        if (entitiesCopy.length % 2 != 0)
        {
            return entitiesCopy[entitiesCopy.length / 2];
        }
        else
        {
            return ((entitiesCopy[entitiesCopy.length / 2] + entitiesCopy[entitiesCopy.length / 2 - 1]) / 2f);
        }
    }

    public static double FindGeometricAverage(int[] entities)
    {
        double geometric = 1;
        if( (entities == null) || (entities.length==0) )
        {
            return 0;
        }

        for (int i : entities)
        {
            geometric *= i;
        }

        if((geometric < 0) && (entities.length % 2 != 0))
        {
            return (Math.pow(Math.abs(geometric), 1d / entities.length));
        }

        return Math.pow(geometric, 1d / entities.length);
    }
}
