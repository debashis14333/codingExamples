package annotationexample;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, LOCAL_VARIABLE })
@Inherited
@Repeatable(MyRepeatedAnnos.class)
public @interface MethodInfo {
	String author() default "Deb";
	int revision() default 1;
	String comments();
}

//Create container annotation 
@Documented
@Retention(RUNTIME) 
@Target({ FIELD, METHOD, LOCAL_VARIABLE })
@Inherited
@interface MyRepeatedAnnos{ 
	MethodInfo[] value(); 
} 
