package Swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame {
    private JPanel contentPane;

    String a1 = "Internet Technology";
    String a2 = "Computer Science";
    String a3 = "Korean Language";
    String a4 = "Chinese Language";
    String a5 = "Select Faculty";
    String a6 = "Null";
    String input, input2, input3, input4;
    
    private JTable table;
    
    TextField textField_1;
    TextField textField_2;
    TextField textField_3;
    TextField textField_4;  
    
    JComboBox<String> comboBox;
    JComboBox<String> comboBox_1;
    
    double s10p;
    double gpa;
    
    public static void main(String[] args) {
    	// Đăng ký driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    	try {
    		Frame frame = new Frame();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            frame.setVisible(true);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public Frame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java\\project\\Student\\shock.jpg"));
        setTitle("Student Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(100, 100, 1156, 685);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(10, 10, 1122, 73);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        Label label = new Label("STUDENT MANAGEMENT");
        label.setForeground(new Color(102, 51, 255));
        label.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 50));
        label.setBounds(300, 0, 840, 84);
        
        panel_1.add(label);
        
        Label label_3 = new Label("basic");
        label_3.setBounds(220, 26, 108, 47);
        panel_1.add(label_3);
        label_3.setForeground(new Color(102, 51, 255));
        label_3.setFont(new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC, 30));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(10, 93, 347, 545);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        Label label_1 = new Label("Student ID");
        label_1.setFont(new Font("Dialog", Font.BOLD, 18));
        label_1.setBounds(10, 35, 114, 21);
        panel_2.add(label_1);

        Label label_1_1 = new Label("Student Name");
        label_1_1.setFont(new Font("Dialog", Font.BOLD, 18));
        label_1_1.setBounds(10, 98, 127, 21);
        panel_2.add(label_1_1);

        textField_1 = new TextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_1.setForeground(Color.BLACK);
        textField_1.setBounds(150, 27, 187, 35);
        panel_2.add(textField_1);

        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(10, 404, 97, 35);
        panel_2.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudentData();
			}
		});

        JButton btnDelete = new JButton("Xóa");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(240, 404, 97, 35);
        panel_2.add(btnDelete);
        
        btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteStudentData();
			}
		});

        JButton btnSua = new JButton("Sửa");
        btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSua.setBounds(125, 404, 102, 35);
        panel_2.add(btnSua);
        
        btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				replaceStudentData();
			}
		});

        textField_2 = new TextField();
        textField_2.setForeground(Color.BLACK);
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_2.setBounds(150, 92, 187, 35);
        panel_2.add(textField_2);

        Label label_1_1_1 = new Label("Student Class");
        label_1_1_1.setFont(new Font("Dialog", Font.BOLD, 18));
        label_1_1_1.setBounds(10, 223, 127, 21);
        panel_2.add(label_1_1_1);

        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "Select faculty", "Internet Technology", "Computer Science", "Korean Language", "Chinese Language"
        }));
        comboBox.setBounds(150, 153, 187, 35);
        panel_2.add(comboBox);

        Label label_1_1_1_1 = new Label("Student Faculty");
        label_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 17));
        label_1_1_1_1.setBounds(10, 160, 145, 21);
        panel_2.add(label_1_1_1_1);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setMaximumRowCount(15);
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox_1.setBounds(150, 216, 187, 35);
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"Null"}));
        panel_2.add(comboBox_1);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectionItem = (String) comboBox.getSelectedItem();
                if (selectionItem != null) {
                    switch (selectionItem) {
                        case "Internet Technology":
                            comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{
                                    "Select class", "23IT1", "23IT2", "23IT3"
                            }));
                            break;
                        case "Computer Science":
                            comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{
                                    "Select class", "23CS1", "23CS2", "23CS3"
                            }));
                            break;
                        case "Korean Language":
                            comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{
                                    "Select class", "23KL1", "23KL2", "23KL3"
                            }));
                            break;
                        case "Chinese Language":
                            comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{
                                    "Select class", "23CL1", "23CL2", "23CL3"
                            }));
                            break;
                        default:
                            comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{
                                    "Null"
                            }));
                            break;
                    }
                }
            }
        });

        JButton btnFind = new JButton("Tìm kiếm");
        btnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnFind.setBounds(10, 449, 97, 35);
        panel_2.add(btnFind);
        
        btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findStudent();
			}
		});

        JButton btnLoadTable = new JButton("Load table");
        btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLoadTable.setBounds(125, 449, 102, 35);
        panel_2.add(btnLoadTable);
        
        btnLoadTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadTableData();
			}
		});

        JButton btnClear = new JButton("Hủy bỏ");
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClear.setBounds(240, 449, 97, 35);
        panel_2.add(btnClear);
        
        textField_3 = new TextField();
        textField_3.setForeground(Color.BLACK);
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_3.setBounds(150, 277, 187, 35);
        panel_2.add(textField_3);
        
        textField_4 = new TextField();
        textField_4.setForeground(Color.BLACK);
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_4.setBounds(150, 336, 187, 35);
        panel_2.add(textField_4);
        
        Label label_1_2 = new Label("Grade by 10");
        label_1_2.setFont(new Font("Dialog", Font.BOLD, 18));
        label_1_2.setBounds(10, 285, 114, 21);
        panel_2.add(label_1_2);
        
        Label label_1_3 = new Label("GPA");
        label_1_3.setFont(new Font("Dialog", Font.BOLD, 18));
        label_1_3.setBounds(10, 345, 114, 21);
        panel_2.add(label_1_3);
        
        btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(192, 192, 192));
        panel_3.setBounds(362, 93, 770, 545);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        Label label_2 = new Label("Project build by Tung Aris");
        label_2.setForeground(SystemColor.textHighlight);
        label_2.setFont(new Font("Cooper Black", Font.BOLD | Font.ITALIC, 12));
        label_2.setBounds(612, 514, 186, 21);
        panel_3.add(label_2);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 745, 472);
        panel_3.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        table.setRowHeight(35);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", "", "", "", "", ""},
        	},
        	new String[] {
        		"Student ID", "Student Name", "Student Faculty", "Student Class", "Grade by 10", "Student GPA"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(190);
        table.getColumnModel().getColumn(2).setPreferredWidth(145);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
    }
    
    public void addStudentData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        String url = "";
        String username = "";
        String password = "";

        try {
            // Kết nối cơ sở dữ liệu
            try (Connection c = DriverManager.getConnection(url, username, password)) {
                // Chuẩn bị câu lệnh SQL
                String query = "INSERT INTO students (S_ID, S_Name, S_Faculty, S_Class, S_10P, S_GPA) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst = c.prepareStatement(query)) {
                    String inputID = textField_1.getText().trim();
                    String inputName = textField_2.getText().trim();
                    String s10pString = textField_3.getText().trim();
                    String gpaString = textField_4.getText().trim();

                    // Kiểm tra điều kiện nhập liệu
                    if (inputID.isEmpty() || inputName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Hãy điền đủ và đúng thông tin cần thiết", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double s10p;
                    double gpa2;
                    try {
                        s10p = Double.parseDouble(s10pString);
                        gpa2 = Double.parseDouble(gpaString);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Điểm phải là số", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (s10p < 0.0 || s10p > 10.0 || gpa2 < 0.0 || gpa2 > 4.0) {
                        JOptionPane.showMessageDialog(null, "Điểm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Thiết lập các giá trị
                    pst.setString(1, inputID);
                    pst.setString(2, inputName);
                    pst.setString(3, (String) comboBox.getSelectedItem());
                    pst.setString(4, (String) comboBox_1.getSelectedItem());
                    pst.setDouble(5, s10p);
                    pst.setDouble(6, gpa2);

                    // Thực thi câu lệnh SQL để thêm sinh viên
                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công");
                    }

                    // Lấy dữ liệu mới từ cơ sở dữ liệu và cập nhật bảng
                    String selectQuery = "SELECT * FROM students";
                    try (PreparedStatement selectPst = c.prepareStatement(selectQuery);
                         ResultSet rs = selectPst.executeQuery()) {

                        // Xóa các hàng hiện có trong bảng
                        model.setRowCount(0);

                        // Thêm dữ liệu mới vào bảng
                        while (rs.next()) {
                            String id = rs.getString("S_ID");
                            String name = rs.getString("S_Name");
                            String faculty = rs.getString("S_Faculty");
                            String className = rs.getString("S_Class");
                            String gradeBy10 = rs.getString("S_10P");
                            String gpa = rs.getString("S_GPA");
                            model.addRow(new Object[]{id, name, faculty, className, gradeBy10, gpa});
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm sinh viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void replaceStudentData() {
    	DefaultTableModel model = (DefaultTableModel) table.getModel();

        String url = "";
        String username = "";
        String password = "";

        try {
            // Kết nối cơ sở dữ liệu
            try (Connection c = DriverManager.getConnection(url, username, password)) {
                // Chuẩn bị câu lệnh SQL
                String query = "DELETE FROM students WHERE S_ID = ?";
                String query2 = "INSERT INTO students (S_ID, S_Name, S_Faculty, S_Class, S_10P, S_GPA) VALUES (?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement pst = c.prepareStatement(query); PreparedStatement pst2 = c.prepareStatement(query2)) {
                	input = textField_1.getText();
                	input2 = textField_2.getText();
                	input3 = textField_3.getText();
                	input4 = textField_3.getText();
                	
                	
                	if (input.isEmpty() || input2.isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                	}
                	double s10p;
                	double gpa2;
                	try {
                		s10p = Double.parseDouble(input3);
                    	gpa2 = Double.parseDouble(input4);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Điểm phải là số", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (s10p < 0.0 || s10p > 10.0 || gpa2 < 0.0 || gpa2 > 4.0) {
                        JOptionPane.showMessageDialog(null, "Điểm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                	
                	pst.setString(1, textField_1.getText());
                    pst.executeUpdate();
                    pst2.setString(1, textField_1.getText());
                    pst2.setString(2, textField_2.getText());
                    pst2.setString(3, (String) comboBox.getSelectedItem());
                    pst2.setString(4, (String) comboBox_1.getSelectedItem());
                    pst2.setString(5, textField_3.getText());
                    pst2.setString(6, textField_4.getText());
                    pst2.executeUpdate();
                        
                    int rowAffect = pst2.executeUpdate();
                    if (rowAffect > 0) {
                    	JOptionPane.showMessageDialog(null, "Cập nhật sinh viên thành công!");
                    }
                }

                // Lấy dữ liệu mới từ cơ sở dữ liệu và cập nhật bảng
                String selectQuery = "SELECT * FROM students";
                try (PreparedStatement selectPst = c.prepareStatement(selectQuery);
                     ResultSet rs = selectPst.executeQuery()) {
                    // Xóa các hàng hiện có trong bảng
                    model.setRowCount(0);

                    // Thêm dữ liệu mới vào bảng
                    while (rs.next()) {
                        String id = rs.getString("S_ID");
                        String name = rs.getString("S_Name");
                        String faculty = rs.getString("S_Faculty");
                        String className = rs.getString("S_Class");
                        String gradeBy10 = rs.getString("S_10P");
                        String gpa = rs.getString("S_GPA");
                        model.addRow(new Object[]{id, name, faculty, className, gradeBy10, gpa});
                        textField_1.setText("");
                        textField_2.setText("");
                        comboBox.setSelectedItem(null);
                        comboBox_1.setSelectedItem(null);
                        textField_3.setText(null);
                        textField_4.setText(null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudentData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        String url = "";
        String username = "";
        String password = "";

        try {
            // Kết nối cơ sở dữ liệu
            try (Connection c = DriverManager.getConnection(url, username, password)) {
                // Chuẩn bị câu lệnh SQL
                String query = "DELETE FROM students WHERE S_ID = ?";
                try (PreparedStatement pst = c.prepareStatement(query)) {
                	input = textField_1.getText();
                	if (input.isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Chưa nhập mã sinh viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                		return;
                	} else {
                		// Thiết lập các giá trị
                        pst.setString(1, textField_1.getText());
                        int rowsAffected = pst.executeUpdate();
                        
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Xóa thông tin sinh viên thành công!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên có mã: " + input, "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        // Thực thi câu lệnh SQL
                        pst.executeUpdate();
                        
                        // Lấy dữ liệu mới từ cơ sở dữ liệu và cập nhật bảng
                        String selectQuery = "SELECT * FROM students";
                        try (PreparedStatement selectPst = c.prepareStatement(selectQuery);
                            ResultSet rs = selectPst.executeQuery()) {
                            // Xóa các hàng hiện có trong bảng
                            model.setRowCount(0);

                            // Thêm dữ liệu mới vào bảng
                            while (rs.next()) {
                                String id = rs.getString("S_ID");
                                String name = rs.getString("S_Name");
                                String faculty = rs.getString("S_Faculty");
                                String className = rs.getString("S_Class");
                                String gradeBy10 = rs.getString("S_10P");
                                String gpa = rs.getString("S_GPA");
                                model.addRow(new Object[]{id, name, faculty, className, gradeBy10, gpa});
                            }
                            
                            
                            textField_1.setText("");
                            textField_2.setText("");
                            comboBox.setSelectedItem(null);
                            comboBox_1.setSelectedItem(null);
                            textField_3.setText(null);
                            textField_4.setText(null);
                            
                        }
                	}
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void findStudent() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        String url = "";
        String username = "";
        String password = "";

        try {
            // Kết nối cơ sở dữ liệu
            try (Connection c = DriverManager.getConnection(url, username, password)) {
                // Chuẩn bị câu lệnh SQL
                String query = "SELECT S_ID, S_Name, S_Faculty, S_Class, S_10P, S_GPA FROM students WHERE S_ID = ?";
                try (PreparedStatement pst = c.prepareStatement(query)) {
                	String input = textField_1.getText();
                	if (input.isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Chưa nhập mã sinh viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
                		return;
                	} else {
                		// Thiết lập các giá trị
                        pst.setString(1, textField_1.getText());
                        
                        // Thực thi câu lệnh SQL và lấy kết quả
                        try (ResultSet rs = pst.executeQuery()) {
                        	if (rs.next()) {
                        		// Xóa các hàng hiện có trong bảng
                                model.setRowCount(0);
                        		String id = rs.getString("S_ID");
                        		String name = rs.getString("S_Name");
                        		String faculty = rs.getString("S_Faculty");
                        		String className = rs.getString("S_Class");
                        		String gradeBy10 = rs.getString("S_10P");
                        		String gpa = rs.getString("S_GPA");
                        		model.addRow(new Object[]{id, name, faculty, className, gradeBy10, gpa});
                        	} else {
                        		JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        	}
                        }
                	}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Clear existing data

        try {
            Connection c = null;
//            DriverManager.registerDriver(new Driver());

            String url = "";
            String username = "";
            String password = "";

            c = DriverManager.getConnection(url, username, password);

            Statement st = c.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("S_ID");
                String name = rs.getString("S_Name");
                String faculty = rs.getString("S_Faculty");
                String className = rs.getString("S_Class");
                String gradeBy10 = rs.getString("S_10P");
                String gpa = rs.getString("S_GPA");
                model.addRow(new Object[]{id, name, faculty, className, gradeBy10, gpa});
            }

            rs.close();
            st.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clearData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        textField_1.setText("");
        textField_2.setText("");
        comboBox.setSelectedItem(null);
        comboBox_1.setSelectedItem(null);
        textField_3.setText("");
        textField_4.setText("");
        model.setRowCount(0);
    }
}
