package vocaltranslate_backend.vocaltranslate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "translations")
@Data
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String targetLanguage;
    private String translatedText;

    @ManyToOne
    @JoinColumn(name = "transcription_id")
    private Transcription transcription;
}
