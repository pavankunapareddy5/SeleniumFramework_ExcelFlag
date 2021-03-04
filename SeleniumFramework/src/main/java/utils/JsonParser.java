package utils;

import com.jayway.jsonpath.JsonPath;
import com.training.constants.Constants;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    public static String getValue(String path)  {

        String temp = "";
        try {
            File file = new File(Constants.JSONFILEPATH);
            return JsonPath.read(file,"$." + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  temp;
    }
}
