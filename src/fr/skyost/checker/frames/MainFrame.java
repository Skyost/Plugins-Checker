package fr.skyost.checker.frames;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import fr.skyost.checker.PluginsChecker;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -1108869543248275664L;
	private JTextField textFieldTitle;
	private JTextField textFieldStage;
	private JTextField textFieldProjectId;
	private JTextField textFieldName;
	private JTextField textFieldSlug;
	private JTextField textFieldType;
	private JTextField textFieldGameVersion;
	private JTextField textFieldFilename;
	private JTextField textFieldUrl;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			setIconImage(new ImageIcon(PluginsChecker.class.getResource("/fr/skyost/checker/res/Skyost.png")).getImage());
			setSize(364, 452);
			setTitle("Skyost's Plugins Checker - v" + PluginsChecker.version);
			
			JLabel lblName = new JLabel("Name :");
			
			JLabel lblProjectId = new JLabel("Project ID :");
			
			JLabel lblStage = new JLabel("Stage :");
			
			JLabel lblLatestVersionTitle = new JLabel("Title :");
			
			textFieldTitle = new JTextField();
			textFieldTitle.setEditable(false);
			textFieldTitle.setColumns(10);
			
			textFieldStage = new JTextField();
			textFieldStage.setEditable(false);
			textFieldStage.setColumns(10);
			
			textFieldProjectId = new JTextField();
			textFieldProjectId.setEditable(false);
			textFieldProjectId.setColumns(10);
			
			textFieldName = new JTextField();
			textFieldName.setEditable(false);
			textFieldName.setColumns(10);
			
			JLabel lblLatestVersion = new JLabel("Latest version informations :");
			lblLatestVersion.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JLabel lblProjectInformations = new JLabel("Project informations :");
			lblProjectInformations.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JLabel lblLblbukkitdev = new JLabel(new ImageIcon(PluginsChecker.class.getResource("/fr/skyost/checker/res/BukkitDev.png")));
			
			JLabel lblSlug = new JLabel("Slug :");
			
			textFieldSlug = new JTextField();
			textFieldSlug.setEditable(false);
			textFieldSlug.setColumns(10);
			
			JLabel lblType = new JLabel("Type :");
			
			JLabel lblGameVersion = new JLabel("Game version :");
			
			JLabel lblFilename = new JLabel("Filename :");
			
			JLabel lblUrl = new JLabel("URL :");
			
			textFieldType = new JTextField();
			textFieldType.setEditable(false);
			textFieldType.setColumns(10);
			
			textFieldGameVersion = new JTextField();
			textFieldGameVersion.setEditable(false);
			textFieldGameVersion.setColumns(10);
			
			textFieldFilename = new JTextField();
			textFieldFilename.setEditable(false);
			textFieldFilename.setColumns(10);
			
			textFieldUrl = new JTextField();
			textFieldUrl.setEditable(false);
			textFieldUrl.setColumns(10);
			
			JButton btnExport = new JButton("Export...");
			btnExport.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent event) {
					try {
						final JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
						fileChooser.setDialogTitle("Export results...");
						fileChooser.setFileFilter(new FileNameExtensionFilter("Html file (*.html)", "html"));
						fileChooser.showOpenDialog(null);
						final File selected = new File(fileChooser.getSelectedFile() + ".html"); // TODO Vérifier si le fichier n'est pas nul
						PrintWriter writer = new PrintWriter(new FileWriter(selected));
						writer.println("<html>");
						writer.println("<head>");
						writer.println("<title>Skyost's Plugins Checker</title>");
						writer.println("<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\">");
						writer.println("<body>");
						writer.println("<h1>Skyost's Plugin Checker v" + PluginsChecker.version + "</h1>");
						writer.println("<h2>Project informations</h2>");
						writer.println("<b>Name :</b> " + textFieldName.getText());
						writer.println("<br /><b>ID :</b> " + textFieldProjectId.getText());
						writer.println("<br /><b>Slug :</b> " + textFieldProjectId.getText());
						writer.println("<br /><b>Stage :</b> " + textFieldStage.getText());
						writer.println("<h2>Latest version informations :</h2>");
						writer.println("<b>Title :</b> " + textFieldTitle.getText());
						writer.println("<br /><b>Type :</b> " + textFieldType.getText());
						writer.println("<br /><b>Game version :</b> " + textFieldGameVersion.getText());
						writer.println("<br /><b>Filename :</b> " + textFieldFilename.getText());
						writer.println("<br /><b>URL :</b> " + textFieldUrl.getText());
						writer.println("<br /><br /><i>By <a href=\"http://www.skyost.eu\">Skyost</a>.</i> ");
						writer.println("</body>");
						writer.println("</html>");
						writer.flush();
						writer.close();
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			});
			
			JButton btnAnotherProject = new JButton("Another project...");
			btnAnotherProject.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent event) {
					reTry();
				}
				
			});
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAnotherProject, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
							.addComponent(btnExport, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
							.addComponent(lblLblbukkitdev, Alignment.LEADING)
							.addComponent(lblProjectInformations, Alignment.LEADING)
							.addComponent(lblLatestVersion, Alignment.LEADING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblName)
									.addComponent(lblProjectId)
									.addComponent(lblSlug)
									.addComponent(lblStage))
								.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textFieldName)
									.addComponent(textFieldProjectId)
									.addComponent(textFieldSlug)
									.addComponent(textFieldStage, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblGameVersion)
									.addComponent(lblLatestVersionTitle)
									.addComponent(lblType)
									.addComponent(lblFilename)
									.addComponent(lblUrl))
								.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textFieldUrl)
									.addComponent(textFieldFilename)
									.addComponent(textFieldType)
									.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addComponent(textFieldGameVersion))))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblLblbukkitdev)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblProjectInformations)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblName)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblProjectId)
							.addComponent(textFieldProjectId, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSlug)
							.addComponent(textFieldSlug, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStage)
							.addComponent(textFieldStage, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblLatestVersion)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLatestVersionTitle)
							.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblType)
							.addComponent(textFieldType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGameVersion)
							.addComponent(textFieldGameVersion, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblFilename)
							.addComponent(textFieldFilename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUrl)
							.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAnotherProject, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
						.addContainerGap())
			);
			getContentPane().setLayout(groupLayout);
			String input = (String)JOptionPane.showInputDialog(this, "Search your project (keywords only !) :", "Plugins Checker", JOptionPane.PLAIN_MESSAGE, new ImageIcon(PluginsChecker.class.getResource("/fr/skyost/checker/res/BukkitIcon.png")), null, null);
			if(input == null || input.equals("")) {
				System.exit(0);
			}
			final HashMap<String, String[]> projects = PluginsChecker.searchProject(input.toLowerCase());
			if(projects == null) {
				JOptionPane.showMessageDialog(this, "No project found for those keywords !", "No project found", JOptionPane.ERROR_MESSAGE);
				reTry();
			}
			String values;
			final StringBuilder stringBuilder = new StringBuilder();
			for(String value : projects.keySet()) {
				stringBuilder.append(value + ",");
			}
			values = stringBuilder.toString();
			Object[] objects = values.substring(0, values.length() - 1).split(",");
			input = (String)JOptionPane.showInputDialog(this, projects.size() + " projects found :", "Plugins Checker", JOptionPane.PLAIN_MESSAGE, new ImageIcon(PluginsChecker.class.getResource("/fr/skyost/checker/res/BukkitIcon.png")), objects, null);
			if(input == null || input.equals("")) {
				System.exit(0);
			}
			final String[] dataA = projects.get(input);
			final String[] dataB = PluginsChecker.getProjectLastFileInformations(dataA[0]);
			textFieldName.setText(input);
			textFieldProjectId.setText(dataA[0]);
			textFieldSlug.setText(dataA[1]);
			textFieldStage.setText(dataA[2]);
			textFieldTitle.setText(dataB[0]);
			textFieldType.setText(dataB[1]);
			textFieldGameVersion.setText(dataB[2]);
			textFieldFilename.setText(dataB[3]);
			textFieldUrl.setText(dataB[4]);
			this.setVisible(true);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			reTry();
		}
	}
	
	private void reTry() {
		this.dispose();
		new MainFrame();
	}
	
}
