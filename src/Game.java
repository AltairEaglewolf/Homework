import java.util.Scanner;

public class Game {

    public static Character manager;
    public static Story story;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите своё имя");

        manager = new Character(in.next());
        story = new Story();
        System.out.println("Спасибо, "+manager.name+ ". Начнём игру.\n\n");
        System.out.println("Ваш день ничем не отличался от обычного. Разве что тем что с момента выхода из дома вас " +
                "преследовало ощущение, что кто-то наблюдает за вами.\n" +"Однако вы старались не обращать вминания, наслаждаясь" +
                " привычным ходом жизни,который вдруг резко оборвался в тот момент, когда прямо на удице вас усыпили.\n "
                + "Вы очнулись в пустой комнате, в которой единственной примечательной вещью оказался ноутбук с включенным экраном.");

        while (true) {
            manager.Health += story.current_situation.dHealth;
            manager.Fatigue += story.current_situation.dFatigue;
            manager.Panic += story.current_situation.dPanic;
            System.out.println("=====\nЗдоровье:" + manager.Health + "\tУсталость"
                    + manager.Fatigue + "\tПаника:" + manager.Panic + "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");
            System.out.println(story.current_situation.text);
            if (story.isEnd()) {
                System.out.println("====================the end!===================");
                return;
            }
            story.go(in.nextInt());
        }

    }

}
