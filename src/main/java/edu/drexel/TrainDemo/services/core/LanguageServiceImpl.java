/*
// Package.

// Import Files.
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LanguageServiceImpl
{

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);
    private LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository)
    {
		super(languageRepository);
		this.languageRepository = languageRepository;
	}

	public Language getByCode(String code) throws ServiceException {
		return languageRepository.findByCode(code);
	}

    System.out.println();

} // End of LanguageServiceImpl.
*/
