// package
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// imports

public class SearchServiceImpl implements SearchService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);


    private SearchService searchService;
    private PricingService pricingService;
    private CoreConfiguration configuration;

    public void index(Ticket ticket)
    {
        // index code
    }

    public void deleteIndex(Ticket ticket)
    {
        // delete code
    }

    public SearchKeywords searchForKeywords(String collectionName, String jsonString, int entriesCount)
    {
        // keyword code
    }

    public SearchResponse search(String languageCode, String jsonString, int entriesCount, int startIndex)
    {
        // search code
    }

    public void initService(){
        searchService.initService();
    }

} // End of Search Service.
