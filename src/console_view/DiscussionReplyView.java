package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuAction;
import model.DiscussionReply;
import model.Section;
import model.Student;
import model.modulecontent.Discussion;

public class DiscussionReplyView {
    public static void display(DiscussionReply reply) {
        System.out.println(reply.getStudent().toString());
        System.out.println(reply.getText());
    }

    /**
     * Choose the student
     * <p>
     *     When you go to create and discussion this will ask the user to select the student
     *     they want to write the discussion for once that user is selected then it will ask
     *     the user to enter the reply
     * </p>
     * @param section section is where the information is being taken and given to
     * @return The new discussion reply that the user created.
     * @author Engjell Toska (ext5190@psu.edu)
     */
    public static DiscussionReply createDiscussionReply(Section section) {
        // TODO 02 - [console_view.DiscussionReplyView.createDiscussionReply] Choose the student
        /*
         * e.g.,
         *   .-------------------------------.
         *   | Student that will write reply |
         *   '-------------------------------'
         *   1) William H. Gates (whg5123@psu.edu)
         *   2) Paul G. Allen (pga123@psu.edu)
         *   3) Bart Simpson (bxs5987@psu.edu)
         *   4) Quit (or just hit Enter)
         *   Choice: 3
         */

        // HINT: This can be done in 2 lines.  Something in SectionView will help you
        Student student = new SectionView(section).chooseStudent("Student that will write reply");


        String text = ViewUtil.readNonBlankStringFromKeyboard("Reply (one line)");



        return new DiscussionReply(student, text);
    }
}
