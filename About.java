import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class About {
	static About about;

	public static String madeBy;

	public static String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}


	public static String aboutButtonPressed() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			about = mapper.readValue(new File("src/Authors.json"), About.class);
		//	System.out.println(about.getMadeBy());


		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return about.getMadeBy();
	}

}
