package com.vti.frontend;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        menuLogin();
    }

    public static void menuLogin() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        System.out.println("Mời bạn đăng nhập");
        User user = function.login();

        if (user.getRole() == Role.Manager){
            menuManager();
        } else{
            menuEmployee();
        }
    }

    public static void menuEmployee() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        while(true){
            displayMenuEmployee();
            System.out.print("Mời bạn nhập chức năng: ");
            int choose = ScannerUtils.inputFunction(1,2, "Bạn phải nhập chức năng từ 1 - 2, mời nhập lại!");

            switch (choose){
                case 1:
                    function.getListUsersByProjectId();
                    break;
                case 2:
                    System.out.println("Tạm biệt và hẹn gặp lại!");
                    return;
            }
        }
    }

    public static void displayMenuEmployee(){
        System.out.println("1 - Tìm kiếm danh sách các user theo projectId");
        System.out.println("2 - Thoát khỏi chương trình");
    }

    public static void menuManager() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        while (true){
            displayMenuManager();
            System.out.print("Mời bạn nhập chức năng: ");
            int choose =ScannerUtils.inputFunction(1,3,"Bạn phải nhập chức năng từ 1 - 3, mời bạn nhập lại!");

            switch (choose){
                case 1:
                    function.getListUsersByProjectId();
                    break;
                case 2:
                    function.addUser();
                    break;
                case 3:
                    System.out.println("Tạm biệt và hẹn gặp lại");
                    return;
            }
        }
    }

    public static void displayMenuManager(){
        System.out.println("1 - Tìm kiếm danh sách user theo projectID");
        System.out.println("2 - Thêm user");
        System.out.println("3 - Thoát khỏi chương trình");
    }
}
