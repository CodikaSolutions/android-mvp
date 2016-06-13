package com.codika.sampleandroidmvp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ignacio on 24/05/16.
 */
public class ValidationUtils {

    static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(target);

        return matcher.matches();
    }

}
