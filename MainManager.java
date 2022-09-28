import java.util.ArrayList;

public interface MainManager {
    public static int LEN_MAX_USERS = 100000;//Integer.MAX_VALUE;
    public ArrayList<User> editUsers(int max);
    public int findProject(ArrayList<Projetos> projects, int choose_id);
}
