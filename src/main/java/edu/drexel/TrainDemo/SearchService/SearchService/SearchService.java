// package
// imports

public interface SearchService
{

    public void index(Ticket ticket);

    public void deleteIndex(Ticket ticket);

    public SearchKeywords searchForKeywords(String collectionName, String jsonString, int entriesCount);

    public SearchResponse search(String languageCode, String jsonString, int entriesCount, int startIndex);

    public void initService();

} // End of Search Service.
