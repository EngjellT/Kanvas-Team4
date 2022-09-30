package console_view;

import model.modulecontent.Announcement;

import static console_view.ViewUtil.makeUnderline;
import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class AnnouncementView {

    public static void display(Announcement announcement) {
        String underline = makeUnderline(announcement.getTopic());

        System.out.println(underline);
        System.out.println(announcement.getTopic());
        System.out.println(underline);
        System.out.println(announcement.getText());
    }

    /**
     * Prompt user for name and text; create Announcement
     * <p>
     *     The string announcementName will get the users input for announcement and the string for announcementText will get
     *     the text input from the user for the announcement. Then it will return the new created announcement
     *     with the name and text that the user put in.
     * </p>
     *
     * @return The new announcement that was just created from the users input
     * @author Engjell Toska
     */
    public static Announcement createAnnouncement() {
        // TODO 01 - [console_view.AnnouncementView.createAnnouncement] - Prompt user for name and text; create Announcement

        String announcementName = readNonBlankStringFromKeyboard("Name of announcement");
        String announcementText = readNonBlankStringFromKeyboard("Text of announcement");

        return new Announcement(announcementName, announcementText);
    }
}
