// package
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// imports

public class SearchController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    private Ticket ticket;
    private SearchService searchService;
    private SearchFacade searchFacade;

    public autocomplete(String query, String store, final String language, Model model, HttpServletRequest request, HttpServletResponse response)
    {
        // autocomplete code.
    }

    public search(SearchRequest searchRequest, Model model, Language language)
    {
        // search code.
    }

    public displaySearch(String query, Model model, HttpServletRequest request, HttpServletResponse response, Locale locale)
    {
        // displaySearch code.
    }


} // End of SearchController
