package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for validating the length of a string field.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringLength {
    /**
     * The minimum allowed length of the string.
     */
    int min() default 0;

    /**
     * The maximum allowed length of the string.
     */
    int max() default Integer.MAX_VALUE;
}