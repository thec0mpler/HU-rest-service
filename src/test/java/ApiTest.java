import org.junit.Test;
import postcode.Address;
import postcode.Api;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ApiTest {
    @Test
    public void getAddressHome() throws IOException {
        Address address = Api.getAddress("3824AH", 42, "");

        assertEquals("", address.getAddition());
        assertEquals("AMERSFOORT", address.getPlace());
        assertEquals("3824AH", address.getPostcode());
        assertEquals("Notarisappelgaarde", address.getStreet());
        assertEquals(42, address.getHouseNumber());
    }

    @Test
    public void getAddressDL200() throws IOException {
        Address address = Api.getAddress("3584BJ", 200, "");

        assertEquals("", address.getAddition());
        assertEquals("UTRECHT", address.getPlace());
        assertEquals("3584BJ", address.getPostcode());
        assertEquals("Daltonlaan", address.getStreet());
        assertEquals(200, address.getHouseNumber());
    }

    @Test
    public void getPostcodeHome() throws IOException {
        Address address = Api.getPostcode("Notarisappelgaarde", 42, "", "Amersfoort");

        assertEquals("", address.getAddition());
        assertEquals("Amersfoort", address.getPlace());
        assertEquals("3824AH", address.getPostcode());
        assertEquals("Notarisappelgaarde", address.getStreet());
        assertEquals(42, address.getHouseNumber());
    }

    @Test
    public void getPostcodeDL200() throws IOException {
        Address address = Api.getPostcode("Daltonlaan", 200, "", "Utrecht");

        assertEquals("", address.getAddition());
        assertEquals("Utrecht", address.getPlace());
        assertEquals("3584BJ", address.getPostcode());
        assertEquals("Daltonlaan", address.getStreet());
        assertEquals(200, address.getHouseNumber());
    }
}
