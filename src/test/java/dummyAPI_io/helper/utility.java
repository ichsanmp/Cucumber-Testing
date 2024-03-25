package dummyAPI_io.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class utility {

    public static File getJsonSchemaFile(String JSONFile) {
        return new File("src/test/java/dummyAPI_io/helper/jsonSchema/" + JSONFile);
    }

    public static String generateTitle() {
        List<String> listTitle = new ArrayList<>();
        listTitle.add("mr");
        listTitle.add("ms");
        listTitle.add("miss");
        int c = listTitle.size();
        int random = (int) (Math.random() * c);
        String getTitle = listTitle.get(random);
        return getTitle;
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }
}
