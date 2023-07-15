package com.hohltier.decompiler.views;

import lombok.Getter;
import lombok.SneakyThrows;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import javax.swing.*;
import java.awt.*;

public class TabNodeView extends JPanel {

    @Getter private final RSyntaxTextArea textArea;
    @Getter private final RTextScrollPane scrollPane;

    @SneakyThrows
    public TabNodeView(String name, String text) {
        setLayout(new BorderLayout());

        Theme theme = Theme.load(getClass().getClassLoader().getResourceAsStream("org/fife/ui/rsyntaxtextarea/themes/eclipse.xml"));
        Font font = new Font("JetBrains Mono", Font.PLAIN, UIManager.getFont("defaultFont").getSize() + 3);

        textArea = new RSyntaxTextArea();
        theme.apply(textArea);
        textArea.setBracketMatchingEnabled(false);
        textArea.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        textArea.setEditable(false);
        textArea.setFont(font);
        textArea.setHighlightCurrentLine(false);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setText(text);

        scrollPane = new RTextScrollPane(textArea);
        scrollPane.getGutter().setLineNumberFont(font);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);
    }

}