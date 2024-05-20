package at.mavila.rest.documentation;

import at.mavila.rest.documentation.api.LanguageApi;
import at.mavila.rest.documentation.model.Language;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LanguageController implements LanguageApi {
  @Override
  public ResponseEntity<Language> addLanguage(Optional<Language> language) {
    return ResponseEntity.of(language);
  }

  @Override
  public ResponseEntity<List<Language>> fetchAllLanguages() {
    return ResponseEntity.ok(List.of(new Language("German"), new Language("Spanish")));
  }
}
