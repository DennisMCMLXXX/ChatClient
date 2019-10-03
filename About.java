import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class About {

    public String madeBy;

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public static void aboutButtonPressed(){

        ObjectMapper mapper = new ObjectMapper();
        try {
            About about = mapper.readValue(new File("Authors.json"), About.class);
            System.out.println(about.getMadeBy());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
