package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuAction;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.DiscussionReply;
import model.Section;
import model.modulecontent.Discussion;

import static console_view.ViewUtil.makeUnderline;

public class DiscussionView {
    final MaintMenu maintMenu = new MaintMenu("Reply Maintentance");

    private final Discussion discussion;
    private final Section section;

    public DiscussionView(Section section, Discussion discussion) {
        this.section = section;
        this.discussion = discussion;
        maintMenu.mcList.setMenuAction(listDiscussionReplies);
        maintMenu.mcCreate.setMenuAction(createDiscussionReply);
        maintMenu.mcDelete.setMenuAction(deleteDiscussionReply);
    }

    private final MenuAction listDiscussionReplies = new MenuAction() {
        @Override
        public void execute() {
            while (true) {
                DiscussionReply reply = chooseDiscussionReply("Replies");
                if (reply == null) break;
                DiscussionReplyView.display(reply);
            }
        }

    };
    private final MenuAction createDiscussionReply = new MenuAction() {
        @Override
        public void execute() {
            DiscussionReply discussionReply = DiscussionReplyView.createDiscussionReply(section);
            discussion.addReply(discussionReply);
        }
    };
    private final MenuAction deleteDiscussionReply = new MenuAction() {
        @Override
        /**
         * Deletes a reply in a Discussion
         * <p>
         * Chooses then deletes an existing instance of an DiscussionReply
         * </p>
         * 
         */
        public void execute() {
            // TODO 03 - [console_view.DiscussionView.deleteDiscussionReply] Choose the reply, and delete it from discussion
            //   This should only take about 5 lines

            DiscussionReply discussionReply;
            do {
                discussionReply = chooseDiscussionReply("Delete Reply");
                if (discussionReply != null) {
                    discussion.deleteDiscussionReply(discussionReply);
                }
            } while (discussionReply != null);
        }
    };


    public static Discussion createDiscussion() {
        String title = ViewUtil.readNonBlankStringFromKeyboard("Title");
        Discussion discussion = new Discussion(title);

        String text = ViewUtil.readNonBlankStringFromKeyboard("Text (one line only)");
        discussion.setText(text);

        return discussion;
    }

    /**
     * Displays a discussion
     * <p>
     * Displays the discussion title, uses the makeUnderline() function to make un underline
     * the exact length of that title, then displays the text of the discussion
     * </p>
     * 
     */
    public void display() {
        // TODO 04 - [console_view.DiscussionView.display] Display discussion as shown in output

        System.out.println();
        String underline = makeUnderline(discussion.getTitle());

        System.out.println(discussion.getTitle());
        System.out.println(underline + "\n");
        System.out.println(discussion.getText());
        /*
         * e.g.,
         * Discuss code that needs to be structured better with methods
         * ------------------------------------------------------------
         *
         * Given what was presented today, point out what parts of the code can be improved by creating methods.
         */









        MenuChoice choice = null;
        while (true) {
            choice = maintMenu.display.displayAndChoose();
            if (choice == maintMenu.mcQuit) break;
        }

    }

    public DiscussionReply chooseDiscussionReply(String title) {
        Menu menu = new Menu(title);
        for (DiscussionReply reply : discussion.getReplies()) {
            MenuChoice choice = new MenuChoice(reply.toString());
            choice.setObject(reply);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);
        MenuChoice choice = display.displayAndChoose();
        DiscussionReply reply = null;
        if (choice != menu.getMenuChoiceQuit()) {
            reply = (DiscussionReply) (choice.getObject());
        }

        return reply;
    }

}
