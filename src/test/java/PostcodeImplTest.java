import org.junit.Test;
import postcode.PostcodeController;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PostcodeImplTest {
    @Test
    public void searchAddressHome() {
        try {
            PostcodeController postcode = new PostcodeController();
            postcode.searchAddress("3824AHH", 42, "");
        } catch (IOException e) {
            assertTrue(true);

            return;
        }

        assertTrue(false);
    }

    @Test
    public void searchAddressDL200() {
        try {
            PostcodeController postcode = new PostcodeController();
            postcode.searchAddress("3584BJJ", 200, "");
        } catch (IOException e) {
            assertTrue(true);

            return;
        }

        assertTrue(false);
    }

    @Test
    public void searchPostcodeHome() {
        try {
            PostcodeController postcode = new PostcodeController();
            postcode.searchPostcode("Notarisappelgaarde", 420, "", "Amersfoort");
        } catch (IOException e) {
            assertTrue(true);

            return;
        }

        assertTrue(false);
    }

    @Test
    public void searchPostcodeDL200() {
        try {
            PostcodeController postcode = new PostcodeController();
            postcode.searchPostcode("Daltoonlaan", 2001, "", "Utrecht");
        } catch (IOException e) {
            assertTrue(true);

            return;
        }

        assertTrue(false);
    }
}
