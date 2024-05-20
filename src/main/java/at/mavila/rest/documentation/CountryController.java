package at.mavila.rest.documentation;

import at.mavila.rest.documentation.api.CountryApi;
import at.mavila.rest.documentation.model.AddCountryRequest;
import at.mavila.rest.documentation.model.Country;
import at.mavila.rest.documentation.model.CountryResponse;
import at.mavila.rest.documentation.model.Language;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CountryController implements CountryApi {

    @Override
    public ResponseEntity<CountryResponse> addCountry(Optional<AddCountryRequest> addCountryRequest) {
        return addCountryRequest.map(request -> {
            log.info("Adding country with name: {}", request.getEnglishName());

            CountryResponse response = new CountryResponse();
            response.setEnglishName(request.getEnglishName());
            response.setId(Optional.of(1));

            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @Override
    public ResponseEntity<List<Country>> fetchAllCountries() {

        List<Country> countries = new ArrayList<>();
        Country austria = new Country();
        austria.setEnglishName(Optional.of("Austria"));
        austria.setLanguages(List.of(new Language("German")));
        Country mexico = new Country();
        mexico.setEnglishName(Optional.of("Mexico"));
        mexico.setLanguages(List.of(new Language("Spanish")));

        countries.add(austria);
        countries.add(mexico);

        return ResponseEntity.ok(countries);
    }
}
