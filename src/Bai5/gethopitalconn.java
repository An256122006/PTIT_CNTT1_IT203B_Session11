package Bai5;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import Bai5.entity.doctor;
import Bai5.Dao.doctorDao;
public class gethopitalconn {
    final static String url="jdbc:mysql://localhost:3306/hospital";
    final static String user="root";
    final static String password="123456789";
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("ket noi thanh cong");
            return connection;
        } catch (Exception e) {
            System.out.println("ket noi that bai");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
        doctorDao doctorDao = new doctorDao();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(" Nhập sai định dạng!");
                continue;
            }

            switch (choice) {
                case 1:
                    List<doctor> doctors = doctorDao.getdoctors();
                    if (doctors.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        System.out.println("Mã | Họ tên | Chuyên khoa");
                        for (doctor d : doctors) {
                            System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpeciality());
                        }
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Nhập ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập chuyên khoa: ");
                        String spec = sc.nextLine();

                        if (name.isEmpty() || spec.isEmpty()) {
                            System.out.println(" Không được để trống!");
                            break;
                        }

                        if (spec.length() > 50) {
                            System.out.println(" Chuyên khoa quá dài!");
                            break;
                        }

                        boolean insert = doctorDao.insertDoctor(new doctor(id, name, spec));

                        if (insert) {
                            System.out.println("Insert thành công");
                        } else {
                            System.out.println("Insert thất bại");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("ID phải là số!");
                    } catch (Exception e) {
                        System.out.println("Lỗi nhập liệu!");
                    }
                    break;

                case 3:
                    doctorDao.thongke();
                    break;

                case 4:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println(" Chọn sai!");
            }
        }
    }
    public static void closeAll(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
