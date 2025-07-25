package Utils.constants;

import Utils.scripts.JS_Scripts;

public class Constants_JS {

    // Script to remove all frames from the page
    public static final String REMOVE_ALL_FRAMES_SCRIPT =
            "document.querySelectorAll('iframe').forEach(f => f.remove()); return document.querySelectorAll('iframe').length;";

    // Script to count the number of frames on the page
    public static final String COUNT_FRAMES_SCRIPT =
            "return document.querySelectorAll('iframe, frame').length;";

    // Script to scroll to the bottom of the page
    public static final String SCROLL_TO_BOTTOM_SCRIPT =
            "window.scrollTo(0, document.body.scrollHeight);";

    // Script to scroll a specific element into view
    public static final String SCROLL_ELEMENT_INTO_VIEW_SCRIPT =
            "arguments[0].scrollIntoView(true);";

    //JS Logging Statements
    public static final String REMOVING_ALL_FRAMES_FROM_THE_PAGE = "Removing all frames from the page";
    public static final String INTERRUPTED_EXCEPTION = "Interrupted exception upon removing the frames from the page ";
    public static final String SCROLLING_TO_THE_BOTTOM_OF_THE_PAGE = "Scrolling to the bottom of the page";
    public static final String SUCCESSFULLY_SCROLLED_TO_THE_BOTTOM_OF_THE_PAGE = "Successfully scrolled to the bottom of the page";
    public static final String FAILED_TO_SCROLL_TO_THE_BOTTOM_OF_THE_PAGE = "Failed to scroll to the bottom of the page: ";
    public static final String SCROLLING_ELEMENT_INTO_VIEW = "Scrolling element into view: {}";
    public static final String SUCCESSFULLY_SCROLLED_ELEMENT_INTO_VIEW = "Successfully scrolled element into view";
    public static final String FAILED_TO_SCROLL_ELEMENT_INTO_VIEW = "Failed to scroll element into view: ";
    public static final String FAILED_TO_REMOVE_FRAMES = "Error removing iframes: ";

}
