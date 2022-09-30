package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Section;
import util.CreateSampleSection;

public class KanvasConsole {
    private static final Section ist261 = CreateSampleSection.initIst261();
    private static final SectionView sectionView = new SectionView(ist261);
    private static final Menu menu = new Menu("Kanvas");

    public static void main(String[] args) {
        menu.addMenuChoice("Students").setMenuAction(sectionView.handleStudents);
        menu.addMenuChoice("Modules").setMenuAction(sectionView.handleModules);
        menu.addMenuChoice("Discussions").setMenuAction(sectionView.handleDiscussions);
        menu.addMenuChoice("Announcements").setMenuAction(sectionView.handleAnnouncements);
        menu.addMenuChoice("Assignments").setMenuAction(sectionView.handleAssignments);
        menu.addMenuChoice("Quizzes").setMenuAction(sectionView.handleQuizzes);

        MenuDisplay display = new MenuDisplay(menu);

        // TODO 00 - [KanvasConsole#main] - Your team info
        System.out.println("TEAM 04"); // Put team number here
        
    

        while (true) {
            MenuChoice choice = display.displayAndChoose();
            if (choice == menu.getMenuChoiceQuit()) {
                break;
            }
        }

    }
}