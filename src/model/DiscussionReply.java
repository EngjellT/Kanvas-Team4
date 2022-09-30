package model;

public class DiscussionReply {
    private Student student;
    private String text;

    private DiscussionReply() {

    }

    public DiscussionReply(Student student, String text) {
        this.student = student;
        this.text = text;
    }

    public Student getStudent() {
        return student;
    }

    public String getText() {
        return text;
    }

    /**
     * Get a formatted String for displaying Discussion Replies
     * <p>
     *     returns a string made of the student's info and the Reply's text
     *     in a formatted string separated by a dash
     * </p>
     * @return formatted string describing discussion reply
     * 
     */
    public String toString() {
        // TODO 09 - [model.DiscussionReply.toString] Write this to match the output
        /*
         * e.g., So a reply looks like this in a menu: 
         *  .--------------.
         *  | Delete Reply |
         *  '--------------'
         *  1) William H. Gates (whg5123@psu.edu) - "The main ..."
         *  2) Paul G. Allen (pga123@psu.edu) - "There are..."
         *  3) Quit (or just hit Enter)
         *  Choice: 1
         *  William H. Gates (whg5123@psu.edu)
         *  The main method needs to separate into other methods
         */
        // NOTE - this task is independent from menu objects.  You will not be doing ANYTHING with menus here.

        return String.format("%s - %s",student.toString(), this.getText());
    }
}
