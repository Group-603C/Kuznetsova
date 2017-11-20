package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static int FindMinimum(int[] entities)
    {
        int minimum = Integer.MAX_VALUE;

        if (entities == null || entities.length == 0)
        {
            return minimum;
        }

        for (int j : entities)
        {
            minimum = Math.min(minimum, j);
        }
        return minimum;
    }

    public static int FindMaximum(int[] entities)
    {
        int maximum = Integer.MIN_VALUE;

        if (entities == null || entities.length == 0)
        {
            return maximum;
        }

        for (int j : entities)
        {
            maximum = Math.max(maximum, j);
        }

        return maximum;
    }

    public static double FindAverage(int[] entities)
    {
        int valueAverage = 0;

        if (entities == null || entities.length == 0)
        {
            return valueAverage;
        }

        for (double j : entities)
        {
            valueAverage += j;
        }

        return (double) valueAverage / entities.length;
    }

    public static double FindMedian(int[] entities)
    {
        if (entities == null || entities.length == 0)
        {
            return 0;
        }

        int[] copyEntities = entities.clone();
        Arrays.sort(copyEntities);

        if (copyEntities.length % 2 == 0)
        {
            return ((copyEntities[copyEntities.length / 2] + copyEntities[copyEntities.length / 2 - 1]) / 2f);
        }

        return copyEntities[copyEntities.length / 2];
    }

    public static double FindGeometricAverage(int[] entities)
    {
        if (entities == null || entities.length == 0)
        {
            return 0;
        }

        double multiplication = 1f;
        for (double j : entities)
        {
            if (j == 0)
            {
                return 0;
            }
            else
            {
                multiplication *= j;
            }
        }

        if (multiplication < 0 && entities.length % 2 == 0)
        {
            return 0;
        }
        if (multiplication < 0 && entities.length % 2 != 0)
        {
            return -(Math.pow(Math.abs(multiplication), 1d / entities.length));
        }
        return (Math.pow(multiplication, 1d / entities.length));
    }

    public static int[] InputArray()
    {
        while (true)
        {
            try
            {
                System.out.print("Введите количество цифр: ");
                Scanner input = new Scanner(System.in);
                int lengthArray = input.nextInt();

                int[] array = new int[lengthArray];

                int i = 0;
                while (i < lengthArray)
                {
                    Scanner symInput = new Scanner(System.in);
                    System.out.print("Введите значение: ");
                    String tempInput = symInput.nextLine();
                    try
                    {
                        int temp = Integer.parseInt(tempInput);
                        array[i] = temp;
                        i++;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("\tОшибка, Введено не численное значение!");
                    }
                }

                return array;
            }
            catch (NegativeArraySizeException e)
            {
                System.out.println("\tОшибка, длина массива не может быть отрицательна!");
            }
            catch (InputMismatchException e)
            {
                System.out.println("\tОшибка, введён символ при указании длины массива!");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] array = InputArray();

        System.out.println("\nМинимум: " + FindMinimum(array));
        System.out.println("Максимум: " + FindMaximum(array));

        System.out.println("\nСреднее арифметическое: " + FindAverage(array));

        System.out.println("\nМедиана: " + FindMedian(array));

        System.out.println("\nСреднее геометрическое: " + FindGeometricAverage(array));
    }
}