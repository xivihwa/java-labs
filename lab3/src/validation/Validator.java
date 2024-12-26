package validation;

import annotations.*;
import java.lang.reflect.Field;

/**
 * Class for validating objects using annotations.
 */
public class Validator {
    /**
     * Validates all fields of the given object according to the specified annotations.
     *
     * @param obj the object to validate
     * @throws Exception if a field does not meet validation requirements
     */
    public void validate(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() + "' cannot be null.");
            }

            if (field.isAnnotationPresent(StringLength.class)) {
                if (value instanceof String) {
                    StringLength stringLength = field.getAnnotation(StringLength.class);
                    String str = (String) value;
                    if (str.length() < stringLength.min() || str.length() > stringLength.max()) {
                        throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                                "' must have length between " + stringLength.min() + " and " + stringLength.max() + ".");
                    }
                } else {
                    throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                            "' must be of type String for @StringLength annotation.");
                }
            }

            if (field.isAnnotationPresent(MinValue.class)) {
                if (value instanceof Integer) {
                    MinValue minValue = field.getAnnotation(MinValue.class);
                    int intValue = (Integer) value;
                    if (intValue < minValue.value()) {
                        throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                                "' must be at least " + minValue.value() + ".");
                    }
                } else {
                    throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                            "' must be of type Integer for @MinValue annotation.");
                }
            }

            if (field.isAnnotationPresent(MaxValue.class)) {
                if (value instanceof Integer) {
                    MaxValue maxValue = field.getAnnotation(MaxValue.class);
                    int intValue = (Integer) value;
                    if (intValue > maxValue.value()) {
                        throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                                "' must be at most " + maxValue.value() + ".");
                    }
                } else {
                    throw new Exception("Field '" + field.getName() + "' in class '" + clazz.getSimpleName() +
                            "' must be of type Integer for @MaxValue annotation.");
                }
            }
        }
    }
}