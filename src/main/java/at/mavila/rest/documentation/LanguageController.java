package at.mavila.rest.documentation;

import at.mavila.rest.documentation.api.LanguageFetchApi;
import at.mavila.rest.documentation.model.Language;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController implements LanguageFetchApi {
  @Override
  public ResponseEntity<Language> addLanguage(Optional<Language> language) {
    return ResponseEntity.of(language);
  }

  @Override
  public ResponseEntity<List<Language>> fetchAllLanguages() {
    return ResponseEntity.ok(List.of(new Language("German"), new Language("Spanish")));
  }
}
