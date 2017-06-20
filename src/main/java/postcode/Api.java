package postcode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * API to get the address or postcode.
 */
public class Api {
    private static final String addressEndpoint = "https://www.postnl.nl/adres-zoeken/";
    private static final String postcodeEndpoint = "https://www.postnl.nl/postcode-zoeken/";

    private Api() {
    }

    private static Elements getResult(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("section.results div.result p");

        // Check for error
        if (elements.isEmpty())
            throw new IOException("Could not find result");

        return elements;
    }

    public static Address getAddress(String postcode, int houseNumber, String addition) throws IOException {
        // Get page
        Elements addressElement = getResult(
                addressEndpoint + "?postal-code=" + postcode + "&number=" + houseNumber + "&addition_value=" + addition
        );

        // Get page new values
        Elements streetAndPlace = addressElement.select("em");
        String street = streetAndPlace.get(0).html();
        String place = streetAndPlace.get(1).html().substring(6);

        // Fix null value
        if (addition == null)
            addition = "";
        if (postcode == null)
            postcode = "";

        // Create AddressType
        Address address = new Address();
        address.setStreet(street);
        address.setPlace(place);
        address.setAddition(addition);
        address.setHouseNumber(houseNumber);
        address.setPostcode(postcode);

        return address;
    }

    public static Address getPostcode(String street, int houseNumber, String addition, String place) throws IOException {
        // Get page
        Elements addressElement = getResult(
                postcodeEndpoint + "?street=" + street + "&number=" + houseNumber + "&addition=" + addition + "&city=" + place
        );

        // Get page new value
        Elements streetAndPlace = addressElement.select("em");
        String postcode = streetAndPlace.get(0).html();

        // Fix null value
        if (street == null)
            street = "";
        if (postcode == null)
            postcode = "";

        // Create AddressType
        Address address = new Address();
        address.setStreet(street);
        address.setPlace(place);
        address.setAddition(addition);
        address.setHouseNumber(houseNumber);
        address.setPostcode(postcode);

        return address;
    }
}
