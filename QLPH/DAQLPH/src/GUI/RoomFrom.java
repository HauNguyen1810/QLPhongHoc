package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Entitys.*;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import utils.*;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.UIManager;
import java.awt.ScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.util.Set;
import java.util.TreeSet;

public class RoomFrom {

	private JFrame frmPhnMmQun;
	private IOData file;
	List<RoomDetails> listRoomDL = new ArrayList<>();
	
	List<Rooms> listRoom = new ArrayList<>();
	List<Areas> listAr = new ArrayList<>();
	List<RowOfHouses> listR = new ArrayList<>();
	List<ClassNames> listCLN = new ArrayList<>();
	List<SubjectNames> listSN = new ArrayList<>();
	private JTextField txtDate;
	private JTable table = new JTable();
	private JComboBox cbbAr;
	private JComboBox cbbAr_1;
	private JComboBox cbbR;
	private JComboBox cbbR_1;
	private JComboBox cbbtl;

	private JComboBox cbbmh;
	private JComboBox cbbTP;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model_1 = new DefaultTableModel();
	private JTextField txtRoomName;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
	private JLabel lblNewLabel;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomFrom window = new RoomFrom();
					window.frmPhnMmQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomFrom() {
		initialize();
		model = (DefaultTableModel) table.getModel();
		model_1 = (DefaultTableModel) table_1.getModel();
		List<RoomDetails> listTK = new ArrayList<>();
//		
		listAr = (List<Areas>) file.readOb("E:\\\\QLPH\\\\DAQLPH\\\\QLK.txt");
		listR = (List<RowOfHouses>) file.readOb("E:\\\\QLPH\\\\DAQLPH\\\\QLD.txt");
		listCLN = (List<ClassNames>) file.readOb("E:\\\\QLPH\\\\DAQLPH\\\\QLTL.txt");
		listSN = (List<SubjectNames>) file.readOb("E:\\QLPH\\DAQLPH\\QLTM.txt");
		listRoom = (List<Rooms>) file.readOb("E:\\QLPH\\DAQLPH\\QLP.txt");
		listRoomDL = (List<RoomDetails>) file.readOb("E:\\\\QLPH\\\\DAQLPH\\\\QLPCT.txt");


		model_1.setRowCount(0);
        Set<RoomDetails> listTKd = listRoomDL.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(RoomDetails::getDate))));
        listTKd.forEach(s -> model_1.addRow(new Object[] {s.getDate(),getNumber(s.getDate())}));


		
       
		for (Areas a : listAr) {
			cbbAr.addItem(a.getAreaName());
			cbbAr_1.addItem(a.getAreaName());
		}
		for (RowOfHouses r : listR) {
			cbbR.addItem(r.getName());
			cbbR_1.addItem(r.getName());
		}
		for (ClassNames classNames : listCLN) {
			cbbtl.addItem(classNames.getClassName());
		}
		for (SubjectNames subjectNames : listSN) {
			cbbmh.addItem(subjectNames.getSubjectName());
		}
		for (Rooms rooms : listRoom) {
			cbbTP.addItem(rooms.getRoomName());
		}

//       listAr.add(new Areas(0, "cơ Sở 1"));
//      listAr.add(new Areas(1, "cơ Sở 2"));
//      listAr.add(new Areas(2, "cơ Sở 3"));
//      listR.add(new RowOfHouses(0, "Dãy A1"));
//      listR.add(new RowOfHouses(1, "Dãy A2"));
//      listR.add(new RowOfHouses(2, "Dãy A3"));
//      listR.add(new RowOfHouses(3, "Dãy A4"));
//      listR.add(new RowOfHouses(4, "Dãy A5"));
//      listR.add(new RowOfHouses(5, "Dãy A8"));
//      listR.add(new RowOfHouses(6, "Dãy A9"));
//      listR.add(new RowOfHouses(7, "Dãy A10"));
//      listR.add(new RowOfHouses(8, "Dãy A11"));
//      listR.add(new RowOfHouses(9, "Dãy A12"));
//      listR.add(new RowOfHouses(10, "Dãy A13"));
//      listCLN.add(new ClassNames(0,"20222I1659002"));
//      listCLN.add(new ClassNames(1, "20222I1659001"));
//      listCLN.add(new ClassNames(2, "20222I1659003"));
//      listCLN.add(new ClassNames(3, "20222I1659004"));
//      listCLN.add(new ClassNames(4, "20222I1659005"));
//      listCLN.add(new ClassNames(5, "20222I1314005"));
//      listSN.add(new SubjectNames(0, "Lập trình căn bản "));
//      listSN.add(new SubjectNames(1, "Ứng dụng thuật toán"));
//      listSN.add(new SubjectNames(2, "Tối ưu hoá"));
//      listSN.add(new SubjectNames(3, "Lập trình Java"));
//		listRoom.add(new Rooms(0,0, 0, "601"));
//		listRoom.add(new Rooms(1,1, 2, "602"));
//		listRoom.add(new Rooms(2,2, 2, "603"));
//		listRoom.add(new Rooms(3,2, 3, "604"));
//		listRoom.add(new Rooms(3,2, 3, "605"));
//		listRoom.add(new Rooms(3,2, 3, "701"));
//		listRoomDL.add(new RoomDetails(0, "09/04/2022", 0, 0));
//		listRoomDL.add(new RoomDetails(1, "09/04/2022", 1, 3));
//		listRoomDL.add(new RoomDetails(2, "09/04/2022", 0, 2));
//		listRoomDL.add(new RoomDetails(3, "09/04/2022", 1, 1));
//		listRoomDL.add(new RoomDetails(1, "11/04/2022", 3, 2));
		addTable();
	}
	
	private int getNumber(String date) {
		int count =0;
		for (RoomDetails roomDetails : listRoomDL) {
		if (roomDetails.getDate().equals(date)) {
			count++;
		}
		}
		return count;
	}

	private Rooms getbyidroom(int id) {
		for (Rooms rooms : listRoom) {
			if (rooms.getId() == id) {
				return rooms;
			}
		}
		return null;
	}

	private String getByname(int id) {
		for (Areas a : listAr) {
			if (a.getId() == id) {
				return a.getAreaName();
			}
		}
		return null;
	}

	private String getByname1(int id) {
		for (RowOfHouses r : listR) {

			if (r.getId() == id) {
				return r.getName();
			}

		}
		return null;
	}

	private String getByname2(int id) {
		for (ClassNames cln : listCLN) {
			if (cln.getId() == id) {
				return cln.getClassName();
			}

		}
		return null;
	}

	private String getByname3(int id) {
		for (SubjectNames s : listSN) {
			if (s.getId() == id) {
				return s.getSubjectName();
			}
		}
		return null;
	}

	private void addTable() {

		model.setRowCount(0);// xoa toan bo du lieu cua Model

		for (RoomDetails x : listRoomDL) {
			model.addRow(new Object[] { getbyidroom(x.getRoomid()).getRoomName(),
					getByname(getbyidroom(x.getRoomid()).getAreaId()),
					getByname1(getbyidroom(x.getRoomid()).getRowOfHousesId()), getByname2(x.getClassNameId()),
					getByname3(x.getSubjectNameId()), x.getDate() });
		}
		if (model.getRowCount() > 0) {// Table co du lieu
			table.setRowSelectionInterval(0, 0);// Cho Table chon dong dau tien
		}

	}

	private void showDetail() {
		RoomDetails r = listRoomDL.get(table.getSelectedRow());
		cbbTP.setSelectedItem(getbyidroom(r.getRoomid()).getRoomName());
		cbbAr.setSelectedItem(getByname(getbyidroom(r.getRoomid()).getAreaId()));
		cbbR.setSelectedItem(getByname1(getbyidroom(r.getRoomid()).getRowOfHousesId()));
		cbbtl.setSelectedItem(getByname2(r.getClassNameId()));
		cbbmh.setSelectedItem(getByname3(r.getSubjectNameId()));
		txtDate.setText(r.getDate());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setVisible(true);
		frmPhnMmQun.setTitle("Phần mềm quản lý phòng học");
		frmPhnMmQun.setBounds(100, 100, 654, 586);
		frmPhnMmQun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhnMmQun.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Quản lý phòng học");
		lblNewLabel.setSize(new Dimension(30, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 637, 45);
		frmPhnMmQun.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 324, 617, 212);
		frmPhnMmQun.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 0, 616, 212);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setDoubleBuffered(true);
		table.setDragEnabled(true);
		table.setDropMode(DropMode.ON);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDetail();
			}
		});
		table.isVisible();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "T\u00EAn ph\u00F2ng", "Khu", "D\u00E3y ph\u00F2ng", "T\u00EAn l\u1EDBp",
						"M\u00F4n H\u1ECDc", "Ng\u00E0y" }));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 56, 617, 252);
		frmPhnMmQun.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Quản Lý Phòng", null, panel_1, null);
		panel_1.setLayout(null);

		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.setBounds(394, 11, 89, 23);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.setBounds(394, 46, 89, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Sửa");
		btnNewButton_4.setBounds(394, 80, 89, 23);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xóa");
		btnNewButton_5.setBounds(394, 114, 89, 23);
		panel_1.add(btnNewButton_5);

		JButton btnNewButton = new JButton("Lưu File");
		btnNewButton.setBounds(394, 148, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Đọc file");
		btnNewButton_1.setBounds(394, 182, 89, 23);
		panel_1.add(btnNewButton_1);

		cbbTP = new JComboBox();
		cbbTP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//				int id = cbbTP.getSelectedIndex();
//				cbbAr.setSelectedItem(getByname(getbyidroom(id).getAreaId()));
//				cbbR.setSelectedItem(getByname1(getbyidroom(id).getRowOfHousesId()));
			}
		});

		cbbTP.setBounds(137, 11, 230, 22);
		panel_1.add(cbbTP);

		cbbAr = new JComboBox();
		cbbAr.setBounds(137, 46, 230, 22);
		panel_1.add(cbbAr);

		cbbR = new JComboBox();
		cbbR.setBounds(137, 80, 230, 22);
		panel_1.add(cbbR);

		txtDate = new JTextField();

		txtDate.setBounds(137, 115, 230, 20);
		panel_1.add(txtDate);
		txtDate.setColumns(10);

		cbbtl = new JComboBox();
		cbbtl.setBounds(137, 148, 230, 22);
		panel_1.add(cbbtl);

		cbbmh = new JComboBox();
		cbbmh.setBounds(137, 182, 230, 22);
		panel_1.add(cbbmh);

		JLabel lblNewLabel_1 = new JLabel("Tên Phòng");
		lblNewLabel_1.setBounds(10, 15, 62, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Khu");
		lblNewLabel_2.setBounds(10, 50, 62, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Dãy nhà");
		lblNewLabel_3.setBounds(10, 84, 46, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ngày");
		lblNewLabel_4.setBounds(10, 118, 62, 14);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tên Lớp");
		lblNewLabel_5.setBounds(10, 152, 62, 14);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Môn Học");
		lblNewLabel_6.setBounds(10, 186, 62, 14);
		panel_1.add(lblNewLabel_6);

		JButton btnNewButton_6 = new JButton("Làm mới");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable();
			}
		});
		
		btnNewButton_6.setBounds(513, 11, 89, 23);
		panel_1.add(btnNewButton_6);
		cbbAr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//Đọc file
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser F = new JFileChooser();
					int result = F.showOpenDialog(btnNewButton_1);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file2 = F.getSelectedFile();
						System.out.println(file2.getAbsolutePath());
						listRoomDL = (List<RoomDetails>) file.readOb(file2.getAbsolutePath());
						addTable();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		//Lưu file
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					file.writeOb("E:\\QLPH\\DAQLPH\\QLPCT.txt", listRoomDL);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLP.txt", listRoom);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLK.txt", listAr);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLD.txt", listR);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLTL.txt", listCLN);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLTM.txt", listSN);
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}	
			}
		});
		//Xác nhận xoá
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = JOptionPane.showConfirmDialog(btnNewButton_5, "Bạn có muốn xóa không");
					if (i == 0) {
						listRoomDL.remove(table.getSelectedRow());
						file.writeOb("E:\\QLPH\\DAQLPH\\QLPCT.txt", listRoomDL);
						JOptionPane.showMessageDialog(btnNewButton_5, "Xóa thành công");
						addTable();
					}
				} catch (Exception e2) {
					 e2.printStackTrace();
			           JOptionPane.showMessageDialog(btnNewButton_5, "Lỗi xảy ra khi xóa phòng.");
					// TODO: handle exception
				}
			}
		});
		//Sửa
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listRoom.set(cbbTP.getSelectedIndex(),
							new Rooms(listRoom.get(cbbTP.getSelectedIndex()).getId(), cbbAr.getSelectedIndex(),
									cbbR.getSelectedIndex(), listRoom.get(cbbTP.getSelectedIndex()).getRoomName()));

					listRoomDL.set(table.getSelectedRow(), new RoomDetails(listRoom.get(cbbTP.getSelectedIndex()).getId(),
							txtDate.getText(), cbbtl.getSelectedIndex(), cbbmh.getSelectedIndex()));
					file.writeOb("E:\\QLPH\\DAQLPH\\QLPCT.txt", listRoomDL);
					file.writeOb("E:\\QLPH\\DAQLPH\\QLP.txt", listRoom);
					JOptionPane.showMessageDialog(btnNewButton_3, "Sửa Thành Công");
					addTable();
				} catch (Exception e2) {
					 e2.printStackTrace();
			            JOptionPane.showMessageDialog(btnNewButton_4, "Lỗi xảy ra khi sửa phòng.");
					// TODO: handle exception
				}
			}
		});
		
		//thêm 
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String dateInput = txtDate.getText().trim(); // Lấy ngày nhập và loại bỏ các khoảng trắng đầu và cuối
		            if (dateInput.isEmpty()) { // Kiểm tra ngày nhập có trống hay không
		                throw new IllegalArgumentException("Vui lòng nhập ngày.");
		            }

		            listRoomDL.add(new RoomDetails(cbbTP.getSelectedIndex(), dateInput, cbbtl.getSelectedIndex(),
		                    cbbmh.getSelectedIndex()));
		            file.writeOb("E:\\QLPH\\DAQLPH\\QLPCT.txt", listRoomDL);
		            JOptionPane.showMessageDialog(btnNewButton_3, "Thêm Thành Công");
		            addTable();
		        } catch (IllegalArgumentException ex) {
		            JOptionPane.showMessageDialog(btnNewButton_3, ex.getMessage());
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(btnNewButton_3, "Lỗi xảy ra khi thêm phòng.");
		        }
			}
		});
		
		//tìm kiếm 
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ArrayList<RoomDetails> listseach = new ArrayList<RoomDetails>();
					String m = JOptionPane.showInputDialog("Mời bạn nhập ngày muốn tìm kiếm?");
					 // Kiểm tra ngày nhập có hợp lệ hay không
		            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		            dateFormat.setLenient(false);
		           
					for (RoomDetails roomDetails : listRoomDL) {
						if (m.equals(roomDetails.getDate())) {
							listseach.add(roomDetails);
						}
					}
					model.setRowCount(0);// xoa toan bo du lieu cua Model

					for (RoomDetails x : listseach) {
						model.addRow(new Object[] { getbyidroom(x.getRoomid()).getRoomName(),
								getByname(getbyidroom(x.getRoomid()).getAreaId()),
								getByname1(getbyidroom(x.getRoomid()).getRowOfHousesId()), getByname2(x.getClassNameId()),
								getByname3(x.getSubjectNameId()), x.getDate() });
					}
					
					if (model.getRowCount() > 0) {// Table co du lieu
						table.setRowSelectionInterval(0, 0);// Cho Table chon dong dau tien
					}

				
			}
		});
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Room", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Phòng");
		lblNewLabel_1_1.setBounds(10, 29, 62, 14);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Khu");
		lblNewLabel_2_1.setBounds(10, 75, 62, 14);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Dãy nhà");
		lblNewLabel_3_1.setBounds(10, 122, 46, 14);
		panel_2.add(lblNewLabel_3_1);

		txtRoomName = new JTextField();
		txtRoomName.setBounds(107, 26, 230, 20);
		panel_2.add(txtRoomName);
		txtRoomName.setColumns(10);

		cbbAr_1 = new JComboBox();
		cbbAr_1.setBounds(107, 71, 230, 22);
		panel_2.add(cbbAr_1);

		cbbR_1 = new JComboBox();
		cbbR_1.setBounds(107, 118, 230, 22);
		panel_2.add(cbbR_1);
		
		//Xác nhận thêm thành công
		JButton btnNewButton_7 = new JButton("Thêm Phòng");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String roomName=txtRoomName.getText().trim();
					if (roomName.isEmpty()) {
					    JOptionPane.showMessageDialog(btnNewButton_7, "Vui lòng nhập tên phòng");
					}
					else {
					listRoom.add(new Rooms(listRoom.size(), cbbAr_1.getSelectedIndex(), cbbR_1.getSelectedIndex(),
							txtRoomName.getText()));
					file.writeOb("E:\\QLPH\\DAQLPH\\QLP.txt", listRoom);
					JOptionPane.showMessageDialog(btnNewButton_7, "Thêm Thành Công");
					DefaultComboBoxModel model = (DefaultComboBoxModel) cbbTP.getModel();
					model.removeAllElements();
					for (Rooms rooms : listRoom) {
						cbbTP.addItem(rooms.getRoomName());
					}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
		            JOptionPane.showMessageDialog(btnNewButton_7, "Lỗi xảy ra khi thêm phòng");
					// TODO: handle exception
				}
			}
		});
		btnNewButton_7.setBounds(444, 61, 109, 42);
		panel_2.add(btnNewButton_7);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel_3, null);
		panel_3.setLayout(null);
		//Thống kê
		JButton btnNewButton_8 = new JButton("Cập nhật");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_1.setRowCount(0);
		        Set<RoomDetails> listTKd = listRoomDL.stream()
		                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(RoomDetails::getDate))));
		        listTKd.forEach(s -> model_1.addRow(new Object[] {s.getDate(),getNumber(s.getDate())}));
			}
		});
		btnNewButton_8.setBounds(502, 11, 89, 23);
		panel_3.add(btnNewButton_8);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 44, 407, 169);
		panel_3.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ng\u00E0y", "S\u1ED1 l\u01B0\u1EE3ng ph\u00F2ng" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setDropMode(DropMode.ON);
		table_1.setDragEnabled(true);
		table_1.setDoubleBuffered(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_1.setAutoCreateRowSorter(true);
	}
}
