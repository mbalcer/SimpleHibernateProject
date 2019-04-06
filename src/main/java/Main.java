import model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        String userList = userDAO.readAll().stream()
                .map(user -> {
                    return String.format("(%d) %s - age: %d", user.getId(), user.getUsername(), user.getAge());
                }).collect(Collectors.joining("\n"));

        System.out.println(userList);

        User user = new User("Jan", "janek123", 55);
        userDAO.add(user);

        userDAO.read(8L);
        user.setAge(33);
        userDAO.update(8L, user);
        userDAO.delete(8L);
    }
}
