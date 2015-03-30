package resources.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String converteData(){
		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String convertida = data.format(new Date());
		return convertida;
		
	}
}
