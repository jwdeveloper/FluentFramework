package io.github.jwdeveloper.ff.core.common.java;

public class StringUtils
{
    public static String EMPTY = "";

    public static boolean isNullOrEmpty(String string)
    {
        if(string == null)
        {
            return true;
        }
        if(string.equals(EMPTY))
        {
            return true;
        }
        if(string.length() == 0)
        {
            return true;
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(String string)
    {
        return !isNullOrEmpty(string);
    }

    public static  String capitalize(String str)
    {
        if (isNullOrEmpty(str))
        {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static  String deCapitalize(String str)
    {
        if (isNullOrEmpty(str))
        {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String removeWhitespaces(String string)
    {
       return string.replaceAll("\\s", "");
    }

    public static String separator()
    {
        return System.lineSeparator();
    }
}
