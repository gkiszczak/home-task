package pl.inpost.home.task.ui.page.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@Target(ElementType.TYPE) // Apply only to classes
public @interface PageUrl {
    String value();
}
