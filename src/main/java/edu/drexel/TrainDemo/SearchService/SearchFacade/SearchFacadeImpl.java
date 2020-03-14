// package
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// imports

public class SearchFacadeImpl implements SearchFacade
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacadeImpl.class);

    private SearchService searchService;
    private CategoryService categoryService;
    private PricingService pricingService;
    private CoreConfiguration coreConfiguration;

    private List<ReadableCategory> getCategoryFacets(Ticket ticket, Language language, Map<String, List<SearchFacet>> facets)
    {
        // getCategoryFacets code.
    }

    private ReadableItinerary convertItineraryToReadableItinerary(Itinerary itinerary, Language language)
    {
        // convertCategoryToReadableItinerary code.
    }

    private ReadableTicket convertTicketToReadableTicket(Ticket ticket, Language language)
    {
        // convertCategoryToReadableTicket code.
    }

    private SearchKeywords getSearchKeywords(AutoCompleteRequest request, String query)
    {
        // getSearchKeywords code.
    }

    public void indexAllData(Ticket ticket) throws Exception
    {
        // indexAll code.
    }

    public SearchList search(Ticket ticket, Language language, SearchProductRequest searchRequest)
    {
        // search code.
    }

    public SearchList convertToSearchList(Ticket ticket, Language language, SearchProductRequest searchRequest , int start, int count) throws Exception
    {
        // convert code.
    }

    ValueList autocompleteRequest(String query, Ticket ticket, Language language){
        // autocomplete code.
    }

} // End of SearchFacadeImpl.
