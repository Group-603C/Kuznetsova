import java.util.regex.*;

public class Formatter
{
    public String build(String formatString, Object... arguments)
    {
        String pattern = "[0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(formatString);

        for (int i=0; i < arguments.length; i++)
        {
            formatString = formatString.replaceFirst(pattern, arguments[i].toString());
        }

        formatString= formatString.replace("{","");
        formatString= formatString.replace("}","");

        return formatString;
    }

    public static void main(String[] args){

        Formatter str=new Formatter();

        System.out.println(str.build("Если ты не сдашь {0} - тебе {1}", "лабы", "конец"));
    }
}
