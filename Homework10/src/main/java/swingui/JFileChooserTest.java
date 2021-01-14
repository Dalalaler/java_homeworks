package swingui;

// Пример использования диалоговых окон работы с файлами и директориями

import exceptions.DataReadException;

import javax.swing.*;
// import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;

public class JFileChooserTest extends JFrame
{
	private  JButton      btnFileFilter = null;

	private  JFileChooser fileChooser   = null;

	String fileName = "default";

	private final String[][] FILTERS = {{"json", "Файлы json (*.json)"},
			                            {"txt" , "Файлы txt (*.txt)"}};
	public JFileChooserTest() {
		super("Выбор файла");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnFileFilter = new JButton("Выберите файл с данными в формате json");


		fileChooser = new JFileChooser();
		// Подключение слушателей к кнопкам
		addFileChooserListeners();
		// Размещение кнопок в интерфейсе
		JPanel contents = new JPanel();
		contents.add(btnFileFilter);
		setContentPane(contents);
		// Вывод окна на экран
		setSize(360, 110);
		setVisible(true);
	}
	private void addFileChooserListeners()
	{
		btnFileFilter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fileChooser.setDialogTitle("Выберите файл");
				// Определяем фильтры типов файлов
                for (int i = 0; i < FILTERS[0].length; i++) {
    				FileFilterExt eff = new FileFilterExt(FILTERS[i][0],
    						                              FILTERS[i][1]);
    				fileChooser.addChoosableFileFilter(eff);
                }
				// Определение режима - только файл
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(JFileChooserTest.this);
				// Если файл выбран, покажем его в сообщении
				if (result == JFileChooser.APPROVE_OPTION ) {
					JOptionPane.showMessageDialog(JFileChooserTest.this,
							"Выбран файл ( " +
									fileChooser.getSelectedFile() + " )");

					try {
						new MainWindow("" + fileChooser.getSelectedFile());
					} catch (DataReadException dataReadException) {
						dataReadException.printStackTrace();
					}

					setVisible(false);

				}

			}
		});

	}
	// Фильтр выбора файлов определенного типа
	static class FileFilterExt extends javax.swing.filechooser.FileFilter
	{
		String extension  ;  // расширение файла
		String description;  // описание типа файлов

		FileFilterExt(String extension, String descr)
		{
			this.extension = extension;
			this.description = descr;
		}
		@Override
		public boolean accept(java.io.File file)
		{
			if(file != null) {
				if (file.isDirectory())
					return true;
				if( extension == null )
					return (extension.length() == 0);
				return file.getName().endsWith(extension);

			}
			return false;
		}
		// Функция описания типов файлов
		@Override
		public String getDescription() {
			return description;
		}
	}

	public static void main(String[] args)
	{
		new JFileChooserTest();
	}
}
