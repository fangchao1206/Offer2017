package NiukeTest;

import java.lang.reflect.Field;

public class ReflectTest {
 public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	 PrivateObject privateObject = new PrivateObject("The Private Value");

		Field privateStringField = PrivateObject.class.
		            getDeclaredField("privateString");

		//privateStringField.setAccessible(true);

		String fieldValue = (String) privateStringField.get(privateObject);
		System.out.println("fieldValue = " + fieldValue);
}
	 int  ReflectTest(){return 1;}

}
