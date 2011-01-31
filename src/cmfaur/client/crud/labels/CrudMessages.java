package cmfaur.client.crud.labels;
	
import com.google.gwt.i18n.client.Messages;

public interface CrudMessages extends Messages {

	String entitiesRemoved(int count, String entity);

	String deleteDescription();

	String delete();

	String chooseEntity();
	
	String noEntitiesToEdit();

	String admin();

	String newEntity();

	String uploadImage();

	String removeImage();

	String requiredImageWidth(int width);

	String requiredImageSize(int width, int height);

	String uploadingProgress();

	String doUpload();

	String uploadError(String clean);

	String pickVideo();

	String removeVideo();

	String pasteIdHere();

	String useVideoId();

	String foundNoVideoWithId(Long videoId);

	String orEnterAtLeastThreeCharactersToSearchForVideo();

	String richText();

	String rawHtml();

	String minimize();

	String maximize();

	String link();

	String video();

	String pasteLinkHere();

	String loading();

	String bold();

	String italic();

	String strikethrough();

	String underline();

	String insertLink();

	String insertVideo();

	String insertImage();

	String searchForEntity(String entity);

	String search();

	String clearSearchResults();

	String maximumImageSize(int width, int height);

	String siteletType();

	String addSitelet();

	String orderChanged();

	String saveOrder();

	String noSiteletsHaveBeenAdded();

	String siteletsRemoved(int size);

	String orderSaved();

	String selectSiteletType();

	String entityAddedAndCanBeSelected();
	
	String clickToDeleteTag();

	String add();

	String allBlogEntries();

	String newBlogEntry();

	String publishBlogEntry();

	String blogEntryHasBeenSaved();

	String blogHeader();

	String blogHeaderDesc();

	String blogPublishDate();

	String blogPublishDateDesc();

	String blogContent();

	String tags();

	String blogTagsDesc();

	String blog();

	String blogDesc();

	String blogEntry();

	String entriesListDescription();

	String clone();

	String mustAddImage();

	String mustAddVideo();

	String noEmbeddedItemsAdded(String embeddedTypeInPlural);

	String deleteEmbeddedItem();

	String embeddedItemsDeleted(String embeddedTypeInPlural, int size);

	String embeddedItemAtLeastOne(String embeddedTypeInSingular);

	String linkIsRequired();

	String chooseLinkType();

	String createNewLink();

	String linkText();

	String selectLinkTo();

	String writeOrPasteLink();

	String save();

	String cancel();

	String selectLinkToEntity(String entityType);

	String editLink();

	String linkOutputAbsoluteUrl(String linkText, String absoluteLink);

	String linkOutputUrl(String linkText, String typeLabel, String displayString);

	String youCanSearchFor(String commaSeparateFields);

	String scheduleUpdateComplete();

	String anErrorOccured(String errorMessage);

	String wrongFileFormat();

	String scheduleAdminIntro();
}
