package postcode;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PostcodeController {
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public Address searchAddress(@RequestParam("postcode") String postcode,
                                 @RequestParam("houseNumber") int houseNumber,
                                 @RequestParam(value = "addition", defaultValue = "") String addition) throws IOException {
        return Api.getAddress(postcode, houseNumber, addition);
    }

    @RequestMapping(value = "/postcode", method = RequestMethod.GET)
    public Address searchPostcode(@RequestParam("street") String street,
                                 @RequestParam("houseNumber") int houseNumber,
                                 @RequestParam(value = "addition", defaultValue = "") String addition,
                                 @RequestParam("place") String place) throws IOException {
        return Api.getPostcode(street, houseNumber, addition, place);
    }
}
