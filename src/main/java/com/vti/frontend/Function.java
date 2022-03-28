package com.vti.frontend;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Function {
    private UserController userController;

    public Function() {
        userController = new UserController();
    }

    public void getListUsersByProjectId() throws SQLException, IOException, ClassNotFoundException {
        while (true){
            System.out.print("Mời bạn nhập projectId: ");
            int projectId = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời bạn nhập lại!");
            boolean check = userController.isProjectIdExists(projectId);
            if (check){
                List<User> listUsers = userController.getListUsersByProjectId(projectId);
                System.out.println("Các user thuộc projectId: " + projectId);
                System.out.printf("%-15s %-25s %-25s %-15s\n", "ID", "Email", "Fullname", "Role");
                for (User user : listUsers) {
                    System.out.printf("%-15s %-25s %-25s %-15s\n", user.getId(), user.getEmail(), user.getFullName(), user.getRole());
                }
                return;
            } else {
                System.out.println("Không tìm thấy project có id là: " + projectId);
            }
        }
    }

    public User login() throws SQLException, IOException, ClassNotFoundException {
        while (true) {
            System.out.print("Mời bạn nhập email: ");
            String email = ScannerUtils.inputEmail("Nhập sai định dạng email");
            System.out.print("Mời bạn nhập password: ");
            String password = ScannerUtils.inputPassword("Password từ 6 - 12 ký tự và có ít nhất một ký tự viết hoa");

            User user = userController.login(email, password);

            if (user != null) {
                System.out.printf("Chào mừng %s (%s) \n \n", user.getFullName(), user.getRole());
                return user;
            } else {
                System.err.println("Bạn đã điền email/password chưa đúng, mời bạn nhập lại!");
            }
        }
    }

    public void addUser() throws SQLException, IOException, ClassNotFoundException {
        System.out.print("Mời bạn nhập Full name: ");
        String fullName = ScannerUtils.StringContainsSpecialCharacter("Tên chỉ chứa chữ, không chứa ký tự đặc biệt");
        while (true) {
            System.out.print("Mời bạn nhập Email: ");
            String email = ScannerUtils.inputEmail("Email chưa đúng định dạng!");
            boolean check = userController.isEmailExists(email);

            if (check == false){
                userController.addUser(fullName, email);
                System.out.println("Đã thêm user: " + fullName);
                return;
            } else {
                System.err.println("Email đã tồn tại! Mời bạn nhập lại email!");
            }
        }
    }
}
