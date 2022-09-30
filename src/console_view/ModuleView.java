package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Module;
import model.Section;
import model.modulecontent.IContent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static console_view.ViewUtil.readNonBlankStringFromKeyboard;


public class ModuleView {
    public static void display(Module module) {

        Menu menu = new Menu(module.getName());
        for (IContent content : module.getContents()) {
            String contentType = content.getContentType();
            String contentDesc = content.getShortDescription();
            MenuChoice choice = new MenuChoice(String.format("%s: %s", contentType, contentDesc));
            menu.addMenuChoice(choice);
            choice.setObject(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);
        MenuChoice choice;
        do {
            choice = display.displayAndChoose();
            System.out.printf("You chose: %s%n", choice.getText());
            System.out.printf("Nothing else will happen here");
        } while (choice != menu.getMenuChoiceQuit());
    }

    /**
     * Create a Module
     * <p>
     *     Create a module and populate it with Content from the Section
     * </p>
     * @param section Section the Module is to be added to
     * @return the new Module
     * 
     */
    public static Module createModule(Section section) {
        String name = readNonBlankStringFromKeyboard("Name of Module");
        Module module = new Module(name);

        Menu menu = new Menu(String.format("Add Content to '%s'", name));


        List<IContent> allContent = new ArrayList<>();
        // TODO 05 - [console_view.ModuleView.createModule] Populate all content from this section
        //   This should include (in this order): announcements, discussions, assignment, quizzes
        allContent.addAll((Collection<? extends IContent>) section.getAnnouncements());
        allContent.addAll((Collection<? extends IContent>) section.getDiscussions());
        allContent.addAll((Collection<? extends IContent>) section.getAssignments());
        allContent.addAll((Collection<? extends IContent>) section.getQuizzes());


        for (IContent content : allContent) {
            String contentType = content.getContentType();
            String contentDesc = content.getShortDescription();
            MenuChoice choice = new MenuChoice(String.format("%s: %s", contentType, contentDesc));
            choice.setObject(content);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice;
        while (true) {
            choice = display.displayAndChoose();
            if (choice == menu.getMenuChoiceQuit()) break;
            module.addContent((IContent) choice.getObject());
        }

        return module;
    }
}
