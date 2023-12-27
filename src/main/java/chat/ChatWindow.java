package chat;

import chat.controllers.CSVWorker;
import chat.models.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;

/**
 * Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения
 * к серверу, область ввода сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
 * Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать на JPanel сверху экрана, а компоненты, относящиеся к отправке
 * сообщения – на JPanel снизу
 */

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private static String msg;
    private static final String path = DbConfig.pathDb;
    CSVWorker csvWorker = new CSVWorker();
    Message newMessage;

    JPanel panServerConnectionScreen = new JPanel(new GridLayout(9,1));
    JLabel loginLabel = new JLabel("Логин:");
    JTextField loginField = new JTextField();
    JLabel passwordLabel = new JLabel("Пароль:");
    JTextField passwordField = new JTextField();
    JLabel domainLabel = new JLabel("Адрес:");
    JTextField domainField = new JTextField();
    JLabel portLabel = new JLabel("Порт:");
    JTextField portField = new JTextField();
    JButton btnConnection = new JButton("Подключиться");

    JPanel panClientScreen = new JPanel(new GridLayout(5,1));
    JLabel incomeMsgLabel = new JLabel("Входящие сообщения:");
    JTextArea incomeMsgText = new JTextArea();
    JLabel sendMsgLabel = new JLabel("Введите сообщение:");
    JTextField sendMsgField = new JTextField();
    JButton btnSendMsg = new JButton("Отправить");

    ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Window");
        setResizable(true);

        panServerConnectionScreen.add(loginLabel);
        panServerConnectionScreen.add(loginField);
        panServerConnectionScreen.add(passwordLabel);
        panServerConnectionScreen.add(passwordField);
        panServerConnectionScreen.add(domainLabel);
        panServerConnectionScreen.add(domainField);
        panServerConnectionScreen.add(portLabel);
        panServerConnectionScreen.add(portField);
        panServerConnectionScreen.add(btnConnection);

        panClientScreen.add(incomeMsgLabel);
        panClientScreen.add(incomeMsgText);
        panClientScreen.add(sendMsgLabel);
        panClientScreen.add(sendMsgField);
        panClientScreen.add(btnSendMsg);

        btnConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        incomeMsgText.append(csvWorker.load(path));

        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }

        });

        btnSendMsg.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setLayout(new GridLayout(1, 2));
        add(panServerConnectionScreen);
        add(panClientScreen);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ChatWindow();
    }

    private void sendMessage() {
        newMessage = new Message(LocalDateTime.now(), loginField.getText(), sendMsgField.getText());
        System.out.println("Отправлено: " + newMessage.toString());
        incomeMsgText.append(newMessage.toString() + "\n");
        sendMsgField.setText("");
        csvWorker.save(path, newMessage);
    }
}
