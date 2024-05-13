package at.mavila.rest.documentation;

import at.mavila.rest.documentation.api.CountryFetchApi;
import at.mavila.rest.documentation.model.Country;
import at.mavila.rest.documentation.model.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CountryController implements CountryFetchApi {
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
