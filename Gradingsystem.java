import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


public class Gradingsystem extends JFrame {
    JScrollPane jsp;
    JTable jt;
    // Constants for rows and columns/dimensions array
    int MAX_ROWS = 3;
    int MAX_COLS = 3;

    Object[][] data = new Object[MAX_ROWS][MAX_COLS]; // Table data
    String[] cols = {"NAME", "MATH", "PHYSICS"}; // Table column headers
    public static void main(String[] args) {
        new Gradingsystem();
    }

    public Gradingsystem() {
        // JFrame properties
        this.setTitle("Grading System");
        this.setSize(400, 400); // Adjust size to fit the table
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Use BorderLayout
        // Initialize data for the table
        Row[] rows = new Row[3];
        rows[0] = new Row("Jane", 40, 20.0f);
        rows[1] = new Row("Jon", 70.0f, 60.0f);
        rows[2] = new Row("Stewart", 80.0f, 75.0f);

        // Convert Row objects to 2D array
        for (int i = 0; i < rows.length; i++) {
            data[i][0] = rows[i].studentName; // Set student name
            data[i][1] = rows[i].gradeMath;   // Set math grade
            data[i][2] = rows[i].gradePhysics;// Set physics grade
        }

        // Create JTable with data
        jt = new JTable(data, cols);

        // Customize table appearance
        jt.setFont(new Font("Serif", Font.BOLD, 14)); // Set font
        jt.setRowHeight(30); // Set row height
        jt.setGridColor(Color.BLUE); // Set grid color

        // Center align table cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TableColumnModel columnModel = jt.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set header background color
        jt.getTableHeader().setBackground(Color.LIGHT_GRAY);
        jt.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        // Add table to JScrollPane
        jsp = new JScrollPane(jt);

        // Add JScrollPane to JFrame
        this.add(jsp, BorderLayout.CENTER);

        // Set JFrame visibility
        this.setVisible(true);
    }
}