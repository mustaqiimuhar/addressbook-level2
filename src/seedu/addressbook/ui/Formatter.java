package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*"; 
    
    public String getInitFailedMessage(){
    	return MESSAGE_INIT_FAILED + getDivider() + getDivider();
    }
    
    public String getGoodbyeMessage(){
    	return MESSAGE_GOODBYE + getDivider() + getDivider();
    }

    public String getShowToUser(String m){
    	return LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX);
    }
    
    public String getWelcomeMessage(String version, String storageFilePath){
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	return getDivider() + "\n" + 
    		   getDivider() + "\n" +
    		   MESSAGE_WELCOME + "\n" +
    		   version + "\n" +
    		   MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + "\n" +
    		   storageFileInfo + "\n" +
    		   getDivider();
    }
    
    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public List<String> getPersonListView(List<? extends ReadOnlyPerson> persons){
    	final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListforViewing(List<String> listItems){
    	final StringBuilder formatted = new StringBuilder();
    	int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
    	for(String listItem : listItems){
    		formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
    		displayIndex++;
    	}
    	return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public String getIndexedListItem(int visibleIndex, String listItem){
    	return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    public String getMessageIndexedListItem() {
		return MESSAGE_INDEXED_LIST_ITEM ;
	}
    
	public String getLinePrefix() {
		return LINE_PREFIX;
	}


	public String getLs() {
		return LS;
	}


	public String getDivider() {
		return DIVIDER;
	}

	public int getDisplayedIndexOffset() {
		return DISPLAYED_INDEX_OFFSET;
	}


	public String getCommentLineFormatRegex() {
		return COMMENT_LINE_FORMAT_REGEX;
	}
}
