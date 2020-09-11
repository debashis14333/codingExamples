package annotationexample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//https://www.geeksforgeeks.org/annotations-in-java/
//https://www.journaldev.com/721/java-annotations
//https://dzone.com/articles/how-annotations-work-java
//https://howtodoinjava.com/java/annotations/complete-java-annotations-tutorial/
public class AnnotationTest {

	// Repeat Words on newMethod
	@MethodInfo(author = "Debashis", comments = "New method", revision = 1)
	@MethodInfo(author = "Dev", comments = "New method modified", revision = 2)
	public static void newMethod() {
		AnnotationTest obj = new AnnotationTest();

		try {
			Class<?> c = obj.getClass();

			// Obtain the annotation for newMethod
			Method m = c.getMethod("newMethod");

			// Display the repeated annotation
			Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
			System.out.println(anno);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		newMethod();
	}

}
