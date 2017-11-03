public class Main
{
    public static void main(String[] args)
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        System.out.println("Количество строк: " + customAnalizer.CountLines());
        System.out.println("Количество слов: " + customAnalizer.CountWords());
        System.out.println("Количество букв: " + customAnalizer.CountLetters());
        System.out.println("Частотный анализ: " + customAnalizer.CountFrequencyCharacteristic());
    }
}
