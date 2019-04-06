import model.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User user = new User();
        user.setUsername("Mateusz");
        user.setPassword("pass123");
        user.setAge(22);

        userDAO.add(user);
        System.out.println(userDAO.read(1L));

        user.setAge(23);
        userDAO.update(1L, user);
        System.out.println(userDAO.read(1L));
    }
}
